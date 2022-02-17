package junia.projet.data;

import junia.core.entity.Arcade;
import junia.core.entity.GameRoom;
import junia.core.entity.Jeu;
import junia.core.entity.Session;
import junia.core.service.ArcadeService;
import junia.core.service.GameRoomService;
import junia.core.service.JeuService;
import junia.core.service.SessionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

public class Application {


    public static void main(String[] args) {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("junia.core.config");
        final JeuService jeuService = context.getBean(JeuService.class);
        final SessionService sessionService = context.getBean(SessionService.class);
        final GameRoomService gameRoomService = context.getBean(GameRoomService.class);
        final ArcadeService arcadeService = context.getBean(ArcadeService.class);
        cleanDB(jeuService, sessionService, gameRoomService, arcadeService);
        final Map<String, Jeu> jeuMap = registerJeu(jeuService);
        final Map<String, Arcade> arcadeMap = registerArcade(arcadeService);
        final Map<String, GameRoom> gameRoomMap = registerGameRoom(gameRoomService, arcadeMap);
        final Map<String, Session> sessionMap = registerSession(sessionService, jeuMap, gameRoomMap);

    }

    private static void cleanDB(final JeuService jeuService, final SessionService sessionService, final GameRoomService gameRoomService, final ArcadeService arcadeService) {
        sessionService.deleteAll();
        gameRoomService.deleteAll();
        arcadeService.deleteAll();
        jeuService.deleteAll();
    }

    private static Map<String, Session> registerSession(SessionService sessionService, Map<String, Jeu> jeuMap, Map<String, GameRoom> gameRoomMap) {
    }

    private static Map<String, GameRoom> registerGameRoom(GameRoomService gameRoomService, Map<String, Arcade> arcadeMap) {
    }

    private static Map<String, Arcade> registerArcade(ArcadeService arcadeService) {
    }

    private static Map<String, Jeu> registerJeu(JeuService jeuService) {
        Map<String, Jeu> jeuMap = new HashMap<>();
        jeuMap.put("The Legend of Zelda: Ocarina of Time", createJeu("The Legend of Zelda: Ocarina of Time", "Electronic Arts", "Action-Aventure", 1415, jeuService));
        jeuMap.put("PResident Evil Village ", createJeu("Resident Evil Village ", "Capcom ", "Horreur", 2000, jeuService));
        jeuMap.put("Metroid Dread", createJeu("Metroid Dread", "MercurySteam Entertainment ", "Science-Fiction", 3000, jeuService));
        jeuMap.put("Super Mario 3D World + Bowser's Fury", createJeu("Super Mario 3D World + Bowser's Fury", "Nintendo EPD, NST", "Aventure", 2507, jeuService));
        jeuMap.put("Psychonauts 2 ", createJeu("Psychonauts 2 ", "Double Fine Productions", "Aventure", 4000, jeuService));
        return jeuMap;
    }

    private static Jeu createJeu(String filmName, String production, String genre, int duration, final JeuService jeuService ) {

        Jeu jeu = new Jeu();
        jeu.setName(filmName);
        jeu.setProduction(production);
        jeu.setGenre(genre);
        jeu.setDuration(duration);

        jeuService.save(jeu);
        return jeu;
    }



}
