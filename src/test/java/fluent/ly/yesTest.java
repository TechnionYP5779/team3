package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class yesTest {
  @Test public void yestest() {
    final Object o1 = new Object();
    final Object o2 = new Object();
    final Runnable f = () -> {
    };
    azzert.assertTrue(yes.forgetting(o1, o2));
    azzert.assertTrue(yes.ignoring(true));
    azzert.assertTrue(yes.ignoring(1.0));
    azzert.assertTrue(yes.ignoring(5L));
    azzert.assertTrue(yes.forgetting(f));
  }
}
