package ee.sportcomplex.dto.users;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("CLIENT")
public class Client  extends User{
}
