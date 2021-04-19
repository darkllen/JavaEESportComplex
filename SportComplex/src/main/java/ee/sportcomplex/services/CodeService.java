package ee.sportcomplex.services;

import ee.sportcomplex.dto.Codes;
import ee.sportcomplex.dto.Complex;
import ee.sportcomplex.repos.CodesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CodeService {
    private final CodesRepo repo;

    public void save(Codes codes, Complex complex) {
        codes.setComplex(complex);
        repo.saveAndFlush(codes);
    }

    public List<Codes> getAll(){
        return repo.getAll();
    }

    public List<Codes> getAllByRole(String role){
        return repo.getAllByRole(role);
    }

    public void removeById(String id) {
        repo.deleteById(id);
    }
}
