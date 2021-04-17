package ee.sportcomplex.services.users;

import ee.sportcomplex.dto.users.Coach;
import ee.sportcomplex.repos.schedules.ScheduleGroupRepo;
import ee.sportcomplex.repos.users.CoachRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final CoachRepo coachRepo;

    public List<CoachRepo.CoachShort> getCoachesShort(){
        return coachRepo.getAllShort();
    }
    public List<Coach> getCoaches(){
        return coachRepo.getAll();
    }
}
