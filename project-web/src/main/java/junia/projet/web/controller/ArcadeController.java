package junia.projet.web.controller;

import org.springframework.stereotype.Controller;
import junia.core.entity.Arcade;
import junia.core.service.ArcadeService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class ArcadeController {

    private ArcadeService arcadeService;

    public ArcadeController(ArcadeService arcadeService) {
        this.arcadeService = arcadeService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getListOfArcade(ModelMap modelMap) {
        List<Arcade> arcades = arcadeService.findAll();

        modelMap.put("arcades", arcades);

        return "arcadeList";
    }

}
