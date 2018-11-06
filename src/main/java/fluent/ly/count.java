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
  
  @SuppressWarnings("static-method") class TEST {
    @Test public void usecase0() {
      assert count.of(Arrays.asList(new String[] { "abc", "klm", "xyz", "pqr" })) == 4;
    }

    @Test public void usecase1() {
      assert count.of(Arrays.asList(new String[] {})) == 0;
    }
  }
}
