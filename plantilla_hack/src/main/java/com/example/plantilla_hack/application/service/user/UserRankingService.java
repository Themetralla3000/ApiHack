package com.example.plantilla_hack.application.service.user;

import com.example.plantilla_hack.application.port.in.user.GetRankingFamilias;
import com.example.plantilla_hack.application.port.in.user.GetRankingSpecificPoblacioUseCase;
import com.example.plantilla_hack.application.port.out.persistance.UserRepository;
import com.example.plantilla_hack.model.User;

import java.util.List;

public class UserRankingService implements GetRankingFamilias, GetRankingSpecificPoblacioUseCase {

    private final UserRepository userRepository;

    public UserRankingService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getRankingFamilias() {
        return userRepository.getRankingFamilias();
    }


    @Override
    public List<User> getRankingSpecificPoblacio(String poblacio) {
        return userRepository.getRankingSpecificPoblacio(poblacio);
    }
}
