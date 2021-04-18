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
    private final ScheduleService service;
    private final UserService userService;

    @ResponseBody
    @RequestMapping(value = {"/ga"}, method = RequestMethod.GET)
    public List<ScheduleInd> ga(Principal principal){
        return service.findAllByClientAndScheduleDateBefore(userService.getClientByLogin(principal.getName()).get(), new java.util.Date());
    }
}
