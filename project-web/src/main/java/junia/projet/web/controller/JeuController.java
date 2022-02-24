package junia.projet.web.controller;

import junia.core.service.JeuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class JeuController {

    private JeuService jeuService;

    public JeuController(JeuService jeuService) {
        this.jeuService = jeuService;
    }

    @RequestMapping(value = "/jeuInfo/{id_jeu}", method = RequestMethod.GET)
    public String getInfoOfJeu(ModelMap modelMap, @PathVariable("id_jeu") Long id_jeu) {
        modelMap.put("jeu", jeuService.findJeu(id_jeu));
        return "jeuList";
    }
}
