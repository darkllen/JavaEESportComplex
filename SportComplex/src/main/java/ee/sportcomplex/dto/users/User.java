package ee.sportcomplex.dto.users;

import ee.sportcomplex.dto.Permissions;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="role",
        discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue("USER")
@Table(name = "users")
@ToString
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login", unique = true)
    @NotEmpty
    @Length(min = 3, max = 15)
    private String login;

    @Column(name = "name", unique = true)
    @NotEmpty
    @Length(min = 3, max = 15)
    private String name;

    @Column(name = "surname", unique = true)
    @NotEmpty
    @Length(min = 3, max = 15)
    private String surname;

    @Column(name = "password")
    @NotEmpty
    @Length(min = 6, max = 20)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_to_permissions",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private List<Permissions> permissions;
}