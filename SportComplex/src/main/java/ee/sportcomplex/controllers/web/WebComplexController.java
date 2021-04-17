package ee.sportcomplex.controllers.web;

import ee.sportcomplex.services.ComplexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class WebComplexController {
    private final ComplexService complexService;

    @RequestMapping(value = {"/all_complexes"}, method = RequestMethod.GET)
    public String all_complexes(Model model){
        model.addAttribute("complexes", complexService.getComplexes());
        return "all_complexes";
    }
}
