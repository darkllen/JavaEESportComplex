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
public class WebCodeController {
    private final ComplexService complexService;

    @RequestMapping(value = {"/generate_code"}, method = RequestMethod.GET)
    public String generate_code(Model model){
        model.addAttribute("complexes", complexService.getComplexes());
        return "owner/generate_code";
    }
}
