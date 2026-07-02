package com.financas.sistemacasal.repository;

import com.financas.sistemacasal.model.ItemEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItemEstoqueRepository
        extends JpaRepository<ItemEstoque, Long> {

    List<ItemEstoque> findItensAbaixoDoMinimo();

}