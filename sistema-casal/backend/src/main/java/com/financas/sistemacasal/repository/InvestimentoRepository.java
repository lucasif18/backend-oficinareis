package com.financas.sistemacasal.repository;

import com.financas.sistemacasal.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {
    
    // Busca os investimentos de vocês filtrando por status (ex: listar só os que ainda estão ATIVOS)
    List<Investimento> findByCasalIdAndStatus(Long casalId, String status);
}