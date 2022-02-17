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

    @ManyToOne
    private GameRoom movieRoom;

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

    public void setJeux(Jeu jeu) {
        this.jeu = jeu;
    }

    public GameRoom getMovieRoom() {
        return movieRoom;
    }

    public void setMovieRoom(GameRoom movieRoom) {
        this.movieRoom = movieRoom;
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
