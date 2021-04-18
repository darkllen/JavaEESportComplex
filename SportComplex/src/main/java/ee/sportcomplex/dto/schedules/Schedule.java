package ee.sportcomplex.dto.schedules;

import com.fasterxml.jackson.annotation.*;
import ee.sportcomplex.EntityIdResolver;
import ee.sportcomplex.dto.users.Coach;
import ee.sportcomplex.dto.users.User;
import ee.sportcomplex.services.users.UserService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@MappedSuperclass
@ToString
public abstract class Schedule {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Getter(AccessLevel.PUBLIC)
    private Integer id;

    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            resolver = EntityIdResolver.class,
            property = "id",
            scope=Coach.class)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="coach_id", nullable=false)
    @Getter(AccessLevel.PUBLIC)
    private Coach coach;

}
