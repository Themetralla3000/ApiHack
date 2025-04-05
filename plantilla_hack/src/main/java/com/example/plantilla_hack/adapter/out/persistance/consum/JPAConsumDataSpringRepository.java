package com.example.plantilla_hack.adapter.out.persistance.consum;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface JPAConsumDataSpringRepository extends JpaRepository<ConsumJPAEntity, Long> {
    List<ConsumJPAEntity> findByUserEmail(String email);
    Optional<ConsumJPAEntity> findByDateAndUserEmail(Date date, String email);
    List<ConsumJPAEntity> findByUserEmailAndDateAfter(String email, Date date);
    Optional<ConsumJPAEntity> findTopByUserEmailOrderByDateDesc(String email);
}