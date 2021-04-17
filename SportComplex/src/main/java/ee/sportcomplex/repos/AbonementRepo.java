package ee.sportcomplex.repos;

import ee.sportcomplex.dto.Abonement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AbonementRepo extends JpaRepository<Abonement, Integer> {

    @Query("SELECT a from Abonement a")
    List<Abonement> getAll();
}
