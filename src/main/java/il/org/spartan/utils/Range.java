package il.org.spartan.utils;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

/** An immutable integral range, representing all integers between
 * {@link #from}, up to, but not including, {@link #to}, i.e.,
 *
 * <pre>
 * {@link #from}, {@link #from}+1, ..., {@link #to}-1
 * </pre>
 *
 * @author Boris van Sosin <code><boris.van.sosin [at] gmail.com></code>
 * @since 2012 */
public class Range {
  /** the beginning of the range (inclusive) */
  public final int from;
  /** the end of the range (exclusive) */
  public final int to;

  /** Instantiates from beginning and end locations
   * @param from JD
   * @param to   JD */
  public Range(final int from, final int to) {
    this.from = from;
    this.to = to;
  }

  /** Instantiates using values found in another intance
   * @param other other */
  public Range(final @NotNull Range other) {
    this(other.from, other.to);
  }

  @Override public boolean equals(final Object ¢) {
    return ¢ instanceof Range && from == ((Range) ¢).from && to == ((Range) ¢).to;
  }

  @Nullable public Range findIncludedIn(final @Nullable Iterable<? extends Range> ¢) {
    if (¢ != null)
      for (final @Nullable Range $ : ¢)
        if ($ != null)
          if (includedIn($))
            return $;
    return null;
  }

  @Override public int hashCode() {
    // Cantor pairing function
    return (int) (from + 0.5 * (to + from) * (to + from + 1));
  }

  /** @param ¢ arbitrary
   * @return <code><b>true</b></code> <i>iff</i> <code><b>this</b></code> is
   *         included in the parameter. */
  public boolean includedIn(final @NotNull Range ¢) {
    return from >= ¢.from && to <= ¢.to;
  }

  public boolean isEmpty() {
    return size() <= 0;
  }

  @NotNull public Range merge(final @NotNull Range ¢) {
    return new Range(Math.min(from, ¢.from), Math.max(to, ¢.to));
  }

  /** Determine whether overlaps in any part another range
   * @param ¢ arbitrary
   * @return <code><b>true</b></code> <i>iff</i> <code><b>this</b></code> overlaps
   *         the parameter. */
  public boolean overlapping(final @NotNull Range ¢) {
    return from >= ¢.from || to <= ¢.to;
  }

  /** Prune all ranges in a given list that include this object.
   * @param rs JD */
  public void pruneIncluders(final @NotNull List<Range> rs) {
    for (;;) {
      final @Nullable Range r = findIncludedIn(rs);
      if (r == null)
        return;
      rs.remove(r);
    }
  }

  /** The number of integers in the range
   * @return a non-negative integer, computed as {@link #to} -{@link #from} */
  public int size() {
    return to - from;
  }

  @Override public String toString() {
    return String.format("[%d, %d]", fluent.ly.box.it(from), fluent.ly.box.it(to));
  }
  
  @SuppressWarnings({ "static-method", "unused"}) public static class TEST {
    @Test public void test() {
      Range zero = new Range(0,0);
      Range zero_from1 = new Range(1,1);
      Range r= new Range(1,10);
      Range r2= new Range(1,11);
      Range r3= new Range(-3,50);
      Range r4= new Range(Integer.MIN_VALUE,Integer.MAX_VALUE);
      Range bo= new Range(-5,2);
      Range ao= new Range(9,11);
      Range r_copy= new Range(r);
      
      assert zero.equals(zero);
      assert !zero.equals(zero_from1);
      assert !zero.equals(r4);
      assert r.equals(r_copy);
      
      assert zero.hashCode()==zero.hashCode();
      assert zero.hashCode()!=zero_from1.hashCode();
      assert zero.hashCode()!=r4.hashCode();
      assert r.hashCode()==r_copy.hashCode();

      List<Range> l = new ArrayList<Range>();
      assert r2.findIncludedIn(l)==null;
      l.add(r);
      l.add(r3);
      l.add(r4);
      assert r_copy.findIncludedIn(l)==r;
      assert r_copy.equals(r_copy.findIncludedIn(l));
      assert r3.findIncludedIn(l)==r3;
      assert r4.findIncludedIn(l)==r4;
      assert r2.findIncludedIn(l)==r3;
      l.add(r2);
      assert r2.findIncludedIn(l)!=r2;
      assert r2.findIncludedIn(null)==null;
      
      r3.pruneIncluders(l);
      assert l.size()==2;
      zero.pruneIncluders(l);
      assert l.size()==2;
      l.remove(r);
      r.pruneIncluders(l);
      assert l.size()==0;
      
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
      
      assert zero.size()==0;
      assert r.size()==9;
      assert r4.size()==Integer.MAX_VALUE-Integer.MIN_VALUE;
      assert r3.merge(bo).size()==55;
      assert r3.includedIn(r3.merge(bo));
      assert bo.includedIn(r3.merge(bo));
      assert !r4.includedIn(r3.merge(bo));
      assert r3.merge(r4).size()==r4.size();

      assert zero.toString().equals("[0, 0]");
      assert r2.toString().equals("[1, 11]");
    }
  }
}