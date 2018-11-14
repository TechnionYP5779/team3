/* Part of the "Spartan Blog"; mutate the rest / but leave this line as is */
package il.org.spartan.iterables;

import java.util.*;

import org.jetbrains.annotations.*;

import an.*;
import fluent.ly.*;

/** No values in an 'enum' used as name space for a collection of 'static'
 * functions.
 * @author Yossi Gil <Yossi.Gil@GMail.COM> */
public enum iterables {
  ;
  /** Counts the number of items in an {@link Iterable}.
   * @param    <T> some arbitrary type
   * @param ts some iterable over items whose type is the type parameter
   * @return number of items the given iterable yields. */
  public static <T> int count(final @Nullable Iterable<T> ts) {
    int $ = 0;
    if (ts != null)
      for (final @Nullable T ¢ : ts)
        $ += as.bit(¢ != null);
    return $;
  }

  /** @param <T> JD
   * @return <code><b>true</b></code> <i>iff</i> the receive is empty */
  public static <T> Iterable<T> empty() {
    return iterable.over();
  }

  /** @param os JD */
  public static boolean isEmpty(final Iterable<?> os) {
    for (final @Nullable Object name2 : os)
      if (name2 != null)
        return false;
    return true;
  }

  /** wraps a value in a singleton iterator form
   * @param   <T> JD
   * @param $ JD
   * @return parameter, but in a singleton iterator form */
  public static <T> Iterator<T> singletonIterator(final T $) {
    return iterable.singleton($).iterator();
  }

  public static <T> Iterable<T> alternate(final Iterable<T> it1, final Iterable<T> it2) {
    return !(it1 == null | it2 == null) ? () -> new Iterator<T>() {
      int current;
      Iterator<T> i1 = it1.iterator();
      Iterator<T> i2 = it2.iterator();

      @Override public boolean hasNext() {
        return i1.hasNext() || i2.hasNext();
      }

      @Override public T next() {
        return current++ % 2 == 0 ? (i1.hasNext() ? i1 : i2).next() : (i2.hasNext() ? i2 : i1).next();
      }
    } : it1 == null ? it2 : it1;
  }
}
