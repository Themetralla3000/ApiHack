package com.example.plantilla_hack.adapter.out.persistance;

import com.example.plantilla_hack.model.Consum;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ConsumRepository {
    private ConsumRepositoryJPA r;
    public ConsumRepository(ConsumRepositoryJPA r){
        this.r=r;
    }

    public List<Consum> getLastDay(){
        return List.of();
    }
}
