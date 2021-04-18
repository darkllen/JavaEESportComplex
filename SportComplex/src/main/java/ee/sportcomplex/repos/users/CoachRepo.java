package ee.sportcomplex.repos.users;

import ee.sportcomplex.dto.Abonement;
import ee.sportcomplex.dto.Complex;
import ee.sportcomplex.dto.users.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CoachRepo extends JpaRepository<Coach, Integer> {
    @Query(value = "SELECT c from Coach c")
    List<CoachShort> getAllShort();


    @Query(value = "SELECT c from Coach c where c.complex in ?1")
    List<CoachShort> getAllShortPossibleByAbonements(List<Complex> complexes);

    @Query(value = "SELECT c from Coach c")
    List<Coach> getAll();

    Optional<Coach> findCoachByLogin(String login);

    public interface CoachShort{
        public int getId();
        public String getName();
        public String getSurname();
    }
}
