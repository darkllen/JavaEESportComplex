package ee.sportcomplex.controllers;

import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.dto.schedules.ScheduleInd;
import ee.sportcomplex.repos.schedules.ScheduleGroupRepo;
import ee.sportcomplex.repos.schedules.ScheduleIndRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class WebController {

    @Autowired
    ScheduleGroupRepo repo;


    @RequestMapping(value = {"/", "/sport_club"}, method = RequestMethod.GET)
    public String index(){
        repo.findAllByCoach_Id(2).forEach(System.out::println);
//        System.out.println("SADSDA");
//        System.out.println(service.findUserByLogin("admin"));
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


    @ResponseBody
    @RequestMapping(value = {"/get_schedule_by_day_of_week_with_trener"}, method = RequestMethod.GET)
    public List<ScheduleGroup> get_schedule_by_day_of_week_with_trener(){
        return repo.findAllByCoach_Id(2);
    }


    @ResponseBody
    @RequestMapping(value = {"/get_a"}, method = RequestMethod.GET)
    public List<ScheduleGroup> get_books(){
        repo.findAllByCoach_Id(2).forEach(x->x.getCoach());
        return repo.findAllByCoach_Id(2);
    }
}
