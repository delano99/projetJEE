package junia.projet.web.controllerApi;

import junia.core.entity.GameRoom;
import junia.core.service.GameRoomService;
import junia.projet.web.DTO.GameRoomDTO;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

@Controller
@Path("/gameroom")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GameRoomControllerApi implements RestController {

    private GameRoomService gameRoomService;

    public GameRoomControllerApi(GameRoomService gameRoomService) {
        this.gameRoomService = gameRoomService;
    }

    @GET
    @Path("/{arcadeName}")
    public List<GameRoomDTO> getGameRoomInArcade(@PathParam("arcadeName") String arcadeName) {
        List<GameRoom> gameRooms = gameRoomService.getGameRoomInArcade(arcadeName);
        List<GameRoomDTO> results = new ArrayList<>();

        for (GameRoom m : gameRooms) {
            GameRoomDTO result = new GameRoomDTO();
            result.setId(m.getId());
            result.setArcade(m.getArcade());
            result.setRoomNumber(m.getRoomNumber());
            results.add(result);
        }
        return results;
    }
}
