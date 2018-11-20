package fluent.ly;
import static fluent.ly.box.*;
import static fluent.ly.unbox.*;
import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings({ "static-method", "null" }) public class UnboxTest {
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
      azzert.assertEquals(¢, res[j++]);
    final Integer[] arrInt = { a, b, c, d, e, f };
    res = unbox.it(arrInt);
    azzert.assertEquals(res.length, arr.length);
    j = 0;
    for (final int ¢ : arr)
      azzert.assertEquals(¢, res[j++]);
    azzert.that(unbox(box(5)), is(5));
    res = unbox(arrInt);
    azzert.that(res.length, is(arr.length));
    j = 0;
    for (final int ¢ : arr)
      azzert.that(¢, is(res[j++]));
  }

  @Test public void testShorts() {
    final short[] arr = { 1, 2, 3, 4, 5, 6 };
    short[] res;
    final Short[] arrShort = box(arr);
    azzert.assertEquals(unbox(box((short) 5)), 5);
    res = unbox(arrShort);
    azzert.assertEquals(res.length, arr.length);
    int j = 0;
    for (final short i : arr)
      azzert.assertEquals(i, res[j++]);
  }

  @Test public void testBytes() {
    final byte[] arr = { 1, 2, 3, 4, 5, 6 };
    byte[] res;
    final Byte[] arrByte = box(arr);
    azzert.assertEquals(unbox(box((byte) 5)), 5);
    res = unbox(arrByte);
    azzert.assertEquals(res.length, arr.length);
    int j = 0;
    for (final byte i : arr)
      azzert.assertEquals(i, res[j++]);
  }

  @Test public void testDoubles() {
    final double[] arr = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 };
    final Double[] arrDouble = box(arr);
    double[] res = unbox.it(arrDouble);
    azzert.assertEquals(res.length, arr.length);
    int j = 0;
    for (final double i : arr)
      assert Math.abs(i - res[j++]) < EPS;
    assert Math.abs(unbox(box(5.0)) - 5.0) < EPS;
    res = unbox(arrDouble);
    azzert.assertEquals(res.length, arr.length);
    j = 0;
    for (final double i : arr)
      assert Math.abs(i - res[j++]) < EPS;
  }

  @Test public void testFloats() {
    final float[] arr = { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f };
    final Float[] arrFloat = box(arr);
    float[] res = unbox.it(arrFloat);
    azzert.assertEquals(res.length, arr.length);
    int j = 0;
    for (final float i : arr)
      assert Math.abs(i - res[j++]) < (float) EPS;
    assert Math.abs(unbox(box(5.0f)) - 5.0f) < (float) EPS;
    res = unbox(arrFloat);
    azzert.assertEquals(res.length, arr.length);
    j = 0;
    for (final float i : arr)
      assert Math.abs(i - res[j++]) < (float) EPS;
  }

  @Test public void testBools() {
    final boolean[] arr = { true, false, true, true, false, false };
    final Boolean[] arrBool = box(arr);
    assert unbox(Boolean.TRUE);
    assert !unbox(Boolean.FALSE);
    final boolean[] res = unbox(arrBool);
    azzert.that(res.length, is(arr.length));
    int j = 0;
    for (final boolean i : arr)
      azzert.assertEquals(i, res[j++]);
  }

  @Test public void testLongs() {
    final long[] arr = { 1, 2, 3, 4, 5, 6 };
    final Long[] arrLong = box(arr);
    assert unbox(box(5l)) == 5l;
    final long[] res = unbox(arrLong);
    azzert.assertEquals(res.length, arr.length);
    int j = 0;
    for (final long i : arr)
      assert i == res[j++];
  }

  @Test public void testChars() {
    final char[] arr = { 1, 2, 3, 4, 5, 6 };
    final Character[] arrChar = box(arr);
    azzert.assertEquals(unbox(box((char) 5)), 5);
    final char[] res = unbox(arrChar);
    azzert.assertEquals(res.length, arr.length);
    int j = 0;
    for (final char i : arr)
      azzert.assertEquals(i, res[j++]);
  }
}
