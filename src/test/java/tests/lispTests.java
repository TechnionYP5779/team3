package tests;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

public class lispTests {
  @SuppressWarnings({ "static-method", "boxing", "null" }) @Test public void test() {
    final List<Integer> li = new ArrayList<>();
    li.add(0, 0);
    li.add(1, 1);
    li.add(2, 2);
    li.add(3, 3);
    azzert.assertTrue(lisp.chop(li).size() == 3);
    azzert.assertTrue(lisp.chop(new ArrayList<Integer>()) == null);
    azzert.assertTrue(lisp.cons(0, li).size() == 4);
    azzert.assertTrue(lisp.next(5, li).equals(3));
    azzert.assertTrue(lisp.next(0, li).equals(1));
    azzert.assertTrue(lisp.get(null, 5) == null);
    azzert.assertTrue(lisp.get(li, 0).equals(1));
    azzert.assertTrue(lisp.prev(0, li).equals(0));
    azzert.assertTrue(lisp.prev(3, li).equals(2));
    azzert.assertTrue(lisp.replace(li, 1, 0).get(0).equals(1));
    azzert.assertTrue(lisp.replace(li, 0, 0).get(0).equals(0));
    azzert.assertTrue(lisp.replace(null, 0, 0) == null);
    azzert.assertTrue(lisp.replace(new ArrayList<Integer>(), 0, 2).equals(new ArrayList<Integer>()));
    azzert.assertTrue(lisp.replaceFirst(li, 1).get(0).equals(1));
    azzert.assertTrue(lisp.replaceLast(li, 1).get(3).equals(1));
    azzert.assertTrue(lisp.chopLast(li).size() == 3);
    azzert.assertTrue(lisp.areEqual("1", "1", "1", "1"));
    final List<Integer> li2 = new ArrayList<>();
    li2.add(0, 0);
    li2.add(1, 1);
    li2.add(2, 2);
    li2.add(3, 3);
    lisp.removeLast(li2);
    azzert.assertTrue(li2.size() == 3);
    azzert.assertTrue(lisp.swap(li2, 0, 1).get(0).equals(1));
    azzert.assertTrue(lisp.swap(li2, 0, 100) == li2);
    azzert.assertTrue(lisp.swap(li2, 100, 0) == li2);
    final Set<Integer> s = new HashSet<>();
    s.add(1);
    lisp.removeFromList(s, li2);
    azzert.assertTrue(li2.size() == 2);
    azzert.assertTrue(lisp.chopLast("123").equals("12"));
  }
}
