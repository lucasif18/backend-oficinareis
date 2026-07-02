package com.financas.sistemacasal.repository;

import com.financas.sistemacasal.model.ContaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long> {

    @Query("""
        SELECT c
        FROM ContaBancaria c
        JOIN FETCH c.banco
        WHERE c.usuario.id = :usuarioId
    """)
    List<ContaBancaria> buscarPorUsuarioComBanco(Long usuarioId);

}