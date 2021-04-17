package ee.sportcomplex.services;

import ee.sportcomplex.repos.ComplexRepo;
import ee.sportcomplex.repos.schedules.ScheduleGroupRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComplexService {
    private final ComplexRepo repo;

    public List<ComplexRepo.ComplexShort> getComplexesShort(){
        return repo.findAllBy();
    }
}
