package ee.sportcomplex.services;

import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.repos.schedules.ScheduleGroupRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleGroupRepo repo;

    public List<ScheduleGroup> getScheduleByDay(ScheduleGroup.DayOfWeek day){
        return repo.findAllByDayOfWeek(day);
    }
}
