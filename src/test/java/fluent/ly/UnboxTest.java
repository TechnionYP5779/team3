package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.*;

import org.junit.*;

@SuppressWarnings({ "static-method", "null" }) public class UnboxTest {
  // NOTE: apparently not all functions are implemented
  private final double EPS = 0.001;

  @Test public void testInts() {
    final int[] arr = { 1, 2, 3, 4, 5, 6 };
    final ArrayList<Integer> lst = new ArrayList<>();
    final Integer a = box.box(1);
    final Integer b = box.box(2);
    final Integer c = box.box(3);
    final Integer d = box.box(4);
    final Integer e = box.box(5);
    final Integer f = box.box(6);
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
    azzert.that(unbox.unbox(box.box(5)), is(5));
    res = unbox.unbox(arrInt);
    azzert.that(res.length, is(arr.length));
    j = 0;
    for (final int ¢ : arr)
      azzert.that(¢, is(res[j++]));
  }

  @Test public void testShorts() {
    final short[] arr = { 1, 2, 3, 4, 5, 6 };
    short[] res;
    final Short[] arrShort = box.box(arr);
    azzert.assertEquals(unbox.unbox(Short.valueOf((short) 5)), 5);
    res = unbox.unbox(arrShort);
    azzert.assertEquals(res.length, arr.length);
    int j = 0;
    for (final short i : arr)
      azzert.assertEquals(i, res[j++]);
  }

  @Test public void testBytes() {
    final byte[] arr = { 1, 2, 3, 4, 5, 6 };
    byte[] res;
    final Byte[] arrByte = box.box(arr);
    azzert.assertEquals(unbox.unbox(Byte.valueOf((byte) 5)), 5);
    res = unbox.unbox(arrByte);
    azzert.assertEquals(res.length, arr.length);
    int j = 0;
    for (final byte i : arr)
      azzert.assertEquals(i, res[j++]);
  }

  @Test public void testDoubles() {
    final double[] arr = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 };
    final Double[] arrDouble = box.box(arr);
    double[] res = unbox.it(arrDouble);
    azzert.assertEquals(res.length, arr.length);
    int j = 0;
    for (final double i : arr)
      azzert.assertTrue(Math.abs(i - res[j++]) < EPS);
    azzert.assertTrue(Math.abs(unbox.unbox(Double.valueOf(5.0)) - 5.0) < EPS);
    res = unbox.unbox(arrDouble);
    azzert.assertEquals(res.length, arr.length);
    j = 0;
    for (final double i : arr)
      azzert.assertTrue(Math.abs(i - res[j++]) < EPS);
  }

  @Test public void testFloats() {
    final float[] arr = { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f };
    final Float[] arrFloat = box.box(arr);
    float[] res = unbox.it(arrFloat);
    azzert.assertEquals(res.length, arr.length);
    int j = 0;
    for (final float i : arr)
      azzert.assertTrue(Math.abs(i - res[j++]) < (float) EPS);
    azzert.assertTrue(Math.abs(unbox.unbox(Float.valueOf(5.0f)) - 5.0f) < (float) EPS);
    res = unbox.unbox(arrFloat);
    azzert.assertEquals(res.length, arr.length);
    j = 0;
    for (final float i : arr)
      azzert.assertTrue(Math.abs(i - res[j++]) < (float) EPS);
  }

  @Test public void testBools() {
    final boolean[] arr = { true, false, true, true, false, false };
    final Boolean[] arrBool = box.box(arr);
    assert unbox.unbox(Boolean.TRUE);
    assert !unbox.unbox(Boolean.FALSE);
    final boolean[] res = unbox.unbox(arrBool);
    azzert.that(res.length, is(arr.length));
    int j = 0;
    for (final boolean i : arr)
      azzert.assertEquals(i, res[j++]);
  }

  @Test public void testLongs() {
    final long[] arr = { 1, 2, 3, 4, 5, 6 };
    final Long[] arrLong = box.box(arr);
    azzert.assertTrue(unbox.unbox(Long.valueOf(5l)) == 5l);
    final long[] res = unbox.unbox(arrLong);
    azzert.assertEquals(res.length, arr.length);
    int j = 0;
    for (final long i : arr)
      azzert.assertTrue(i == res[j++]);
  }

  @Test public void testChars() {
    final char[] arr = { 1, 2, 3, 4, 5, 6 };
    final Character[] arrChar = box.box(arr);
    azzert.assertEquals(unbox.unbox(Character.valueOf((char) 5)), 5);
    final char[] res = unbox.unbox(arrChar);
    azzert.assertEquals(res.length, arr.length);
    int j = 0;
    for (final char i : arr)
      azzert.assertEquals(i, res[j++]);
  }
}
