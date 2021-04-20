package ee.sportcomplex.services;

import ee.sportcomplex.dto.Permissions;
import ee.sportcomplex.repos.PermissionsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PermissionsService {
    private final PermissionsRepo repo;

    public Permissions getPermission(Permissions.PermissionName name){
        return repo.getByPermission(name);
    }
}
