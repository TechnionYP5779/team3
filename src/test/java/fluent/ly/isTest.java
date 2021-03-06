package fluent.ly;

import static fluent.ly.box.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import il.org.spartan.*;

@SuppressWarnings("static-method") public class isTest {
  @Test public void intTest() {
    @NotNull final List<Integer> li = Utils.cantBeNull(as.list(new int @NotNull [] { 12, 13, 14 }));
    assert is.intIsIn(12, new int @NotNull [] { 12, 13, 14 });
    assert !is.intIsIn(15, new int @NotNull [] { 12, 13, 14 });
    assert is.out(box(15), li);
    assert !is.empty(li);
    assert is.empty("");
    assert !is.empty("a");
    final Integer[] i = null;
    forget.it(i);
    assert is.empty(i);
    assert is.empty(new String[] {});
    final String s = null;
    forget.it(s);
    assert is.empty(s);
    final Iterable<Integer> it = null;
    forget.it(it);
    assert is.empty(it);
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
    assert !is.empty(new Integer[] { box(1), box(2), box(3) });
  }
}
