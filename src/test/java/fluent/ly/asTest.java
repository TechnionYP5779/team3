package fluent.ly;

import static org.junit.Assert.*;

import static fluent.ly.azzert.*;

import java.util.*;
import static fluent.ly.box.*;
import org.jetbrains.annotations.*;
import org.junit.*;
import il.org.spartan.Utils;

@SuppressWarnings( "static-method") public class asTest {
  @Test public void asBitOfFalse() {
    azzert.that(as.bit(false), is(0));
  }

  @Test public void asBitOfTrue() {
    azzert.that(as.bit(true), is(1));
  }

  @Test public void asIntArraySimple() {
    final int @NotNull [] is = as.intArray(100, 200, 200, 12, 13, 0);
    azzert.assertCollectionsEqual(Utils.cantBeNull(as.list(is)), as.ingeterList(is));
  }

  @Test public void asListSimple() {
    // direct call `as.list(12, 13, 14)` kills Travis --or
    final @NotNull List<Integer> is = Utils.cantBeNull(as.list(new int @NotNull [] { 12, 13, 14 }));
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

  @Test public void asIteretableTest() {
    Integer val = box(1);
    for (final Integer ¢ : as.asIterable(Utils.cantBeNull(box(1)), Utils.cantBeNull(box(2)), Utils.cantBeNull(box(3)))) {
      assert ¢.equals(val);
      val = box(val.intValue() + 1);
    }
  }

  @Test public void asIteretableLambdaTest() {
    Integer val = box(1);
    for (final Integer ¢ : as.asIterableLambda(Utils.cantBeNull(box(1)), Utils.cantBeNull(box(2)), Utils.cantBeNull(box(3)))) {
      assert ¢.equals(val);
      val = box(val.intValue() + 1);
    }
  }

  @Test public void bitObjectTest() {
    assert as.bit(null) == 0;
    assert as.bit("false") == 1;
  }

  @Test @SuppressWarnings("unlikely-arg-type") public void setTest() {
    final Set<? extends String> s1 = as.set("a", "b", "c");
    assert s1.size() == 3;
    Collection<String> list = as.list("a", "b", "c");
    forget.it(list);
    assert s1.containsAll(list);
  }

  @Test public void stringsTest() {
    assertArrayEquals(new String[] { "a", "b", "c", "1" }, as.strings(as.list("a", "b", "c", box(1), null)));
  }
  
  @Test public void moreTests() {
    assertArrayEquals(as.intArray(Utils.cantBeNull(as.list(new int[] {1,2,3}))), new int[] {1,2,3});
    assert as.iterator(box(1)).next().equals(box(1));
    Iterator<Integer> i = null;
    forget.it(i);
    assert as.list(i).isEmpty();
    assert "a".equals(as.string('a'));
    assert "null".equals(as.string(null));
    assert "1".equals(as.string(Utils.cantBeNull(box(1))));
    
  }
}
