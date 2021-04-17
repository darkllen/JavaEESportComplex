package ee.sportcomplex.repos;

import ee.sportcomplex.dto.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypesRepo extends JpaRepository<Type, Integer> {
    @Query(value = "SELECT t from Type t")
    List<TypesShort> getAllShort();
    public interface TypesShort{
        public int getId();
        public String getName();
    }
}
