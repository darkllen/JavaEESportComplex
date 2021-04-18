package ee.sportcomplex.dto.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ee.sportcomplex.dto.Abonement;
import ee.sportcomplex.dto.schedules.ScheduleGroup;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@DiscriminatorValue("CLIENT")
public class Client  extends User{

    @JsonIgnore
    @OneToMany(mappedBy="client", fetch = FetchType.LAZY)
    private List<Abonement> abonements;
}
