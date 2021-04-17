package ee.sportcomplex.dto.schedules;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Time;

@Entity
@Getter
@Setter
@Table(name = "schedule_group")
@ToString
public class ScheduleGroup extends Schedule{

    @Column(name = "name")
    @NotEmpty
    @Length(min = 3, max = 20)
    String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week")
    @NotEmpty

    DayOfWeek dayOfWeek;
    @Column(name = "time")
    @NotEmpty
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
