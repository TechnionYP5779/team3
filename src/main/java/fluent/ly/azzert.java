package fluent.ly;

import static il.org.spartan.Utils.*;

import static fluent.ly.box.*;

import java.util.*;

import org.hamcrest.*;
import org.hamcrest.core.*;
import org.hamcrest.number.*;
import org.jetbrains.annotations.*;
import org.junit.*;

import il.org.spartan.utils.*;

/** Extends {@link org.junit.Assert} with more assertion for equality
 * comparisons. If the comparison yields a "not-equal" result, a JUnit assertion
 * failure is issued.
 * @author Itay Maman Jul 9, 2007
 * @author Yossi Gil revised 2015-07-18 */
//
public class azzert extends org.junit.Assert {
  public static <T> Matcher<T> allOf(final java.lang.Iterable<Matcher<? super T>> ¢) {
    return AllOf.allOf(¢);
  }

  @SafeVarargs public static <T> Matcher<T> allOf(final Matcher<? super T>... ¢) {
    return AllOf.allOf(¢);
  }

  public static <T> Matcher<T> allOf(final Matcher<? super T> first, final Matcher<? super T> second) {
    return AllOf.allOf(first, second);
  }

  public static <T> Matcher<T> allOf(final Matcher<? super T> first, final Matcher<? super T> second, final Matcher<? super T> third) {
    return AllOf.allOf(first, second, third);
  }

  public static <T> Matcher<T> allOf(final Matcher<? super T> first, final Matcher<? super T> second, final Matcher<? super T> third,
      final Matcher<? super T> fourth, final Matcher<? super T> fifth) {
    return AllOf.allOf(first, second, third, fourth, fifth);
  }

  public static <T> Matcher<T> allOf(final Matcher<? super T> first, final Matcher<? super T> second, final Matcher<? super T> third,
      final Matcher<? super T> fourth, final Matcher<? super T> fifth, final Matcher<? super T> sixth) {
    return AllOf.allOf(first, second, third, fourth, fifth, sixth);
  }

  public static <T> Matcher<T> any(final java.lang.Class<T> type) {
    return IsInstanceOf.any(type);
  }

  public static <T> AnyOf<T> anyOf(final java.lang.Iterable<Matcher<? super T>> ¢) {
    return AnyOf.anyOf(¢);
  }

  @SafeVarargs public static <T> AnyOf<T> anyOf(final Matcher<? super T>... ¢) {
    return AnyOf.anyOf(¢);
  }

  public static Matcher<Object> anything() {
    return IsAnything.anything();
  }

  public static Matcher<Object> anything(final String description) {
    return IsAnything.anything(description);
  }

  public static <T> void assertCollectionsEqual(final @NotNull Collection<T> c1, final @NotNull Collection<T> c2) {
    assertCollectionsEqual("", c1, c2);
  }

  public static <T> void assertCollectionsEqual(final @NotNull Collection<T> ts1, final T[] ts2) {
    assertCollectionsEqual("", ts1, cantBeNull(Arrays.asList(ts2)));
  }

  public static <T> void assertCollectionsEqual(final @NotNull String s, final @NotNull Collection<T> c1, final @NotNull Collection<T> c2) {
    assertContained(s, c1, c2);
    assertContained(s, c2, c1);
  }

  public static <T> void assertCollectionsEqual(final @NotNull String s, final @NotNull Collection<T> ts1, final T[] ts2) {
    assertCollectionsEqual(s, ts1, cantBeNull(Arrays.asList(ts2)));
  }

  public static <T> void assertCollectionsEqual(final @NotNull String s, final T[] ts1, final @NotNull Collection<T> ts2) {
    assertCollectionsEqual(s, ts2, ts1);
  }

  public static <T> void assertContained(final @NotNull String s, final @NotNull Collection<T> c1, final @NotNull Collection<T> c2) {
    // assertLE(s, c1.size(), c2.size());
    final @NotNull ArrayList<T> missing = new ArrayList<>();
    for (final T ¢ : c1)
      if (!c2.contains(¢))
        missing.add(¢);
    switch (missing.size()) {
      case 0:
        return;
      case 1:
        fail(s + "Element '" + missing.get(0) + "' not found in " + c2.size() + " sized-\n collection " + c2);
        break;
      default:
        fail(s + "Element '" + missing.get(0) + "' and '" + missing.get(1) + "'  as well as " + (missing.size() - 2)
            + " other \n elements were not found in " + c2.size() + " sized-\n collection " + c2);
        break;
    }
  }

  public static <T> void assertContains(final @NotNull Collection<T> ts, final T t) {
    assertContains("", ts, t);
  }

  public static <T> void assertContains(final @NotNull String s, final @NotNull Collection<T> ts, final T t) {
    assert ts.contains(t) : s + " t = " + t;
  }

  public static void assertEquals(final boolean a, final boolean b) {
    assertEquals(box(a), box(b));
  }

  public static void assertEquals(final boolean b1, final Boolean b2) {
    assertEquals(box(b1), b2);
  }

  public static void assertEquals(final Boolean b1, final boolean b2) {
    assertEquals(b1, box(b2));
  }

  public static void assertEquals(final int expected, final int actual) {
    assertEquals(box.it(expected), box.it(actual));
  }

  public static void assertEquals(final int a, final Integer b) {
    assertEquals(box(a), b);
  }

  public static void assertEquals(final Integer a, final int b) {
    assertEquals(a, box(b));
  }

  public static void assertEquals(final @NotNull String message, final boolean b1, final boolean b2) {
    assertEquals(message, box(b1), box(b2));
  }

  public static void assertEquals(final @NotNull String message, final boolean b1, final Boolean b2) {
    assertEquals(message, box(b1), b2);
  }

  public static void assertEquals(final @NotNull String message, final Boolean b1, final boolean b2) {
    assertEquals(message, b1, box(b2));
  }

  public static void assertEquals(final @NotNull String reason, final int i1, final int i2) {
    assertThat(reason, fluent.ly.box.it(i1), CoreMatchers.equalTo(fluent.ly.box.it(i2)));
  }

  public static void assertEquals(final @NotNull String message, final int a, final Integer b) {
    assertEquals(message, box(a), b);
  }

  public static void assertEquals(final @NotNull String message, final Integer a, final int b) {
    assertEquals(message, a, box(b));
  }

  public static void assertFalse(final boolean ¢) {
    that("", box(¢), is(Boolean.FALSE));
  }

  public static void assertFalse(final @NotNull String s, final boolean b) {
    that(s, b, is(Boolean.FALSE));
  }

  public static void assertLE(final @NotNull String s, final int i, final int m) {
    assert i <= m : s + " n=" + i + " m=" + m;
  }

  public static <T> void assertNotContains(final @NotNull Collection<T> ts, final T t) {
    assertNotContains("", ts, t);
  }

  public static <T> void assertNotContains(final @NotNull String s, final @NotNull Collection<T> ts, final T t) {
    assert !ts.contains(t) : s + " t = " + t;
  }

  public static void assertNotEquals(final Object o1, final Object o2) {
    assertThat("", o1, CoreMatchers.not(o2));
  }

  public static void assertNotEquals(final @NotNull String message, final @NotNull Object o1, final Object o2) {
    assert !o1.equals(o2);
  }

  public static void assertNotEquals(final @NotNull String s1, final @NotNull String s2) {
    assertNotEquals("", s1, s2);
  }

  public static void assertNotEquals(final @NotNull String message, final @NotNull String s1, final @NotNull String s2) {
    assert !s1.equals(s2) : message;
  }

  public static void assertNull(final Object ¢) {
    assert ¢ == null;
  }

  public static void assertNull(final @NotNull String message, final Object o) {
    assertEquals(message, null, o);
  }

  public static void assertPositive(final int ¢) {
    assert ¢ > 0 : "Expecting a positive value, but got " + ¢;
  }

  public static <T> void assertSubset(final @NotNull Collection<T> c1, final @NotNull Collection<T> c2) {
    assertContained("", c1, c2);
  }

  public static void assertTrue(final boolean ¢) {
    that("", box(¢), is(Boolean.TRUE));
  }

  public static void assertTrue(final @NotNull String s, final boolean b) {
    that(s, box(b), is(Boolean.TRUE));
  }

  public static void assertZero(final int ¢) {
    assertEquals("Expecting a zero", ¢, 0);
  }

  @NotNull public static Asserter aye(final boolean claim) {
    return aye("", claim);
  }

  @NotNull public static Asserter aye(final @NotNull String reason, final boolean claim) {
    return new Asserter().andAye(reason, claim);
  }

  public static <LHS> CombinableMatcher.CombinableBothMatcher<LHS> both(final Matcher<? super LHS> ¢) {
    return CombinableMatcher.both(¢);
  }

  @Factory public static Matcher<Boolean> comparesEqualTo(final boolean ¢) {
    return OrderingComparison.comparesEqualTo(box(¢));
  }

  @Factory public static Matcher<Byte> comparesEqualTo(final byte ¢) {
    return OrderingComparison.comparesEqualTo(box(¢));
  }

  @Factory public static Matcher<Character> comparesEqualTo(final char ¢) {
    return OrderingComparison.comparesEqualTo(box(¢));
  }

  @Factory public static Matcher<Double> comparesEqualTo(final double ¢) {
    return OrderingComparison.comparesEqualTo(box(¢));
  }

  @Factory public static Matcher<Float> comparesEqualTo(final float ¢) {
    return OrderingComparison.comparesEqualTo(box(¢));
  }

  @Factory public static Matcher<Integer> comparesEqualTo(final int ¢) {
    return OrderingComparison.comparesEqualTo(box(¢));
  }

  @Factory public static Matcher<Long> comparesEqualTo(final long ¢) {
    return OrderingComparison.comparesEqualTo(box(¢));
  }

  @Factory public static Matcher<Short> comparesEqualTo(final short ¢) {
    return OrderingComparison.comparesEqualTo(box(¢));
  }

  public static Matcher<String> containsString(final @NotNull String substring) {
    return StringContains.containsString(substring);
  }

  public static <T> Matcher<T> describedAs(final @NotNull String description, final Matcher<T> m, final Object... values) {
    return DescribedAs.describedAs(description, m, values);
  }

  public static <LHS> CombinableMatcher.CombinableEitherMatcher<LHS> either(final Matcher<? super LHS> ¢) {
    return CombinableMatcher.either(¢);
  }

  public static Matcher<String> endsWith(final @NotNull String suffix) {
    return StringEndsWith.endsWith(suffix);
  }

  public static <T> void equals(final @NotNull String prefix, final @NotNull Collection<T> set, final @NotNull Collection<T> ts) {
    @NotNull Set<T> temp = new HashSet<>();
    temp.addAll(set);
    temp.removeAll(ts);
    assert temp.isEmpty() : temp;
    temp = new HashSet<>();
    temp.addAll(ts);
    temp.removeAll(set);
    assert temp.isEmpty() : prefix + " - " + temp;
  }

  public static <T> Matcher<T> equalTo(final T operand) {
    return IsEqual.equalTo(operand);
  }

  public static Matcher<String> equalToIgnoringCase(final @NotNull String expectedString) {
    return org.hamcrest.Matchers.equalToIgnoringCase(expectedString);
  }

  public static Matcher<String> equalToIgnoringWhiteSpace(final @NotNull String expectedString) {
    return org.hamcrest.Matchers.equalToIgnoringWhiteSpace(expectedString);
  }

  public static <U> Matcher<java.lang.Iterable<U>> everyItem(final Matcher<U> itemMatcher) {
    return Every.everyItem(itemMatcher);
  }

  public static void fail() {
    Assert.fail();
  }

  public static void fail(final @NotNull String ¢) {
    Assert.fail(¢);
  }

  public static void falze(final boolean ¢) {
    assert !¢;
  }

  @Factory public static Matcher<Boolean> greaterThan(final boolean ¢) {
    return OrderingComparison.greaterThan(box(¢));
  }

  @Factory public static Matcher<Byte> greaterThan(final byte ¢) {
    return OrderingComparison.greaterThan(box(¢));
  }

  @Factory public static Matcher<Character> greaterThan(final char ¢) {
    return OrderingComparison.greaterThan(box(¢));
  }

  @Factory public static Matcher<Double> greaterThan(final double ¢) {
    return OrderingComparison.greaterThan(box(¢));
  }

  @Factory @NotNull public static Matcher<Float> greaterThan(final float ¢) {
    return cantBeNull(OrderingComparison.greaterThan(box(¢)));
  }

  @Factory @NotNull public static Matcher<Integer> greaterThan(final int ¢) {
    return cantBeNull(OrderingComparison.greaterThan(box(¢)));
  }

  @Factory @NotNull public static Matcher<Long> greaterThan(final long ¢) {
    return cantBeNull(OrderingComparison.greaterThan(box(¢)));
  }

  @Factory @NotNull public static Matcher<Short> greaterThan(final short ¢) {
    return cantBeNull(OrderingComparison.greaterThan(box(¢)));
  }

  @Factory @NotNull public static Matcher<Boolean> greaterThanOrEqualTo(final boolean ¢) {
    return cantBeNull(OrderingComparison.greaterThanOrEqualTo(box(¢)));
  }

  @Factory @NotNull public static Matcher<Byte> greaterThanOrEqualTo(final byte ¢) {
    return cantBeNull(OrderingComparison.greaterThanOrEqualTo(box(¢)));
  }

  @Factory @NotNull public static Matcher<Character> greaterThanOrEqualTo(final char ¢) {
    return cantBeNull(OrderingComparison.greaterThanOrEqualTo(box(¢)));
  }

  @Factory @NotNull public static Matcher<Double> greaterThanOrEqualTo(final double ¢) {
    return cantBeNull(OrderingComparison.greaterThanOrEqualTo(box(¢)));
  }

  @Factory @NotNull public static Matcher<Float> greaterThanOrEqualTo(final float ¢) {
    return cantBeNull(OrderingComparison.greaterThanOrEqualTo(box(¢)));
  }

  @Factory @NotNull public static Matcher<Integer> greaterThanOrEqualTo(final int ¢) {
    return cantBeNull(OrderingComparison.greaterThanOrEqualTo(box(¢)));
  }

  @Factory @NotNull public static Matcher<Long> greaterThanOrEqualTo(final long ¢) {
    return cantBeNull(OrderingComparison.greaterThanOrEqualTo(box(¢)));
  }

  @Factory @NotNull public static Matcher<Short> greaterThanOrEqualTo(final short ¢) {
    return cantBeNull(OrderingComparison.greaterThanOrEqualTo(box(¢)));
  }

  @NotNull public static <T> Matcher<java.lang.Iterable<? super T>> hasItem(final Matcher<? super T> itemMatcher) {
    return cantBeNull(IsCollectionContaining.hasItem(itemMatcher));
  }

  @NotNull public static <T> Matcher<java.lang.Iterable<? super T>> hasItem(final T item) {
    return cantBeNull(IsCollectionContaining.hasItem(item));
  }

  @SafeVarargs @NotNull public static <T> Matcher<java.lang.Iterable<T>> hasItems(final Matcher<? super T>... itemMatchers) {
    return cantBeNull(IsCollectionContaining.hasItems(itemMatchers));
  }

  @SafeVarargs @NotNull public static <T> Matcher<java.lang.Iterable<T>> hasItems(final T... items) {
    return cantBeNull(IsCollectionContaining.hasItems(items));
  }

  @NotNull public static <T> Matcher<T> instanceOf(final java.lang.Class<?> type) {
    return cantBeNull(IsInstanceOf.instanceOf(type));
  }

  @NotNull public static Matcher<Boolean> is(final boolean ¢) {
    return is(box(¢));
  }

  @NotNull public static Matcher<Byte> is(final byte ¢) {
    return is(box(¢));
  }

  @NotNull public static Matcher<Character> is(final char ¢) {
    return is(box(¢));
  }

  @NotNull public static Matcher<Double> is(final double ¢) {
    return is(box(¢));
  }

  @NotNull public static Matcher<Float> is(final float ¢) {
    return is(box(¢));
  }

  @NotNull public static Matcher<Integer> is(final int ¢) {
    return is(box(¢));
  }

  @NotNull public static Matcher<Long> is(final long ¢) {
    return is(box(¢));
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> is(final Matcher<T> ¢) {
    return cantBeNull(Is.is(¢));
  }

  @NotNull public static Matcher<Short> is(final short ¢) {
    return is(box(¢));
  }

  @Contract(pure = true) public static <T> @NotNull Matcher<T> is(final T value) {
    return cantBeNull(Is.is(value));
  }

  @NotNull public static <T> Matcher<T> isA(final java.lang.Class<T> type) {
    return cantBeNull(Is.isA(type));
  }

  public static void isNull(final Object ¢) {
    assertThat("", ¢, nullValue());
  }

  /** @param message what to print
   * @param o       what to examine */
  @Contract("_, !null -> fail") public static void isNull(final @NotNull String message, final Object o) {
    azzert.assertNull(message, o);
  }

  @NotNull public static Outer<@Nullable String> iz(final @NotNull String ¢) {
    return new Outer<>(¢);
  }

  @Factory @NotNull public static Matcher<Boolean> lessThan(final boolean ¢) {
    return cantBeNull(OrderingComparison.lessThan(box(¢)));
  }

  @Factory @NotNull public static Matcher<Byte> lessThan(final byte ¢) {
    return cantBeNull(OrderingComparison.lessThan(box(¢)));
  }

  @Factory @NotNull public static Matcher<Character> lessThan(final char ¢) {
    return cantBeNull(OrderingComparison.lessThan(box(¢)));
  }

  @Factory @NotNull public static Matcher<Double> lessThan(final double ¢) {
    return cantBeNull(OrderingComparison.lessThan(box(¢)));
  }

  @Factory @NotNull public static Matcher<Float> lessThan(final float ¢) {
    return cantBeNull(OrderingComparison.lessThan(box(¢)));
  }

  @Factory @NotNull public static Matcher<Integer> lessThan(final int ¢) {
    return cantBeNull(OrderingComparison.lessThan(box(¢)));
  }

  @Factory @NotNull public static Matcher<Long> lessThan(final long ¢) {
    return cantBeNull(OrderingComparison.lessThan(box(¢)));
  }

  @Factory @NotNull public static Matcher<Short> lessThan(final short ¢) {
    return cantBeNull(OrderingComparison.lessThan(box(¢)));
  }

  @Factory @NotNull public static Matcher<Boolean> lessThanOrEqualTo(final boolean ¢) {
    return cantBeNull(OrderingComparison.lessThanOrEqualTo(box(¢)));
  }

  @Factory @NotNull public static Matcher<Byte> lessThanOrEqualTo(final byte ¢) {
    return cantBeNull(OrderingComparison.lessThanOrEqualTo(box(¢)));
  }

  @Factory @NotNull public static Matcher<Character> lessThanOrEqualTo(final char ¢) {
    return cantBeNull(OrderingComparison.lessThanOrEqualTo(box(¢)));
  }

  @Factory @NotNull public static Matcher<Double> lessThanOrEqualTo(final double ¢) {
    return cantBeNull(OrderingComparison.lessThanOrEqualTo(box(¢)));
  }

  @Factory @NotNull public static Matcher<Float> lessThanOrEqualTo(final float ¢) {
    return cantBeNull(OrderingComparison.lessThanOrEqualTo(box(¢)));
  }

  @Factory @NotNull public static Matcher<Integer> lessThanOrEqualTo(final int ¢) {
    return cantBeNull(OrderingComparison.lessThanOrEqualTo(box(¢)));
  }

  @Factory @NotNull public static Matcher<Long> lessThanOrEqualTo(final long ¢) {
    return cantBeNull(OrderingComparison.lessThanOrEqualTo(box(¢)));
  }

  @Factory @NotNull public static Matcher<Short> lessThanOrEqualTo(final short ¢) {
    return cantBeNull(OrderingComparison.lessThanOrEqualTo(box(¢)));
  }

  @NotNull public static Asserter nay(final boolean claim) {
    return nay("", claim);
  }

  @NotNull public static Asserter nay(final @NotNull String reason, final boolean claim) {
    return new Asserter().andNay(reason, claim);
  }

  public static void nonNulls(final @NotNull Iterable<Object> os) {
    assert os != null;
    assert os != null;
    for (final Object ¢ : os)
      assert ¢ != null : os + "";
  }

  @NotNull public static Matcher<Boolean> not(final boolean ¢) {
    return cantBeNull(IsNot.not(box(¢)));
  }

  @NotNull public static Matcher<Byte> not(final byte ¢) {
    return cantBeNull(IsNot.not(box(¢)));
  }

  @NotNull public static Matcher<Character> not(final char i) {
    return cantBeNull(IsNot.not(box(i)));
  }

  @NotNull public static Matcher<Double> not(final double ¢) {
    return cantBeNull(IsNot.not(box(¢)));
  }

  @NotNull public static Matcher<Float> not(final float ¢) {
    return cantBeNull(IsNot.not(box(¢)));
  }

  @NotNull public static Matcher<Integer> not(final int ¢) {
    return cantBeNull(IsNot.not(box(¢)));
  }

  @NotNull public static Matcher<Long> not(final long i) {
    return cantBeNull(IsNot.not(box(i)));
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> not(final Matcher<T> ¢) {
    return cantBeNull(IsNot.not(¢));
  }

  @NotNull public static Matcher<Short> not(final short ¢) {
    return cantBeNull(IsNot.not(box(¢)));
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> not(final T value) {
    return cantBeNull(IsNot.not(value));
  }

  public static void notNull(final Object ¢) {
    assertThat("", ¢, notNullValue());
  }

  public static void notNull(final @NotNull String s, final Object o) {
    assertThat(s, o, notNullValue());
  }

  @Contract(pure = true) @NotNull public static Matcher<Object> notNullValue() {
    return cantBeNull(IsNull.notNullValue());
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> notNullValue(final java.lang.Class<T> type) {
    return cantBeNull(IsNull.notNullValue(type));
  }

  public static void notNullz(final @NotNull Object... os) {
    assert os != null;
    assert os != null;
    for (final Object ¢ : os)
      assert ¢ != null : os + "";
  }

  @Contract(pure = true) @NotNull public static Matcher<Object> nullValue() {
    return cantBeNull(IsNull.nullValue());
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> nullValue(final java.lang.Class<T> type) {
    return cantBeNull(IsNull.nullValue(type));
  }

  public static void positive(final int ¢) {
    azzert.that(¢, greaterThan(0));
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> sameInstance(final T target) {
    return cantBeNull(IsSame.sameInstance(target));
  }

  @NotNull public static Matcher<String> startsWith(final @NotNull String prefix) {
    return cantBeNull(StringStartsWith.startsWith(prefix));
  }

  public static void that(final boolean b, final @NotNull Matcher<? super Boolean> m) {
    assertThat("", box(b), m);
  }

  public static void that(final byte b, final @NotNull Matcher<? super Byte> m) {
    assertThat("", box(b), m);
  }

  public static void that(final char c, final @NotNull Matcher<? super Character> m) {
    assertThat("", box(c), m);
  }

  public static void that(final double d, final @NotNull Matcher<? super Double> m) {
    assertThat("", box(d), m);
  }

  public static void that(final float f, final @NotNull Matcher<? super Float> m) {
    assertThat("", box(f), m);
  }

  public static void that(final int i, final @NotNull Matcher<? super Integer> m) {
    assertThat("", box(i), m);
  }

  public static void that(final long l, final @NotNull Matcher<? super Long> m) {
    assertThat("", box(l), m);
  }

  public static void that(final Object actual, final @NotNull Outer<@Nullable String> expected) {
    assertThat("", compressSpaces(actual + ""), is(compressSpaces(cantBeNull(expected.get()))));
  }

  public static void that(final short s, final @NotNull Matcher<? super Short> m) {
    assertThat("", box(s), m);
  }

  public static void that(final @NotNull String reason, final boolean b, final @NotNull Matcher<? super Boolean> m) {
    assertThat(reason, box(b), m);
  }

  public static void that(final @NotNull String reason, final byte b, final @NotNull Matcher<? super Byte> m) {
    assertThat(reason, box(b), m);
  }

  public static void that(final @NotNull String reason, final char c, final @NotNull Matcher<? super Character> m) {
    assertThat(reason, box(c), m);
  }

  public static void that(final @NotNull String reason, final double d, final @NotNull Matcher<? super Double> m) {
    assertThat(reason, box(d), m);
  }

  public static void that(final @NotNull String reason, final float f, final @NotNull Matcher<? super Float> m) {
    assertThat(reason, box(f), m);
  }

  public static void that(final @NotNull String reason, final int i, final @NotNull Matcher<? super Integer> m) {
    assertThat(reason, box(i), m);
  }

  public static void that(final @NotNull String reason, final long l, final @NotNull Matcher<? super Long> m) {
    assertThat(reason, box(l), m);
  }

  public static void that(final @NotNull String reason, final short s, final @NotNull Matcher<? super Short> m) {
    assertThat(reason, box(s), m);
  }

  public static <T> void that(final @NotNull String reason, final T actual, final @NotNull Matcher<? super T> t) {
    assertThat(reason, actual, t);
  }

  public static <T> void that(final T actual, final @NotNull Matcher<? super T> t) {
    assertThat("", actual, t);
  }

  @Contract(pure = true) @NotNull public static <T> Matcher<T> theInstance(final T target) {
    return cantBeNull(IsSame.theInstance(target));
  }

  public static void xassertEquals(final int a, final int b) {
    assertEquals("", a, b);
  }

  public static void xassertEquals(final @NotNull String s, final int a, final int b) {
    assertEquals(s, box(a), box(b));
  }

  /** Assert that an integer is zero
   * @param ¢ JD */
  public static void zero(final int ¢) {
    assertEquals(0, ¢);
  }

  /** Assert that long is zero
   * @param ¢ JD */
  public static void zero(final long ¢) {
    assertEquals(0L, ¢);
  }

  public static class ____META {
    //
  }

  public static class Asserter {
    @NotNull public Asserter andAye(final boolean claim) {
      return andAye("", claim);
    }

    @NotNull public Asserter andAye(final @NotNull String reason, final boolean claim) {
      azzert.that(reason, claim, is(true));
      return this;
    }

    @NotNull public Asserter andNay(final boolean claim) {
      return andNay("", claim);
    }

    @NotNull public Asserter andNay(final @NotNull String reason, final boolean claim) {
      azzert.that(reason, claim, is(false));
      return this;
    }
  }
}
