package com.financas.sistemacasal.repository;

import com.financas.sistemacasal.model.ItemEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemEstoqueRepository extends JpaRepository<ItemEstoque, Long> {

    // Query para buscar automaticamente o que precisa ir para a lista de compras
    @Query("SELECT i FROM ItemEstoque i WHERE i.quantidadeAtual <= i.quantidadeMinima")
    List<ItemEstoque> findItensAbaixoDoMinimo();
}