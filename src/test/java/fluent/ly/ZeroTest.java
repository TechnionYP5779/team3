package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class ZeroTest {
  @Test public void zerotest() {
    final Object o1 = new Object();
    final Object o2 = new Object();
    azzert.assertTrue(zero.forgetting(o1, o2) == 0);
    azzert.assertTrue(zero.forget(true) == 0);
    azzert.assertTrue(zero.forget(1.0) == 0);
    azzert.assertTrue(zero.forget(5L) == 0);
  }
}
