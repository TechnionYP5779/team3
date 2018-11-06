package il.org.spartan.utils;

import org.jetbrains.annotations.*;
import org.junit.*;

import il.org.spartan.*;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-03-21 */
public class Outer<@Nullable Inner> {
  @Nullable public Inner inner;

  public Outer(final Inner inner) {
    this.inner = inner;
  }
  
  public Outer() {
    inner=null;
  }
  

  @Override @NotNull @SuppressWarnings("unchecked") public Outer<Inner> clone() throws CloneNotSupportedException {
    return (Outer<Inner>) Utils.cantBeNull(super.clone());
  }


  /** @param ¢ JD
   * @return <code><b>true</b></code> <i>iff</i> method <code>equals</code>
   *         returns <code><b>true</b></code> for the wrapped objects. */
  public boolean equals(final Outer<Inner> ¢) {
    return inner == null ? ¢.inner == null : equalsAux(¢.inner);
  }

  private boolean equalsAux(final Inner ¢) {
    return inner != null && inner.equals(¢);
  }

  @Override public int hashCode() {
    return 31 + Utils.hash(inner);
  }
  @Override @NotNull public String toString() {
    return inner == null ? "null" : Utils.cantBeNull(inner + "");
  }
  /** set current value */
  public void set(final Inner inner) {
    this.inner = inner;
  }
  /** @return value wrapped in this object. */
  public Inner get() {
    return inner;
  }
  
  public class tests {
    @SuppressWarnings({ "unchecked", "boxing", "synthetic-access", "null" }) @Test public void outerAdds() {
      @SuppressWarnings({ "rawtypes" }) Outer o = new Outer(10);
      @SuppressWarnings({ "rawtypes" }) Outer o1 = new Outer(10);
      assert(o.equals(o1)); 
      assert(o.equalsAux(o1)); 
      o.set(11);
      assert((int)o.get() == 11);
    }
}
}
