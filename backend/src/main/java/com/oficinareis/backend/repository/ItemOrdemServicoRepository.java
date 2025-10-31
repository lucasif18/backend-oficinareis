package com.oficinareis.backend.repository;

import com.oficinareis.backend.model.ItemOrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface Repository para a entidade ItemOrdemServico.
 * Estende JpaRepository, fornecendo operações CRUD básicas.
 */
@Repository
// Correção: A entidade gerenciada deve ser ItemOrdemServico
public interface ItemOrdemServicoRepository extends JpaRepository<ItemOrdemServico, Long> {
}
