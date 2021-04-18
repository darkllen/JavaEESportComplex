package ee.sportcomplex.controllers.rest;

import ee.sportcomplex.services.AbonementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class RestAbonementController {
    private final AbonementService service;

    @ResponseBody
    @RequestMapping(value = {"/get_abonement_price_by_type_and_duration"}, method = RequestMethod.GET)
    public Integer get_abonement_price_by_type_and_duration(@RequestParam int type, @RequestParam int duration){
        return service.getPriceByTypeAndTime(type, duration).orElse(0);
    }
}
