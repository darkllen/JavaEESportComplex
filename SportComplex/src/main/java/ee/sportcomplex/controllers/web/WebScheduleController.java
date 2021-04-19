package ee.sportcomplex.controllers.web;

import ee.sportcomplex.dto.Abonement;
import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.dto.users.Admin;
import ee.sportcomplex.dto.users.Client;
import ee.sportcomplex.dto.users.Coach;
import ee.sportcomplex.dto.users.User;
import ee.sportcomplex.services.ComplexService;
import ee.sportcomplex.services.ScheduleService;
import ee.sportcomplex.services.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class WebScheduleController {
    private final ScheduleService scheduleService;
    private final UserService userService;

    @RequestMapping(value = {"/edit_schedule_group"}, method = RequestMethod.GET)
    public String edit_schedule_group(@RequestParam Integer id, Model model, Principal principal){
        model.addAttribute("training", scheduleService.getGroupById(id));
        model.addAttribute("coaches", userService.getAdminByLogin(principal.getName()).orElse(null).getComplex().getCoaches());
        return "admin/edit_group";
    }

    @RequestMapping(value = {"/add_schedule_group"}, method = RequestMethod.GET)
    public String add_schedule_group(Model model, Principal principal){
        model.addAttribute("coaches", userService.getAdminByLogin(principal.getName()).orElse(null).getComplex().getCoaches());
        return "admin/add_group";
    }

    @RequestMapping(value = {"/timetable"}, method = RequestMethod.GET)
    public String timetable(Principal principal, Model model){
        if (principal.getName().isBlank())
        model.addAttribute("trainings", List.of(
                scheduleService.getScheduleByDay(ScheduleGroup.DayOfWeek.MONDAY),
                scheduleService.getScheduleByDay(ScheduleGroup.DayOfWeek.TUESDAY),
                scheduleService.getScheduleByDay(ScheduleGroup.DayOfWeek.WEDNESDAY),
                scheduleService.getScheduleByDay(ScheduleGroup.DayOfWeek.THURSDAY),
                scheduleService.getScheduleByDay(ScheduleGroup.DayOfWeek.FRIDAY),
                scheduleService.getScheduleByDay(ScheduleGroup.DayOfWeek.SATURDAY),
                scheduleService.getScheduleByDay(ScheduleGroup.DayOfWeek.SUNDAY)));

        Optional<Coach> coach = userService.getCoachByLogin(principal.getName());
        coach.ifPresent(value -> model.addAttribute("trainings", List.of(
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.MONDAY, List.of(value)),
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.TUESDAY, List.of(value)),
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.WEDNESDAY, List.of(value)),
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.THURSDAY, List.of(value)),
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.FRIDAY, List.of(value)),
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.SATURDAY, List.of(value)),
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.SUNDAY, List.of(value)))));

        Optional<Admin> admin = userService.getAdminByLogin(principal.getName());
        admin.ifPresent(value -> model.addAttribute("trainings", List.of(
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.MONDAY,    value.getComplex().getCoaches()),
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.TUESDAY,   value.getComplex().getCoaches()),
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.WEDNESDAY, value.getComplex().getCoaches()),
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.THURSDAY,  value.getComplex().getCoaches()),
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.FRIDAY,    value.getComplex().getCoaches()),
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.SATURDAY,  value.getComplex().getCoaches()),
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.SUNDAY,    value.getComplex().getCoaches()))));

        Optional<Client> client = userService.getClientByLogin(principal.getName());
        client.ifPresent(value -> model.addAttribute("trainings", List.of(
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.MONDAY,    value.getAbonements().stream().flatMap(x->x.getComplex().getCoaches().stream()).collect(Collectors.toList())),
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.TUESDAY,   value.getAbonements().stream().flatMap(x->x.getComplex().getCoaches().stream()).collect(Collectors.toList())),
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.WEDNESDAY, value.getAbonements().stream().flatMap(x->x.getComplex().getCoaches().stream()).collect(Collectors.toList())),
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.THURSDAY,  value.getAbonements().stream().flatMap(x->x.getComplex().getCoaches().stream()).collect(Collectors.toList())),
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.FRIDAY,    value.getAbonements().stream().flatMap(x->x.getComplex().getCoaches().stream()).collect(Collectors.toList())),
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.SATURDAY,  value.getAbonements().stream().flatMap(x->x.getComplex().getCoaches().stream()).collect(Collectors.toList())),
                scheduleService.getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek.SUNDAY,    value.getAbonements().stream().flatMap(x->x.getComplex().getCoaches().stream()).collect(Collectors.toList())))));

        if (!model.containsAttribute("trainings"))
            model.addAttribute("trainings", List.of(
                    scheduleService.getScheduleByDay(ScheduleGroup.DayOfWeek.MONDAY),
                    scheduleService.getScheduleByDay(ScheduleGroup.DayOfWeek.TUESDAY),
                    scheduleService.getScheduleByDay(ScheduleGroup.DayOfWeek.WEDNESDAY),
                    scheduleService.getScheduleByDay(ScheduleGroup.DayOfWeek.THURSDAY),
                    scheduleService.getScheduleByDay(ScheduleGroup.DayOfWeek.FRIDAY),
                    scheduleService.getScheduleByDay(ScheduleGroup.DayOfWeek.SATURDAY),
                    scheduleService.getScheduleByDay(ScheduleGroup.DayOfWeek.SUNDAY)));

        return "timetable";
    }
}
