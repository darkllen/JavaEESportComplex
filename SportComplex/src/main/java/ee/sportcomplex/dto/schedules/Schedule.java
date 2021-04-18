package ee.sportcomplex.dto.schedules;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ee.sportcomplex.dto.users.Coach;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@MappedSuperclass
@ToString
public abstract class Schedule {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Getter(AccessLevel.PUBLIC)
    @NotEmpty
    private Integer id;

    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="coach_id", nullable=false)
    @Getter(AccessLevel.PUBLIC)
    @NotEmpty
    private Coach coach;
}
