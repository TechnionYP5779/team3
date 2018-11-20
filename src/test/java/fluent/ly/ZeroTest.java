package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class ZeroTest {
  @Test public void zerotest() {
    final Object o2 = new Object();
    assert zero.forgetting(new Object(), o2) == 0;
    assert zero.forget(true) == 0;
    assert zero.forget(1.0) == 0;
    assert zero.forget(5L) == 0;
  }
}
