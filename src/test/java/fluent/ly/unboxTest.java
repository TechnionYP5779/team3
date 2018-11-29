package fluent.ly;

import static il.org.spartan.Utils.*;
import static fluent.ly.box.*;
import static fluent.ly.unbox.*;
import static fluent.ly.azzert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class unboxTest {
  // NOTE: apparently not all functions are implemented
  private final double EPS = 0.001;

  @Test public void testInts() {
    final int[] arr = { 1, 2, 3, 4, 5, 6 };
    final ArrayList<Integer> lst = new ArrayList<>();
    final Integer a = box(1), b = box(2), c = box(3), d = box(4), e = box(5), f = box(6);
    lst.add(a);
    lst.add(b);
    lst.add(c);
    lst.add(d);
    lst.add(e);
    lst.add(f);
    int[] res = unbox.it(lst);
    azzert.that(res.length, is(arr.length));
    int j = 0;
    for (final int ¢ : arr)
      azzert.that(¢, is(res[j++]));
    final @NotNull Integer[] arrInt = { cantBeNull(a), cantBeNull(b), cantBeNull(c), cantBeNull(d), cantBeNull(e), cantBeNull(f) };
    res = unbox.it(arrInt);
    azzert.that(res.length, is(arr.length));
    j = 0;
    for (final int ¢ : arr)
      azzert.that(¢, is(res[j++]));
    azzert.that(unbox(cantBeNull(box(5))), is(5));
    res = unbox(arrInt);
    azzert.that(res.length, is(arr.length));
    j = 0;
    for (final int ¢ : arr)
      azzert.that(¢, is(res[j++]));
  }

  @Test public void testShorts() {
    final short[] arr = { 1, 2, 3, 4, 5, 6 };
    short[] res;
    final @NotNull Short[] arrShort = box(arr);
    azzert.that(unbox(cantBeNull(box((short) 5))), is(5));
    res = unbox(arrShort);
    azzert.that(res.length, is(arr.length));
    int j = 0;
    for (final short i : arr)
      azzert.that(i, is(res[j++]));
  }

  @Test public void testBytes() {
    final byte[] arr = { 1, 2, 3, 4, 5, 6 };
    byte[] res;
    @NotNull final Byte[] arrByte = box(arr);
    azzert.that(unbox(cantBeNull(box((byte) 5))), is(5));
    res = unbox(arrByte);
    azzert.that(res.length, is(arr.length));
    int j = 0;
    for (final byte i : arr)
      azzert.that(i, is(res[j++]));
  }

  @Test public void testDoubles() {
    final double[] arr = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 };
    final @NotNull Double[] arrDouble = box(arr);
    double[] res = unbox.it(arrDouble);
    azzert.that(res.length, is(arr.length));
    int j = 0;
    for (final double i : arr)
      assert Math.abs(i - res[j++]) < EPS;
    assert Math.abs(unbox(cantBeNull(box(5.0))) - 5.0) < EPS;
    res = unbox(arrDouble);
    azzert.that(res.length, is(arr.length));
    j = 0;
    for (final double i : arr)
      assert Math.abs(i - res[j++]) < EPS;
  }

  @Test public void testFloats() {
    final float[] arr = { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f };
    final Float[] arrFloat = box(arr);
    float[] res = unbox.it(arrFloat);
    azzert.that(res.length, is(arr.length));
    int j = 0;
    for (final float i : arr)
      assert Math.abs(i - res[j++]) < (float) EPS;
    assert Math.abs(unbox(cantBeNull(box(5.0f))) - 5.0f) < (float) EPS;
    res = unbox(arrFloat);
    azzert.that(res.length, is(arr.length));
    j = 0;
    for (final float i : arr)
      assert Math.abs(i - res[j++]) < (float) EPS;
  }

  @Test public void testBools() {
    final boolean[] arr = { true, false, true, true, false, false };
    final @NotNull Boolean[] arrBool = box(arr);
    assert unbox(cantBeNull(Boolean.TRUE));
    assert !unbox(cantBeNull(Boolean.FALSE));
    final boolean[] res = unbox(arrBool);
    azzert.that(res.length, is(arr.length));
    int j = 0;
    for (final boolean i : arr)
      azzert.that(i, is(res[j++]));
  }

  @Test public void testLongs() {
    final long[] arr = { 1, 2, 3, 4, 5, 6 };
    @NotNull final Long[] arrLong = box(arr);
    assert unbox(box(5l)) == 5l;
    final long[] res = unbox(arrLong);
    azzert.that(res.length, is(arr.length));
    int j = 0;
    for (final long i : arr)
      azzert.that(i, is(res[j++]));
  }

  @Test public void testChars() {
    final char[] arr = { 1, 2, 3, 4, 5, 6 };
    final @NotNull Character[] arrChar = box(arr);
    azzert.that(unbox(cantBeNull(box((char) 5))), is(5));
    final char[] res = unbox(arrChar);
    azzert.that(res.length, is(arr.length));
    int j = 0;
    for (final char i : arr)
      azzert.that(i, is(res[j++]));
  }

  @Test public void more() {
    assert unbox.it(cantBeNull(box(1))) == 1;
    short s = 7;
    forget.it(s);
    assertArrayEquals(unbox(as.list(new Short[] { box(s) })), new short[] { s });
  }
}
