package ee.sportcomplex.controllers.web;

import ee.sportcomplex.dto.schedules.ScheduleGroup;
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
    public String timetable(@RequestParam Integer id, Model model, Principal principal){
        //todo - add model attribute - name = training - get by id
        model.addAttribute("training", scheduleService.getGroupById(id));
        //todo - add model attribute - name = coaches - list of all coaches from complex where admin belongs
        model.addAttribute("coaches", userService.getAdminByLogin(principal.getName()).orElse(null).getComplex());

        return "admin/edit_group";
    }

}
