package com.financas.sistemacasal.service;

import com.financas.sistemacasal.dto.BancoResponseDTO;
import com.financas.sistemacasal.repository.BancoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BancoService {

    private final BancoRepository bancoRepository;

    @Transactional(readOnly = true)
    public List<BancoResponseDTO> listarTodos() {
        return bancoRepository.findAll().stream()
                .map(BancoResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }
}