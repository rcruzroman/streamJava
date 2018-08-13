package lecturesSolved;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

public class Lecture3 {

  @Test
  public void min() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    Integer min1 = numbers.stream().min(Integer::compareTo).get();
    assertThat(min1).isEqualTo(1);
    System.out.println(min1);

    Integer min2 = numbers.stream().min(Comparator.naturalOrder()).get();
    assertThat(min2).isEqualTo(1);
    System.out.println(min2);

  }

  @Test
  public void max() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    Optional<Integer> max = numbers.stream().max(Integer::compareTo);
    assertThat(max.get()).isEqualTo(100);
    System.out.println(max.get());
  }
}
