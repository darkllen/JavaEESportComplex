package ee.sportcomplex.dto.schedules;

import ee.sportcomplex.dto.users.Client;
import ee.sportcomplex.dto.users.Coach;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "schedule_ind")
@ToString
public class ScheduleInd {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="coach_id", nullable=false)
    private Coach coach;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id", nullable=false)
    private Client client;

    @Column(name = "schedule_date")
    private Date scheduleDate;
}
