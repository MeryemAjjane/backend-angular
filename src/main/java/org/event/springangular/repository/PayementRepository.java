package org.event.springangular.repository;

import org.event.springangular.entities.Payement;
import org.event.springangular.entities.PayementStatus;
import org.event.springangular.entities.PayementType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PayementRepository extends JpaRepository<Payement, Long> {
    List<Payement> findByStudentCode(String code);
    List<Payement> findByStatus(PayementStatus status);
    List<Payement> findByType(PayementType type);
}
