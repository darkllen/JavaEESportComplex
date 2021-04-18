package ee.sportcomplex.dto.schedules;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ee.sportcomplex.dto.users.Client;
import ee.sportcomplex.dto.users.Coach;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "schedule_ind")
@ToString
public class ScheduleInd extends Schedule {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id", nullable=false)
    @NotEmpty
    private Client client;

    @Column(name = "schedule_date")
    @NotEmpty
    private Date scheduleDate;
}
