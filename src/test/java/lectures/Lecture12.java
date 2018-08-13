package lecturesSolved;

import beans.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture12 {
  @Test
  public void understandingCollect() throws Exception {
    List<String> emails = MockData.getPeople()
        .stream()
        .map(Person::getEmail)
            .collect(() -> new ArrayList<String>(),
                    (list, element) -> list.add(element),
                    (list1, list2) -> list1.addAll(list2));

//        .collect(Collectors.toList());

    emails.forEach(System.out::println);

    List<String> emails2 = MockData.getPeople()
            .stream()
            .map(Person::getEmail)
            .collect(ArrayList::new,
                    ArrayList::add,
                    ArrayList::addAll);

    emails2.forEach(System.out::println);

  }
}
