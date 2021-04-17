package ee.sportcomplex.services;

import ee.sportcomplex.repos.ComplexRepo;
import ee.sportcomplex.repos.TypesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeService {
    private final TypesRepo repo;
    public List<TypesRepo.TypesShort> getTypesShort(){
        return repo.getAllShort();
    }
}
