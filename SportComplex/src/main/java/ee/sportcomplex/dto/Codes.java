package ee.sportcomplex.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "codes")
public class Codes {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "role")
    @NotEmpty
    private String role;

    @Column(name = "complex")
    private int complex;

    public Codes() {
        this.id = UUID.randomUUID().toString();
    }
}
