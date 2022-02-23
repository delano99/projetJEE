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

    private static Map<String, Arcade> registerArcade(ArcadeService arcadeService) {

        Map<String, Arcade> arcadeMap = new HashMap<>();
        arcadeMap.put("PONG", createArcade("PONG", arcadeService));
        arcadeMap.put("Galaga", createArcade("Galaga", arcadeService));
        arcadeMap.put("Gradius", createArcade("Gradius", arcadeService));
        return arcadeMap;
    }

    private static Arcade createArcade(String arcadeName, final ArcadeService arcadeService) {

        Arcade arcade = new Arcade();
        arcade.setArcadeName(arcadeName);

        arcadeService.save(arcade);
        return arcade;
    }


    private static Map<String, Session> registerSession(SessionService sessionService, Map<String, Jeu> jeuMap, Map<String, GameRoom> gameRoomMap) {

        Map<String, Session> sessions = new HashMap<>();
        java.sql.Time timeMorning = new Time(8, 00, 00);
        java.sql.Time timeNoon = new Time(12, 00, 00);
        java.sql.Time timeAfterNoon = new Time(16, 00, 00);
        java.sql.Time timeEvening = new Time(20, 00, 00);
        String str = "2015-03-31";
        java.sql.Date date = java.sql.Date.valueOf(str);//converting string into sql date

        sessions.put("Session 1", createSession(jeuMap.get("The Legend of Zelda: Ocarina of Time"), gameRoomMap.get("Room 1 PONG"), date, timeNoon, sessionService));
        sessions.put("Session 2", createSession(jeuMap.get("Metroid Dread"), gameRoomMap.get("Room 1 PONG"), date, timeNoon, sessionService));
        sessions.put("Session 3", createSession(jeuMap.get("The Legend of Zelda: Ocarina of Time"), gameRoomMap.get("Room 1 PONG"), date, timeAfterNoon, sessionService));
        sessions.put("Session 4", createSession(jeuMap.get("PResident Evil Village"), gameRoomMap.get("Room 1 PONG"), date, timeEvening, sessionService));
        sessions.put("Session 5", createSession(jeuMap.get("Psychonauts 2 "), gameRoomMap.get("Room 2 PONG"), date, timeNoon, sessionService));
        sessions.put("Session 6", createSession(jeuMap.get("The Legend of Zelda: Ocarina of Time"), gameRoomMap.get("Room 2 PONG"), date, timeNoon, sessionService));
        sessions.put("Session 7", createSession(jeuMap.get("Super Mario 3D World + Bowser's Fury"), gameRoomMap.get("Room 2 PONG"), date, timeAfterNoon, sessionService));
        sessions.put("Session 8", createSession(jeuMap.get("Metroid Dread"), gameRoomMap.get("Room 2 PONG"), date, timeEvening, sessionService));
        sessions.put("Session 9", createSession(jeuMap.get("PResident Evil Village"), gameRoomMap.get("Room 3 PONG"), date, timeNoon, sessionService));
        sessions.put("Session 10", createSession(jeuMap.get("PResident Evil Village"), gameRoomMap.get("Room 3 PONG"), date, timeNoon, sessionService));
        sessions.put("Session 11", createSession(jeuMap.get("Super Mario 3D World + Bowser's Fury"), gameRoomMap.get("Room 3 PONG"), date, timeAfterNoon, sessionService));
        sessions.put("Session 12", createSession(jeuMap.get("The Legend of Zelda: Ocarina of Time"), gameRoomMap.get("Room 3 PONG"), date, timeEvening, sessionService));


        sessions.put("Session 13", createSession(jeuMap.get("The Legend of Zelda: Ocarina of Time"), gameRoomMap.get("Room 1 Galaga"), date, timeNoon, sessionService));
        sessions.put("Session 14", createSession(jeuMap.get("PResident Evil Village"), gameRoomMap.get("Room 1 Galaga"), date, timeNoon, sessionService));
        sessions.put("Session 15", createSession(jeuMap.get("The Legend of Zelda: Ocarina of Time"), gameRoomMap.get("Room 1 Galaga"), date, timeAfterNoon, sessionService));
        sessions.put("Session 16", createSession(jeuMap.get("Metroid Dread"), gameRoomMap.get("Room 1 Galaga"), date, timeEvening, sessionService));
        sessions.put("Session 17", createSession(jeuMap.get("Metroid Dread"), gameRoomMap.get("Room 2 Galaga"), date, timeNoon, sessionService));
        sessions.put("Session 18", createSession(jeuMap.get("Psychonauts 2 "), gameRoomMap.get("Room 2 Galaga"), date, timeNoon, sessionService));
        sessions.put("Session 19", createSession(jeuMap.get("Psychonauts 2 "), gameRoomMap.get("Room 2 Galaga"), date, timeAfterNoon, sessionService));
        sessions.put("Session 20", createSession(jeuMap.get("Super Mario 3D World + Bowser's Fury"), gameRoomMap.get("Room 2 Galaga"), date, timeEvening, sessionService));
        sessions.put("Session 21", createSession(jeuMap.get("Metroid Dread"), gameRoomMap.get("Room 3 Galaga"), date, timeNoon, sessionService));
        sessions.put("Session 22", createSession(jeuMap.get("Super Mario 3D World + Bowser's Fury"), gameRoomMap.get("Room 3 Galaga"), date, timeNoon, sessionService));
        sessions.put("Session 23", createSession(jeuMap.get("Metroid Dread"), gameRoomMap.get("Room 3 Galaga"), date, timeAfterNoon, sessionService));
        sessions.put("Session 24", createSession(jeuMap.get("Super Mario 3D World + Bowser's Fury"), gameRoomMap.get("Room 3 Galaga"), date, timeEvening, sessionService));

        sessions.put("Session 25", createSession(jeuMap.get("Metroid Dread"), gameRoomMap.get("Room 1 Gradius"), date, timeNoon, sessionService));
        sessions.put("Session 26", createSession(jeuMap.get("Metroid Dread"), gameRoomMap.get("Room 1 Gradius"), date, timeNoon, sessionService));
        sessions.put("Session 27", createSession(jeuMap.get("Super Mario 3D World + Bowser's Fury"), gameRoomMap.get("Room 1 Gradius"), date, timeAfterNoon, sessionService));
        sessions.put("Session 28", createSession(jeuMap.get("Psychonauts 2"), gameRoomMap.get("Room 1 Gradius"), date, timeEvening, sessionService));
        sessions.put("Session 29", createSession(jeuMap.get("Psychonauts 2"), gameRoomMap.get("Room 2 Gradius"), date, timeNoon, sessionService));
        sessions.put("Session 30", createSession(jeuMap.get("Super Mario 3D World + Bowser's Fury"), gameRoomMap.get("Room 2 Gradius"), date, timeNoon, sessionService));
        sessions.put("Session 31", createSession(jeuMap.get("Super Mario 3D World + Bowser's Fury"), gameRoomMap.get("Room 2 Gradius"), date, timeAfterNoon, sessionService));
        sessions.put("Session 32", createSession(jeuMap.get("Psychonauts 2"), gameRoomMap.get("Room 2 Gradius"), date, timeEvening, sessionService));
        sessions.put("Session 33", createSession(jeuMap.get("PResident Evil Village"), gameRoomMap.get("Room 3 Gradius"), date, timeNoon, sessionService));
        sessions.put("Session 34", createSession(jeuMap.get("PResident Evil Village"), gameRoomMap.get("Room 3 Gradius"), date, timeNoon, sessionService));
        sessions.put("Session 35", createSession(jeuMap.get("Metroid Dread"), gameRoomMap.get("Room 3 Gradius"), date, timeAfterNoon, sessionService));
        sessions.put("Session 36", createSession(jeuMap.get("The Legend of Zelda: Ocarina of Time"), gameRoomMap.get("Room 3 Gradius"), date, timeEvening, sessionService));

        return sessions;
    }

    private static Session createSession(Jeu jeu, GameRoom gameRoom, java.sql.Date date, java.sql.Time startHour, final SessionService sessionService) {

        Session session = new Session();
        session.setJeu(jeu);
        session.setStartHour(startHour);
        session.setDate(date);
        session.setGameRoom(gameRoom);

        sessionService.save(session);
        return session;
    }

    private static Map<String, GameRoom> registerGameRoom(GameRoomService gameRoomService, Map<String, Arcade> arcadeMap) {

        Map<String, GameRoom> gameRoomMap = new HashMap<>();
        gameRoomMap.put("Room 1 PONG", createGameRoom(1, arcadeMap.get("PONG"), gameRoomService));
        gameRoomMap.put("Room 2 PONG", createGameRoom(2, arcadeMap.get("PONG"), gameRoomService));
        gameRoomMap.put("Room 3 PONG", createGameRoom(3, arcadeMap.get("PONG"), gameRoomService));
        gameRoomMap.put("Room 1 Galaga", createGameRoom(1, arcadeMap.get("Galaga"), gameRoomService));
        gameRoomMap.put("Room 2 Galaga", createGameRoom(2, arcadeMap.get("Galaga"), gameRoomService));
        gameRoomMap.put("Room 3 Galaga", createGameRoom(3, arcadeMap.get("Galaga"), gameRoomService));
        gameRoomMap.put("Room 1 Gradius", createGameRoom(1, arcadeMap.get("Gradius"), gameRoomService));
        gameRoomMap.put("Room 2 Gradius", createGameRoom(2, arcadeMap.get("Gradius"), gameRoomService));
        gameRoomMap.put("Room 3 Gradius", createGameRoom(3, arcadeMap.get("Gradius"), gameRoomService));
        return gameRoomMap;
    }

    private static GameRoom createGameRoom(Integer gameRoomNumber, Arcade arcade, final GameRoomService gameRoomService) {

        GameRoom gameRoom = new GameRoom();
        gameRoom.setRoomNumber(gameRoomNumber);
        gameRoom.setArcade(arcade);

        gameRoomService.save(gameRoom);
        return gameRoom;
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
