package pl.tuszynski.bmi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tuszynski.bmi.Repository.ResultRepository;
import pl.tuszynski.bmi.Model.Result;

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
