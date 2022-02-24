package junia.core.dao;

import junia.core.entity.Arcade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArcadeDAO extends JpaRepository<Arcade, Long> {
    List<Arcade> findAll();
}
