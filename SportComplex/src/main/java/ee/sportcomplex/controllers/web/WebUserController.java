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
    public String book_personal(Model model, Principal principal){
        if (principal.getName() == null)
            model.addAttribute("coaches", userService.getCoachesShort());
        if (userService.getClientByLogin(principal.getName()).orElse(null).getAbonements().isEmpty())
            model.addAttribute("coaches", userService.getCoachesShort());
        else{
            model.addAttribute("coaches",
                    userService.getCoachesShortPossibleByAbonements(
                            userService.getClientByLogin(
                                    principal.getName()).orElse(null).getAbonements()));
        }
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

    @RequestMapping(value = {"/show_personal_coach"}, method = RequestMethod.GET)
    public String show_personal_coach(Model model, Principal principal){
        model.addAttribute("trainings",
                scheduleService.
                        findAllByCoachAndScheduleDateAfter(
                                userService.getCoachByLogin(principal.getName()).get(),
                                new java.util.Date()));
        model.addAttribute("old_trainings",
                scheduleService.
                        findAllByCoachAndScheduleDateBefore(
                                userService.getCoachByLogin(principal.getName()).get(),
                                new java.util.Date()));
        return "client/show_personal";
    }

    @RequestMapping(value = {"/settings"}, method = RequestMethod.GET)
    public String settings(Model model){
        //todo return "abonement"  in model attribute (if user=client)
        return "client/settings";
    }

    @RequestMapping(value = {"/change_user_info"}, method = RequestMethod.GET)
    public String change_user_info(Principal principal, Model model){
        model.addAttribute("user", userService.getAuthByLogin(principal.getName()));
        return "client/change_user_info";
    }

    @RequestMapping(value = {"/signup"}, method = RequestMethod.GET)
    public String signup(){
        return "signup";
    }
}
