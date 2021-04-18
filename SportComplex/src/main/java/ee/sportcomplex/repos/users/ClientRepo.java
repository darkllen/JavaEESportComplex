package ee.sportcomplex.repos.users;

import ee.sportcomplex.dto.users.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client, Integer> {
    Optional<Client> findClientsByLogin(String login);
}
