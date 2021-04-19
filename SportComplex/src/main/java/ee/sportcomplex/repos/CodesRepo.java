package ee.sportcomplex.repos;

import ee.sportcomplex.dto.Codes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodesRepo extends JpaRepository<Codes, String> {
}
