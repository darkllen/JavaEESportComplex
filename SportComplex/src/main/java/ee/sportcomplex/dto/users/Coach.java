package ee.sportcomplex.dto.users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ee.sportcomplex.dto.schedules.ScheduleGroup;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Getter
@Setter
@DiscriminatorValue("COACH")
@ToString
public class Coach extends User{

    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @OneToMany(mappedBy="coach", fetch = FetchType.EAGER)
    private List<ScheduleGroup> scheduleGroups;
}
