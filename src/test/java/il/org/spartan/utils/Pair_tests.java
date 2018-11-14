package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({ "unused", "static-method", "boxing" }) public class Pair_tests {
  @Test public void basic_test() {
    final Pair<Integer, String> p = new Pair<>(1, "abc"), p2 = new Pair<>(1, "abc"), p3 = new Pair<>(3, "aaaa"), p4 = new Pair<>(1, "ac");
    azzert.assertTrue(p.equals(p));
    azzert.assertTrue(p.equals(p2));
    azzert.assertTrue(!p.equals(p3));
    azzert.assertTrue(p.hashCode() != p3.hashCode());
    azzert.assertTrue(p.hashCode() != p4.hashCode());
    azzert.assertTrue(p.hashCode() == p2.hashCode());
    azzert.assertTrue("<1,abc>".equals(p + ""));
    azzert.assertTrue(!p.equals(Pair.newPair("X", 22)));
  }

  @Test public void Pairs_nulls_test() {
    new Pair<>(1, "abc");
    new Pair<>(3, "aaaa");
    new Pair<>(1, "abc");
    final Pair<Integer, String> p = new Pair<>(1, "abc"), p4 = new Pair<>(1, "ac"), a[] = Pair.makePairs(3), b[] = Pair.makePairs(6);
    azzert.assertTrue(!p.equals(a[1]));
    b[3] = p;
    a[1] = new Pair<>(1, "ac");
    azzert.assertTrue(b[3].equals(p));
    azzert.assertTrue(a[1].equals(p4));
  }
}