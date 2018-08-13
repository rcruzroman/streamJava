package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;


public class Lecture1 {

    @Test
    public void imperativeApproach() throws IOException {
        List<Person> people = MockData.getPeople();
        Integer index = 0;

        for (Person personOriginal : people) {
            if (personOriginal.getAge() <= 18) {
                System.out.printf("\nPerson: " + index + " - " + personOriginal.getFirstName() + " " + personOriginal.getLastName());
                index++;
                if (index > 10) {
                    return;
                }
            }
        }
        // 1. Find people aged less or equal 18
        // 2. Then change implementation to find first 10 people

    }

    @Test
    public void declarativeApproachUsingStreams() throws Exception {
        ImmutableList<Person> people = MockData.getPeople();

        people.stream()
                .filter(p -> p.getAge() <= 18)
                .limit(10)
                .forEach(System.out::println);

    }
}
