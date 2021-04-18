package ee.sportcomplex.controllers.rest;

import ee.sportcomplex.dto.Abonement;
import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.dto.schedules.ScheduleInd;
import ee.sportcomplex.services.AbonementService;
import ee.sportcomplex.services.ScheduleService;
import ee.sportcomplex.services.users.UserLoginService;
import ee.sportcomplex.services.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.sql.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestTest {
    private final AbonementService service;
    private final UserService userService;

//    @ResponseBody
//    @RequestMapping(value = {"/ga"}, method = RequestMethod.GET)
//    public Integer ga(@RequestParam int t, @RequestParam int m){
//        return service.getPriceByTypeAndTime(t, m).orElse(0);
//    }
}
