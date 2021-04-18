package ee.sportcomplex.repos.schedules;

import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.dto.schedules.ScheduleInd;
import ee.sportcomplex.dto.users.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleGroupRepo extends JpaRepository<ScheduleGroup, Integer> {
    List<ScheduleGroup> findAllByDayOfWeek(ScheduleGroup.DayOfWeek day);

    List<ScheduleGroup> findAllByDayOfWeekAndCoach(ScheduleGroup.DayOfWeek day, Coach coach);
}
