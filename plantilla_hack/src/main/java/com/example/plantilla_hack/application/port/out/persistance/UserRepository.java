package com.example.plantilla_hack.application.port.out.persistance;

import com.example.plantilla_hack.model.User;

import java.util.List;

public interface UserRepository {

    void reiniciarRacha();

    int getRacha(); //

    void aumentarRacha();

    List<User> getRankingFamilias();

    List<User> getRankingSpecificPoblacio(String poblacio);
}
