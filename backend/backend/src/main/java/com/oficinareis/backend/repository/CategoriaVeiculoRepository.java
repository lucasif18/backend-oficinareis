// 1. CategoriaVeiculoRepository.java
package com.oficinareis.backend.repository;

import com.oficinareis.backend.model.CategoriaVeiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaVeiculoRepository extends JpaRepository<CategoriaVeiculo, Long> {
}
