// 3. TipoServicoRepository.java
package com.oficinareis.backend.repository;

import com.oficinareis.backend.model.TipoServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoServicoRepository extends JpaRepository<TipoServico, Long> {
}