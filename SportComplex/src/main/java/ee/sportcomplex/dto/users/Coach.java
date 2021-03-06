package ee.sportcomplex.dto.users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ee.sportcomplex.dto.Complex;
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

    @JsonIgnore
    @OneToMany(mappedBy="coach", fetch = FetchType.LAZY)
    private List<ScheduleGroup> scheduleGroups;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "complex_coach",
            joinColumns = @JoinColumn(name = "coach_id"),
            inverseJoinColumns = @JoinColumn(name = "complex_id")
    )
    private Complex complex;
}
