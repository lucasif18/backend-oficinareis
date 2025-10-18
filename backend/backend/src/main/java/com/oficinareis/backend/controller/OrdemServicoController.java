package com.oficinareis.backend.controller;

import com.oficinareis.backend.model.ItemOrdemServico;
import com.oficinareis.backend.model.OrdemServico;
import com.oficinareis.backend.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ordens") // Mapeamento simplificado
@CrossOrigin(origins = "*")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    // 1. LISTAR TODAS AS OS
    @GetMapping
    public List<OrdemServico> listarTodas() {
        return ordemServicoRepository.findAll();
    }

    // 2. ABRIR NOVA OS (Com lógica de cálculo)
    @PostMapping
    public ResponseEntity<OrdemServico> abrirOS(@RequestBody OrdemServico os) {

        double totalPecas = 0.0;

        // 1. Calcular o total de peças e ajustar o relacionamento bidirecional
        if (os.getItens() != null) {
            for (ItemOrdemServico item : os.getItens()) {
                // Seta a referência da OS dentro de cada Item, já que o JPA exige
                item.setOrdemServico(os);

                // Soma o valor de cada item (Quantidade * Preço Unitário)
                totalPecas += item.getQuantidade() * item.getPrecoUnitarioVenda();
            }
        }

        // 2. Calcular o Valor Total Final
        double valorMaoDeObra = os.getValorMaoDeObra() != null ? os.getValorMaoDeObra() : 0.0;
        double valorFinal = totalPecas + valorMaoDeObra;

        os.setValorTotal(valorFinal); // Define o valor total na OS

        // 3. Salvar a OS e todos os Itens (graças ao CascadeType.ALL)
        OrdemServico novaOs = ordemServicoRepository.save(os);

        return ResponseEntity.ok(novaOs);
    }
}