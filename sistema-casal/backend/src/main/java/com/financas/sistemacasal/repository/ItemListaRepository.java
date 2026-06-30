package com.financas.sistemacasal.repository;

import com.financas.sistemacasal.model.ItemLista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemListaRepository extends JpaRepository<ItemLista, Long> {
}