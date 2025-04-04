package com.example.plantilla_hack.adapter.in.rest.consum;

import com.example.plantilla_hack.application.port.in.consum.*;
import com.example.plantilla_hack.model.Consum;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/carts")
public class ConsumeDaysController {

    private final GetAllDaysUseCase getAllDaysUseCase;
    private final GetConsumSpecificDayUseCase getConsumSpecificDayUseCase;
    private final GetLastMonthUseCase getLastMonthUseCase;
    private final GetLastWeekUseCase getLastWeekUseCase;
    private final GetYesterdayUseCase getYesterdayUseCase;

    public ConsumeDaysController(GetAllDaysUseCase getAllDaysUseCase,
                                  GetConsumSpecificDayUseCase getConsumSpecificDayUseCase,
                                  GetLastMonthUseCase getLastMonthUseCase,
                                  GetLastWeekUseCase getLastWeekUseCase,
                                  GetYesterdayUseCase getYesterdayUseCase) {
        this.getAllDaysUseCase = getAllDaysUseCase;
        this.getConsumSpecificDayUseCase = getConsumSpecificDayUseCase;
        this.getLastMonthUseCase = getLastMonthUseCase;
        this.getLastWeekUseCase = getLastWeekUseCase;
        this.getYesterdayUseCase = getYesterdayUseCase;
    }


    // Implement the endpoints for the use cases here
// Implement the endpoints for the use cases here

    @GetMapping("/all")
    public ResponseEntity<List<Consum>> getAllDays() {
        List<Consum> consumList = getAllDaysUseCase.getAllDays();
        return ResponseEntity.ok(consumList);
    }

    @GetMapping("/specific")
    public ResponseEntity<Consum> getConsumSpecificDay(@RequestParam Date date) {
        Consum consum = getConsumSpecificDayUseCase.getConsumSpecificDay(date);
        return ResponseEntity.ok(consum);
    }

    @GetMapping("/last-month")
    public ResponseEntity<List<Consum>> getLastMonth() {
        List<Consum> consumList = getLastMonthUseCase.getLastMonth();
        return ResponseEntity.ok(consumList);
    }

    @GetMapping("/last-week")
    public ResponseEntity<List<Consum>> getLastWeek() {
        List<Consum> consumList = getLastWeekUseCase.getLastWeek();
        return ResponseEntity.ok(consumList);
    }

    @GetMapping("/yesterday")
    public ResponseEntity<Consum> getYesterday() {
        Consum consumList = getYesterdayUseCase.getYesterday();
        return ResponseEntity.ok(consumList);
    }
}
