package ee.sportcomplex.services;

import ee.sportcomplex.dto.Abonement;
import ee.sportcomplex.dto.Complex;
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

    public Optional<Integer> getPriceByTypeAndTime(int type, int monthes){
        return repo.getPriceByTypeAndTime(type,monthes);
    }
}
