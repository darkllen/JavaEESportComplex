package ee.sportcomplex.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ee.sportcomplex.EntityIdResolver;
import ee.sportcomplex.dto.users.Coach;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "codes")
@ToString
public class Codes {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "role")
    @NotEmpty
    private String role;

    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            resolver = EntityIdResolver.class,
            property = "id",
            scope= Complex.class)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="complex", nullable=false)
    private Complex complex;

    public Codes() {
        this.id = UUID.randomUUID().toString();
    }
}
