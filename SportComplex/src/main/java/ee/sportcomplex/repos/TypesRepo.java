package ee.sportcomplex.repos;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypesRepo {
    @Query(value = "SELECT t from Type t")
    List<TypesShort> getAllShort();
    public interface TypesShort{
        public int getId();
        public String getName();
    }
}
