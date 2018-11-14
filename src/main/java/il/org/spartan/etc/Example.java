package il.org.spartan.etc;

import java.util.function.*;

public interface Example {
  interface Converts extends Example {
    String from();

    String to();
  }

  @FunctionalInterface interface Ignores extends Example, Supplier<String> {
    /**/ }
}