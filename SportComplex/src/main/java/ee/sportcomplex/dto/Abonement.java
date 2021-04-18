package ee.sportcomplex.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ee.sportcomplex.dto.users.Client;
import ee.sportcomplex.dto.users.Coach;
import lombok.AccessLevel;
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
@Table(name = "abonement")
public class Abonement {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "price", unique = true)
    @Min(0)
    private int price;

    @Column(name = "time_in_month", unique = true)
    @Min(1)
    @Max(36)
    private int time_in_month;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="type_id", nullable=false)
    private Type type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="complex_id", nullable=false)
    private Complex complex;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id", nullable=true)
    private Client client;

    @Column(name = "user_phone", unique = true)
    @Length(min = 10, max = 13)
    private String user_phone;

}
