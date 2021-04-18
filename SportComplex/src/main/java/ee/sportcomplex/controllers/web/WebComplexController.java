package ee.sportcomplex.controllers.web;

import ee.sportcomplex.services.ComplexService;
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
public class WebComplexController {
    private final ComplexService complexService;
    private final UserService userService;

    @RequestMapping(value = {"/all_complexes"}, method = RequestMethod.GET)
    public String all_complexes(Model model){
        model.addAttribute("complexes", complexService.getComplexes());
        return "all_complexes";
    }

    @RequestMapping(value = {"/edit_complex"}, method = RequestMethod.GET)
    public String edit_complex(Principal principal, Model model, @RequestParam(required = false) Integer id){
        if (id != null){
            model.addAttribute("complex", complexService.getById(id));
        }else{
            model.addAttribute("complex", complexService.getById(
                    userService.getAdminByLogin(
                            principal.getName()).orElse(null)
                            .getComplex()
                            .getId()));
        }

        return "admin/edit_complex";
    }
}
