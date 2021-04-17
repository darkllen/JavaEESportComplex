package ee.sportcomplex.controllers.rest;

import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.services.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestScheduleController {
    private final ScheduleService service;

    @ResponseBody
    @RequestMapping(value = {"/get_schedule_by_day_of_week_with_trener"}, method = RequestMethod.GET)
    public List<ScheduleGroup> get_schedule_by_day_of_week_with_trener(@RequestParam String day_of_week){
        return service.getScheduleByDay(ScheduleGroup.DayOfWeek.valueOf(day_of_week));
    }
}
