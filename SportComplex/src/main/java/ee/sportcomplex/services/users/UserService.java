package ee.sportcomplex.services.users;

import ee.sportcomplex.dto.Abonement;
import ee.sportcomplex.dto.users.Admin;
import ee.sportcomplex.dto.users.Client;
import ee.sportcomplex.dto.users.Coach;
import ee.sportcomplex.repos.schedules.ScheduleGroupRepo;
import ee.sportcomplex.repos.users.AdminRepo;
import ee.sportcomplex.repos.users.ClientRepo;
import ee.sportcomplex.repos.users.CoachRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final CoachRepo coachRepo;
    private final ClientRepo clientRepo;
    private final AdminRepo adminRepo;

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

}
