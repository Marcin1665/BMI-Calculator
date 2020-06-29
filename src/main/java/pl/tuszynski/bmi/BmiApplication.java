package pl.tuszynski.bmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.tuszynski.bmi.Model.Result;

@SpringBootApplication
public class BmiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmiApplication.class, args);


        // INSERT

        Result result = new Result();
        result.setNickname("Sample user");
        result.setHeight((double) 186);
        result.setWeight((double) 90);
        result.setBmi("24");

    }


}
