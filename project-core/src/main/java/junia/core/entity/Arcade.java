package junia.core.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@JsonIgnoreProperties({"gameRoom"})
public class Arcade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String arcadeName;

    public Arcade() {
    }

    @OneToMany(mappedBy = "arcade")
    private List<GameRoom> gameRooms;

    public String getArcadeName() {
        return arcadeName;
    }

    public void setArcadeName(String arcadeName) {
        this.arcadeName = arcadeName;
    }

    public List<GameRoom> getGameRooms() {
        return gameRooms;
    }

    public void setGameRooms(List<GameRoom> gameRooms) {
        this.gameRooms = gameRooms;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
