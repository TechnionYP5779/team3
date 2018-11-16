package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class nilTests {
  @Test public void usecase0() {
    azzert.isNull(nil.ignoring(true));
  }

  @Test public void usecase1() {
    azzert.isNull(nil.ignoring(3));
  }

  @Test public void usecase2() {
    azzert.isNull(nil.ignoring(2.5));
  }

  @Test public void usecase3() {
    azzert.isNull(nil.forgetting(Integer.valueOf(1), Double.valueOf(4), "hi"));
  }

  @Test public void usecase4() {
    azzert.isNull(nil.guardingly(λ -> Boolean.valueOf("hi".equals(λ))).on(null));
  }
}
