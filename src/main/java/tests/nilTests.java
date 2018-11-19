package tests;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class nilTests {
  @Test public void usecase0() {
    isNull(nil.ignoring(true));
  }

  @Test public void usecase1() {
    isNull(nil.ignoring(3));
  }

  @Test public void usecase2() {
    isNull(nil.ignoring(2.5));
  }

  @Test public void usecase3() {
    isNull(nil.forgetting(box.box(1), box.box(4), "hi"));
  }

  @Test public void usecase4() {
    isNull(nil.guardingly(λ -> box.box("hi".equals(λ))).on(null));
  }
}
