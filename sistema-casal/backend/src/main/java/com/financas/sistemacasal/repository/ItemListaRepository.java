package com.financas.sistemacasal.repository;

import com.financas.sistemacasal.model.ItemLista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ItemListaRepository extends JpaRepository<ItemLista, Long> {
}