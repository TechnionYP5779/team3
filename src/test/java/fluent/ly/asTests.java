package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class asTests {
  @Test public void asBitOfFalse() {
    azzert.that(as.bit(false), is(0));
  }

  @Test public void asBitOfTrue() {
    azzert.that(as.bit(true), is(1));
  }

  @SuppressWarnings("null") @Test public void asIntArraySimple() {
    final int @NotNull [] is = as.intArray(100, 200, 200, 12, 13, 0);
    azzert.assertCollectionsEqual(as.list(is), as.ingeterList(is));
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
      azzert.assertTrue(¢.equals(val));
      val = Integer.valueOf(val.intValue() + 1);
    }
  }

  @SuppressWarnings("null") @Test public void asIteretableLambdaTest() {
    Integer val = Integer.valueOf(1);
    for (final Integer ¢ : as.asIterableLambda(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3))) {
      azzert.assertTrue(¢.equals(val));
      val = Integer.valueOf(val.intValue() + 1);
    }
  }

  @Test public void bitObjectTest() {
    azzert.assertTrue(as.bit(null) == 0);
    azzert.assertTrue(as.bit("false") == 1);
  }

  @Test @SuppressWarnings("unlikely-arg-type") public void setTest() {
    final Set<? extends String> s1 = as.set("a", "b", "c");
    azzert.assertTrue(s1.size() == 3);
    azzert.assertTrue(s1.containsAll(as.list("a", "b", "c")));
  }

  @Test public void stringsTest() {
    final String[] expected = new String[] { "a", "b", "c", "1" };
    final String[] actual = as.strings(as.list("a", "b", "c", Integer.valueOf(1), null));
    Assert.assertArrayEquals(expected, actual);
  }
}
