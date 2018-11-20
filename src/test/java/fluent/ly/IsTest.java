package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class IsTest {
  @Test @SuppressWarnings("null") public void intTest() {
    final @NotNull List<Integer> li = as.list(new int @NotNull [] { 12, 13, 14 });
    assert is.intIsIn(12, new int @NotNull [] { 12, 13, 14 });
    assert !is.intIsIn(15, new int @NotNull [] { 12, 13, 14 });
    assert is.out(box.box(15), li);
    assert !is.empty(li);
  }

  @Test public void strTest() {
    final List<String> li = as.list("a", "b", "c");
    assert is.in("a", "a", "b", "c");
    assert !is.in("d", "a", "b", "c");
    assert is.out("1", li);
    assert !is.empty(li);
  }

  @Test public void emptyTest() {
    final List<? extends String> li = new ArrayList<>();
    assert is.out("1", li);
    assert is.empty(li);
    assert is.empty("");
    assert !is.empty(new Integer[] { box.box(1), box.box(2), box.box(3) });
  }
}
