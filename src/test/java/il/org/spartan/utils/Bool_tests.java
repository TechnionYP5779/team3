package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class Bool_tests {
  @Test public void booleanAdds() {
    final @NotNull Bool b = new Bool(true);
    azzert.that(b.get(), is(true));
    b.clear();
    azzert.that(b.get(), is(false));
    b.set(true);
    azzert.that(b.get(), is(true));
  }
}
