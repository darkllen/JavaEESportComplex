package ee.sportcomplex.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Table(name = "type")
public class Type {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty
    private Integer id;

    @Column(name = "name", unique = true)
    @NotEmpty
    @Length(min = 1, max = 20)
    private String name;

    @Column(name = "vip", unique = true)
    @NotEmpty
    private boolean vip;
}