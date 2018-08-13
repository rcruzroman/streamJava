package lecturesSolved;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    final Predicate<Car> filterCar = car -> car.getPrice() < 10000;

    List<Car> carsFiltered = cars.stream().filter(filterCar).collect(Collectors.toList());
    carsFiltered.stream().forEach(System.out::println);


  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
    List<Object> personsDTO = people.stream().map(person -> {
      PersonDTO personDTO = new PersonDTO(person.getId(), person.getFirstName(), person.getAge());
      return personDTO;
    }).collect(Collectors.toList());

    assertThat(personsDTO).hasSize(people.size());

    List<Object> personsDTORefactored = people.stream().map(PersonDTO::mapFromPerson).collect(Collectors.toList());
    assertThat(personsDTORefactored).hasSize(people.size());


  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    ImmutableList<Car> cars = MockData.getCars();
    System.out.println("Average: " + cars.stream().mapToDouble(Car::getPrice ).average().getAsDouble() );


  }

  @Test
  public void test() throws Exception {

  }
}


