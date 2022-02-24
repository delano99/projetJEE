package junia.projet.web.DTO;

import junia.core.entity.GameRoom;
import junia.core.entity.Jeu;

import java.sql.Date;
import java.sql.Time;

public class SessionDTO {

    public long id;

    private Jeu jeu;

    private GameRoom gameRoom;

    private Date date;

    private Time startHour;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    public GameRoom getGameRoom() {
        return gameRoom;
    }

    public void setGameRoom(GameRoom gameRoom) {
        this.gameRoom = gameRoom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartHour() {
        return startHour;
    }

    public void setStartHour(Time startHour) {
        this.startHour = startHour;
    }
}
