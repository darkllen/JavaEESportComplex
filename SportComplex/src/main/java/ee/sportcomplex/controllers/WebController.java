package ee.sportcomplex.controllers;

import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.dto.schedules.ScheduleInd;
import ee.sportcomplex.repos.ComplexRepo;
import ee.sportcomplex.repos.schedules.ScheduleGroupRepo;
import ee.sportcomplex.repos.schedules.ScheduleIndRepo;
import ee.sportcomplex.services.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebController {
    private final ScheduleService service;

    @RequestMapping(value = {"/", "/sport_club"}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = {"/all_complexes"}, method = RequestMethod.GET)
    public String all_complexes(){
        return "all_complexes";
    }

    @RequestMapping(value = {"/timetable"}, method = RequestMethod.GET)
    public String timetable(){
        return "timetable";
    }

    @RequestMapping(value = {"/buy_abonement"}, method = RequestMethod.GET)
    public String buy_abonement(){
        return "buy_abonement";
    }

    @RequestMapping(value = {"/book_personal"}, method = RequestMethod.GET)
    public String book_personal(){
        return "client/book_personal";
    }

    @RequestMapping(value = {"/show_personal"}, method = RequestMethod.GET)
    public String show_personal(){
        return "client/show_personal";
    }

    @ResponseBody
    @RequestMapping(value = {"/get_schedule_by_day_of_week_with_trener"}, method = RequestMethod.GET)
    public List<ScheduleGroup> get_schedule_by_day_of_week_with_trener(@RequestParam String day_of_week){
        return service.getScheduleByDay(ScheduleGroup.DayOfWeek.valueOf(day_of_week));
    }

}
