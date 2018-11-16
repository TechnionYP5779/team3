package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;




public class boxTests {

  @SuppressWarnings("static-method") @Test public void boxAdds() {
    final Boolean b = box.box(true);
    final Boolean b1 = Boolean.valueOf(true);
    azzert.that(b1.equals(b), is(true));
    final boolean[] arr = { true, false, true };
    final Boolean[] b2 = box.box(arr);
    final Boolean[] arr1 = { box.box(true), box.box(false), box.box(true) };
    for (int i = 0; i < 3; i++)
      azzert.that(b2[i].equals(arr1[i]), is(true));
    final byte num = 10;
    final Byte by = box.box(num);
    final Byte n = Byte.valueOf(num);
    azzert.that(by.equals(n), is(true));
    final byte[] arrb = { 10, 1, 4 };
    final Byte[] arrBy = box.box(arrb);
    final Byte[] arrb1 = { box.box((byte)10), box.box((byte)1), box.box((byte)4) };
    for (int i = 0; i < 3; i++)
      azzert.that(arrBy[i].equals(arrb1[i]), is(true));
    final Character cb = box.box('a');
    final Character c1 = Character.valueOf('a');
    azzert.that(cb.equals(c1), is(true));
    final char[] arrc = { 'a', 'b', 'c' };
    final Character[] arrcb = box.box(arrc);
    final Character[] arrc1 = { box.box('a'), box.box('b'), box.box('c') };
    for (int i = 0; i < 3; i++)
      azzert.that(arrcb[i].equals(arrc1[i]), is(true));
    final Double db = box.box(5.0);
    final Double d1 = Double.valueOf(5.0);
    azzert.that(db.equals(d1), is(true));
    final double[] arrd = { 5.0, 6.1, 7.2 };
    final Double[] arrdb = box.box(arrd);
    final Double[] arrd1 = { box.box(5.0), box.box(6.1), box.box(7.2) };
    for (int i = 0; i < 3; i++)
      azzert.that(arrdb[i].equals(arrd1[i]), is(true));
    final float f = 56;
    final Float fb = box.box(f);
    final Float f1 = Float.valueOf(56);
    azzert.that(fb.equals(f1), is(true));
    final float[] arrf = { 56f, 50f, 40f };
    final Float[] arrfb = box.box(arrf);
    final Float[] arrf1 = { box.box(56f), box.box(50f), box.box(40f) };
    for (int i = 0; i < 3; i++)
      azzert.that(arrfb[i].equals(arrf1[i]), is(true));
    final int i = 56;
    final Integer ib = box.box(i);
    final Integer i1 = Integer.valueOf(56);
    azzert.that(ib.equals(i1), is(true));
    final int[] arri = { 56, 50, 40 };
    final Integer[] arrib = box.box(arri);
    final Integer[] arri1 = { box.box(56), box.box(50), box.box(40) };
    for (int j = 0; j < 3; j++)
      azzert.that(arrib[j].equals(arri1[j]), is(true));
    final long l = 56;
    final Long lb = box.box(l);
    final Long l1 = Long.valueOf(56);
    azzert.that(lb.equals(l1), is(true));
    final long[] arrl = { 56L, 50L, 40L };
    final Long[] arrlb = box.box(arrl);
    final Long[] arrl1 = { box.box(56L), box.box(50L), box.box(40L) };
    for (int j = 0; j < 3; j++)
      azzert.that(arrlb[j].equals(arrl1[j]), is(true));
    final short s = 5;
    final Short sb = box.box(s);
    final Short s1 = Short.valueOf("5");
    azzert.that(sb.equals(s1), is(true));
    final short[] arrs = { 5, 6, 7 };
    final Short[] arrsb = box.box(arrs);
    final Short[] arrs1 = { box.box((short)5),box.box((short) 6), box.box((short)7) };
    for (int j = 0; j < 3; j++)
      azzert.that(arrsb[j].equals(arrs1[j]), is(true));
    final Boolean ITb = box.it(true);
    final Boolean ITb1 = Boolean.valueOf(true);
    azzert.that(ITb1.equals(ITb), is(true));
    final boolean[] ITarr = { true, false, true };
    final Boolean[] ITb2 = box.it(ITarr);
    final Boolean[] ITarr1 = {box.box( true), box.box(false), box.box(true) };
    for (int j = 0; j < 3; j++)
      azzert.that(ITb2[j].equals(ITarr1[j]), is(true));
    final byte ITnum = 10;
    final Byte ITby = box.it(ITnum);
    final Byte ITn = Byte.valueOf(ITnum);
    azzert.that(ITby.equals(ITn), is(true));
    final byte[] ITarrb = { 10, 1, 4 };
    final Byte[] ITarrBy = box.it(ITarrb);
    final Byte[] ITarrb1 = { box.box((byte)10), box.box((byte)1),box.box((byte) 4) };
    for (int j = 0; j < 3; j++)
      azzert.that(ITarrBy[j].equals(ITarrb1[j]), is(true));
    final Character ITcb = box.it('a');
    final Character ITc1 = Character.valueOf('a');
    azzert.that(ITcb.equals(ITc1), is(true));
    final char[] ITarrc = { 'a', 'b', 'c' };
    final Character[] ITarrcb = box.it(ITarrc);
    final Character[] ITarrc1 = { box.box('a'), box.box('b'), box.box('c') };
    for (int j = 0; j < 3; j++)
      azzert.that(ITarrcb[j].equals(ITarrc1[j]), is(true));
    final Double ITdb = box.it(5.0);
    final Double ITd1 = Double.valueOf(5.0);
    azzert.that(ITdb.equals(ITd1), is(true));
    final double[] ITarrd = { 5.0, 6.1, 7.2 };
    final Double[] ITarrdb = box.it(ITarrd);
    final Double[] ITarrd1 = { box.box(5.0), box.box(6.1), box.box(7.2) };
    for (int j = 0; j < 3; j++)
      azzert.that(ITarrdb[j].equals(ITarrd1[j]), is(true));
    final float ITf = 56;
    final Float ITfb = box.it(ITf);
    final Float ITf1 = Float.valueOf(56);
    azzert.that(ITfb.equals(ITf1), is(true));
    final float[] ITarrf = { 56f, 50f, 40f };
    final Float[] ITarrfb = box.it(ITarrf);
    final Float[] ITarrf1 = { box.box(56f), box.box(50f),box.box( 40f) };
    for (int j = 0; j < 3; j++)
      azzert.that(ITarrfb[j].equals(ITarrf1[j]), is(true));
    final int ITi = 56;
    final Integer ITib = box.it(ITi);
    final Integer ITi1 = Integer.valueOf(56);
    azzert.that(ITib.equals(ITi1), is(true));
    final int[] ITarri = { 56, 50, 40 };
    final Integer[] ITarrib = box.it(ITarri);
    final Integer[] ITarri1 = {box.box( 56), box.box(50),box.box( 40) };
    for (int j = 0; j < 3; j++)
      azzert.that(ITarrib[j].equals(ITarri1[j]), is(true));
    final long ITl = 56;
    final Long ITlb = box.it(ITl);
    final Long ITl1 = Long.valueOf(56);
    azzert.that(ITlb.equals(ITl1), is(true));
    final long[] ITarrl = { 56L, 50L, 40L };
    final Long[] ITarrlb = box.it(ITarrl);
    final Long[] ITarrl1 = { box.box(56L), box.box(50L), box.box(40L )};
    for (int j = 0; j < 3; j++)
      azzert.that(ITarrlb[j].equals(ITarrl1[j]), is(true));
    final short ITs = 5;
    final Short ITsb = box.it(ITs);
    final Short ITs1 = Short.valueOf("5");
    azzert.that(ITsb.equals(ITs1), is(true));
    final short[] ITarrs = { 5, 6, 7 };
    final Short[] ITarrsb = box.it(ITarrs);
    final Short[] ITarrs1 = { box.box((short)5),box.box((short) 6),box.box((short) 7) };
    for (int j = 0; j < 3; j++)
      azzert.that(ITarrsb[j].equals(ITarrs1[j]), is(true));
  }
}
