package ee.sportcomplex.services;

import ee.sportcomplex.dto.Complex;
import ee.sportcomplex.repos.ComplexRepo;
import ee.sportcomplex.repos.schedules.ScheduleGroupRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ComplexService {
    private final ComplexRepo repo;

    public List<ComplexRepo.ComplexShort> getComplexesShort(){
        return repo.getAllShort();
    }

    public List<Complex> getComplexes(){
        return repo.getAll();
    }

    public Complex getById(int id){
        return repo.getOne(id);
    }

    public Complex editComplex(Complex complex) {
        repo.saveAndFlush(complex);
        return complex;
    }

    public void removeComplexById(Integer id) {
        repo.deleteById(id);
    }
}
