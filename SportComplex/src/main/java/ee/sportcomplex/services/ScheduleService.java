package ee.sportcomplex.services;

import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.dto.schedules.ScheduleInd;
import ee.sportcomplex.dto.users.Client;
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
        System.out.println(indRepo.findAllByClientAndScheduleDateBefore(client,date));
        return indRepo.findAllByClientAndScheduleDateBefore(client,date);
    };
    public List<ScheduleInd> findAllByClientAndScheduleDateAfter(Client client, Date date){
        return indRepo.findAllByClientAndScheduleDateAfter(client,date);
    };
}
