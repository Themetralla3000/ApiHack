package com.example.plantilla_hack.adapter.in.rest.user;

import com.example.plantilla_hack.application.port.in.user.AumentarRachaUseCase;
import com.example.plantilla_hack.application.port.in.user.GetRachaUseCase;
import com.example.plantilla_hack.application.port.in.user.ReiniciarRachaUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/racha")
public class UserRachaController {

    private final GetRachaUseCase getRachaUseCase;
    private final AumentarRachaUseCase aumentarRachaUseCase;
    private final ReiniciarRachaUseCase reiniciarRachaUseCase;

    public UserRachaController(GetRachaUseCase getRachaUseCase,
                                AumentarRachaUseCase aumentarRachaUseCase,
                                ReiniciarRachaUseCase reiniciarRachaUseCase) {
        this.getRachaUseCase = getRachaUseCase;
        this.aumentarRachaUseCase = aumentarRachaUseCase;
        this.reiniciarRachaUseCase = reiniciarRachaUseCase;
    }


    // Implement the endpoints for the use cases here
    // For example:
     @GetMapping("/get")
     public ResponseEntity<Integer> getRacha() {
         int racha = getRachaUseCase.getRacha();
         return ResponseEntity.ok(racha);
     }

     @PostMapping("/increase")
     public ResponseEntity<Void> increaseRacha() {
         aumentarRachaUseCase.aumentarRacha();
         return ResponseEntity.ok().build();
     }

     @PostMapping("/reset")
     public ResponseEntity<Void> resetRacha() {
         reiniciarRachaUseCase.reiniciarRacha();
         return ResponseEntity.ok().build();
         
     }
}
