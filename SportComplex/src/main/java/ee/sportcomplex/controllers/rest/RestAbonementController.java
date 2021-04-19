package ee.sportcomplex.controllers.rest;

import ee.sportcomplex.dto.Abonement;
import ee.sportcomplex.services.AbonementService;
import ee.sportcomplex.services.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RestAbonementController {
    private final AbonementService service;
    private final UserService userService;

    @ResponseBody
    @RequestMapping(value = {"/get_abonement_price_by_type_and_duration"}, method = RequestMethod.GET)
    public Integer get_abonement_price_by_type_and_duration(@RequestParam int type, @RequestParam int duration){
        return service.getPriceByTypeAndTime(type, duration);
    }

    @ResponseBody
    @RequestMapping(value = {"/add_existing_abonement"}, method = RequestMethod.POST)
    public ResponseEntity<String> add_existing_abonement(@RequestBody Map<String, Integer> map, Principal principal){
        try{
            service.addExistingAbonement(map.get("id"), userService.getClientByLogin(principal.getName()).orElse(null));
            return ResponseEntity.ok().body("ok");
        }catch (Exception e){
            return ResponseEntity.badRequest().header("error", "impossible to add").body("error");
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/add_abonement"}, method = RequestMethod.POST)
    public ResponseEntity<String> add_abonement(@RequestBody @Valid Abonement abonement, Principal principal){
        try{
            if (principal==null){
                return ResponseEntity.ok().body(String.valueOf(service.addAbonement(abonement)));
            }else {
                abonement.setClient(userService.getClientByLogin(principal.getName()).orElse(null));
                service.addAbonement(abonement);
                return ResponseEntity.ok().body("\"ok\"");
            }

        }catch (Exception e){
            return ResponseEntity.badRequest().header("error", "impossible to add").body("error");
        }
    }


//    add_abonement
}
