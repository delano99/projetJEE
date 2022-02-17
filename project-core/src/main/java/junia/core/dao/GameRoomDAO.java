package junia.core.dao;

import junia.core.entity.GameRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRoomDAO extends JpaRepository<GameRoom, Long> {

    @Query("SELECT m FROM GameRoom m where m.arcade.arcadeName = :arcadeName ")
    List<GameRoom> getGameRoomInArcade(@Param("arcadeName") String arcadeName);
}
