package ee.sportcomplex.repos;

import ee.sportcomplex.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findUserByLogin(String login);
}
