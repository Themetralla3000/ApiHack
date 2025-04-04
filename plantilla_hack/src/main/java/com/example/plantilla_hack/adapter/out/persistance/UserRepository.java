package com.example.plantilla_hack.adapter.out.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserJPA, Integer> {
    Optional<UserJPA> findByEmail(String email);
}