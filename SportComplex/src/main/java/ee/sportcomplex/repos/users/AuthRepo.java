package ee.sportcomplex.repos.users;

import ee.sportcomplex.dto.users.AuthUser;
import ee.sportcomplex.dto.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepo extends JpaRepository<AuthUser, Integer> {
    Optional<AuthUser> findUserByLogin(String login);
}
