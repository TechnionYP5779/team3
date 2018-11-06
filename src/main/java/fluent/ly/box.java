// <a href=http://ssdl-linux.cs.technion.ac.il/wiki/index.php>SSDLPedia</a>
package fluent.ly;

import static il.org.spartan.Utils.*;

import static fluent.ly.azzert.*;

import javax.swing.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import il.org.spartan.*;
import il.org.spartan.utils.*;

/** A utility class, with a collection of function to box primitive types in
 * their reference type equivalent representation. Similarly, this class offers
 * functions to box arrays of primitive types into their reference type
 * equivalent.
 * @author Yossi Gil, the Technion.
 * @since 21/06/2008
 * @see unbox */
@SuppressWarnings("null") public enum box {
  // A namespace: no values to this <code><b>enum</b></code>
  ;
  /** box a <code><b>boolean</b></code> into a {@link Boolean} object.
   * @param ¢ some <code><b>boolean</b></code> value
   * @return a non-<code><b>null</b></code> {@link Boolean} with the value of
   *         <code>c</code> */
  public static Boolean box(final boolean ¢) {
    return Boolean.valueOf(¢);
  }

  @NotNull public static Boolean[] box(final boolean bs[]) {
    final @NotNull Boolean[] $ = new Boolean[bs.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(bs[¢]);
    return $;
  }

  @NotNull public static Byte box(final byte ¢) {
    return Utils.canBeNull(Byte.valueOf(¢));
  }

  @NotNull public static Byte[] box(final byte bs[]) {
    final Byte @NotNull [] $ = new Byte[bs.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(bs[¢]);
    return $;
  }

  /** box a <code><b>char</b></code> into a {@link Character} object.
   * @param ¢ some <code><b>char</b></code> value
   * @return a non-<code><b>null</b></code> {@link Character} with the value of
   *         <code>c</code> */
  public static Character box(final char ¢) {
    return Character.valueOf(¢);
  }

  @NotNull public static Character @NotNull [] box(final char cs[]) {
    final Character @NotNull [] $ = new Character[cs.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(cs[¢]);
    return $;
  }

  /** box a <code><b>double</b></code> into a {@link Double} object.
   * @param ¢ some <code><b>double</b></code> value
   * @return a non-<code><b>null</b></code> {@link Double} with the value of
   *         <code>d</code> */
  public static Double box(final double ¢) {
    return Double.valueOf(¢);
  }

  @NotNull public static Double[] box(final double ds[]) {
    final Double @NotNull [] $ = new Double[ds.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(ds[¢]);
    return $;
  }

  /** box a <code><b>float</b></code> into a {@link Float} object.
   * @param ¢ some <code><b>float</b></code> value
   * @return a non-<code><b>null</b></code> {@link Float} with the value of
   *         <code>f</code> */
  public static Float box(final float ¢) {
    return Float.valueOf(¢);
  }

  @NotNull public static Float[] box(final float fs[]) {
    final @NotNull Float[] $ = new Float[fs.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(fs[¢]);
    return $;
  }

  /** box an <code><b>int</b></code> into an {@link Integer} object.
   * @param ¢ some <code><b>int</b></code> value
   * @return a non-<code><b>null</b></code> {@link Integer} with the value of
   *         <code>n</code> */
  public static Integer box(final int ¢) {
    return Integer.valueOf(¢);
  }

  @NotNull public static Integer[] box(final int is[]) {
    final Integer @NotNull [] $ = new Integer[is.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(is[¢]);
    return $;
  }

  @NotNull public static Long box(final long ¢) {
    return Long.valueOf(¢);
  }

  @NotNull public static Long @NotNull [] box(final long ls[]) {
    final Long @NotNull [] $ = new Long[ls.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(ls[¢]);
    return $;
  }

  /** box a <code><b>short</b></code> into a {@link Short} object.
   * @param ¢ some <code><b>short</b></code> value
   * @return a non-<code><b>null</b></code> {@link Short} with the value of
   *         <code>s</code> */
  public static Short box(final short ¢) {
    return Short.valueOf(¢);
  }

  @NotNull public static Short[] box(final short ss[]) {
    final Short @NotNull [] $ = new Short[ss.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(ss[¢]);
    return $;
  }

  /** box a <code><b>boolean</b></code> into a {@link Boolean} object.
   * @param ¢ some <code><b>boolean</b></code> value
   * @return a non-<code><b>null</b></code> {@link Boolean} with the value of
   *         <code>c</code> */
  public static Boolean it(final boolean ¢) {
    return cantBeNull(Boolean.valueOf(¢));
  }

  @NotNull public static Boolean[] it(final boolean bs[]) {
    final Boolean @NotNull [] $ = new Boolean @NotNull [bs.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(bs[¢]);
    return $;
  }

  /** box a <code><b>byte</b></code> into a {@link Byte} object.
   * @param ¢ some <code><b>long</b></code> value
   * @return a non-<code><b>null</b></code> {@link Long} with the value of
   *         <code>l</code> */
  public static Byte it(final byte ¢) {
    return cantBeNull(Byte.valueOf(¢));
  }

  @NotNull public static Byte[] it(final byte bs[]) {
    final Byte @NotNull [] $ = new Byte @NotNull [bs.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(bs[¢]);
    return $;
  }

  @NotNull public static Character it(final char ¢) {
    return cantBeNull(Character.valueOf(¢));
  }

  @NotNull public static Character @NotNull [] it(final char cs[]) {
    final @NotNull Character @NotNull [] $ = new Character @NotNull [cs.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = it(cs[¢]);
    return $;
  }

  /** box a <code><b>double</b></code> into a {@link Double} object.
   * @param ¢ some <code><b>double</b></code> value
   * @return a non-<code><b>null</b></code> {@link Double} with the value of
   *         <code>d</code> */
  public static Double it(final double ¢) {
    return cantBeNull(Double.valueOf(¢));
  }

  @NotNull public static Double[] it(final double ds[]) {
    final Double @NotNull [] $ = new Double[ds.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = box(ds[¢]);
    return $;
  }

  /** box a <code><b>float</b></code> into a {@link Float} object.
   * @param ¢ some <code><b>float</b></code> value
   * @return a non-<code><b>null</b></code> {@link Float} with the value of
   *         <code>f</code> */
  @NotNull public static Float it(final float ¢) {
    return cantBeNull(Float.valueOf(¢));
  }

  @NotNull public static Float[] it(final float fs[]) {
    final @NotNull Float @NotNull [] $ = new Float @NotNull [fs.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = it(fs[¢]);
    return $;
  }

  /** box an <code><b>int</b></code> into an {@link Integer} object.
   * @param ¢ some <code><b>int</b></code> value
   * @return a non-<code><b>null</b></code> {@link Integer} with the value of
   *         <code>n</code>
   * @see #box(int) */
  public static Integer it(final int ¢) {
    return box(¢);
  }

  @NotNull public static Integer[] it(final int ¢[]) {
    return box(¢);
  }

  @NotNull public static Long it(final long ¢) {
    return cantBeNull(Long.valueOf(¢));
  }

  @NotNull public static Long @NotNull [] it(final long ls[]) {
    final @NotNull Long @NotNull [] $ = new Long[ls.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = it(ls[¢]);
    return $;
  }

  @NotNull public static Short it(final short ¢) {
    return cantBeNull(Short.valueOf(¢));
  }

  @NotNull public static Short @NotNull [] it(final short ss[]) {
    final @NotNull Short @NotNull [] $ = new Short @NotNull [ss.length];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = it(ss[¢]);
    return $;
  }
  
  @SuppressWarnings("static-method") public static class TEST {
    @Test public void boxAdds() {
      Boolean b = box(true);
      Boolean b1 = new Boolean(true);
      azzert.that(b1.equals(b), is(true));
      
      
      boolean[] arr = {true, false, true};
      Boolean[] b2 = box(arr);
      Boolean[] arr1 = {true, false, true};
      for(int i=0;i<3;i++) {
        azzert.that(b2[i].equals(arr1[i]), is(true));
      }
      
      
      byte num = 10; 
      Byte by = box(num);
      Byte n = new Byte(num);
      azzert.that(by.equals(n), is(true));
      
      
      byte[] arrb = {10,1,4}; 
      Byte[] arrBy = box(arrb);
      Byte[] arrb1 = {10,1,4}; 
      for(int i=0;i<3;i++) {
        azzert.that(arrBy[i].equals(arrb1[i]), is(true));
      }
      
      
      Character cb = box('a');
      Character c1 = new Character('a');
      azzert.that(cb.equals(c1), is(true));
      
      char[] arrc = {'a', 'b', 'c'}; 
      Character[] arrcb = box(arrc);
      Character[] arrc1 = {'a', 'b', 'c'}; 
      for(int i=0;i<3;i++) {
        azzert.that(arrcb[i].equals(arrc1[i]), is(true));
      }
      
      
      Double db = box(5.0);
      Double d1 = new Double(5.0);
      azzert.that(db.equals(d1), is(true));
      
      
      double[] arrd = {5.0, 6.1, 7.2}; 
      Double[] arrdb = box(arrd);
      Double[] arrd1 = {5.0, 6.1, 7.2}; 
      for(int i=0;i<3;i++) {
        azzert.that(arrdb[i].equals(arrd1[i]), is(true));
      }
      
      float f = 56; 
      Float fb = box(f);
      Float f1 = new Float(56);
      azzert.that(fb.equals(f1), is(true));
      
      
      float[] arrf = {56f,50f,40f}; 
      Float[] arrfb = box(arrf);
      Float[] arrf1 = {56f,50f,40f}; 
      for(int i=0;i<3;i++) {
        azzert.that(arrfb[i].equals(arrf1[i]), is(true));
      }
      
      
      int i = 56; 
      Integer ib = box(i);
      Integer i1 = new Integer(56);
      azzert.that(ib.equals(i1), is(true));
      
      
      int[] arri = {56,50,40}; 
      Integer[] arrib = box(arri);
      Integer[] arri1 = {56,50,40}; 
      for(int j=0;j<3;j++) {
        azzert.that(arrib[j].equals(arri1[j]), is(true));
      }
      
      
      long l = 56; 
      Long lb = box(l);
      Long l1 = new Long(56);
      azzert.that(lb.equals(l1), is(true));
      
      
      long[] arrl = {56L,50L,40L}; 
      Long[] arrlb = box(arrl);
      Long[] arrl1 = {56L,50L,40L}; 
      for(int j=0;j<3;j++) {
        azzert.that(arrlb[j].equals(arrl1[j]), is(true));
      }
      
      
      short s = 5; 
      Short sb = box(s);
      Short s1 = new Short("5");
      azzert.that(sb.equals(s1), is(true));
      
      
      short[] arrs = {5,6,7}; 
      Short[] arrsb = box(arrs);
      Short[] arrs1 = {5,6,7}; 
      for(int j=0;j<3;j++) {
        azzert.that(arrsb[j].equals(arrs1[j]), is(true));
      }
      
      
      
      
      
      Boolean ITb = it(true);
      Boolean ITb1 = new Boolean(true);
      azzert.that(ITb1.equals(ITb), is(true));
      
      
      boolean[] ITarr = {true, false, true};
      Boolean[] ITb2 = it(ITarr);
      Boolean[] ITarr1 = {true, false, true};
      for(int j=0;j<3;j++) {
        azzert.that(ITb2[j].equals(ITarr1[j]), is(true));
      }
      
      
      byte ITnum = 10; 
      Byte ITby = it(ITnum);
      Byte ITn = new Byte(ITnum);
      azzert.that(ITby.equals(ITn), is(true));
      
      
      byte[] ITarrb = {10,1,4}; 
      Byte[] ITarrBy = it(ITarrb);
      Byte[] ITarrb1 = {10,1,4}; 
      for(int j=0;j<3;j++) {
        azzert.that(ITarrBy[j].equals(ITarrb1[j]), is(true));
      }
      
      
      Character ITcb = it('a');
      Character ITc1 = new Character('a');
      azzert.that(ITcb.equals(ITc1), is(true));
      
      char[] ITarrc = {'a', 'b', 'c'}; 
      Character[] ITarrcb = it(ITarrc);
      Character[] ITarrc1 = {'a', 'b', 'c'}; 
      for(int j=0;j<3;j++) {
        azzert.that(ITarrcb[j].equals(ITarrc1[j]), is(true));
      }
      
      
      Double ITdb = it(5.0);
      Double ITd1 = new Double(5.0);
      azzert.that(ITdb.equals(ITd1), is(true));
      
      
      double[] ITarrd = {5.0, 6.1, 7.2}; 
      Double[] ITarrdb = it(ITarrd);
      Double[] ITarrd1 = {5.0, 6.1, 7.2}; 
      for(int j=0;j<3;j++) {
        azzert.that(ITarrdb[j].equals(ITarrd1[j]), is(true));
      }
      
      float ITf = 56; 
      Float ITfb = it(ITf);
      Float ITf1 = new Float(56);
      azzert.that(ITfb.equals(ITf1), is(true));
      
      
      float[] ITarrf = {56f,50f,40f}; 
      Float[] ITarrfb = it(ITarrf);
      Float[] ITarrf1 = {56f,50f,40f}; 
      for(int j=0;j<3;j++) {
        azzert.that(ITarrfb[j].equals(ITarrf1[j]), is(true));
      }
      
      
      int ITi = 56; 
      Integer ITib = it(ITi);
      Integer ITi1 = new Integer(56);
      azzert.that(ITib.equals(ITi1), is(true));
      
      
      int[] ITarri = {56,50,40}; 
      Integer[] ITarrib = it(ITarri);
      Integer[] ITarri1 = {56,50,40}; 
      for(int j=0;j<3;j++) {
        azzert.that(ITarrib[j].equals(ITarri1[j]), is(true));
      }
      
      
      long ITl = 56; 
      Long ITlb = it(ITl);
      Long ITl1 = new Long(56);
      azzert.that(ITlb.equals(ITl1), is(true));
      
      
      long[] ITarrl = {56L,50L,40L}; 
      Long[] ITarrlb = it(ITarrl);
      Long[] ITarrl1 = {56L,50L,40L}; 
      for(int j=0;j<3;j++) {
        azzert.that(ITarrlb[j].equals(ITarrl1[j]), is(true));
      }
      
      
      short ITs = 5; 
      Short ITsb = it(ITs);
      Short ITs1 = new Short("5");
      azzert.that(ITsb.equals(ITs1), is(true));
      
      
      short[] ITarrs = {5,6,7}; 
      Short[] ITarrsb = it(ITarrs);
      Short[] ITarrs1 = {5,6,7}; 
      for(int j=0;j<3;j++) {
        azzert.that(ITarrsb[j].equals(ITarrs1[j]), is(true));
      }
    }
  }
}
