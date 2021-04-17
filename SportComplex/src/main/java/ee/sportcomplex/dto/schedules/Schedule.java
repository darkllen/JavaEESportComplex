package ee.sportcomplex.dto.schedules;

import ee.sportcomplex.dto.users.Coach;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@ToString
public abstract class Schedule {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Getter(AccessLevel.PUBLIC)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="coach_id", nullable=false)
    @Getter(AccessLevel.PUBLIC)
    private Coach coach;
}
