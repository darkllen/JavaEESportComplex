package ee.sportcomplex.controllers.rest;

import ee.sportcomplex.dto.Complex;
import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.services.ScheduleService;
import ee.sportcomplex.services.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        List<ScheduleGroup> scheduleGroups= service.getScheduleByDay(ScheduleGroup.DayOfWeek.valueOf(day_of_week));
//        scheduleGroups.forEach(x->System.out.println(x.getCoach().getName()));
        return service.getScheduleByDay(ScheduleGroup.DayOfWeek.valueOf(day_of_week));
    }

    @ResponseBody
    @RequestMapping(value = {"/get_schedule_by_day_of_week_by_trener"}, method = RequestMethod.GET)
    public List<ScheduleGroup> get_schedule_by_day_of_week_by_trener(Principal principal, @RequestParam String day_of_week){
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

    @ResponseBody
    @RequestMapping(value = {"/remove_schedule_group"}, method = RequestMethod.POST)
    public ResponseEntity<String> remove_schedule_group(@RequestBody Map<String, Integer> map){
        try{
            service.removeGroupById(map.get("id"));
            return ResponseEntity.ok().body("{\"removed\":\"removed\"}");
        } catch (Exception e){
            return ResponseEntity.badRequest().header("error", "error").body("{\"removed\":\"removed\"}");
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/edit_schedule_group"}, method = RequestMethod.POST)
    public ScheduleGroup edit_schedule_group(@RequestBody @Valid ScheduleGroup group){
        return service.editGroup(group);
    }

    @ResponseBody
    @RequestMapping(value = {"/add_schedule_group"}, method = RequestMethod.POST)
    public ScheduleGroup add_schedule_group(@RequestBody @Valid ScheduleGroup group){
        return service.editGroup(group);
    }

}
