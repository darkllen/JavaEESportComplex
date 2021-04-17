package ee.sportcomplex.repos.users;

import ee.sportcomplex.dto.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findUserByName(String login);
}
