package il.org.spartan.utils;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class BoolTest {
  @Test public void booleanAdds() {
    final @NotNull Bool b = new Bool(true);
    assert b.get();
    b.clear();
    assert !b.get();
    b.set(true);
    assert b.get();
  }
}
