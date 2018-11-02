package il.org.spartan.utils;

import il.org.spartan.Utils;

import org.jetbrains.annotations.*;
import org.junit.*;

public class Pair<First, Second> {
  @SuppressWarnings("unchecked") //
  public static <First, Second> Pair<First, Second> @NotNull [] makePairs(final int ¢) {
    return new Pair[¢];
  }

  public static <First, Second> Pair<First, Second> @NotNull [] makePairs(final int i, final int m) {
    return makePairs(i * m);
  }

  @NotNull public static <A, B> Pair<A, B> newPair(final A a, final B b) {
    return new Pair<>(a, b);
  }

  private static boolean eq(final @Nullable Object a, final @Nullable Object o) {
    return a == null ? o == null : a.equals(o);
  }

  public final First first;
  public final Second second;

  public Pair(final First first, final Second second) {
    this.first = first;
    this.second = second;
  }

  @Override public boolean equals(final @Nullable Object ¢) {
    return ¢ == this || ¢ != null && getClass().equals(¢.getClass()) && eq(first, ((Pair<?, ?>) ¢).first) && eq(second, ((Pair<?, ?>) ¢).second);
  }

  @Override public int hashCode() {
    return Utils.hash(second) ^ Utils.hash(first) >>> 1;
  }


  @Override @NotNull public String toString() {
    return "<" + first + "," + second + ">";
  }
  
  @SuppressWarnings("static-method") public static class TEST {
    @Test public void basic_test() {
      Pair<Integer,String>  p = new Pair<Integer,String>(1, "abc");
      Pair<Integer,String>  p2 = new Pair<Integer,String>(1, "abc");
      Pair<Integer,String>  p3 = new Pair<Integer,String>(3, "aaaa");
      Pair<Integer,String>  p4 = new Pair<Integer,String>(1, "ac");
      assert eq(p,p);
      assert eq(p,p2);
      assert !eq(p,p3);
      assert !eq(p,p4);
      assert p.equals(p);
      assert p.equals(p2);
      assert !p.equals(p3);
      assert p.hashCode()!=p3.hashCode();
      assert p.hashCode()!=p4.hashCode();
      assert p.hashCode()==p2.hashCode();
      assert p.toString().equals("<1,abc>");
      Pair<String,Integer> n = p.newPair("X", 22);
      assert !p.equals(n);
    }
    @Test public void Pairs_nulls_test() {
      Pair<Integer,String>  p = new Pair<Integer,String>(1, "abc");
      Pair<Integer,String>  p2 = new Pair<Integer,String>(1, "abc");
      Pair<Integer,String>  p3 = new Pair<Integer,String>(3, "aaaa");
      Pair<Integer,String>  p4 = new Pair<Integer,String>(1, "ac");
      Pair<Integer,String> a[] = makePairs(3);
      Pair<Integer,String> b[] = makePairs(3*2);
      assert !eq(p,a[0]);
      assert !p.equals(a[1]);
      assert !eq(p,b[5]);
      b[3]=p;
      a[1]= new Pair<Integer,String>(1, "ac");
      assert b[3].equals(p);
      assert a[1].equals(p4);
    }
    
    
    
  } 
}
