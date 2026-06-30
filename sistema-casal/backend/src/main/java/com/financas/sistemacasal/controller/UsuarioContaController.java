package com.financas.sistemacasal.controller;

import com.financas.sistemacasal.dto.ContaBancariaResponseDTO;
import com.financas.sistemacasal.service.ContaBancariaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioContaController {

    private final ContaBancariaService contaBancariaService;

    @GetMapping("/{id}/contas")
    public ResponseEntity<List<ContaBancariaResponseDTO>> listarContasDoUsuario(@PathVariable Long id) {
        List<ContaBancariaResponseDTO> contas = contaBancariaService.listarContasPorUsuario(id);
        return ResponseEntity.ok(contas);
    }
}