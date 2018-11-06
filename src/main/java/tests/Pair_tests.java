package tests;

import org.junit.*;

import il.org.spartan.utils.*;

@SuppressWarnings({ "static-access", "unused", "static-method",
  "boxing"}) public class Pair_tests {
@Test public void basic_test() {
Pair<Integer, String> p = new Pair<Integer, String>(1, "abc"), p2 = new Pair<Integer, String>(1, "abc"),
p3 = new Pair<Integer, String>(3, "aaaa"), p4 = new Pair<Integer, String>(1, "ac");

assert p.equals(p);
assert p.equals(p2);
assert !p.equals(p3);
assert p.hashCode()!=p3.hashCode();
assert p.hashCode()!=p4.hashCode();
assert p.hashCode()==p2.hashCode();
assert "<1,abc>".equals(p + "");
assert !p.equals(p.newPair("X", 22));
}
@Test public void Pairs_nulls_test() {
new Pair<Integer, String>(1, "abc");
new Pair<Integer, String>(3, "aaaa");
new Pair<Integer, String>(1, "abc");
Pair<Integer, String> p = new Pair<Integer, String>(1, "abc"), p4 = new Pair<Integer, String>(1, "ac"), a[] = Pair.makePairs(3), b[] = Pair.makePairs(6);
assert !p.equals(a[1]);
b[3]=p;
a[1]= new Pair<Integer,String>(1, "ac");
assert b[3].equals(p);
assert a[1].equals(p4);
}



} 