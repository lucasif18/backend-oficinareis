// 2. PecaMotorRepository.java
package com.oficinareis.backend.repository;

import com.oficinareis.backend.model.PecaMotor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PecaMotorRepository extends JpaRepository<PecaMotor, Long> {
}