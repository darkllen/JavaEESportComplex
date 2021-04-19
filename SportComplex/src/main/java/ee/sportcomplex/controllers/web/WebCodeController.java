package ee.sportcomplex.controllers.web;

import ee.sportcomplex.dto.users.Admin;
import ee.sportcomplex.dto.users.User;
import ee.sportcomplex.services.CodeService;
import ee.sportcomplex.services.ComplexService;
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
public class WebCodeController {
    private final ComplexService complexService;
    private final UserService userService;
    private final CodeService codeService;

    @RequestMapping(value = {"/generate_code"}, method = RequestMethod.GET)
    public String generate_code(Model model){
        model.addAttribute("complexes", complexService.getComplexes());
        return "owner/generate_code";
    }
    @RequestMapping(value = {"/available_codes"}, method = RequestMethod.GET)
    public String available_codes(Principal principal, Model model){
        if (principal == null){
            model.addAttribute("codes", codeService.getAll());
            return "admin/available_codes";
        }


        Optional<Admin> admin = userService.getAdminByLogin(principal.getName());
        admin.ifPresent(value -> model.addAttribute("codes",codeService.getAllByRoleAndComplex("COACH", value.getComplex())));

        if (!model.containsAttribute("codes"))
            model.addAttribute("codes", codeService.getAll());

        return "admin/available_codes";
    }

}
