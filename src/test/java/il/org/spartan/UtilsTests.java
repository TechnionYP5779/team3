package il.org.spartan;

import static fluent.ly.azzert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings( "static-method" )  public class UtilsTests {
  @SuppressWarnings("null") @NotNull public static Integer[] intToIntegers(final int... is) {
    final Integer @NotNull [] $ = new Integer @NotNull [is.length];
    for (int ¢ = 0; ¢ < is.length; ++¢)
      $[¢] = fluent.ly.box.it(is[¢]);
    return $;
  }

  @SuppressWarnings("unchecked") @Test public void addAllTypical() {
    final Set<String> ss = new HashSet<>();
    accumulate.to(ss).addAll(as.set("A", "B"), null, as.set("B", "C", "D"));
    azzert.nay(ss.contains("E"));
    azzert.nay(ss.contains(null));
    azzert.that(ss.size(), is(4));
    for (final @NotNull String ¢ : ss)
      azzert.aye("", ss.contains(¢));
  }

  @Test public void addTypical() {
    final Set<String> ss = new HashSet<>();
    accumulate.to(ss).add(null, "A", null, "B", "B", null, "C", "D", null);
    azzert.nay(ss.contains("E"));
    azzert.nay(ss.contains(null));
    azzert.that(ss.size(), is(4));
    for (final @NotNull String ¢ : ss)
      azzert.aye("", ss.contains(¢));
    azzert.aye(ss.contains("A"));
  }

  @Test public void cantBeNullOfNull() {
    try {
      Utils.cantBeNull(null);
      azzert.fail("AssertionError expected prior to this line.");
    } catch (final AssertionError ¢) {
      forget.it(¢);
      azzert.aye("", true);
    }
  }

  @Test public void cantBeNullTypical() {
    assert Utils.cantBeNull(new Object()) != null;
  }

  @Test public void isNullTypical() {
    try {
      isNull(Utils.mustBeNull(null));
      azzert.fail("AssertionError expected prior to this line.");
    } catch (final AssertionError ¢) {
      forget.it(¢);
      azzert.aye("", true);
    }
  }

  @Test public void mustBeNullOfNotNull() {
    try {
      Utils.mustBeNull(new Object());
      azzert.fail("AssertionError expected prior to this line.");
    } catch (final AssertionError ¢) {
      forget.it(¢);
      azzert.aye("", true);
    }
  }

  @Test public void quoteEmptyString() {
    azzert.that(idiomatic.quote(""), is("''"));
  }

  @Test public void quoteNull() {
    azzert.that(idiomatic.quote(null), is("<null reference>"));
  }

  @Test public void quoteSimpleString() {
    azzert.that(idiomatic.quote("A"), is("'A'"));
  }

  @Test public void swapDegenerate() {
    final @NotNull String @NotNull [] ss = as.array("A", "B", "C", "D");
    Utils.swap(ss, 1, 1);
    azzert.assertCollectionsEqual(as.list("A", "B", "C", "D"), ss);
  }

  @Test public void swapTypical() {
    final @NotNull String @NotNull [] ss = as.array("A", "B", "C", "D");
    Utils.swap(ss, 1, 2);
    azzert.assertCollectionsEqual(as.list("A", "C", "B", "D"), ss);
  }

  @Test public void swapTypicalCase() {
    final Integer @NotNull [] $ = intToIntegers(29, 1, 60);
    Utils.swap($, 0, 1);
    azzert.assertCollectionsEqual(as.list(intToIntegers(1, 29, 60)), $);
  }

  @Test @SuppressWarnings("unchecked") public void addTest() {
    @SuppressWarnings("rawtypes") final List listSource = new ArrayList();
    listSource.add("123");
    listSource.add("456");
    assert Utils.add(new ArrayList<>(), listSource.iterator()).size() > 0;
  }

  @Test @SuppressWarnings({ "unchecked", "rawtypes" }) public void addTest2() {
    assert Utils.add(new ArrayList(), "a", "a", "b", "c").size() == 4;
  }

  @Test public void hasNullTest() {
    assert Utils.hasNull(null, "a");
  }

  @Test public void hasIntest() {
    assert Utils.intIsIn(3, 2, 4, 3);
  }

  @Test @SuppressWarnings("unchecked") public void tesDup() {
    @SuppressWarnings("rawtypes") final List list = new ArrayList();
    list.add("123");
    list.add("123");
    Utils.removeDuplicates(list);
    assert list.size() == 1;
  }

  @Test public void removeSuffixTest() {
    assert "123".equals(Utils.removeSuffix("12345", "45"));
  }

  @Test public void removePrefixTest() {
    assert "45".equals(Utils.removePrefix("12345", "123"));
  }

  @Test public void removeFromArrayTest() {
    assert Utils.delete(new String[] { "1", "2", "3" }, 1).length == 2;
  }

  @Test public void appendToArrayTest() {
    assert Utils.append(new String[] { "1", "2", "3" }, "5").length == 4;
  }

}
