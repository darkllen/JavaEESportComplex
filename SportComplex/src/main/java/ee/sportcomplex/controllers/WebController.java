package ee.sportcomplex.controllers;

import ee.sportcomplex.repos.schedules.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

    @Autowired
    ScheduleRepo repo;


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
}
