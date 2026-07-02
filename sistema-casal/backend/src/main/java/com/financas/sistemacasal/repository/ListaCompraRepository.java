package com.financas.sistemacasal.repository;

import com.financas.sistemacasal.model.ListaCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ListaCompraRepository extends JpaRepository<ListaCompra, Long> {
    // Busca a lista ativa do casal que ainda não foi fechada/finalizada no mercado
    Optional<ListaCompra> findByCasalIdAndFinalizadaFalse(Long casalId);
}