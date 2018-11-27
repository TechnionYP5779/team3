package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class yesTest {
  @Test public void yestest() {
    final Object o1 = new Object(), o2 = new Object();
    final Runnable f = () -> {
      // test
    };
    assert yes.forgetting(o1, o2);
    assert yes.ignoring(true);
    assert yes.ignoring(1.0);
    assert yes.ignoring(5L);
    assert yes.forgetting(f);
  }
}
