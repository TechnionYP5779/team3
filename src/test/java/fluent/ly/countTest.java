package fluent.ly;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class countTest {
  @Test public void usecase0() {
    assert count.of(Arrays.asList(new String[] { "abc", "klm", "xyz", "pqr" })) == 4;
  }

  @Test public void usecase1() {
    assert count.of(Arrays.asList(new String[] {})) == 0;
  }
}
