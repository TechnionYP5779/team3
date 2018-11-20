package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class OuterTest {
  @Test public void outerAdds() {
    final Outer<Integer> o = new Outer<>(box.it(10));
    assert o.equals(new Outer<>(box.it(10)));
    o.set(box.it(11));
    assert o.get().equals(box.it(11));
  }
}
