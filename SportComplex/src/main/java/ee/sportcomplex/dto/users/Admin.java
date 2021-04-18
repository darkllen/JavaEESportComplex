package ee.sportcomplex.dto.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ee.sportcomplex.dto.Complex;
import ee.sportcomplex.dto.schedules.ScheduleGroup;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Getter
@Setter
@DiscriminatorValue("ADMIN")
@ToString
public class Admin extends User{

    @JsonIgnore
    @OneToOne(mappedBy = "admin", fetch = FetchType.LAZY)
    private Complex complex;
}
