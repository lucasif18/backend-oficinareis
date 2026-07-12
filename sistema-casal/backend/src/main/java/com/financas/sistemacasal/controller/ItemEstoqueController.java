package com.financas.sistemacasal.controller;

import com.financas.sistemacasal.dto.ItemEstoqueResponseDTO;
import com.financas.sistemacasal.service.ItemEstoqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/api/casais/{casalId}/estoque")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ItemEstoqueController {

    private final ItemEstoqueService itemEstoqueService;

    @PostMapping
    public ResponseEntity<List<ItemEstoqueResponseDTO>> listarEstoque(
            @PathVariable Long casalId) {

        return ResponseEntity.ok(
                itemEstoqueService.listarPorCasal(casalId)
        );
    }
}