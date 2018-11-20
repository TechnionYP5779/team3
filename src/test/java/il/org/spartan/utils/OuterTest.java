package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({ "null", "static-method" }) public class OuterTest {
  @Test public void outerAdds() {
    final Outer<Integer> o = new Outer<>(box.box(10));
    assert o.equals(new Outer<>(box.box(10)));
    o.set(box.box(11));
    assert o.get().equals(box.box(11));
  }
}
