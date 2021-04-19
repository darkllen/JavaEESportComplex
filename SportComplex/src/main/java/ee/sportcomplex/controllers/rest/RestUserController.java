package ee.sportcomplex.controllers.rest;

import ee.sportcomplex.dto.Codes;
import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.dto.users.Coach;
import ee.sportcomplex.dto.users.User;
import ee.sportcomplex.repos.ComplexRepo;
import ee.sportcomplex.repos.users.CoachRepo;
import ee.sportcomplex.services.CodeService;
import ee.sportcomplex.services.ComplexService;
import ee.sportcomplex.services.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RestUserController {
    private final CodeService codeService;
    private final UserService userService;

    @ResponseBody
    @RequestMapping(value = {"/generate_code"}, method = RequestMethod.POST)
    public ResponseEntity<String> generate_code(@RequestBody Codes codes){
        codeService.save(codes);
        return ResponseEntity.ok().body("\""+codes.getId()+"\"");
    }


    @ResponseBody
    @RequestMapping(value = {"/remove_coach"}, method = RequestMethod.POST)
    public ResponseEntity<String> remove_coach(@RequestBody Map<String, Integer> map){
        try{
            userService.setToClient(map.get("id"));
            return ResponseEntity.ok().body("{\"removed\":\"removed\"}");
        } catch (Exception e){
            return ResponseEntity.badRequest().header("error", "error").body("{\"removed\":\"removed\"}");
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/edit_coach"}, method = RequestMethod.POST)
    public Coach edit_schedule_group(@RequestBody @Valid Coach coach){
        //TODO test
        return userService.editCoach(coach);
    }

//    private final UserService service;
//
//    @ResponseBody
//    @RequestMapping(value = {"/get_all_coaches_short"}, method = RequestMethod.GET)
//    public List<Coach> get_all_coaches_short(){
//        service.getCoaches().forEach(System.out::println);
//        return service.getCoaches();
//    }
}
