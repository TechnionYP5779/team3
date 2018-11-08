package tests;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

public class isTest {
  @SuppressWarnings({ "boxing", "static-method", "null" }) @Test public void intTest() {
    final @NotNull List<Integer> li = as.list(new int @NotNull [] { 12, 13, 14 });
    assert is.intIsIn(12, new int @NotNull [] { 12, 13, 14 }) == true;
    assert is.intIsIn(15, new int @NotNull [] { 12, 13, 14 }) == false;
    assert is.out(15, li);
    assert is.empty(li) == false;
  }

  @SuppressWarnings("static-method") @Test public void strTest() {
    final List<String> li = as.list("a", "b", "c");
    assert is.in("a", "a", "b", "c");
    assert !is.in("d", "a", "b", "c");
    assert is.out("1", li);
    assert is.empty(li) == false;
  }

  @SuppressWarnings({ "static-method", "unused", "boxing" }) @Test public void emptyTest() {
    final List<? extends String> li = new ArrayList<>();
    assert is.out("1", li);
    assert is.empty(li);
    assert is.empty("");
    assert !is.empty(new Integer[] { 1, 2, 3 });
  }
}
