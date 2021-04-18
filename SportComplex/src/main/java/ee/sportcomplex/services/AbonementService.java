package ee.sportcomplex.services;

import ee.sportcomplex.dto.Abonement;
import ee.sportcomplex.dto.Complex;
import ee.sportcomplex.dto.users.Client;
import ee.sportcomplex.repos.AbonementRepo;
import ee.sportcomplex.repos.ComplexRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AbonementService {
    private final AbonementRepo repo;

    //public List<ComplexRepo.ComplexShort> getComplexesShort(){
//        return repo.getAllShort();
//    }

    public List<Abonement> getAbonements(){
        return repo.getAll();
    }

    public Integer getPriceByTypeAndTime(int type, int monthes){
        return (int)((monthes*repo.getPriceByTypeAndTime(type).orElse(0))*(1-(monthes-monthes%5)/100.0));
    }

    public void addExistingAbonement(int id, Client client){
        if (repo.getOne(id).getClient() == null)
        repo.addExistingAbonement(id, client);
        else throw new IllegalArgumentException("has client");
    }
}
