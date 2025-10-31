package com.oficinareis.backend.service;

import com.oficinareis.backend.model.ItemOrdemServico;
import com.oficinareis.backend.model.OrdemServico;
import com.oficinareis.backend.model.Status;
import com.oficinareis.backend.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdemServicoService implements IOrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;

    @Autowired
    public OrdemServicoService(OrdemServicoRepository ordemServicoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
    }

    /**
     * Calcula o valor total da OS (peças + mão de obra) e define a data de criação.
     * @param os OrdemServico a ser processada.
     */
    private void calcularEValidar(OrdemServico os) {
        double totalPecas = 0.0;
        
        // Garante que o itemOrdemServico.ordemServico seja setado
        if (os.getItens() != null) {
            for (ItemOrdemServico item : os.getItens()) {
                item.setOrdemServico(os);
                totalPecas += item.getQuantidade() * item.getPrecoUnitarioVenda();
            }
        }
        
        // Assume 0.0 se valorMaoDeObra for nulo
        double valorMaoDeObra = os.getValorMaoDeObra() != null ? os.getValorMaoDeObra() : 0.0;
        os.setValorTotal(totalPecas + valorMaoDeObra);
        
        // Define a data de criação se for uma nova OS
        if (os.getId() == null) {
            os.setDataCriacao(LocalDateTime.now());
            // Define o status inicial como ABERTA se não estiver definido
            if (os.getStatus() == null) {
                os.setStatus(Status.ABERTA);
            }
        }
    }

    @Override
    @Transactional
    public OrdemServico save(OrdemServico ordemServico) {
        calcularEValidar(ordemServico);
        return ordemServicoRepository.save(ordemServico);
    }

    @Override
    public Optional<OrdemServico> findById(Long id) {
        return ordemServicoRepository.findById(id);
    }

    @Override
    public List<OrdemServico> findAll() {
        return ordemServicoRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        ordemServicoRepository.deleteById(id);
    }
    
    /**
     * Atualiza o status e a data de fechamento da Ordem de Serviço.
     * @param id ID da OS.
     * @param novoStatus O novo status em formato String.
     * @return A OS atualizada ou um Optional vazio se não encontrada.
     */
    @Transactional
    public Optional<OrdemServico> atualizarStatus(Long id, String novoStatus) {
        return ordemServicoRepository.findById(id)
            .map(os -> {
                try {
                    // Tenta converter a string para o enum Status
                    Status status = Status.valueOf(novoStatus.toUpperCase());
                    os.setStatus(status);

                    // Ajustando a data de fechamento
                    if (status == Status.FINALIZADA || status == Status.CANCELADA) {
                        os.setDataFechamento(LocalDateTime.now());
                    } else {
                        os.setDataFechamento(null);
                    }

                    return ordemServicoRepository.save(os);
                } catch (IllegalArgumentException e) {
                    // Lança a exceção para ser tratada no Controller (retornando 400 Bad Request)
                    throw new IllegalArgumentException("Status inválido. Use ABERTA, EM_ANDAMENTO, FINALIZADA ou CANCELADA.");
                }
            });
    }
}
