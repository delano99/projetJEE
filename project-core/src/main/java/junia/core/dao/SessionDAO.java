package junia.core.dao;

import junia.core.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionDAO extends JpaRepository<Session, Long> {

    @Query("SELECT s FROM Session s where s.gameRoom.arcade.arcadeName = :arcadeName")
    List<Session> findAllSessionsSpecificArcade(@Param("arcadeName") String arcadeName);
}
