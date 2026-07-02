package com.financas.sistemacasal.repository;

import com.financas.sistemacasal.model.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {
    // O Spring Data JPA gera a query automaticamente a partir do nome do método!
    List<ContaBancaria> findByUsuarioIdWithBanco(Long usuarioId);
}