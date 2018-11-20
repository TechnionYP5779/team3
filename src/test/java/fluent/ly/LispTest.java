package fluent.ly;

import static il.org.spartan.Utils.*;

import static fluent.ly.box.*;



import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;


@SuppressWarnings( "static-method" ) public class LispTest {
  @Test public void test() {
    final @Nullable List<@Nullable Integer> li = new ArrayList<>();
    li.add(0, box(0));
    li.add(1, box(1));
    li.add(2, box(2));
    li.add(3, box(3));
    assert cantBeNull(lisp.chop(li)).size() == 3;
    assert lisp.chop(new ArrayList<Integer>()) == null;
    assert lisp.cons(box(0), li).size() == 4;
    assert cantBeNull(lisp.next(5, li)).equals(box(3));
    assert cantBeNull(lisp.next(0, li)).equals(box(1));
    assert lisp.get(null, 5) == null;
    assert cantBeNull(lisp.get(li, 0)).equals(box(1));
    assert cantBeNull(lisp.prev(0, li)).equals(box(0));
    assert cantBeNull(lisp.prev(3, li)).equals(box(2));
    assert cantBeNull(cantBeNull(lisp.replace(li, box(1), 0)).get(0)).equals(box(1));
    assert cantBeNull(cantBeNull(lisp.replace(li, box(0), 0)).get(0)).equals(box(0));
    assert lisp.replace(null, box(0), 0) == null;
    assert cantBeNull(lisp.replace(new ArrayList<Integer>(), box(0), 2)).equals(new ArrayList<Integer>());
    assert cantBeNull(cantBeNull(lisp.replaceFirst(li, box(1))).get(0)).equals(box(1));
    assert cantBeNull(cantBeNull(lisp.replaceLast(li, box(1))).get(3)).equals(box(1));
    assert lisp.chopLast(li).size() == 3;
    assert lisp.areEqual("1", "1", "1", "1");
    final List<Integer> li2 = new ArrayList<>();
    li2.add(0, box(0));
    li2.add(1, box(1));
    li2.add(2, box(2));
    li2.add(3, box(3));
    lisp.removeLast(li2);
    assert li2.size() == 3;
    assert lisp.swap(li2, 0, 1).get(0).equals(box(1));
    assert lisp.swap(li2, 0, 100) == li2;
    assert lisp.swap(li2, 100, 0) == li2;
    final Set<Integer> s = new HashSet<>();
    s.add(box(1));
    lisp.removeFromList(s, li2);
    assert li2.size() == 2;
    assert "12".equals(lisp.chopLast("123"));
  }
}
