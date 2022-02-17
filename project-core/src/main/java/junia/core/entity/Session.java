package junia.core.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @ManyToOne
    private Jeu jeu;

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

    @ManyToOne
    private GameRoom gameRoom;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;

    private Time startHour;

    public Session() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Jeu getJeux() {
        return jeu;
    }


}
