package ee.sportcomplex.controllers.web;

import ee.sportcomplex.services.ComplexService;
import ee.sportcomplex.services.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class WebAbonementController {
    private final ComplexService complexService;
    private final TypeService typeService;

    @RequestMapping(value = {"/buy_abonement"}, method = RequestMethod.GET)
    public String all_complexes(Model model){
        model.addAttribute("complexes", complexService.getComplexesShort());
        model.addAttribute("types", typeService.getTypesShort());
        return "buy_abonement";
    }
}
