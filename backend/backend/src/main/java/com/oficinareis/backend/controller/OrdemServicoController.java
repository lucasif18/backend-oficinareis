package com.oficinareis.backend.controller;

import com.oficinareis.backend.model.OrdemServico;
import com.oficinareis.backend.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ordens-servico")
@CrossOrigin(origins = "*")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @GetMapping
    public List<OrdemServico> listar() {
        return ordemServicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public OrdemServico buscarPorId(@PathVariable Long id) {
        return ordemServicoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public OrdemServico criar(@RequestBody OrdemServico ordemServico) {
        return ordemServicoRepository.save(ordemServico);
    }

    @PutMapping("/{id}")
    public OrdemServico atualizar(@PathVariable Long id, @RequestBody OrdemServico ordemAtualizada) {
        return ordemServicoRepository.findById(id)
                .map(ordem -> {
                    ordem.setData(ordemAtualizada.getData());
                    ordem.setNumeroOrdem(ordemAtualizada.getNumeroOrdem());
                    ordem.setTipoVeiculo(ordemAtualizada.getTipoVeiculo());
                    ordem.setModeloMotor(ordemAtualizada.getModeloMotor());
                    ordem.setSerie(ordemAtualizada.getSerie());
                    ordem.setTipoPeca(ordemAtualizada.getTipoPeca());
                    ordem.setCliente(ordemAtualizada.getCliente());
                    ordem.setCategoria(ordemAtualizada.getCategoria());
                    ordem.setPecas(ordemAtualizada.getPecas());
                    ordem.setServicos(ordemAtualizada.getServicos());
                    return ordemServicoRepository.save(ordem);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        ordemServicoRepository.deleteById(id);
    }
}
