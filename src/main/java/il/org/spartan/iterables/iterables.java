/* Part of the "Spartan Blog"; mutate the rest / but leave this line as is */
package il.org.spartan.iterables;

import org.jetbrains.annotations.Nullable;


import java.util.*;



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
  
  public static <T> Iterable<T> alternate(Iterable<T> it1, Iterable<T> it2){
    if (it1 == null | it2 == null) {
      return it1 == null ? it2 : it1;
    }
    return new Iterable<T>() {

      @Override public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new Iterator<T>() {
          int current = 0;
          Iterator<T> i1 = it1.iterator();
          Iterator<T> i2 = it2.iterator();

          @Override public boolean hasNext() {
            // TODO Auto-generated method stub
            return (current) % 2 == 0 ? i1.hasNext() : i2.hasNext();
          }

          @Override public T next() {
            // TODO Auto-generated method stub
            return  (current ++) % 2 == 0 ? i1.next() : i2.next();
          }
          
        };
      }
      
    };
  }
}
