package com.example.plantilla_hack.adapter.out.persistance.consum;

import com.example.plantilla_hack.application.port.out.persistance.ConsumRepository;
import com.example.plantilla_hack.model.Consum;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JPAConsumRepository implements ConsumRepository {

    private final JPAConsumDataSpringRepository consumJpaRepository;

    public JPAConsumRepository(JPAConsumDataSpringRepository consumJpaRepository) {
        this.consumJpaRepository = consumJpaRepository;
    }

    @Override
    public List<Consum> getAllDays(String email) {
        return consumJpaRepository.findByUserEmail(email).stream()
                .map(ConsumMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Consum getConsumSpecificDay(Date date, String email) {
        return consumJpaRepository.findByDateAndUserEmail(date, email)
                .map(ConsumMapper::toModel)
                .orElse(null);
    }

    @Override
    public List<Consum> getLastMonth(String email) {
        Date oneMonthAgo = // calcular la fecha de hace un mes
        return consumJpaRepository.findByUserEmailAndDateAfter(email, oneMonthAgo).stream()
                .map(ConsumMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Consum> getLastWeek(String email) {
        Date oneWeekAgo = // calcular la fecha de hace una semana
        return consumJpaRepository.findByUserEmailAndDateAfter(email, oneWeekAgo).stream()
                .map(ConsumMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Consum getLastDay(String email) {
        return consumJpaRepository.findTopByUserEmailOrderByDateDesc(email)
                .map(ConsumMapper::toModel)
                .orElse(null);
    }
}