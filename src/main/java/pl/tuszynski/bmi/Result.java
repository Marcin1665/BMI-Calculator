package pl.tuszynski.bmi;

import javax.persistence.*;

@Entity
@Table
public class Result {
  private Long id;
  private String nickname;
  private Integer weight;
  private Integer height;
  private Double bmi;


  public Result() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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


  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }


  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Double getBmi() {
    return bmi;
  }

  public void setBmi(Double bmi) {
    this.bmi = bmi;
  }

  @Override
  public String toString() {
    return "Result{" +
      "id=" + id +
      ", nickname='" + nickname + '\'' +
      ", weight=" + weight +
      ", height=" + height +
      ", BMI=" + bmi +
      '}';
  }

}
