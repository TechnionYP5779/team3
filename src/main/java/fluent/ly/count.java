package fluent.ly;

import java.util.*;

import org.junit.*;

public interface count {
  static <T> int of(final Iterable<T> ts) {
    int $ = 0;
    for (@SuppressWarnings("unused") final T __ : ts)
      ++$;
    return $;
  }
  
  @SuppressWarnings("static-method") public static class TEST {
    @Test public void usecase0() {
      String a[] = new String[]{"abc","klm","xyz","pqr"};
      List<String> list1 = Arrays.asList(a);
      assert count.of(list1) == 4;
    }

    @Test public void usecase1() {
      assert count.of(Arrays.asList(new String[] {})) == 0;
    }
  }
}
