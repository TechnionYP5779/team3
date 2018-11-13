package tests;



import org.junit.*;

import fluent.ly.*;
import fluent.ly.___.Bug.Assertion.*;
import fluent.ly.___.Bug.Assertion.Value.Numerical.*;
import fluent.ly.___.Bug.Assertion.Variant.*;
import fluent.ly.___.Bug.Contract.*;
import fluent.ly.___.Variant;

@SuppressWarnings("static-method") public class __Tests {
  @Test public void ensure() {
    ___.ensure(true);
    try {
      ___.ensure(false);
    } catch (final Postcondition e) {
      azzert.assertTrue("".equals(e.getMessage()));
    }
    try {
      ___.ensure(false, "ensure");
    } catch (final Postcondition e) {
      azzert.assertTrue("ensure".equals(e.getMessage()));
    }
    try {
      ___.ensure(false, "ensure %s message %s", "this", "now");
    } catch (final Postcondition e) {
      azzert.assertTrue("ensure this message now".equals(e.getMessage()));
    }
  }

  @Test public void negative() {
    ___.negative(-1);
    ___.negative(-2);
    ___.negative(-0.3);
    try {
      ___.negative(0);
    } catch (final Negative ¢) {
      azzert.assertTrue("Found 0 while expecting a negative integer.".equals(¢.getMessage()));
    }
    try {
      ___.negative(0.0);
    } catch (final Negative ¢) {
      azzert.assertTrue("Found 0.00000 while expecting a negative number.".equals(¢.getMessage()));
    }
    try {
      ___.negative(-1);
    } catch (final Negative ¢) {
      azzert.assertTrue("Found -1 while expecting a negative integer.".equals(¢.getMessage()));
    }
    try {
      ___.negative(-1.0);
    } catch (final Negative ¢) {
      azzert.assertTrue("Found -1.00000 while expecting a negative number.".equals(¢.getMessage()));
    }
  }

  @Test public void nonnegative() {
    ___.nonnegative(1);
    ___.nonnegative(2);
    ___.nonnegative(0);
    ___.nonnegative(0.3);
    ___.nonnegative(0.0);
    try {
      ___.nonnegative(1);
    } catch (final NonNegative ¢) {
      azzert.assertTrue("Found -1 while expecting a negative integer.".equals(¢.getMessage()));
    }
    try {
      ___.nonnegative(1.0);
    } catch (final NonNegative ¢) {
      azzert.assertTrue("Found -1.00000 while expecting a negative number.".equals(¢.getMessage()));
    }
  }

  @Test public void nonnull() {
    ___.nonnull(new Object());
    try {
      ___.nonnull(null);
    } catch (final Exception ¢) {
      azzert.assertTrue("".equals(¢.getMessage()));
    }
    try {
      ___.nonnull(null, "nonnull");
    } catch (final Exception ¢) {
      azzert.assertTrue("nonnull".equals(¢.getMessage()));
    }
    try {
      ___.nonnull(null, "nonnull %s message %s", "this", "now");
    } catch (final Exception ¢) {
      azzert.assertTrue("nonnull this message now".equals(¢.getMessage()));
    }
  }

  @Test public void nonpositive() {
    ___.nonpositive(-1);
    ___.nonpositive(-2);
    ___.nonpositive(-0.3);
    ___.nonpositive(0);
    ___.nonpositive(0.0);
    try {
      ___.nonpositive(-1);
    } catch (final NonPositive ¢) {
      azzert.assertTrue("Found -1 while expecting a nonpositive integer.".equals(¢.getMessage()));
    }
    try {
      ___.nonpositive(-1.0);
    } catch (final NonPositive ¢) {
      azzert.assertTrue("Found -1.00000 while expecting a nonpositive number.".equals(¢.getMessage()));
    }
  }

  @Test public void positive() {
    ___.positive(1);
    ___.positive(2);
    ___.positive(0.3);
    try {
      ___.positive(0);
    } catch (final Positive ¢) {
      azzert.assertTrue("Found 0 while expecting a positive integer.".equals(¢.getMessage()));
    }
    try {
      ___.positive(0.0);
    } catch (final Positive ¢) {
      azzert.assertTrue("Found 0.00000 while expecting a positive number.".equals(¢.getMessage()));
    }
    try {
      ___.positive(-1);
    } catch (final Positive ¢) {
      azzert.assertTrue("Found -1 while expecting a positive integer.".equals(¢.getMessage()));
    }
    try {
      ___.positive(-1.0);
    } catch (final Positive ¢) {
      azzert.assertTrue("Found -1.00000 while expecting a positive number.".equals(¢.getMessage()));
    }
  }

  @Test public void require() {
    ___.require(true);
    try {
      ___.require(false);
    } catch (final Precondition ¢) {
      azzert.assertTrue("".equals(¢.getMessage()));
    }
    try {
      ___.require(false, "requireMessage");
    } catch (final Precondition ¢) {
      azzert.assertTrue("requireMessage".equals(¢.getMessage()));
    }
    try {
      ___.require(false, "require %s message %s", "this", "now");
    } catch (final Precondition ¢) {
      azzert.assertTrue("require this message now".equals(¢.getMessage()));
    }
  }

  @Test(expected = ___.Bug.class) public void requireBug() {
    ___.require(false);
  }

  @Test(expected = Precondition.class) public void requirePrecondition() {
    ___.require(false);
  }

  @Test public void sure() {
    ___.sure(true);
    try {
      ___.sure(false);
    } catch (final Invariant e) {
      azzert.assertTrue("".equals(e.getMessage()));
    }
    try {
      ___.sure(false, "sure");
    } catch (final Invariant e) {
      azzert.assertTrue("sure".equals(e.getMessage()));
    }
    try {
      ___.sure(false, "sure %s message %s", "this", "now");
    } catch (final Invariant e) {
      azzert.assertTrue("sure this message now".equals(e.getMessage()));
    }
  }

  @Test public void unreachable() {
    try {
      ___.unreachable();
    } catch (final Reachability ¢) {
      azzert.assertTrue("".equals(¢.getMessage()));
    }
    try {
      ___.unreachable("unreachable message");
    } catch (final Reachability ¢) {
      azzert.assertTrue("unreachable message".equals(¢.getMessage()));
    }
    try {
      ___.unreachable("unreachable %s message %s", "this", "now");
    } catch (final Reachability ¢) {
      azzert.assertTrue("unreachable this message now".equals(¢.getMessage()));
    }
  }

  @Test public void variant() {
    {
      final Variant v = new Variant(10);
      azzert.assertTrue(10 == v.value());
      v.check(9);
      v.check(8);
      v.check(4);
      v.check(2);
      v.check(1);
      v.check(0);
      azzert.assertTrue(0==v.value());
    }
    try {
      ___.unused(new Variant(-1));
    } catch (final Initial e) {
      azzert.assertTrue("Initial variant value (-1) is negative".equals(e.getMessage()));
    }
    try {
      final Variant v = new Variant(10);
      v.check(8);
      v.check(9);
    } catch (final Nondecreasing ¢) {
      azzert.assertTrue("New variant value (9) should be less than previous value (8)".equals(¢.getMessage()));
    }
    try {
      final Variant v = new Variant(10);
      v.check(8);
      v.check(-2);
    } catch (final Underflow ¢) {
      azzert.assertTrue("New variant value (-2) is negative".equals(¢.getMessage()));
    }
  }
}
