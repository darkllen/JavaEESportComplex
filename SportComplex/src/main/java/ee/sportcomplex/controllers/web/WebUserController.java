package ee.sportcomplex.controllers.web;

import ee.sportcomplex.services.ScheduleService;
import ee.sportcomplex.services.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class WebUserController {
    private final UserService userService;
    private final ScheduleService scheduleService;

    @RequestMapping(value = {"/book_personal"}, method = RequestMethod.GET)
    public String book_personal(Model model){
        model.addAttribute("coaches", userService.getCoachesShort());
        return "client/book_personal";
    }

    @RequestMapping(value = {"/show_personal"}, method = RequestMethod.GET)
    public String show_personal(Model model, Principal principal){
        model.addAttribute("trainings",
                scheduleService.
                        findAllByClientAndScheduleDateAfter(
                            userService.getClientByLogin(principal.getName()).get(),
                            new java.util.Date()));
        model.addAttribute("old_trainings",
                scheduleService.
                        findAllByClientAndScheduleDateBefore(
                                userService.getClientByLogin(principal.getName()).get(),
                                new java.util.Date()));
        return "client/show_personal";
    }
}
