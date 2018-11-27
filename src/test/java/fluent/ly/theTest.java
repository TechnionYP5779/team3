package fluent.ly;

import java.util.*;
import static fluent.ly.box.*;
import org.junit.*;

@SuppressWarnings("static-method") public class theTest {
  @Test @SuppressWarnings("null") public void testos() {
    assert the.nil() == null;
    assert " #1/2".equals(the.nth("1", "2"));
    assert " #1/2".equals(the.nth(1, 2));
    assert " #1/0".equals(the.nth(1, new ArrayList<Integer>()));
    assert the.penultimateOf(new ArrayList<Integer>()) == null;
    final List<Integer> li = new ArrayList<>();
    li.add(0, box(0));
    li.add(1, box(1));
    li.add(2, box(2));
    li.add(3, box(3));
    assert the.previous(box(1), li).equals(box(0));
    assert the.previous(box(1), null) == null;
    assert the.tailOf(li).size() == 3;
    assert "23".equals(the.tailOf("123"));
    assert the.rest(box(1), li).size() == 2;
    assert the.headOf(li).equals(box(0));
    assert the.headOf(null) == null;
    assert the.headOf(new ArrayList<Integer>()) == null;
    assert the.ith("123", 0) == '1';
    assert the.max(0, 1, 2, 3, 4, 5) == 5;
    assert the.min(0, 1, 2, 3, 4, 5) == 0;
    Integer[] anArray = new Integer[10];
    anArray[0] = box(100);
    anArray[1] = box(200);
    anArray[2] = box(300);
    anArray[3] = box(400);
    anArray[4] = box(500);
    anArray[5] = box(600);
    anArray[6] = box(700);
    anArray[7] = box(800);
    anArray[8] = box(900);
    anArray[9] = box(1000);
    assert the.lastOf(anArray).equals(box(1000));
    assert the.tailOf(anArray).length == 9;
    assert the.sqr(2) == 4;
    assert the.lastOf(li).equals(box(3));
    final List<String> li2 = new ArrayList<>();
    li2.add(0, "1");
    assert("1".equals(the.onlyOneOf(li2)));
    assert(the.onlyOneOf(null)==null);
    li2.add(1,"2");
    assert("2".equals(the.secondOf(li2)));
    assert(the.secondOf(null)==null);
    
    
  }
}
