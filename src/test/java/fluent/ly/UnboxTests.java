package fluent.ly;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({ "all" }) public class UnboxTests {
  // NOTE: apparently not all functions are implemented
  private final double EPS = 0.001;

  @Test public void testInts() {
    final int[] arr = { 1, 2, 3, 4, 5, 6 };
    final ArrayList<Integer> lst = new ArrayList<>();
    lst.add(1);
    lst.add(2);
    lst.add(3);
    lst.add(4);
    lst.add(5);
    lst.add(6);
    int[] res = unbox.it(lst);
    azzert.assertEquals(res.length, arr.length);
    int j = 0;
    for (final int ¢ : arr)
      azzert.assertEquals(¢, res[j++]);
    final Integer[] arrInt = { 1, 2, 3, 4, 5, 6 };
    res = unbox.it(arrInt);
    azzert.assertEquals(res.length, arr.length);
    j = 0;
    for (final int ¢ : arr)
      azzert.assertEquals(¢, res[j++]);
    azzert.assertEquals(unbox.unbox(Integer.valueOf(5)), 5);
    res = unbox.unbox(arrInt);
    azzert.assertEquals(res.length, arr.length);
    j = 0;
    for (final int ¢ : arr)
      azzert.assertEquals(¢, res[j++]);
  }

  @Test public void testShorts() {
    final short[] arr = { 1, 2, 3, 4, 5, 6 };
    short[] res;
    final Short[] arrShort = { 1, 2, 3, 4, 5, 6 };
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
    final Byte[] arrByte = { 1, 2, 3, 4, 5, 6 };
    azzert.assertEquals(unbox.unbox(Byte.valueOf((byte) 5)), 5);
    res = unbox.unbox(arrByte);
    azzert.assertEquals(res.length, arr.length);
    int j = 0;
    for (final byte i : arr)
      azzert.assertEquals(i, res[j++]);
  }

  @Test public void testDoubles() {
    final double[] arr = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 };
    final Double[] arrDouble = { 1.0, 2.0, 3.0, 4.0, 5.0, 6.0 };
    double[] res = unbox.it(arrDouble);
    azzert.assertEquals(res.length, arr.length);
    int j = 0;
    for (final double i : arr)
      azzert.assertTrue( Math.abs(i - res[j++]) < EPS);
      azzert.assertTrue( Math.abs(unbox.unbox(Double.valueOf(5.0)) - 5.0) < EPS);
    res = unbox.unbox(arrDouble);
    azzert.assertEquals(res.length, arr.length);
    j = 0;
    for (final double i : arr)
      azzert.assertTrue( Math.abs(i - res[j++]) < EPS);
  }

  @Test public void testFloats() {
    final float[] arr = { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f };
    final Float[] arrFloat = { 1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f };
    float[] res = unbox.it(arrFloat);
    azzert.assertEquals(res.length, arr.length);
    int j = 0;
    for (final float i : arr)
      azzert.assertTrue( Math.abs(i - res[j++]) < (float) EPS);
      azzert.assertTrue( Math.abs(unbox.unbox(Float.valueOf(5.0f)) - 5.0f) < (float) EPS);
    res = unbox.unbox(arrFloat);
    azzert.assertEquals(res.length, arr.length);
    j = 0;
    for (final float i : arr)
      azzert.assertTrue( Math.abs(i - res[j++]) < (float) EPS);
  }

  @Test public void testBools() {
    final boolean[] arr = { true, false, true, true, false, false };
    final Boolean[] arrBool = { true, false, true, true, false, false };
    azzert.assertEquals(unbox.unbox(Boolean.TRUE), true);
    azzert.assertEquals(unbox.unbox(Boolean.FALSE), false);
    final boolean[] res = unbox.unbox(arrBool);
    azzert.assertEquals(res.length, arr.length);
    int j = 0;
    for (final boolean i : arr)
      azzert.assertEquals(i, res[j++]);
  }

  @Test public void testLongs() {
    final long[] arr = { 1, 2, 3, 4, 5, 6 };
    final Long[] arrLong = { 1l, 2l, 3l, 4l, 5l, 6l };
    azzert.assertTrue( unbox.unbox(Long.valueOf(5l)) == 5l);
    final long[] res = unbox.unbox(arrLong);
    azzert.assertEquals(res.length, arr.length);
    int j = 0;
    for (final long i : arr)
      azzert.assertTrue( i == res[j++]);
  }

  @Test public void testChars() {
    final char[] arr = { 1, 2, 3, 4, 5, 6 };
    final Character[] arrChar = { 1, 2, 3, 4, 5, 6 };
    azzert.assertEquals(unbox.unbox(Character.valueOf((char) 5)), 5);
    final char[] res = unbox.unbox(arrChar);
    azzert.assertEquals(res.length, arr.length);
    int j = 0;
    for (final char i : arr)
      azzert.assertEquals(i, res[j++]);
  }
}
