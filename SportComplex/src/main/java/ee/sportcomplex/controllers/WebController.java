package ee.sportcomplex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ee.sportcomplex.services.UserService;

@Controller
public class WebController {
//    @Autowired
//    UserService service;

    @RequestMapping(value = {"/aa", "all_books"}, method = RequestMethod.GET)
    public String index(){
//        System.out.println("SADSDA");
//        System.out.println(service.loadUserByUsername("admin"));
        return "index";
    }
}
