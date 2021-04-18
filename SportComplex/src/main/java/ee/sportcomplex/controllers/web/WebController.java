package ee.sportcomplex.controllers.web;

import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.services.ComplexService;
import ee.sportcomplex.services.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebController {

    @RequestMapping(value = {"/", "/sport_club"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = {"/timetable"}, method = RequestMethod.GET)
    public String timetable(){
        return "timetable";
    }



}
