package fluent.ly;

import java.util.*;

import org.junit.*;


public class LispTest {
  @Test @SuppressWarnings({ "static-method", "boxing", "null" }) public void test() {
    final List<Integer> li = new ArrayList<>();
    li.add(0, 0);
    li.add(1, 1);
    li.add(2, 2);
    li.add(3, 3);
    assert lisp.chop(li).size() == 3;
    assert lisp.chop(new ArrayList<Integer>()) == null;
    assert lisp.cons(0, li).size() == 4;
    assert lisp.next(5, li).equals(3);
    assert lisp.next(0, li).equals(1);
    assert lisp.get(null, 5) == null;
    assert lisp.get(li, 0).equals(1);
    assert lisp.prev(0, li).equals(0);
    assert lisp.prev(3, li).equals(2);
    assert lisp.replace(li, 1, 0).get(0).equals(1);
    assert lisp.replace(li, 0, 0).get(0).equals(0);
    assert lisp.replace(null, 0, 0) == null;
    assert lisp.replace(new ArrayList<Integer>(), 0, 2).equals(new ArrayList<Integer>());
    assert lisp.replaceFirst(li, 1).get(0).equals(1);
    assert lisp.replaceLast(li, 1).get(3).equals(1);
    assert lisp.chopLast(li).size() == 3;
    assert lisp.areEqual("1", "1", "1", "1");
    final List<Integer> li2 = new ArrayList<>();
    li2.add(0, 0);
    li2.add(1, 1);
    li2.add(2, 2);
    li2.add(3, 3);
    lisp.removeLast(li2);
    assert li2.size() == 3;
    assert lisp.swap(li2, 0, 1).get(0).equals(1);
    assert lisp.swap(li2, 0, 100) == li2;
    assert lisp.swap(li2, 100, 0) == li2;
    final Set<Integer> s = new HashSet<>();
    s.add(1);
    lisp.removeFromList(s, li2);
    assert li2.size() == 2;
    assert "12".equals(lisp.chopLast("123"));
  }
}
