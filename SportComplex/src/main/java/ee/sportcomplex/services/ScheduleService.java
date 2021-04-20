package ee.sportcomplex.services;

import ee.sportcomplex.dto.Complex;
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

    public List<ScheduleGroup> getScheduleByDayByCoaches(ScheduleGroup.DayOfWeek day, List<Coach> coaches) {
        return groupRepo.findAllByDayOfWeekAndCoachIn(day, coaches);
    }

    public void removeIndById(int id){
        indRepo.removeById(id);
    }

    public void removeGroupById(Integer id) {
        groupRepo.removeById(id);
    }

    public ScheduleGroup getGroupById(Integer id) {
        return groupRepo.getOne(id);
    }

    public ScheduleGroup editGroup(ScheduleGroup group) {
        groupRepo.saveAndFlush(group);
        return group;
    }

    public ScheduleInd addInd(ScheduleInd ind) {
        indRepo.saveAndFlush(ind);
        return ind;
    }
}
