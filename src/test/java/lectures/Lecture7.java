package lecturesSolved;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;

import beans.Person;
import mockdata.MockData;
import org.junit.Assert;
import org.junit.Test;

public class  Lecture7 {

  @Test
  public void count() throws Exception {
    List<Person> personList = MockData.getPeople();
    long countFemales = personList.stream().filter(p -> p.getGender().equalsIgnoreCase("female")).count();

    Assert.assertEquals(countFemales, 467l);
  }

  @Test
  public void min() throws Exception {
    double minYellowCars = MockData.getCars()
            .stream()
            .filter(c -> c.getColor().equalsIgnoreCase("yellow"))
            .mapToDouble(car -> car.getPrice())
            .min()
            .getAsDouble();

    Assert.assertEquals(minYellowCars, 6600.59, 0);
  }

  @Test
  public void max() throws Exception {

    double maxYellowCars = MockData.getCars()
            .stream()
            .filter(c -> c.getColor().equalsIgnoreCase("yellow"))
            .mapToDouble(car -> car.getPrice())
            .max()
            .getAsDouble();

    Assert.assertEquals(maxYellowCars, 99677.14, 0);
  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();
    double averagePrice = cars.stream()
            .mapToDouble(c -> c.getPrice())
            .average()
            .orElse(0);

    Assert.assertEquals(averagePrice, 52693.19979, 0);

  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream()
        .mapToDouble(Car::getPrice)
        .sum();
    BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
    System.out.println(sum);
    System.out.println(bigDecimalSum);

  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics statistics = cars.stream()
        .mapToDouble(Car::getPrice)
        .summaryStatistics();
    System.out.println(statistics);
    System.out.println(statistics.getAverage());
    System.out.println(statistics.getCount());
    System.out.println(statistics.getMax());
    System.out.println(statistics.getMin());
    System.out.println(statistics.getSum());
  }

}