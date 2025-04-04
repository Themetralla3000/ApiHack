package com.example.plantilla_hack.application.service.user;

import com.example.plantilla_hack.application.port.in.user.AumentarRachaUseCase;
import com.example.plantilla_hack.application.port.in.user.GetRachaUseCase;
import com.example.plantilla_hack.application.port.in.user.ReiniciarRachaUseCase;
import com.example.plantilla_hack.application.port.out.persistance.UserRepository;

public class UserRachaService implements AumentarRachaUseCase, ReiniciarRachaUseCase, GetRachaUseCase {

private final UserRepository userRepository;

    public UserRachaService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void aumentarRacha() {
        userRepository.aumentarRacha();
    }

    @Override
    public void reiniciarRacha() {
        userRepository.reiniciarRacha();
    }

    @Override
    public int getRacha() {
        return userRepository.getRacha();
    }
}
