package com.financas.sistemacasal.service;

import com.financas.sistemacasal.model.*;
import com.financas.sistemacasal.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class EstoqueInteligenteService {

    private final ItemEstoqueRepository estoqueRepository;
    private final ListaCompraRepository listaCompraRepository;
    private final LancamentoRepository lancamentoRepository;
    private final ContaBancariaRepository contabancariaRepository;

    // Injeção de todas as dependências necessárias para cruzar os dados
    public EstoqueInteligenteService(ItemEstoqueRepository estoqueRepository,
            ListaCompraRepository listaCompraRepository,
            LancamentoRepository lancamentoRepository,
            ContaBancariaRepository contabancariaRepository) {
        this.estoqueRepository = estoqueRepository;
        this.listaCompraRepository = listaCompraRepository;
        this.lancamentoRepository = lancamentoRepository;
        this.contabancariaRepository = contabancariaRepository;
    }

    @Transactional
    public void gerarListaComprasAutomatica(Long casalId) {
        ListaCompra listaAtiva = listaCompraRepository.findByCasalIdAndFinalizadaFalse(casalId)
                .orElseThrow(
                        () -> new RuntimeException("Crie uma lista de compras ativa antes de sincronizar o estoque!"));

        List<ItemEstoque> itensAcabando = estoqueRepository.findItensAbaixoDoMinimo();

        for (ItemEstoque itemEstoque : itensAcabando) {
            boolean jaExiste = listaAtiva.getItens().stream()
                    .anyMatch(item -> item.getNome().equalsIgnoreCase(itemEstoque.getNome()));

            if (!jaExiste) {
                ItemLista novoItem = new ItemLista();
                novoItem.setNome(itemEstoque.getNome());
                novoItem.setCategoria(itemEstoque.getCategoria());
                novoItem.setQuantidadeAComprar(
                        itemEstoque.getQuantidadeMinima() * 2 - itemEstoque.getQuantidadeAtual());
                novoItem.setListaCompra(listaAtiva);
                listaAtiva.getItens().add(novoItem);
            }
        }
        listaCompraRepository.save(listaAtiva);
    }

    /**
     * MÁGICA DO FLUXO FINANCEIRO INTEGRADO:
     * Fecha a lista, incrementa a despensa e debita o valor total de forma segura.
     */
    @Transactional
    public void finalizarCompraNoMercado(Long listaId, Long contaBancariaId, BigDecimal valorTotalGasto,
            Usuario responsavel, String formaPagamento) {
        // 1. Recupera a lista de compras
        ListaCompra lista = listaCompraRepository.findById(listaId)
                .orElseThrow(() -> new RuntimeException("Lista de compras não encontrada!"));

        if (lista.getFinalizada()) {
            throw new IllegalStateException("Esta lista de compras já foi finalizada!");
        }

        // 2. Busca a conta bancária de onde sairá o dinheiro
        ContaBancaria conta = contabancariaRepository.findById(contaBancariaId)
                .orElseThrow(() -> new RuntimeException("Conta bancária não encontrada!"));

        // 3. Atualiza o estoque doméstico com os itens marcados como 'comprados'
        for (ItemLista item : lista.getItens()) {
            if (item.getComprado()) {
                ItemEstoque estoque = estoqueRepository.findAll().stream()
                        .filter(e -> e.getNome().equalsIgnoreCase(item.getNome()))
                        .findFirst()
                        .orElseGet(() -> {
                                     ItemEstoque novoItem = new ItemEstoque();
                                     novoItem.setNome(item.getNome());
                                     novoItem.setQuantidadeAtual(0);
                                     novoItem.setQuantidadeMinima(1);
                                     novoItem.setCategoria(item.getCategoria());
                                     return novoItem;
    });

                estoque.setQuantidadeAtual(estoque.getQuantidadeAtual() + item.getQuantidadeAComprar());
                estoqueRepository.save(estoque);
            }
        }

        // 4. Cria o Lançamento Automático de Saída no Fluxo de Caixa (Módulo 4 do
        // Escopo)
        Lancamento despesaMercado = new Lancamento();
        despesaMercado.setDescricao("Supermercado - Lista Automática #" + lista.getId());
        despesaMercado.setValor(valorTotalGasto); // 100% compatível agora
        despesaMercado.setTipo("SAIDA");
        despesaMercado.setFormaPagamento(formaPagamento);
        despesaMercado.setCategoria("Alimentação / Supermercado");
        despesaMercado.setDataCompetencia(LocalDate.now());
        despesaMercado.setValidado(true);
        despesaMercado.setUsuario(responsavel);
        // despesaMercado.setCasal(conta.getCasal());
        despesaMercado.setContaBancaria(conta);

        lancamentoRepository.save(despesaMercado);

        // 5. Deduz o saldo da conta bancária utilizando o método correto do BigDecimal
        conta.setSaldoAtual(conta.getSaldoAtual().subtract(valorTotalGasto));
        contabancariaRepository.save(conta);

        // 6. Finaliza o status da lista de compras
        lista.setFinalizada(true);
        lista.setValorTotal(valorTotalGasto); // 100% compatível agora
        listaCompraRepository.save(lista);
    }
}