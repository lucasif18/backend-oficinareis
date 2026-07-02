package com.financas.sistemacasal.repository;

import com.financas.sistemacasal.model.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

    // Busca todas as movimentações do casal organizadas por data
    List<Lancamento> findByCasalIdOrderByDataCompetenciaDesc(Long casalId);
}