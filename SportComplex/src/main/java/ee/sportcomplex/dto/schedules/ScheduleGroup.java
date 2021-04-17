package ee.sportcomplex.dto.schedules;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Getter
@Setter
@Table(name = "schedule_group")
@ToString
public class ScheduleGroup extends Schedule{
    @Column(name = "name")
    String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week")
    DayOfWeek dayOfWeek;
    @Column(name = "time")
    Time time;

    public enum DayOfWeek {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }
}
