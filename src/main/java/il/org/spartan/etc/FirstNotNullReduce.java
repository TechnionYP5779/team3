package il.org.spartan.etc;

import org.jetbrains.annotations.*;

import il.org.spartan.utils.*;

/** Return the first element that is not null
 * @author oran1248
 * @since 2017-04-20 */
public class FirstNotNullReduce<@Nullable T> extends NullReduce<T> {
  @Override public T reduce(final T r1, final T r2) {
    return r1 == null ? r2 : r1;
  }
}
