package com.financas.sistemacasal.controller;

import com.financas.sistemacasal.dto.ItemEstoqueResponseDTO;
import com.financas.sistemacasal.service.ItemEstoqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // Ajuste conforme a URL do seu Vue 3 se necessário
public class ItemEstoqueController {

    private final ItemEstoqueService itemEstoqueService;

    @GetMapping
    public ResponseEntity<List<ItemEstoqueResponseDTO>> listarEstoque() {
        List<ItemEstoqueResponseDTO> estoque = itemEstoqueService.listarTodos();
        return ResponseEntity.ok(estoque);
    }
}