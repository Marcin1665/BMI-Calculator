package pl.tuszynski.bmi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tuszynski.bmi.model.Result;
import pl.tuszynski.bmi.repository.ResultRepository;

import java.util.List;

@Service
@Transactional
public class ResultService {

    @Autowired
    private ResultRepository repo;

    public List<Result> listAll() {
        return repo.findAll();
    }

    public void save(Result result) {
        repo.save(result);
    }

    public Result get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }


}
