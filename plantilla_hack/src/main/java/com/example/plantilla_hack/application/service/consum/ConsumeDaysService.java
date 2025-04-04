package com.example.plantilla_hack.application.service.consum;

import com.example.plantilla_hack.application.port.in.consum.*;
import com.example.plantilla_hack.application.port.out.persistance.ConsumRepository;
import com.example.plantilla_hack.model.Consum;

import java.util.Date;
import java.util.List;

public class ConsumeDaysService implements GetAllDaysUseCase, GetConsumSpecificDayUseCase, GetLastWeekUseCase, GetLastMonthUseCase, GetYesterdayUseCase {

    private final ConsumRepository consumRepository;


    public ConsumeDaysService(ConsumRepository consumRepository) {
        this.consumRepository = consumRepository;
    }

    @Override
    public List<Consum> getAllDays() {
        return consumRepository.getAllDays();
    }

    @Override
    public Consum getConsumSpecificDay(Date date) {
        return consumRepository.getConsumSpecificDay(date);
    }

    @Override
    public List<Consum> getLastWeek() {
        return consumRepository.getLastWeek();
    }

    @Override
    public List<Consum> getLastMonth() {
        return consumRepository.getLastMonth();
    }

    @Override
    public Consum getYesterday() {
        return consumRepository.getLastDay();
    }
}
