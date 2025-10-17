package com.oficinareis.backend.repository;

import com.oficinareis.backend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marca a interface como um repositório
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Agora temos: save(), findById(), findAll(), delete(), etc.
}