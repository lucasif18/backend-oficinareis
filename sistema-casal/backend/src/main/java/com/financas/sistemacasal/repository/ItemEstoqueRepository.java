package com.financas.sistemacasal.repository;

import com.financas.sistemacasal.model.ItemEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface ItemEstoqueRepository
        extends JpaRepository<ItemEstoque, Long> {

    List<ItemEstoque> findByCasalId(Long casalId);

    @Query("""
        SELECT i
        FROM ItemEstoque i
        WHERE i.quantidadeAtual <= i.quantidadeMinima
    """)
    List<ItemEstoque> findItensAbaixoDoMinimo();

}