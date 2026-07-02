package com.financas.sistemacasal.repository;

import com.financas.sistemacasal.model.Banco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Long> {
}