package junia.core.dao;

import junia.core.entity.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JeuDAO extends JpaRepository<Jeu, Long> {

    @Query("SELECT j FROM Jeu j where j.id = :id ")
        Jeu findJeu(@Param("id") long jeu_id);

    @Query("SELECT j FROM Jeu j where j.name = :name ")
        Jeu findJeuByName(@Param("name") String arcadeName);
}
