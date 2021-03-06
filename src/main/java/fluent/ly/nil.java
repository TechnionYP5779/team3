package fluent.ly;

import java.util.function.*;

import org.jetbrains.annotations.*;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-04-10 */
public interface nil {
  interface On<T, R> {
    R on(T t);
  }

  static <@Nullable T> T forgetting(final Object _1, final Object... _2) {
    forget.it(_1);
    forget.it(_2);
    return null;
  }

  static <T, R> On<T, R> guardingly(final Function<T, R> f) {
    return λ -> λ == null ? null : f.apply(λ);
  }

  static <@Nullable T> T ignoring(final boolean __) {
    forget.it(__);
    return null;
  }

  static <@Nullable T> T ignoring(final double __) {
    forget.it(__);
    return null;
  }

  static <@Nullable T> T ignoring(final long __) {
    forget.it(__);
    return null;
  }
}
