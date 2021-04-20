package ee.sportcomplex.controllers.web;

import ee.sportcomplex.dto.users.Admin;
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
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class WebCoachController {
    private final UserService userService;
    private final ComplexService complexService;

    @RequestMapping(value = {"/coaches"}, method = RequestMethod.GET)
    public String coaches(Model model, Principal principal){
        model.addAttribute("complexes", complexService.getComplexesShort());

        Optional<Admin> admin =  userService.getAdminByLogin(principal.getName());
        admin.ifPresentOrElse(v->model.addAttribute("coaches", v.getComplex().getCoaches()), ()->model.addAttribute("coaches", userService.getCoaches()));

        return "admin/coaches";
    }

    @RequestMapping(value = {"/edit_coach"}, method = RequestMethod.GET)
    public String edit_coach(@RequestParam Integer id, Model model){
        model.addAttribute("coach", userService.getCoachByID(id));
        return "admin/edit_coach";
    }
}
