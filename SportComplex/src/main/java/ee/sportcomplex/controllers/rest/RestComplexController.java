package ee.sportcomplex.controllers.rest;

import ee.sportcomplex.dto.Complex;
import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.repos.ComplexRepo;
import ee.sportcomplex.services.ComplexService;
import ee.sportcomplex.services.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestComplexController {
    private final ComplexService service;

    @ResponseBody
    @RequestMapping(value = {"/edit_complex"}, method = RequestMethod.POST)
    public Complex edit_complex(@RequestBody @Valid Complex complex){
        return service.editComplex(complex);
    }

}
