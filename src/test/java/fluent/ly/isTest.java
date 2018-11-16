package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

public class isTest {
  @SuppressWarnings({ "static-method", "null" }) @Test public void intTest() {
    final @NotNull List<Integer> li = as.list(new int @NotNull [] { 12, 13, 14 });

    azzert.assertTrue( is.intIsIn(12, new int @NotNull [] { 12, 13, 14 }) == true);
    azzert.assertTrue( is.intIsIn(15, new int @NotNull [] { 12, 13, 14 }) == false);
    azzert.assertTrue( is.out(box.box(15), li));
    azzert.assertTrue( is.empty(li) == false);

  }

  @SuppressWarnings("static-method") @Test public void strTest() {
    final List<String> li = as.list("a", "b", "c");
    azzert.assertTrue(is.in("a", "a", "b", "c"));
    azzert.assertTrue(!is.in("d", "a", "b", "c"));
    azzert.assertTrue(is.out("1", li));
    azzert.assertTrue(is.empty(li) == false);
  }

  @SuppressWarnings({ "static-method"}) @Test public void emptyTest() {
    final List<? extends String> li = new ArrayList<>();

    azzert.assertTrue( is.out("1", li));
    azzert.assertTrue( is.empty(li));
    azzert.assertTrue( is.empty(""));
    azzert.assertTrue( !is.empty(new Integer[] {box.box( 1), box.box(2), box.box(3 )}));

  }
}
