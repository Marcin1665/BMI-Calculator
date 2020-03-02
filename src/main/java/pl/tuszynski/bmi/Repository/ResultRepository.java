package pl.tuszynski.bmi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tuszynski.bmi.Model.Result;

public interface ResultRepository extends JpaRepository<Result, Long> {

}
