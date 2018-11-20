package fluent.ly;

import java.util.*;

import org.junit.*;

public class TheTest {
  @Test @SuppressWarnings({ "null", "static-method" }) public void testos() {
    assert the.nil() == null;
    assert " #1/2".equals(the.nth("1", "2"));
    assert " #1/2".equals(the.nth(1, 2));
    assert " #1/0".equals(the.nth(1, new ArrayList<Integer>()));
    assert the.penultimateOf(new ArrayList<Integer>()) == null;
    final List<Integer> li = new ArrayList<>();
    li.add(0, box.box(0));
    li.add(1, box.box(1));
    li.add(2, box.box(2));
    li.add(3, box.box(3));
    assert the.previous(box.box(1), li).equals(box.box(0));
    assert the.previous(box.box(1), null) == null;
    assert the.tailOf(li).size() == 3;
    assert "23".equals(the.tailOf("123"));
    assert the.rest(box.box(1), li).size() == 2;
    assert the.headOf(li).equals(box.box(0));
    assert the.headOf(null) == null;
    assert the.headOf(new ArrayList<Integer>()) == null;
    assert the.ith("123", 0) == '1';
    assert the.max(0, 1, 2, 3, 4, 5) == 5;
    assert the.min(0, 1, 2, 3, 4, 5) == 0;
    Integer[] anArray = new Integer[10];
    anArray[0] = box.box(100);
    anArray[1] = box.box(200);
    anArray[2] = box.box(300);
    anArray[3] = box.box(400);
    anArray[4] = box.box(500);
    anArray[5] = box.box(600);
    anArray[6] = box.box(700);
    anArray[7] = box.box(800);
    anArray[8] = box.box(900);
    anArray[9] = box.box(1000);
    assert the.lastOf(anArray).equals(box.box(1000));
    assert the.tailOf(anArray).length == 9;
    assert the.sqr(2) == 4;
    assert the.lastOf(li).equals(box.box(3));
  }
}
