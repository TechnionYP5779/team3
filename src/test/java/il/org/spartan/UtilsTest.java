package il.org.spartan;

import static fluent.ly.azzert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.Utils.FoundHandleForT.*;
import il.org.spartan.etc.*;

@SuppressWarnings( "static-method" )  public class UtilsTest {
  @NotNull @SuppressWarnings("null") public static Integer[] intToIntegers(final int... is) {
    final Integer @NotNull [] $ = new Integer @NotNull [is.length];
    for (int ¢ = 0; ¢ < is.length; ++¢)
      $[¢] = fluent.ly.box.it(is[¢]);
    return $;
  }

  @Test @SuppressWarnings("unchecked") public void addAllTypical() {
    final Set<String> ss = new HashSet<>();
    accumulate.to(ss).addAll(as.set("A", "B"), null, as.set("B", "C", "D"));
    azzert.nay(ss.contains("E"));
    azzert.nay(ss.contains(null));
    azzert.that(ss.size(), is(4));
    for (final String ¢ : ss)
      azzert.aye("", ss.contains(¢));
  }

  @Test public void addTypical() {
    final Set<String> ss = new HashSet<>();
    accumulate.to(ss).add(null, "A", null, "B", "B", null, "C", "D", null);
    azzert.nay(ss.contains("E"));
    azzert.nay(ss.contains(null));
    azzert.that(ss.size(), is(4));
    for (final String ¢ : ss)
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
    final String [] ss = as.array("A", "B", "C", "D");
    Utils.swap(ss, 1, 1);
    azzert.assertCollectionsEqual(as.list("A", "B", "C", "D"), ss);
  }

  @Test public void swapTypical() {
    final String [] ss = as.array("A", "B", "C", "D");
    Utils.swap(ss, 1, 2);
    azzert.assertCollectionsEqual(as.list("A", "C", "B", "D"), ss);
  }

  @Test public void swapTypicalCase() {
    final @NotNull Integer [] $ = intToIntegers(29, 1, 60);
    Utils.swap($, 0, 1);
    azzert.assertCollectionsEqual(as.list(intToIntegers(1, 29, 60)), $);
  }

  @Test @SuppressWarnings("unchecked") public void addTest() {
    @SuppressWarnings("rawtypes") final List listSource = new ArrayList();
    listSource.add("123");
    listSource.add("456");
    assert !Utils.add(new ArrayList<>(), listSource.iterator()).isEmpty();
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
    assert Utils.delete(new @NotNull String[] { "1", "2", "3" }, 1).length == 2;
  }

  @Test public void appendToArrayTest() {
    assert Utils.append(new @NotNull String[] { "1", "2", "3" }, "5").length == 4;
  }

  @Test public void test2() {
    final List<String> li1 = new ArrayList<>();
    li1.add("1");
    final List<String> li2 = new ArrayList<>();
    li2.add("2");
    li2.add(null);
    assert Utils.add(li1, li2).size() == 2;
    assert Utils.add(li1, "2", null).size() == 3;
    assert Utils.addAll(li1, li2).size() == 5;
    assert Utils.add(li1, "3", "3", null).size() == 7;
    assert Utils.add(li1, "3", "3", null).size() == 9;
    @NotNull final String[] arr = { "1", "2", "3" };
    assert Utils.append(arr, "4").length == 4;
    assert Utils.compare(true, true) == 0;
    assert Utils.compare(true, false) == 1;
    assert Utils.compare(false, true) == -1;
    assert Utils.compare(false, false) == 0;
    assert Utils.compare(false, false) == 0;
    assert "a b c".equals(Utils.compressSpaces("a b     c    "));
    assert Utils.delete(arr, 2).length == 2;
    assert Utils.inRange(3, li1);
    assert !Utils.inRange(-1, li1);
    assert Utils.intIsIn(3, 4, 4, 4, 4, 3);
    assert Utils.lastIn(null, li2);
    assert !Utils.lastIn("5", li2);
    assert Utils.found(1) != null;
    assert Utils.found("1") != null;
    assert Utils.mustBeNull(null) == null;
    assert Utils.prepend(new StringBuilder("12"), '0').length() == 3;
    assert Utils.prepend(new StringBuilder("12"), "00").length() == 4;
    assert "'123'".equals(Utils.quote("123"));
    assert "<null reference>".equals(Utils.quote(null));
    final List<String> li3 = new ArrayList<>();
    li3.add("3");
    li3.add("3");
    Utils.removeDuplicates(li3);
    assert Utils.removePrefix("123", "12").length() == 1;
    assert Utils.removeSuffix("123", "3").length() == 2;
    assert "abc".equals(Utils.removeWhites("a b     c    "));
    assert Utils.sort(new int[] { 3, 2, 1 })[0] == 1;
    assert Utils.sqr(2) == 4;
    assert Utils.suffixedBy("123", "1", "2", "3");
    assert !Utils.suffixedBy("123", "3342");
    assert Utils.suffixedBy("123", li3);
    @NotNull final String[] arr3 = { "1", "2", "3" };
    Utils.swap(arr3, 0, 2);
    assert "3".equals(arr3[0]);
    assert new Utils.FoundHandleForT<>("1") != null;
    final Utils.FoundHandleForT<String> t = new Utils.FoundHandleForT<>("1");
    assert t.in("1");
    assert !t.in("2");
    assert new FoundHandleForInt(1) != null;
    final FoundHandleForInt t1 = new FoundHandleForInt(1);
    assert t1.in(1);
    assert !t1.in(2);
  }
}
