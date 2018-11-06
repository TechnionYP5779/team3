package il.org.spartan.utils;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.Accumulator.Counter;

import static fluent.ly.azzert.*;
/** A poor man's approximation of a mutable boolean, which is so much more
 * convenient than {@link Boolean}
 * @author Ori Marcovitch
 * @since Oct 16, 2016 */
public final class Bool {
  public static Bool valueOf(final boolean ¢) {
    return new Bool(¢);
  }

  public boolean inner;

  public Bool() {
  }

  public Bool(final boolean b) {
    inner = b;
  }

  public Bool clear() {
    return set(false);
  }

  public boolean get() {
    return inner;
  }

  /** Function form, good substitute for auto-boxing */
  public Boolean inner() {
    return Boolean.valueOf(inner);
  }

  public Bool set() {
    return set(true);
  }

  public Bool set(final boolean ¢) {
    inner = ¢;
    return this;
  }
  
  @SuppressWarnings("static-method") public static class TEST {
    @Test public void booleanAdds() {
      final @NotNull Bool b = new Bool(true);
      azzert.that(b.get(), is(true));
      b.clear(); 
      azzert.that(b.get(), is(false));
      b.set(true); 
      azzert.that(b.get(), is(true));
      
    }
}
}
