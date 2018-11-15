package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.*;

@SuppressWarnings("unused") public class Int_tests {
  @SuppressWarnings("static-method") @Test public void basic_test() {
    new Int();
    final Int b = new Int(3);
    azzert.assertTrue( b.equals(b));
    azzert.assertTrue( b.inner == 3);
    azzert.assertTrue( Int.valueOf(0).inner == 0);
  }

  @SuppressWarnings({ "static-method" }) @Test public void set_get_change_test() {
    final Int a = new Int(), b = new Int(3);
    a.set(4);
    azzert.assertTrue( a.get() == 4);
    a.set(-6);
    azzert.assertTrue( a.get() != 4);
    azzert.assertTrue( a.get() == -6);
    b.set(Integer.MAX_VALUE);
    azzert.assertTrue( b.get() == Integer.MAX_VALUE);
    b.set(Integer.MIN_VALUE);
    azzert.assertTrue( b.get() == Integer.MIN_VALUE);
    b.clear();
    azzert.assertTrue( b.get() == 0);
    b.step();
    azzert.assertTrue( b.inner().equals(box.box(b.get())));
    azzert.assertTrue( b.next() == 2);
    azzert.assertTrue( b.next() == Int.valueOf(3).get());
    azzert.assertTrue( "3".equals(b + ""));
  }

  @SuppressWarnings("static-method") @Test public void math_test() {
    final Int a = new Int(5), b = new Int(3);
    a.add(b);
    azzert.assertTrue( a.get() == 8);
    a.add(-10);
    azzert.assertTrue( a.get() == -2);
    b.add(a);
    a.add(a);
    azzert.assertTrue( b.get() == 1);
    azzert.assertTrue( a.get() == -4);
  }

}
