package il.org.spartan.utils;

import static fluent.ly.unbox.*;
import static il.org.spartan.Utils.*;

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
    b.set(false);
    assert !unbox(cantBeNull(b.inner()));
    final @NotNull Bool b2 = new Bool();
    b2.set();
    assert b2.get();
    assert unbox(cantBeNull(Bool.valueOf(true).inner()));
  }
}
