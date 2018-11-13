package tests;

import static fluent.ly.azzert.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.*;

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
