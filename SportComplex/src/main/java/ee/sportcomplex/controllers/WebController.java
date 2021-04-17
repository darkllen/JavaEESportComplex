package ee.sportcomplex.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
//    @Autowired
//    UserService service;

    @RequestMapping(value = {"/", "/sport_club"}, method = RequestMethod.GET)
    public String index(){
//        System.out.println("SADSDA");
//        System.out.println(service.loadUserByUsername("admin"));
        return "index";
    }
}
