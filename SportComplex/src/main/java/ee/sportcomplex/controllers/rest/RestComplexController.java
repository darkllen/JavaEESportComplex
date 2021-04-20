package ee.sportcomplex.controllers.rest;

import ee.sportcomplex.dto.Complex;
import ee.sportcomplex.services.ComplexService;
import ee.sportcomplex.services.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RestComplexController {
    private final ComplexService service;

    @ResponseBody
    @RequestMapping(value = {"/edit_complex", "/add_complex"}, method = RequestMethod.POST)
    public Complex edit_complex(@RequestBody @Valid Complex complex){
        return service.editComplex(complex);
    }

    @ResponseBody
    @RequestMapping(value = {"/remove_complex"}, method = RequestMethod.POST)
    public ResponseEntity<String> remove_complex(@RequestBody Map<String, Integer> map){
        try{
            service.removeComplexById(map.get("id"));
            return ResponseEntity.ok().body("{\"removed\":\"removed\"}");
        } catch (Exception e){
            return ResponseEntity.badRequest().header("error", "error").body("{\"removed\":\"removed\"}");
        }
    }

}
