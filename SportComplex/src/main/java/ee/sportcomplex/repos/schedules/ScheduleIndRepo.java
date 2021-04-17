package ee.sportcomplex.repos.schedules;

import ee.sportcomplex.dto.Permissions;
import ee.sportcomplex.dto.schedules.ScheduleInd;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleIndRepo extends JpaRepository<ScheduleInd, Integer> {
    List<ScheduleInd> findAllByCoach_Id(Integer coach_id);
}
