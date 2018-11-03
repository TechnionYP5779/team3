package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

/** A utility class, offering a collection of function to unbox arrays and
 * collection of the boxed versions of the primitive types. The input of each
 * unboxing function is a {@link Collection} or an array of one the following
 * eight reference types
 * <ol>
 * <li>{@link Boolean}
 * <li>{@link Byte}
 * <li>{@link Character}
 * <li>{@link Double}
 * <li>{@link Float}
 * <li>{@link Integer}
 * <li>{@link Long}
 * <li>{@link Short}
 * </ol>
 * The returned value is an array of the equivalent primitive type.
 * <p>
 * Note that unboxing of a single value of a reference type is easy using a
 * function such as {@link Long#longValue()}
 * @author Yossi Gil.
 * @see box */
@SuppressWarnings("null") public enum unbox {
  // A namespace: no values to this <code><b>enum</b></code>
  ;
  public static double @NotNull [] it(final @NotNull Double[] ¢) {
    return unbox(¢);
  }

  public static float @NotNull [] it(Float[] ¢) {
    return unbox(¢);
  }

  public static int it(final @NotNull Integer ¢) {
    return ¢.intValue();
  }

  public static int @NotNull [] it(final @NotNull Integer[] ¢) {
    return unbox(¢);
  }

  public static int @NotNull [] it(final @NotNull List<Integer> ¢) {
    return it(¢.toArray(new Integer[¢.size()]));
  }

  public static boolean unbox(final @NotNull Boolean ¢) {
    return ¢.booleanValue();
  }

  /** unbox an array of {@link Boolean}s into an array of
   * <code><b>boolean</b></code>s.
   * @param bs an array of {@link Boolean}s
   * @return an equivalent array of <code><b>boolean</b></code>s. */
  public static boolean @NotNull [] unbox(final @NotNull Boolean[] bs) {
    final boolean @NotNull [] $ = new boolean[bs.length];
    for (int ¢ = 0; ¢ < bs.length; ++¢)
      $[¢] = bs[¢].booleanValue();
    return $;
  }

  public static byte unbox(final @NotNull Byte ¢) {
    return ¢.byteValue();
  }

  /** unbox an array of {@link Byte}s into an array of <code><b>byte</b></code> s.
   * @param bs an array of {@link Byte}s
   * @return an equivalent array of <code><b>byte</b></code>s. */
  public static byte @NotNull [] unbox(final @NotNull Byte[] bs) {
    final byte @NotNull [] $ = new byte[bs.length];
    for (int ¢ = 0; ¢ < bs.length; ++¢)
      $[¢] = bs[¢].byteValue();
    return $;
  }

  public static char unbox(final @NotNull Character ¢) {
    return ¢.charValue();
  }

  /** unbox an array of {@link Character}s into an array of
   * <code><b>char</b></code>s.
   * @param cs an array of {@link Character}s
   * @return an equivalent array of <code><b>char</b></code>s. */
  public static char @NotNull [] unbox(final @NotNull Character[] cs) {
    final char @NotNull [] $ = new char[cs.length];
    for (int ¢ = 0; ¢ < cs.length; ++¢)
      $[¢] = cs[¢].charValue();
    return $;
  }

  /** unbox a {@link Collection} of {@link Short}s into an array of
   * <code><b>short</b></code>s.
   * @param ss a {@link Collection} of {@link Integer}s
   * @return an equivalent array of <code><b>short</b></code>s. */
  public static short @NotNull [] unbox(final @NotNull Collection<Short> ss) {
    final short @NotNull [] $ = new short[ss.size()];
    int i = 0;
    for (final @NotNull Short v : ss)
      $[i++] = v.shortValue();
    return $;
  }

  public static double unbox(final @NotNull Double ¢) {
    return ¢.doubleValue();
  }

  /** unbox an array of {@link Double}s into an array of
   * <code><b>double</b></code>s.
   * @param ds an array of {@link Double}s
   * @return an equivalent array of <code><b>double</b></code>s. */
  public static double @NotNull [] unbox(final @NotNull Double[] ds) {
    final double @NotNull [] $ = new double[ds.length];
    for (int ¢ = 0; ¢ < ds.length; ++¢)
      $[¢] = ds[¢].floatValue();
    return $;
  }

  public static float unbox(final @NotNull Float ¢) {
    return ¢.floatValue();
  }

  /** unbox an array of {@link Float}s into an array of <code><b>float</b></code>
   * s.
   * @param fs an array of {@link Float}s
   * @return an equivalent array of <code><b>float</b></code>s. */
  public static float @NotNull [] unbox(final Float[] fs) {
    final float @NotNull [] $ = new float[fs.length];
    for (int ¢ = 0; ¢ < fs.length; ++¢)
      $[¢] = fs[¢].floatValue();
    return $;
  }

  public static int unbox(final @NotNull Integer ¢) {
    return ¢.intValue();
  }

  /** unbox an array of {@link Integer}s into an array of <code><b>int</b></code>
   * s.
   * @param is an array of {@link Integer}s
   * @return an equivalent array of <code><b>int</b></code>s. */
  public static int @NotNull [] unbox(final @NotNull Integer[] is) {
    final int @NotNull [] $ = new int[is.length];
    for (int ¢ = 0; ¢ < is.length; ++¢)
      $[¢] = is[¢].intValue();
    return $;
  }

  public static long unbox(final @NotNull Long ¢) {
    return ¢.longValue();
  }

  /** unbox an array of {@link Long}s into an array of <code><b>long</b></code> s.
   * @param ls an array of {@link Long}s
   * @return an equivalent array of <code><b>long</b></code>s. */
  public static long @NotNull [] unbox(final @NotNull Long[] ls) {
    final long @NotNull [] $ = new long[ls.length];
    for (int ¢ = 0; ¢ < ls.length; ++¢)
      $[¢] = ls[¢].longValue();
    return $;
  }

  public static short unbox(final @NotNull Short ¢) {
    return ¢.shortValue();
  }

  /** unbox an array of {@link Short}s into an array of <code><b>short</b></code>
   * s.
   * @param ss an array of {@link Integer}s
   * @return an equivalent array of <code><b>short</b></code>s. */
  public static short @NotNull [] unbox(final @NotNull Short[] ss) {
    final short @NotNull [] $ = new short[ss.length];
    for (int ¢ = 0; ¢ < ss.length; ++¢)
      $[¢] = ss[¢].shortValue();
    return $;
  }
  
  @SuppressWarnings({"static-method", "boxing"})
  public static class Tests {
    //NOTE: apparently not all functions are implemented
    
    private final double EPS = 0.001;
    
    @Test
    public void testInts() {
      int[] arr = {1,2,3,4,5,6};
      
      ArrayList<Integer> lst = new ArrayList<>();
      lst.add(1);
      lst.add(2);
      lst.add(3);
      lst.add(4);
      lst.add(5);
      lst.add(6);
      
      int[] res = unbox.it(lst);

      azzert.assertEquals(res.length, arr.length);
      int j = 0;
      for(int ¢ : arr)
        azzert.assertEquals(¢, res[j++]);
      
      Integer[] arrInt = {1,2,3,4,5,6};

      res = unbox.it(arrInt);

      azzert.assertEquals(res.length, arr.length);
      j = 0;
      for(int ¢ : arr)
        azzert.assertEquals(¢, res[j++]);
      
      azzert.assertEquals(unbox.unbox(Integer.valueOf(5)), 5);
      
      res = unbox.unbox(arrInt);

      azzert.assertEquals(res.length, arr.length);
      j = 0;
      for(int ¢ : arr)
        azzert.assertEquals(¢, res[j++]);
    }
    
    @Test
    public void testShorts() {
      short[] arr = { 1, 2, 3, 4, 5, 6 }, res;
      
      Short[] arrShort = {1,2,3,4,5,6};
      
      azzert.assertEquals(unbox.unbox(Short.valueOf((short) 5)), 5);
      
      res = unbox.unbox(arrShort);

      azzert.assertEquals(res.length, arr.length);
      int j = 0;
      for(short i : arr)
        azzert.assertEquals(i, res[j++]);
    }
    
    @Test
    public void testBytes() {
      byte[] arr = { 1, 2, 3, 4, 5, 6 }, res;
      
      Byte[] arrByte = {1,2,3,4,5,6};
      
      azzert.assertEquals(unbox.unbox(Byte.valueOf((byte) 5)), 5);
      
      res = unbox.unbox(arrByte);

      azzert.assertEquals(res.length, arr.length);
      int j = 0;
      for(byte i : arr)
        azzert.assertEquals(i, res[j++]);
    }
    
    @Test
    public void testDoubles() {
      double[] arr = {1.0,2.0,3.0,4.0,5.0,6.0};
      Double[] arrDouble = {1.0,2.0,3.0,4.0,5.0,6.0};

      double[] res = unbox.it(arrDouble);

      azzert.assertEquals(res.length, arr.length);
      int j = 0;
      for(double i : arr)
        assert Math.abs(i - res[j++]) < EPS;

      assert Math.abs(unbox.unbox(Double.valueOf(5.0)) - 5.0) < EPS;
      
      res = unbox.unbox(arrDouble);

      azzert.assertEquals(res.length, arr.length);
      j = 0;
      for(double i : arr)
        assert Math.abs(i - res[j++]) < EPS;
    }
    
    @Test
    public void testFloats() {      
      float[] arr = {1.0f,2.0f,3.0f,4.0f,5.0f,6.0f};
      Float[] arrFloat = {1.0f,2.0f,3.0f,4.0f,5.0f,6.0f};

      float[] res = unbox.it(arrFloat);

      azzert.assertEquals(res.length, arr.length);
      int j = 0;
      for(float i : arr)
        assert Math.abs(i - res[j++]) < (float) EPS;

      assert Math.abs(unbox.unbox(Float.valueOf(5.0f)) - 5.0f) < (float) EPS;
      
      res = unbox.unbox(arrFloat);

      azzert.assertEquals(res.length, arr.length);
      j = 0;
      for(float i : arr)
        assert Math.abs(i - res[j++]) < (float) EPS;
    }
    
    @Test
    public void testBools() {
      boolean[] arr = {true, false, true, true, false, false};
      
      Boolean[] arrBool = {true, false, true, true, false, false};
      
      azzert.assertEquals(unbox.unbox(Boolean.TRUE), true);
      azzert.assertEquals(unbox.unbox(Boolean.FALSE), false);
      
      boolean[] res = unbox.unbox(arrBool);

      azzert.assertEquals(res.length, arr.length);
      int j = 0;
      for(boolean i : arr)
        azzert.assertEquals(i, res[j++]);
    } 
    
    @Test
    public void testLongs() {
      long[] arr = {1,2,3,4,5,6};
      
      Long[] arrLong = {1l,2l,3l,4l,5l,6l};
      
      assert unbox.unbox(Long.valueOf(5l)) == 5l;
      
      long[] res = unbox.unbox(arrLong);

      azzert.assertEquals(res.length, arr.length);
      int j = 0;
      for(long i : arr)
        assert i == res[j++];
    }
    
    @Test
    public void testChars() {
      char[] arr = {1,2,3,4,5,6};
      
      Character[] arrChar = {1,2,3,4,5,6};
      
      azzert.assertEquals(unbox.unbox(Character.valueOf((char) 5)), 5);
      
      char[] res = unbox.unbox(arrChar);

      azzert.assertEquals(res.length, arr.length);
      int j = 0;
      for(char i : arr)
        azzert.assertEquals(i, res[j++]);
    }
  }
}
