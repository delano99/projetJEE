package junia.projet.web.DTO;

import junia.core.entity.Arcade;

public class GameRoomDTO {

    public long id;

    private Integer roomNumber;


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


    public Arcade getArcade() {
        return arcade;
    }

    public void setArcade(Arcade arcade) {
        this.arcade = arcade;
    }
}
