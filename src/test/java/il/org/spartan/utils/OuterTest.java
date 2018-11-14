package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

public class OuterTest {
  @Test @SuppressWarnings({ "unchecked", "boxing", "null", "static-method" }) public void outerAdds() {
    @SuppressWarnings({ "rawtypes" }) final Outer o = new Outer(10);
    @SuppressWarnings({ "rawtypes" }) final Outer o1 = new Outer(10);
    azzert.assertTrue(o.equals(o1));
    o.set(11);
    azzert.assertTrue((int) o.get() == 11);
  }
}
