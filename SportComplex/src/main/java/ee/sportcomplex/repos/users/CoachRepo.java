package ee.sportcomplex.repos.users;

import ee.sportcomplex.dto.users.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoachRepo extends JpaRepository<Coach, Integer> {
    @Query(value = "SELECT c from Coach c")
    List<CoachShort> getAllShort();

    @Query(value = "SELECT c from Coach c")
    List<Coach> getAll();

    public interface CoachShort{
        public int getId();
        public String getName();
        public String getSurname();
    }
}
