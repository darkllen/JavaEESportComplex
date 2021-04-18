package ee.sportcomplex.repos.schedules;

import ee.sportcomplex.dto.Permissions;
import ee.sportcomplex.dto.schedules.ScheduleInd;
import ee.sportcomplex.dto.users.Client;
import ee.sportcomplex.dto.users.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ScheduleIndRepo extends JpaRepository<ScheduleInd, Integer> {
    List<ScheduleInd> findAllByCoach_Id(Integer coach_id);

    List<ScheduleInd> findAllByClientAndScheduleDateBefore(Client client, Date date);
    List<ScheduleInd> findAllByClientAndScheduleDateAfter(Client client, Date date);

    List<ScheduleInd> findAllByCoachAndScheduleDateBefore(Coach coach, Date date);
    List<ScheduleInd> findAllByCoachAndScheduleDateAfter(Coach coach, Date date);
}
