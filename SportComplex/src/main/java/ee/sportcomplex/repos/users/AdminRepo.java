package ee.sportcomplex.repos.users;

import ee.sportcomplex.dto.users.Admin;
import ee.sportcomplex.dto.users.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

public interface AdminRepo  extends JpaRepository<Admin, Integer> {

    Optional<Admin> findAdminByLogin(String login);
}
