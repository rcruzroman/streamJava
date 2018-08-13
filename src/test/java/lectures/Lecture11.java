package lecturesSolved;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String result = "";

    for(String name: names){
      result += "," + name;
    }

    result = result.substring(result.indexOf(",") + 1, result.length() );
    System.out.println(result);

  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String join = names.stream()
            .collect(Collectors.joining(", "));
    System.out.println(join);

  }
}
