package junia.projet.web.controller;

import junia.core.entity.Session;
import junia.core.service.SessionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SessionController {

    private SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @RequestMapping(value = "/session/{arcadeName}", method = RequestMethod.GET)
    public String getListOfSessions(ModelMap modelMap, @PathVariable("arcadeName") String arcadeName) {
        List<Session> sessions = sessionService.findAllSessionsSpecificArcade(arcadeName);
        modelMap.put("sessions", sessions);
        return "sessionList";
    }


}
