package ee.sportcomplex.repos;

import ee.sportcomplex.dto.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PermissionsRepo extends JpaRepository<Permissions, Integer> {
    List<Permissions> getAll();
    Optional<Permissions> getByPermission(Permissions.PermissionName permission);
}
