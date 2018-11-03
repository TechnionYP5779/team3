package fluent.ly;

import org.jetbrains.annotations.*;

public interface not {
  @SafeVarargs static <T> boolean in(final T t, final @NotNull T... ts) {
    return !is.in(t, ts);
  }

  static boolean nil(final Object ¢) {
    return ¢ != null;
  }
}