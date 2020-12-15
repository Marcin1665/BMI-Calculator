package pl.tuszynski.bmi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.tuszynski.bmi.model.Result;


@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

}
