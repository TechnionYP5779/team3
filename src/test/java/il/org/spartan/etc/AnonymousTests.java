package il.org.spartan.etc;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.etc.*;

@SuppressWarnings("static-method") public class AnonymousTests {
  @Test public void usecase0() {
    azzert.assertTrue( anonymous.ly(() -> true));
  }

  @Test public void usecase1() {
    azzert.assertTrue( anonymous.ly(() -> 2) == 2);
  }

  @Test public void usecase2() {
    azzert.assertTrue( anonymous.ly(() -> 2.5) == 2.5);
  }

  @Test public void usecase3() {
    azzert.assertTrue( "hello".equals(anonymous.ly(() -> "hello")));
  }
}
