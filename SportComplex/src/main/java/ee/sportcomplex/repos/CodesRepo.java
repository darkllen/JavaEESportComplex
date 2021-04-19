package ee.sportcomplex.repos;

import ee.sportcomplex.dto.Abonement;
import ee.sportcomplex.dto.Codes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CodesRepo extends JpaRepository<Codes, String> {

    @Query("SELECT c from Codes c")
    List<Codes> getAll();
}
