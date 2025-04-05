package com.example.plantilla_hack.adapter.out.persistance.consum;

import com.example.plantilla_hack.model.Consum;

public class ConsumMapper {
    public static ConsumJPAEntity toEntity(Consum consum) {

        ConsumJPAEntity consumJPAEntity = new ConsumJPAEntity();
        consumJPAEntity.setDate(consum.getDate());
        consumJPAEntity.setDucha(consum.getDucha());
        consumJPAEntity.setGrifo(consum.getGrifo());
        consumJPAEntity.setLavadora(consum.getLavadora());
        consumJPAEntity.setCisterna(consum.getCisterna());
        consumJPAEntity.setLavaplatos(consum.getLavaplatos());
        consumJPAEntity.setTotal(consum.getTotal());

        // Aquí deberías establecer la relación con el usuario, si es necesario
         consumJPAEntity.setUserJPAEntity(consum.getUserId());


    }

    public static Consum toModel(ConsumJPAEntity consumJPAEntity) {
        // Implementación de mapeo de entidad a modelo
        return new Consum(/* parámetros */);
    }
}