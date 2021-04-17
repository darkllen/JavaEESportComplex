package ee.sportcomplex.controllers.rest;

import ee.sportcomplex.dto.Abonement;
import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.services.AbonementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestTest {
    private final AbonementService service;

    @ResponseBody
    @RequestMapping(value = {"/ga"}, method = RequestMethod.GET)
    public List<Abonement> ga(){
        return service.getAbonements();
    }
}
