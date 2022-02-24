package junia.projet.web.controllerApi;

import junia.core.entity.GameRoom;
import junia.core.entity.Session;
import junia.core.service.GameRoomService;
import junia.core.service.SessionService;
import junia.projet.web.DTO.GameRoomDTO;
import junia.projet.web.DTO.SessionDTO;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Controller
@Path("/session")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SessionControllerApi implements RestController {

    private SessionService sessionService;

    public SessionControllerApi(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GET
    @Path("/{arcadeName}")

    public List<SessionDTO> getSessionByArcade(@PathParam("arcadeName") String arcadeName){
        List<Session> sessions = sessionService.findAllSessionsSpecificArcade(arcadeName);
        List<SessionDTO> results = new ArrayList<>();

        for(Session s : sessions){
            SessionDTO result = new SessionDTO();
            result.setId(s.getId());
            result.setJeu(s.getJeu());
            result.setGameRoom(s.getGameRoom());
            result.setDate(s.getDate());
            result.setStartHour(s.getStartHour());
            results.add(result);
        }
        return results;
    }
}
