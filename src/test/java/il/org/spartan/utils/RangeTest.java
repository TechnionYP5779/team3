package il.org.spartan.utils;

import java.util.*;

import org.junit.*;

@SuppressWarnings("static-method") public class RangeTest {
  @Test public void test() {
    final Range zero = new Range(0, 0), zero_from1 = new Range(1, 1), r = new Range(1, 10), r2 = new Range(1, 11), r3 = new Range(-3, 50),
        r4 = new Range(Integer.MIN_VALUE, Integer.MAX_VALUE), bo = new Range(-5, 2), ao = new Range(9, 11), r_copy = new Range(r);
    assert zero.equals(zero);
    assert !zero.equals(zero_from1);
    assert !zero.equals(r4);
    assert r.equals(r_copy);
    assert zero.hashCode() == zero.hashCode();
    assert zero.hashCode() != zero_from1.hashCode();
    assert zero.hashCode() != r4.hashCode();
    assert r.hashCode() == r_copy.hashCode();
    final List<Range> l = new ArrayList<>();
    assert r2.findIncludedIn(l) == null;
    l.add(r);
    l.add(r3);
    l.add(r4);
    assert r_copy.findIncludedIn(l) == r;
    assert r_copy.equals(r_copy.findIncludedIn(l));
    assert r3.findIncludedIn(l) == r3;
    assert r4.findIncludedIn(l) == r4;
    assert r2.findIncludedIn(l) == r3;
    l.add(r2);
    assert r2.findIncludedIn(l) != r2;
    assert r2.findIncludedIn(null) == null;
    r3.pruneIncluders(l);
    assert l.size() == 2;
    zero.pruneIncluders(l);
    assert l.size() == 2;
    l.remove(r);
    r.pruneIncluders(l);
    assert l.isEmpty();
    assert r2.includedIn(r3);
    assert !r2.includedIn(r);
    assert !r.includedIn(zero);
    assert !zero_from1.includedIn(zero);
    assert r3.includedIn(r4);
    assert r.overlapping(r);
    assert r.overlapping(r4);
    assert !r4.overlapping(r);
    assert r.overlapping(bo);
    assert r.overlapping(ao);
    assert !r.isEmpty();
    assert zero_from1.isEmpty();
    assert zero.isEmpty();
    assert r.size() == 9;
    assert r4.size() == Integer.MAX_VALUE - Integer.MIN_VALUE;
    assert r3.merge(bo).size() == 55;
    assert r3.includedIn(r3.merge(bo));
    assert bo.includedIn(r3.merge(bo));
    assert !r4.includedIn(r3.merge(bo));
    assert r3.merge(r4).size() == r4.size();
    assert "[0, 0]".equals(zero + "");
    assert "[1, 11]".equals(r2 + "");
  }
}