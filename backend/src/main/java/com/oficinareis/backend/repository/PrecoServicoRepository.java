// 4. PrecoServicoRepository.java
package com.oficinareis.backend.repository;

import com.oficinareis.backend.model.PrecoServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecoServicoRepository extends JpaRepository<PrecoServico, Long> {
}
