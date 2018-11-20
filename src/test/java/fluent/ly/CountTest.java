package fluent.ly;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class CountTest {
  @Test public void usecase0() {
    azzert.assertTrue(count.of(Arrays.asList(new String[] { "abc", "klm", "xyz", "pqr" })) == 4);
  }

  @Test public void usecase1() {
    azzert.assertTrue(count.of(Arrays.asList(new String[] {})) == 0);
  }
}
