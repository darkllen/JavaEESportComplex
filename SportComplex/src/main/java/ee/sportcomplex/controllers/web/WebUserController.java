package ee.sportcomplex.controllers.web;


import ee.sportcomplex.services.ComplexService;
import ee.sportcomplex.services.ScheduleService;
import ee.sportcomplex.services.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class WebUserController {
    private final UserService service;

    @RequestMapping(value = {"/book_personal"}, method = RequestMethod.GET)
    public String book_personal(Model model){
        model.addAttribute("coaches", service.getCoachesShort());
        return "client/book_personal";
    }
}
