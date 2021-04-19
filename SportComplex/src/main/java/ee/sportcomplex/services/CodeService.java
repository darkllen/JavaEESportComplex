package ee.sportcomplex.services;

import ee.sportcomplex.dto.Codes;
import ee.sportcomplex.repos.CodesRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CodeService {
    private final CodesRepo repo;

    public void save(Codes codes) {
        repo.saveAndFlush(codes);
    }
}
