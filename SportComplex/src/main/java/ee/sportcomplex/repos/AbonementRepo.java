package ee.sportcomplex.repos;

import ee.sportcomplex.dto.Abonement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AbonementRepo extends JpaRepository<Abonement, Integer> {

    @Query("SELECT a from Abonement a")
    List<Abonement> getAll();

    @Query("SELECT a.price from Abonement a WHERE a.type.id=?1 and a.time_in_month=?2")
    Optional<Integer> getPriceByTypeAndTime(int type_id, int monthes);
}
