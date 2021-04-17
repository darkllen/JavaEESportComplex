package ee.sportcomplex.controllers;

import ee.sportcomplex.repos.ComplexRepo;
import ee.sportcomplex.repos.users.CoachRepo;
import ee.sportcomplex.services.ComplexService;
import ee.sportcomplex.services.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestUserController {
    private final UserService service;

    @ResponseBody
    @RequestMapping(value = {"/get_all_coaches_short"}, method = RequestMethod.GET)
    public List<CoachRepo.CoachShort> get_all_coaches_short(){
        return service.getCoachesShort();
    }
}
