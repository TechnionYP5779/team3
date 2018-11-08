package tests;

import static org.junit.Assert.*;

import static fluent.ly.azzert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class asTests {
  @Test public void asBitOfFalse() {
    azzert.that(as.bit(false), is(0));
  }

  @Test public void asBitOfTrue() {
    azzert.that(as.bit(true), is(1));
  }

  @Test public void asIntArraySimple() {
    final int @NotNull [] is = as.intArray(100, 200, 200, 12, 13, 0);
    assertArrayEquals(is, as.intArray(as.ingeterList(is)));
  }

  @Test public void asListSimple() {
    // direct call `as.list(12, 13, 14)` kills Travis --or
    @SuppressWarnings("null") final @NotNull List<Integer> is = as.list(new int @NotNull [] { 12, 13, 14 });
    azzert.that(is.get(0), is(fluent.ly.box.it(12)));
    azzert.that(is.get(1), is(fluent.ly.box.it(13)));
    azzert.that(is.get(2), is(fluent.ly.box.it(14)));
    azzert.that(is.size(), is(3));
  }

  @Test public void stringOfNull() {
    azzert.that(as.string(null), is("null"));
  }

  @Test public void stringWhenToStringReturnsNull() {
    azzert.that(as.string(new Object() {
      @Override @Nullable public String toString() {
        return null;
      }
    }), is("null"));
  }

  @SuppressWarnings("null") @Test public void asIteretableTest() {
    Integer val = Integer.valueOf(1);
    for (final Integer ¢ : as.asIterable(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3))) {
      assert ¢.equals(val);
      val = Integer.valueOf(val.intValue() + 1);
    }
  }

  @SuppressWarnings("null") @Test public void asIteretableLambdaTest() {
    Integer val = Integer.valueOf(1);
    for (final Integer ¢ : as.asIterableLambda(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3))) {
      assert ¢.equals(val);
      val = Integer.valueOf(val.intValue() + 1);
    }
  }

  @Test public void bitObjectTest() {
    assert as.bit(null) == 0;
    assert as.bit("false") == 1;
  }

  @Test @SuppressWarnings("unlikely-arg-type") public void setTest() {
    final Set<? extends String> s1 = as.set("a", "b", "c");
    assert s1.size() == 3;
    assert s1.containsAll(as.list("a", "b", "c"));
  }

  @Test public void stringsTest() {
    Assert.assertArrayEquals(new String[] { "a", "b", "c", "1" }, as.strings(as.list("a", "b", "c", Integer.valueOf(1), null)));
  }
}
