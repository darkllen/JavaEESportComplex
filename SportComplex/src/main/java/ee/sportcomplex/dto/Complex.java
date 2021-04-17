package ee.sportcomplex.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "complex")
public class Complex {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty
    private Integer id;

    @Column(name = "name", unique = true)
    @NotEmpty
    @Length(min = 3, max = 25)
    private String name;

    @Column(name = "description", unique = true)
    @NotEmpty
    @Length(min = 3, max = 100)
    private String description;

    @Column(name = "space", unique = true)
    @NotEmpty
    @Min(10)
    @Max(10000)
    private int space;

    @Column(name = "floors_num", unique = true)
    @NotEmpty
    @Min(1)
    @Max(10)
    private int floors_num;

    @Column(name = "open_date", unique = true)
    private Date open_date;

    @Column(name = "city", unique = true)
    @NotEmpty
    @Length(min = 3, max = 20)
    private String city;

}
