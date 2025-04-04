package com.example.plantilla_hack.application.port.out.persistance;

import com.example.plantilla_hack.model.Consum;

import java.util.Date;
import java.util.List;

public interface ConsumRepository {

    List<Consum> getAllDays();
    Consum getConsumSpecificDay(Date date);
    List<Consum> getLastMonth();
    List<Consum> getLastWeek();
    Consum getLastDay();
}
