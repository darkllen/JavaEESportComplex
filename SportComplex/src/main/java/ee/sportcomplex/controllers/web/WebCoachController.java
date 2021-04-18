package ee.sportcomplex.controllers.web;

import ee.sportcomplex.services.ComplexService;
import ee.sportcomplex.services.TypeService;
import ee.sportcomplex.services.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class WebCoachController {
    private final UserService userService;
    private final ComplexService complexService;

    @RequestMapping(value = {"/coaches"}, method = RequestMethod.GET)
    public String all_complexes(Model model, Principal principal){
//        model.addAttribute("complexes", complexService.getComplexesShort());
        model.addAttribute("coaches", userService.getAdminByLogin(principal.getName()).orElse(null).getComplex().getCoaches());
        return "admin/coaches";
    }

    @RequestMapping(value = {"/edit_coach"}, method = RequestMethod.GET)
    public String edit_coach(@RequestParam Integer id, Model model){
        //todo coachService.getCoachById
//        model.addAttribute("coach", coachService.getCoachById(id));
        return "admin/edit_coach";
    }
}
