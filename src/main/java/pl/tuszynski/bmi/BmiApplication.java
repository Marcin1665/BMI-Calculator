package pl.tuszynski.bmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.tuszynski.bmi.Model.Result;

@SpringBootApplication
public class BmiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmiApplication.class, args);



    }


}
