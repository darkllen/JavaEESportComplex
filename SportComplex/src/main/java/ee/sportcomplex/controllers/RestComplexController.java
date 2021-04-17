package ee.sportcomplex.controllers;

import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.repos.ComplexRepo;
import ee.sportcomplex.services.ComplexService;
import ee.sportcomplex.services.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestComplexController {
    private final ComplexService service;

    @ResponseBody
    @RequestMapping(value = {"/get_all_complexes_short"}, method = RequestMethod.GET)
    public List<ComplexRepo.ComplexShort> get_all_complexes_short(){
        return service.getComplexesShort();
    }
}
