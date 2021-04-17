package ee.sportcomplex.repos;

import ee.sportcomplex.dto.Complex;
import ee.sportcomplex.dto.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplexRepo extends JpaRepository<Complex, Integer> {
    List<ComplexShort> findAllBy();
    public interface ComplexShort{
        public int getId();
        public String getName();
    }
}
