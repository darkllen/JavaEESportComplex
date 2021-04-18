package ee.sportcomplex.services.users;

import ee.sportcomplex.dto.users.Client;
import ee.sportcomplex.dto.users.Coach;
import ee.sportcomplex.repos.schedules.ScheduleGroupRepo;
import ee.sportcomplex.repos.users.ClientRepo;
import ee.sportcomplex.repos.users.CoachRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final CoachRepo coachRepo;
    private final ClientRepo clientRepo;

    public List<CoachRepo.CoachShort> getCoachesShort(){
        return coachRepo.getAllShort();
    }
    public List<Coach> getCoaches(){
        return coachRepo.getAll();
    }
    public Optional<Client> getClientByLogin(String login){
        return clientRepo.findClientsByLogin(login);
    }
}
