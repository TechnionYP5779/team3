package fluent.ly;

import java.util.function.*;

import org.junit.*;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-04-10 */
@SuppressWarnings({ "unused", "null" }) public interface nil {
  interface On<T, R> {
    R on(T t);
  }

  static <T> T forgetting(final Object _1, final Object... _2) {
    return null;
  }

  static <T, R> On<T, R> guardingly(final Function<T, R> f) {
    return λ -> λ == null ? null : f.apply(λ);
  }

  static <T> T ignoring(final boolean __) {
    return null;
  }

  static <T> T ignoring(final double __) {
    return null;
  }

  static <T> T ignoring(final long __) {
    return null;
  }
  
  @SuppressWarnings("static-method") public static class TEST {
    @Test public void usecase0() {
      azzert.isNull(nil.ignoring(true));
    }

    @Test public void usecase1() {
      azzert.isNull(nil.ignoring(3));
    }

    @Test public void usecase2() {
      azzert.isNull(nil.ignoring(2.5));
    }
    
    @Test public void usecase3() {
      azzert.isNull(nil.forgetting(Integer.valueOf(1), Double.valueOf(4), "hi"));
    }
    
    @Test public void usecase4() {
      On<Object, Object> f = nil.guardingly(x->Boolean.valueOf(x.equals("hi")));
      azzert.isNull(f.on(null));
    }
  }
  
}
