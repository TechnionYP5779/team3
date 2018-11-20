package fluent.ly;

import org.junit.*;
import static fluent.ly.box.*;

@SuppressWarnings("static-method") public class BoxTest {
  @Test public void boxAdds() {
    assert box(true).equals(box(true));
    final Boolean[] b2 = box(new boolean[] { true, false, true }), arr1 = { box(true), box(false), box(true) };
    for (int ¢ = 0; ¢ < 3; ++¢)
      assert b2[¢].equals(arr1[¢]);
    final byte num = 10;
    assert box(num).equals(box(num));
    final Byte[] arrBy = box(new byte[] { 10, 1, 4 }), arrb1 = { box((byte) 10), box((byte) 1), box((byte) 4) };
    for (int ¢ = 0; ¢ < 3; ++¢)
      assert arrBy[¢].equals(arrb1[¢]);
    assert box('a').equals(box('a'));
    final Character[] arrcb = box(new char[] { 'a', 'b', 'c' }), arrc1 = { box('a'), box('b'), box('c') };
    for (int ¢ = 0; ¢ < 3; ++¢)
      assert arrcb[¢].equals(arrc1[¢]);
    assert box(5.0).equals(box(5.0));
    final Double[] arrdb = box(new double[] { 5.0, 6.1, 7.2 }), arrd1 = { box(5.0), box(6.1), box(7.2) };
    for (int ¢ = 0; ¢ < 3; ++¢)
      assert arrdb[¢].equals(arrd1[¢]);
    assert box(56.0f).equals(box((float) 56));
    final Float[] arrfb = box(new float[] { 56f, 50f, 40f }), arrf1 = { box(56f), box(50f), box(40f) };
    for (int ¢ = 0; ¢ < 3; ++¢)
      assert arrfb[¢].equals(arrf1[¢]);
    assert box(56).equals(box(56));
    final Integer[] arrib = box(new int[] { 56, 50, 40 }), arri1 = { box(56), box(50), box(40) };
    for (int j = 0; j < 3; ++j)
      assert arrib[j].equals(arri1[j]);
    assert box(56L).equals(box(56L));
    final Long[] arrlb = box(new long[] { 56L, 50L, 40L }), arrl1 = { box(56L), box(50L), box(40L) };
    for (int j = 0; j < 3; ++j)
      assert arrlb[j].equals(arrl1[j]);
    assert box((short) 5).equals(Short.valueOf("5"));
    final Short[] arrsb = box(new short[] { 5, 6, 7 }), arrs1 = { box((short) 5), box((short) 6), box((short) 7) };
    for (int j = 0; j < 3; ++j)
      assert arrsb[j].equals(arrs1[j]);
    assert box(true).equals(box.it(true));
    final Boolean[] ITb2 = box.it(new boolean[] { true, false, true }), ITarr1 = { box(true), box(false), box(true) };
    for (int j = 0; j < 3; ++j)
      assert ITb2[j].equals(ITarr1[j]);
    final byte ITnum = 10;
    assert box.it(ITnum).equals(box(ITnum));
    final Byte[] ITarrBy = box.it(new byte[] { 10, 1, 4 }), ITarrb1 = { box((byte) 10), box((byte) 1), box((byte) 4) };
    for (int j = 0; j < 3; ++j)
      assert ITarrBy[j].equals(ITarrb1[j]);
    assert box.it('a').equals(box('a'));
    final Character[] ITarrcb = box.it(new char[] { 'a', 'b', 'c' }), ITarrc1 = { box('a'), box('b'), box('c') };
    for (int j = 0; j < 3; ++j)
      assert ITarrcb[j].equals(ITarrc1[j]);
    assert box.it(5.0).equals(box(5.0));
    final Double[] ITarrdb = box.it(new double[] { 5.0, 6.1, 7.2 }), ITarrd1 = { box(5.0), box(6.1), box(7.2) };
    for (int j = 0; j < 3; ++j)
      assert ITarrdb[j].equals(ITarrd1[j]);
    assert box.it(56.0f).equals(box((float) 56));
    final Float[] ITarrfb = box.it(new float[] { 56f, 50f, 40f }), ITarrf1 = { box(56f), box(50f), box(40f) };
    for (int j = 0; j < 3; ++j)
      assert ITarrfb[j].equals(ITarrf1[j]);
    assert box.it(56).equals(box(56));
    final Integer[] ITarrib = box.it(new int[] { 56, 50, 40 }), ITarri1 = { box(56), box(50), box(40) };
    for (int j = 0; j < 3; ++j)
      assert ITarrib[j].equals(ITarri1[j]);
    assert box.it(56L).equals(box(56L));
    final Long[] ITarrlb = box.it(new long[] { 56L, 50L, 40L }), ITarrl1 = { box(56L), box(50L), box(40L) };
    for (int j = 0; j < 3; ++j)
      assert ITarrlb[j].equals(ITarrl1[j]);
    assert box.it((short) 5).equals(Short.valueOf("5"));
    for (int j = 0; j < 3; ++j)
      assert box.it(new short[] { 5, 6, 7 })[j].equals((new Short[] { box((short) 5), box((short) 6), box((short) 7) })[j]);
  }
}
