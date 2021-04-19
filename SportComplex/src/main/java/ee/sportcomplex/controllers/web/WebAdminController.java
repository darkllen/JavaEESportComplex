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
public class WebAdminController {
    private final UserService userService;
    private final ComplexService complexService;

    @RequestMapping(value = {"/admins"}, method = RequestMethod.GET)
    public String admins(Model model, Principal principal){
        model.addAttribute("complexes", complexService.getComplexesShort());
        //todo - return admins, not coaches
        model.addAttribute("admins", userService.getAdminByLogin(principal.getName()).orElse(null).getComplex().getCoaches());
        return "owner/admins";
    }

    @RequestMapping(value = {"/edit_admin"}, method = RequestMethod.GET)
    public String edit_admin(@RequestParam Integer id, Model model){
        //todo - get admin by id, not coach
        model.addAttribute("admin", userService.getCoachByID(id));
        return "admin/edit_admin";
    }

}
