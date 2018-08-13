package lectures;


import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

public class Lecture9 {

  @Test
  public void reduce() throws Exception {
    Integer[] integers = {1302, 1, 2, 3, 4, 99, 100, 121, 199};
    Optional<Integer> reduce = Arrays.stream(integers)
            .reduce((a, b) -> a + b);

    System.out.println(reduce.get());

    Integer reducedMore = Arrays.stream(integers)
            .reduce(0, (a, b) -> a + b);

    System.out.println(reducedMore);

    Integer reducedWithSum = Arrays.stream(integers)
            .reduce(0, Integer::sum);

    System.out.println(reducedWithSum);


  }


}

