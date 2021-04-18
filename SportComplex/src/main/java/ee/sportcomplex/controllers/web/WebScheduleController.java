package ee.sportcomplex.controllers.web;

import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.dto.users.Admin;
import ee.sportcomplex.services.ComplexService;
import ee.sportcomplex.services.ScheduleService;
import ee.sportcomplex.services.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

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

}
