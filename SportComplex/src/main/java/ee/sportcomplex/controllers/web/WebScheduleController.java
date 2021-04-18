package ee.sportcomplex.controllers.web;

import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.services.ComplexService;
import ee.sportcomplex.services.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebScheduleController {

    @RequestMapping(value = {"/edit_schedule_group"}, method = RequestMethod.GET)
    public String timetable(@RequestParam Integer id){
        //todo - add model attribute - name = training - get by id
        //todo - add model attribute - name = coaches - list of all coaches from complex where admin belongs

        return "admin/edit_group";
    }

}
