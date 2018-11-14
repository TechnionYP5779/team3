package fluent.ly;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({ "static-method", "unused" }) public class maybeTests {
  @Test public void usecase0() {
    azzert.isNull(maybe.no().get());
  }

  @Test public void usecase1() {
    azzert.isNull(maybe.yes(null).get());
  }

  @Test public void usecase2() {
    azzert.assertTrue( maybe.yes(new Object()).get() != null);
  }
}