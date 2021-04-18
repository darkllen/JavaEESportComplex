package ee.sportcomplex.controllers.rest;

import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.services.ScheduleService;
import ee.sportcomplex.services.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RestScheduleController {
    private final ScheduleService service;
    private final UserService userService;

    @ResponseBody
    @RequestMapping(value = {"/get_schedule_by_day_of_week_with_trener"}, method = RequestMethod.GET)
    public List<ScheduleGroup> get_schedule_by_day_of_week_with_trener(@RequestParam String day_of_week){
        return service.getScheduleByDay(ScheduleGroup.DayOfWeek.valueOf(day_of_week));
    }

    @ResponseBody
    @RequestMapping(value = {"/get_shedule_by_day_of_week_by_trener"}, method = RequestMethod.GET)
    public List<ScheduleGroup> get_schedule_by_day_of_week_with_trener(Principal principal, @RequestParam String day_of_week){
        return service.getScheduleByDayByCoach(ScheduleGroup.DayOfWeek.valueOf(day_of_week), userService.getCoachByLogin(principal.getName()).orElse(null));
    }

    @ResponseBody
    @RequestMapping(value = {"/remove_schedule_ind"}, method = RequestMethod.POST)
    public ResponseEntity<String> remove_schedule_ind(@RequestBody Map<String, Integer> map){
        try{
            service.removeIndById(map.get("id"));
            return ResponseEntity.ok().body("{\"removed\":\"removed\"}");
        } catch (Exception e){
            return ResponseEntity.badRequest().header("error", "error").body("{\"removed\":\"removed\"}");
        }
    }
}
