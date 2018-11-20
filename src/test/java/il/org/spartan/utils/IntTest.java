package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class IntTest {
  @Test public void basic_test() {
    final Int b = new Int(3);
    assert b.equals(b);
    assert b.inner == 3;
    assert Int.valueOf(0).inner == 0;
  }

  @Test public void set_get_change_test() {
    final Int a = new Int(), b = new Int(3);
    a.set(4);
    assert a.get() == 4;
    a.set(-6);
    assert a.get() != 4;
    assert a.get() == -6;
    b.set(Integer.MAX_VALUE);
    assert b.get() == Integer.MAX_VALUE;
    b.set(Integer.MIN_VALUE);
    assert b.get() == Integer.MIN_VALUE;
    b.clear();
    assert b.get() == 0;
    b.step();
    assert b.inner().equals(box.it(b.get()));
    assert b.next() == 2;
    assert b.next() == Int.valueOf(3).get();
    assert "3".equals(b + "");
  }

  @Test public void math_test() {
    final Int a = new Int(5), b = new Int(3);
    a.add(b);
    assert a.get() == 8;
    a.add(-10);
    assert a.get() == -2;
    b.add(a);
    a.add(a);
    assert b.get() == 1;
    assert a.get() == -4;
  }
}
