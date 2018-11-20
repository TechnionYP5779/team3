package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class PairTest {
  @Test public void basic_test() {
    final Pair<Integer, String> p = new Pair<>(box.it(1), "abc"), p2 = new Pair<>(box.it(1), "abc"), p3 = new Pair<>(box.it(3), "aaaa"),
        p4 = new Pair<>(box.it(1), "ac");
    assert p.equals(p);
    assert p.equals(p2);
    assert !p.equals(p3);
    assert p.hashCode() != p3.hashCode();
    assert p.hashCode() != p4.hashCode();
    assert p.hashCode() == p2.hashCode();
    assert "<1,abc>".equals(p + "");
    assert !p.equals(Pair.newPair("X", box.it(22)));
  }

  @Test public void Pairs_nulls_test() {
    final Pair<Integer, String> p = new Pair<>(box.it(1), "abc"), p4 = new Pair<>(box.it(1), "ac"), a[] = Pair.makePairs(3),
        b[] = Pair.makePairs(6);
    assert !p.equals(a[1]);
    b[3] = p;
    a[1] = new Pair<>(box.it(1), "ac");
    assert b[3].equals(p);
    assert a[1].equals(p4);
  }
}