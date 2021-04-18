package ee.sportcomplex.services;

import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.dto.schedules.ScheduleInd;
import ee.sportcomplex.dto.users.Client;
import ee.sportcomplex.dto.users.Coach;
import ee.sportcomplex.repos.schedules.ScheduleGroupRepo;
import ee.sportcomplex.repos.schedules.ScheduleIndRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleGroupRepo groupRepo;
    private final ScheduleIndRepo indRepo;

    public List<ScheduleGroup> getScheduleByDay(ScheduleGroup.DayOfWeek day){
        return groupRepo.findAllByDayOfWeek(day);
    }

    public List<ScheduleInd> findAllByClientAndScheduleDateBefore(Client client, Date date){
        return indRepo.findAllByClientAndScheduleDateBefore(client,date);
    };
    public List<ScheduleInd> findAllByClientAndScheduleDateAfter(Client client, Date date){
        return indRepo.findAllByClientAndScheduleDateAfter(client,date);
    };

    public List<ScheduleInd> findAllByCoachAndScheduleDateBefore(Coach coach, Date date){
        return indRepo.findAllByCoachAndScheduleDateBefore(coach,date);
    };
    public List<ScheduleInd> findAllByCoachAndScheduleDateAfter(Coach coach, Date date){
        return indRepo.findAllByCoachAndScheduleDateAfter(coach,date);
    };

    public List<ScheduleGroup> getScheduleByDayByCoach(ScheduleGroup.DayOfWeek day, Coach coach) {
        return groupRepo.findAllByDayOfWeekAndCoach(day, coach);
    }

    public void removeIndById(int id){
        indRepo.removeById(id);
    }
}
