package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class forgetTest {
  @Test public void testForget() {
    forget.it(5);
    forget.it(false);
    forget.it(1.0);
    forget.it("bla");
    forget.all("1", "2", "3");
  }

  @Test public void unuse() {
    long a = 1;
    forget.unuse(a);
    double b = 1;
    forget.unused(b, new double[] {});
    forget.unused(b, new Object[] {});
    forget.unused(a, new long[] {});
    forget.unused(a, new Object[] {});
  }

  @Test public void unused() {
    forget.______unused("a", "b");
  }
}
