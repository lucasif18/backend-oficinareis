package com.financas.sistemacasal.controller;

import com.financas.sistemacasal.dto.BancoResponseDTO;
import com.financas.sistemacasal.service.BancoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bancos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BancoController {

    private final BancoService bancoService;

    @GetMapping
    public ResponseEntity<List<BancoResponseDTO>> listarBancos() {
        return ResponseEntity.ok(bancoService.listarTodos());
    }
}