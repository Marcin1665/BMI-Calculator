package pl.tuszynski.bmi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tuszynski.bmi.Model.Result;


@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

}
