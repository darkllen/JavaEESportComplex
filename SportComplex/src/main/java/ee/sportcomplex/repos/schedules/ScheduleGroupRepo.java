package ee.sportcomplex.repos.schedules;

import ee.sportcomplex.dto.schedules.ScheduleGroup;
import ee.sportcomplex.dto.schedules.ScheduleInd;
import ee.sportcomplex.dto.users.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import javax.transaction.Transactional;
import java.util.List;

public interface ScheduleGroupRepo extends JpaRepository<ScheduleGroup, Integer> {
    List<ScheduleGroup> findAllByDayOfWeek(ScheduleGroup.DayOfWeek day);

    List<ScheduleGroup> findAllByDayOfWeekAndCoachIn(ScheduleGroup.DayOfWeek day, List<Coach> coach);

    @Modifying
    @Transactional
    void removeById(Integer id);
}
