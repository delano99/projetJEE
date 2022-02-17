package junia.core.service;

import junia.core.dao.GameRoomDAO;
import junia.core.entity.GameRoom;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GameRoomService {

    private final GameRoomDAO gameRoomDAO;

    public GameRoomService(GameRoomDAO gameRoomDAO) {
        this.gameRoomDAO = gameRoomDAO;
    }

    public void deleteAll(){
        gameRoomDAO.deleteAll();
    }

    public void save(final GameRoom gameRoom){
        gameRoomDAO.save(gameRoom);
    }
    public List<GameRoom> getGameRoomInArcade(String arcadeName){
        return gameRoomDAO.getGameRoomInArcade(arcadeName);
    }
}
