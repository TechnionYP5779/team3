package fluent.ly;

import java.util.function.*;

import org.junit.*;

/** TODO Yossi Gil: document class
 * @author Yossi Gil
 * @since 2017-04-12 */
public interface anonymous {
  static boolean ly(final BooleanSupplier $) {
    return $.getAsBoolean();
  }

  static double ly(final DoubleSupplier $) {
    return $.getAsDouble();
  }

  static int ly(final IntSupplier $) {
    return $.getAsInt();
  }

  static long ly(final LongSupplier $) {
    return $.getAsLong();
  }

  static <T> T ly(final Supplier<T> $) {
    return $.get();
  }
  
  @SuppressWarnings("static-method") class TEST {
    @Test public void usecase0() {
      assert anonymous.ly(()->true);
    }

    @Test public void usecase1() {
      assert anonymous.ly(()->2) == 2;
    }

    @Test public void usecase2() {
      assert anonymous.ly(()->2.5) == 2.5;
    }
    
    @Test public void usecase3() {
      assert "hello".equals(anonymous.ly(() -> "hello"));
    }
  }
}
