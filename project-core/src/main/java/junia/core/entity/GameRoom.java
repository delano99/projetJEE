package junia.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"sessions"})
public class GameRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    private Integer roomNumber;

    @OneToMany(mappedBy = "gameRoom")
    @JsonIgnore
    private List<Session> sessions;


    @ManyToOne
    @JsonIgnore
    private Arcade arcade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public Arcade getArcade() {
        return arcade;
    }

    public void setArcade(Arcade arcade) {
        this.arcade = arcade;
    }
}
