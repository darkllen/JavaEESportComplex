package ee.sportcomplex.services.users;

import ee.sportcomplex.dto.Abonement;
import ee.sportcomplex.dto.Codes;
import ee.sportcomplex.dto.Complex;
import ee.sportcomplex.dto.Permissions;
import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.dto.users.*;
import ee.sportcomplex.repos.CodesRepo;
import ee.sportcomplex.repos.ComplexRepo;
import ee.sportcomplex.repos.PermissionsRepo;
import ee.sportcomplex.repos.schedules.ScheduleGroupRepo;
import ee.sportcomplex.repos.users.AdminRepo;
import ee.sportcomplex.repos.users.AuthRepo;
import ee.sportcomplex.repos.users.ClientRepo;
import ee.sportcomplex.repos.users.CoachRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final CoachRepo coachRepo;
    private final ClientRepo clientRepo;
    private final AdminRepo adminRepo;
    private final AuthRepo authRepo;
    private final PermissionsRepo permissionsRepo;
    private final CodesRepo codesRepo;
    private final ComplexRepo complexRepo;

    public List<CoachRepo.CoachShort> getCoachesShort(){
        return coachRepo.getAllShort();
    }
    public List<Coach> getCoaches(){
        return coachRepo.getAll();
    }
    public Optional<Client> getClientByLogin(String login){
        return clientRepo.findClientsByLogin(login);
    }
    public Optional<Coach> getCoachByLogin(String login){
        return coachRepo.findCoachByLogin(login);
    }

    public Optional<Admin> getAdminByLogin(String login){
        return adminRepo.findAdminByLogin(login);
    }

    public List<CoachRepo.CoachShort> getCoachesShortPossibleByAbonements(List<Abonement> abonements) {
        return coachRepo.getAllShortPossibleByAbonements(abonements.stream().map(Abonement::getComplex).collect(Collectors.toList()));
    }

    @Transactional
    public void setToClient(Integer id) {
        Coach coach = coachRepo.getOne(id);

        AuthUser old = authRepo.findUserByLogin(coach.getLogin()).get();
        AuthUser user = new AuthUser();
        user.setId(id);
        user.setLogin(old.getLogin());
        user.setPassword(old.getPassword());
        user.setName(old.getName());
        user.setSurname(old.getSurname());
        user.setRole("CLIENT");
        user.setPermissions(List.of(permissionsRepo.getByPermission(Permissions.PermissionName.CLIENT)));

        authRepo.delete(old);
        authRepo.flush();
        authRepo.saveAndFlush(user);
    }

    public Coach editCoach(Coach coach) {
        coachRepo.saveAndFlush(coach);
        return coach;
    }

    public Coach getCoachByID(Integer id) {
        return coachRepo.getOne(id);
    }

    public AuthUser editAuthUser(AuthUser user) {
        if (user.getPassword() == null){
            user.setPassword(authRepo.getOne(user.getId()).getPassword());
        }
        authRepo.saveAndFlush(user);
        return user;
    }

    public AuthUser createAuthUser(AuthUser user) {
        user.setPermissions(List.of(permissionsRepo.getByPermission(Permissions.PermissionName.CLIENT)));
        authRepo.saveAndFlush(user);
        return user;
    }

    public AuthUser getAuthByLogin(String name) {
        return authRepo.findUserByLogin(name).orElse(null);
    }


    @Transactional
    public void upgradeUser(AuthUser old, String code) {
        Codes codes = codesRepo.getOne(code);

        if (codes.getRole().equals("ADMIN") && codes.getComplex().getAdmin()!=null){
            throw new IllegalArgumentException("Wrong complex");
        }

        AuthUser user = new AuthUser();
        user.setId(old.getId());
        user.setLogin(old.getLogin());
        user.setPassword(old.getPassword());
        user.setName(old.getName());
        user.setSurname(old.getSurname());
        user.setRole(codes.getRole());
        user.setPermissions(List.of(permissionsRepo.getByPermission(Permissions.PermissionName.valueOf(codes.getRole()))));

        authRepo.delete(old);
        authRepo.flush();
        authRepo.saveAndFlush(user);

        if (codes.getRole().equals("COACH")){
            Coach coach = coachRepo.findCoachByLogin(user.getLogin()).get();
            coach.setComplex(codes.getComplex());
            coachRepo.saveAndFlush(coach);
        }else {
            Admin admin = adminRepo.findAdminByLogin(user.getLogin()).get();

            Complex complex = codes.getComplex();
            complex.setAdmin(admin);
            admin.setComplex(complex);
            complexRepo.saveAndFlush(complex);
            adminRepo.saveAndFlush(admin);
        }
        codesRepo.delete(codes);
        Admin admin = adminRepo.findAdminByLogin(user.getLogin()).get();
    }

    public Admin getAdminByID(Integer id) {
        return adminRepo.getOne(id);
    }

    public List<Admin> getAllAdmins() {
        return  adminRepo.findAll();
    }
}
