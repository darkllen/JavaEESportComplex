package ee.sportcomplex.repos;

import ee.sportcomplex.dto.Abonement;
import ee.sportcomplex.dto.users.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface AbonementRepo extends JpaRepository<Abonement, Integer> {

    @Query("SELECT a from Abonement a")
    List<Abonement> getAll();

    @Query("SELECT a.price from Type a WHERE a.id=?1")
    Optional<Integer> getPriceByTypeAndTime(int type_id);

    @Modifying
    @Transactional
    @Query("update Abonement a SET a.client=?2 where a.id=?1")
    void addExistingAbonement(int abonId, Client client);
}
