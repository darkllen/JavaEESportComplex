package ee.sportcomplex.dto.users;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@DiscriminatorValue("ADMIN")
public class Coach extends User{
}
