package tests;

import org.junit.*;

import fluent.ly.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
import static fluent.ly.azzert.*;
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
    isNull(nil.forgetting(Integer.valueOf(1), Double.valueOf(4), "hi"));
  }

  @Test public void usecase4() {
    isNull(nil.guardingly(λ -> Boolean.valueOf("hi".equals(λ))).on(null));
  }
}
