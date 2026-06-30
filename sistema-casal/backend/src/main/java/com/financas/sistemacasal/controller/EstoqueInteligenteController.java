package com.financas.sistemacasal.controller;

import com.financas.sistemacasal.model.Usuario;
import com.financas.sistemacasal.service.EstoqueInteligenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin; // 👈 Importa a anotação
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/estoque-inteligente")
@CrossOrigin(origins = "*") // Permite que o seu front-end em Vue.js conserte com o Back-end sem erros de
                            // CORS
public class EstoqueInteligenteController {

    private final EstoqueInteligenteService estoqueService;

    public EstoqueInteligenteController(EstoqueInteligenteService estoqueService) {
        this.estoqueService = estoqueService;
    }

    /**
     * Rota para acionar a inteligência artificial do Módulo 4:
     * Varre a despensa e monta a lista de compras baseada no que está acabando.
     * POST -> http://localhost:8080/api/estoque-inteligente/sincronizar/{casalId}
     */
    @PostMapping("/sincronizar/{casalId}")
    public ResponseEntity<String> sincronizarEstoqueComLista(@PathVariable Long casalId) {
        try {
            estoqueService.gerarListaComprasAutomatica(casalId);
            return ResponseEntity.ok("Lista de compras sincronizada com o estoque atual com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao sincronizar: " + e.getMessage());
        }
    }

    /**
     * Rota mágica do caixa do supermercado:
     * Finaliza a lista, abastece o estoque, retira o saldo e lança no fluxo de
     * caixa.
     * POST -> http://localhost:8080/api/estoque-inteligente/finalizar-compra
     */
    @PostMapping("/finalizar-compra")
    public ResponseEntity<String> finalizarCompra(@RequestBody CompraRequest request) {
        try {
            // Simulando a recuperação do usuário logado que veio do front (Lucas ou Lane)
            // Em produção com Spring Security, pegaríamos do SecurityContextHolder
            Usuario responsavel = new Usuario();
            responsavel.setId(request.getUsuarioId());

            estoqueService.finalizarCompraNoMercado(
                    request.getListaId(),
                    request.getContaBancariaId(),
                    request.getValorTotalGasto(),
                    responsavel,
                    request.getFormaPagamento());

            return ResponseEntity.ok("Compra finalizada! Estoque reabastecido e fluxo de caixa atualizado.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao finalizar compra: " + e.getMessage());
        }
    }
}

/**
 * Classe auxiliar DTO para mapear o JSON que virá do formulário do Vue.js
 */
class CompraRequest {
    private Long listaId;
    private Long contaBancariaId;
    private BigDecimal valorTotalGasto;
    private Long usuarioId;
    private String formaPagamento;

    // Getters e Setters para o Jackson converter o JSON perfeitamente
    public Long getListaId() {
        return listaId;
    }

    public void setListaId(Long listaId) {
        this.listaId = listaId;
    }

    public Long getContaBancariaId() {
        return contaBancariaId;
    }

    public void setContaBancariaId(Long contaBancariaId) {
        this.contaBancariaId = contaBancariaId;
    }

    public BigDecimal getValorTotalGasto() {
        return valorTotalGasto;
    }

    public void setValorTotalGasto(BigDecimal valorTotalGasto) {
        this.valorTotalGasto = valorTotalGasto;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}