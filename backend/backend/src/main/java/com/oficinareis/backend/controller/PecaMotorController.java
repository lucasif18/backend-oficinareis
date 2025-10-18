package com.oficinareis.backend.controller;

import com.oficinareis.backend.model.PecaMotor;
import com.oficinareis.backend.repository.PecaMotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pecas-motor")
@CrossOrigin(origins = "*")
public class PecaMotorController {

    @Autowired
    private PecaMotorRepository pecaMotorRepository;

    // GET: Listar todas as Peças de Motor
    @GetMapping
    public List<PecaMotor> listarTodas() {
        return pecaMotorRepository.findAll();
    }

    // POST: Criar nova Peça de Motor
    @PostMapping
    public PecaMotor criarPecaMotor(@RequestBody PecaMotor pecaMotor) {
        return pecaMotorRepository.save(pecaMotor);
    }

    // PUT: Atualizar Peça de Motor por ID
    @PutMapping("/{id}")
    public ResponseEntity<PecaMotor> atualizarPecaMotor(@PathVariable Long id, @RequestBody PecaMotor novaPecaMotor) {
        return pecaMotorRepository.findById(id)
                .map(peca -> {
                    peca.setNome(novaPecaMotor.getNome());
                    return ResponseEntity.ok(pecaMotorRepository.save(peca));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE: Excluir Peça de Motor por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPecaMotor(@PathVariable Long id) {
        if (!pecaMotorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pecaMotorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}