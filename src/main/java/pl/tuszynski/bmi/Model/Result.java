package pl.tuszynski.bmi.Model;

import javax.persistence.*;


@Entity
@Table
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private Double weight;
    private Double height;
    private String bmi;

    public Result(){

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }


    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getBmi() {

        return String.format("%.2f%n", (weight / (height * height)) * 10000);

    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", bmi='" + bmi + '\'' +
                '}';
    }
}
