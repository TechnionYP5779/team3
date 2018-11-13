package tests;

import java.util.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.*;

@SuppressWarnings({ "static-method", "unused" }) public class Range_tests {
  @Test public void test() {
    final Range zero = new Range(0, 0), zero_from1 = new Range(1, 1), r = new Range(1, 10), r2 = new Range(1, 11), r3 = new Range(-3, 50),
        r4 = new Range(Integer.MIN_VALUE, Integer.MAX_VALUE), bo = new Range(-5, 2), ao = new Range(9, 11), r_copy = new Range(r);
    azzert.assertTrue( zero.equals(zero));
    azzert.assertTrue( !zero.equals(zero_from1));
    azzert.assertTrue( !zero.equals(r4));
    azzert.assertTrue( r.equals(r_copy));
    azzert.assertTrue( zero.hashCode() == zero.hashCode());
    azzert.assertTrue( zero.hashCode() != zero_from1.hashCode());
    azzert.assertTrue( zero.hashCode() != r4.hashCode());
    azzert.assertTrue( r.hashCode() == r_copy.hashCode());
    final List<Range> l = new ArrayList<>();
    azzert.assertTrue( r2.findIncludedIn(l) == null);
    l.add(r);
    l.add(r3);
    l.add(r4);
    azzert.assertTrue( r_copy.findIncludedIn(l) == r);
    azzert.assertTrue( r_copy.equals(r_copy.findIncludedIn(l)));
    azzert.assertTrue( r3.findIncludedIn(l) == r3);
    azzert.assertTrue( r4.findIncludedIn(l) == r4);
    azzert.assertTrue( r2.findIncludedIn(l) == r3);
    l.add(r2);
    azzert.assertTrue( r2.findIncludedIn(l) != r2);
    azzert.assertTrue( r2.findIncludedIn(null) == null);
    r3.pruneIncluders(l);
    azzert.assertTrue( l.size() == 2);
    zero.pruneIncluders(l);
    azzert.assertTrue( l.size() == 2);
    l.remove(r);
    r.pruneIncluders(l);
    azzert.assertTrue( l.isEmpty());
    azzert.assertTrue( r2.includedIn(r3));
    azzert.assertTrue( !r2.includedIn(r));
    azzert.assertTrue( !r.includedIn(zero));
    azzert.assertTrue( !zero_from1.includedIn(zero));
    azzert.assertTrue( r3.includedIn(r4));
    azzert.assertTrue( r.overlapping(r));
    azzert.assertTrue( r.overlapping(r4));
    azzert.assertTrue( !r4.overlapping(r));
    azzert.assertTrue( r.overlapping(bo));
    azzert.assertTrue( r.overlapping(ao));
    azzert.assertTrue( !r.isEmpty());
    azzert.assertTrue( zero_from1.isEmpty());
    azzert.assertTrue( zero.isEmpty());
    azzert.assertTrue( r.size() == 9);
    azzert.assertTrue( r4.size() == Integer.MAX_VALUE - Integer.MIN_VALUE);
    azzert.assertTrue( r3.merge(bo).size() == 55);
    azzert.assertTrue( r3.includedIn(r3.merge(bo)));
    azzert.assertTrue( bo.includedIn(r3.merge(bo)));
    azzert.assertTrue( !r4.includedIn(r3.merge(bo)));
    azzert.assertTrue( r3.merge(r4).size() == r4.size());
    azzert.assertTrue( "[0, 0]".equals(zero + ""));
    azzert.assertTrue( "[1, 11]".equals(r2 + ""));
  }
}