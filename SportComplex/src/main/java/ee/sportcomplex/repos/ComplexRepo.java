package ee.sportcomplex.repos;

import ee.sportcomplex.dto.Complex;
import ee.sportcomplex.dto.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComplexRepo extends JpaRepository<Complex, Integer> {
    @Query(value = "SELECT c from Complex c")
    List<ComplexShort> getAllShort();
    public interface ComplexShort{
        public int getId();
        public String getName();
    }

    @Query(value = "SELECT c from Complex c")
    List<Complex> getAll();
}
