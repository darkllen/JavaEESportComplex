package ee.sportcomplex.controllers.rest;

import ee.sportcomplex.dto.Codes;
import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.dto.users.Admin;
import ee.sportcomplex.dto.users.AuthUser;
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
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RestUserController {
    private final CodeService codeService;
    private final UserService userService;

    @ResponseBody
    @RequestMapping(value = {"/generate_code"}, method = RequestMethod.POST)
    public ResponseEntity<String> generate_code(@RequestBody Codes codes, Principal principal){
        Optional<Admin> admin = userService.getAdminByLogin(principal.getName());
        admin.ifPresentOrElse(v-> codeService.save(codes, v.getComplex()), ()->codeService.save(codes));


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

    @ResponseBody
    @RequestMapping(value = {"/change_user_info"}, method = RequestMethod.POST)
    public AuthUser change_user_info(@RequestBody @Valid AuthUser user){
        return userService.editAuthUser(user);
    }

    @ResponseBody
    @RequestMapping(value = {"/send_code"}, method = RequestMethod.POST)
    public ResponseEntity<String> send_code(Principal principal, @RequestBody Map<String, String> map){
        try{
            userService.upgradeUser(userService.getAuthByLogin(principal.getName()), map.get("code"));
            return ResponseEntity.ok().body("{\"upgraded\":\"upgraded\"}");
        } catch (Exception e){
            return ResponseEntity.badRequest().header("error", "error").body("{\"error\":\"error\"}");
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/remove_code"}, method = RequestMethod.POST)
    public ResponseEntity<String> remove_code(@RequestBody Map<String, String> map){
        try{
            codeService.removeById(map.get("id"));
            return ResponseEntity.ok().body("{\"removed\":\"removed\"}");
        } catch (Exception e){
            return ResponseEntity.badRequest().header("error", "error").body("{\"removed\":\"removed\"}");
        }
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
