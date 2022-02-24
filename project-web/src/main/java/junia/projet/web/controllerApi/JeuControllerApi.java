package junia.projet.web.controllerApi;

import junia.core.entity.Jeu;
import junia.core.service.JeuService;
import junia.projet.web.DTO.JeuDTO;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.lang.annotation.Annotation;

@Controller
@Path("/jeu")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class JeuControllerApi implements RestController {

    private JeuService jeuService;

    public JeuControllerApi(JeuService jeuService) {
        this.jeuService = jeuService;
    }

    @GET
    @Path("/{jeuName}")
    public JeuDTO getJeuInfo(@PathParam("jeuName") String jeuName) {
        Jeu jeu = jeuService.findJeuByName(jeuName);
        JeuDTO result = new JeuDTO();
        result.setProduction(jeu.getProduction());
        result.setDuration(jeu.getDuration());
        result.setGenre(jeu.getGenre());
        result.setId(jeu.getId());
        result.setName(jeu.getName());
        return result;
    }
}
