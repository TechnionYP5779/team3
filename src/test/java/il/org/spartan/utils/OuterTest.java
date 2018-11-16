package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

public class OuterTest {
  @Test @SuppressWarnings({ "unchecked", "null", "static-method" }) public void outerAdds() {
    @SuppressWarnings({ "rawtypes" }) final Outer o = new Outer(box.box(10));
    @SuppressWarnings({ "rawtypes" }) final Outer o1 = new Outer(box.box(10));
    azzert.assertTrue(o.equals(o1));
    o.set(box.box(11));
    azzert.assertTrue(((Integer) o.get()).equals(box.box(11)));
  }
}
