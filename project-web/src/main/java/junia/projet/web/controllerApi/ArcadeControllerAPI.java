package junia.projet.web.controllerApi;
import junia.core.entity.Arcade;
import junia.core.service.ArcadeService;
import org.springframework.stereotype.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@Path("/arcade")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ArcadeControllerAPI implements RestController {
    private ArcadeService arcadeService;

    public ArcadeControllerAPI(ArcadeService arcadeService) {
        this.arcadeService = arcadeService;
    }

    @GET
    @Path("")
    public Map<Long, String> listArcades() {
        return arcadeService.findAll().stream().collect(Collectors.toMap(Arcade::getId, Arcade::getArcadeName));
    }

}
