package com.financas.sistemacasal.service;

import com.financas.sistemacasal.dto.ContaBancariaResponseDTO;
import com.financas.sistemacasal.repository.ContaBancariaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContaBancariaService {

    private final ContaBancariaRepository contaBancariaRepository;

    @Transactional(readOnly = true)
    public List<ContaBancariaResponseDTO> listarContasPorUsuario(Long usuarioId) {
        // Busca otimizada trazendo o relacionamento do Banco em um único Join
        return contaBancariaRepository.buscarPorUsuarioComBanco(usuarioId).stream()
                .map(ContaBancariaResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }
}