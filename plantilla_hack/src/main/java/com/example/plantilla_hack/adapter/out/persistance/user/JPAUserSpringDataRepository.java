package com.example.plantilla_hack.adapter.out.persistance.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface JPAUserSpringDataRepository extends CrudRepository<UserJPAEntity, Integer> {
    Optional<UserJPAEntity> findByEmail(String email);
    List<UserJPAEntity> findAllByOrderByTotalDesc();
    List<UserJPAEntity> getRankingPoblacio(String poblacio);

    List<UserJPAEntity> findAllByOrderByRachaFamiliesDesc();
}