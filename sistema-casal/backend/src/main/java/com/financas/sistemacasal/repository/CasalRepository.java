package com.financas.sistemacasal.repository;

import com.financas.sistemacasal.model.Casal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CasalRepository extends JpaRepository<Casal, Long> {
}