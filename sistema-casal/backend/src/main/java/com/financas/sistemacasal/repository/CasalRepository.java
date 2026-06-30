package com.financas.sistemacasal.repository;

import com.financas.sistemacasal.model.Casal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasalRepository extends JpaRepository<Casal, Long> {
}