package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

/** A poor man's approximation of a mutable int, which is so much more
 * convenient than {@link Integer}
 * @author Yossi Gil
 * @since Sep 12, 2016 */
public final class Int {
  public int inner;

  public Int() {
    ___.______unused();
  }

  public Int(final int inner) {
    this.inner = inner;
  }

  /** Function form, good substitute for auto-boxing */
  public Integer inner() {
    return Integer.valueOf(inner);
  }

  /** @param ¢ JD
   * @return */
  public static Int valueOf(final int ¢) {
    final Int $ = new Int();
    $.inner = ¢;
    return $;
  }

  public void step() {
    ++inner;
  }

  public int get() {
    return inner;
  }

  public void add(final int value) {
    inner += value;
  }

  public void set(final int inner) {
    this.inner = inner;
  }

  @Override public String toString() {
    return inner + "";
  }

  public int next() {
    return ++inner;
  }

  public void add(final Int other) {
    inner += other.get();
  }

  public void clear() {
    inner = 0;
  }
  
  
  @SuppressWarnings("static-method") public static class TEST {
    @Test public void basic_test() {
      Int a= new Int();
      assert a==a;
      Int b= new Int(3);
      assert b==b;
      assert b.equals(b);
      assert b.inner==3;
      assert valueOf(0).inner==0;
    }

    @Test public void set_get_change_test() {
      Int a= new Int();
      Int b= new Int(3);
      a.set(4);
      assert a.get()==4;
      a.set(-6);
      assert a.get()!=4;
      assert a.get()==-6;
      b.set(Integer.MAX_VALUE);
      assert b.get()==Integer.MAX_VALUE;
      b.set(Integer.MIN_VALUE);
      assert b.get()==Integer.MIN_VALUE;
      b.clear();
      assert b.get()==0;
      b.step();
      assert b.inner()==b.get();
      assert b.next()==2;
      assert b.next()==valueOf(3).get();
      assert b.toString().equals("3"+ "");
    }
    
    @Test public void math_test() {
      Int a= new Int(5);
      Int b= new Int(3);
      a.add(b);
      assert a.get()==8;
      a.add(-10);
      assert a.get()==-2;
      b.add(a);
      a.add(a);
      assert b.get()==1;
      assert a.get()==-4;
      }
    
  }
  
}










