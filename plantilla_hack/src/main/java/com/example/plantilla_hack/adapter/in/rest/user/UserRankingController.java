package com.example.plantilla_hack.adapter.in.rest.user;

import com.example.plantilla_hack.application.port.in.user.GetRankingFamilias;
import com.example.plantilla_hack.application.port.in.user.GetRankingSpecificPoblacioUseCase;
import com.example.plantilla_hack.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user/ranking")
public class UserRankingController {

     private final GetRankingFamilias getRankingFamilias;
     private final GetRankingSpecificPoblacioUseCase getRankingSpecificPoblacioUseCase;



    public UserRankingController(GetRankingFamilias getRankingFamilias, GetRankingSpecificPoblacioUseCase getRankingSpecificPoblacioUseCase) {
        this.getRankingFamilias = getRankingFamilias;
        this.getRankingSpecificPoblacioUseCase = getRankingSpecificPoblacioUseCase;
    }

    @RequestMapping("/families")
    public List<User> getRankingFamilias(@RequestParam String email) {
        return getRankingFamilias.getRankingFamilias(email);
    }

    @RequestMapping("/poblacio")
    public List<User> getRankingSpecificPoblacio(@RequestParam String poblacio) {
        return getRankingSpecificPoblacioUseCase.getRankingSpecificPoblacio(poblacio);
    }
}
