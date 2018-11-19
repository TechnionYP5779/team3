package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

 @SuppressWarnings({ "null", "static-method" }) public class OuterTest {
   @Test public void outerAdds() {
     final Outer<Integer> o = new Outer<>(box.box(10));
     final Outer<Integer>  o1 = new Outer<>(box.box(10));
    azzert.assertTrue(o.equals(o1));
    o.set(box.box(11));
    azzert.assertTrue(o.get().equals(box.box(11)));
  }
}
