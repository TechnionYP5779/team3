package fluent.ly;

import java.util.*;
import static fluent.ly.box.*;
import org.junit.*;

// import il.org.spartan.utils.*;
import fluent.ly.range.*;

public class rangeTest {
  @Test @SuppressWarnings("static-method") public void test() {
    final inner_range a = range.from(2);
    assert a != null;
    assert a.getClass().equals(inner_range.class);
    assert a.from().equals(box(2));
    assert range.from(2).from().equals(box(2));
    assert a.to(6).getClass().equals(inner_range.class);
    assert range.from(2).to(6).getClass().equals(inner_range.class);
    final inner_range b = range.to(2);
    assert b != null;
    assert b.getClass().equals(inner_range.class);
    assert a.to(6).from().equals(box(2));
    assert b.from() == null;
    assert range.to(2).from() == null;
    assert b.from(3).from().equals(box(3));
    assert range.to(2).from(3).from().equals(box(3));
    assert b.from().equals(box(3));
    final Iterator<Integer> iter = range.from(-2).numbers();
    for (int ¢ = -1; ¢ < 2; ++¢) {
      assert iter.hasNext();
      assert iter.next().equals(box(¢));
    }
    final Iterator<Integer> iter2 = range.to(Integer.MIN_VALUE + 3).numbers();
    for (int ¢ = Integer.MIN_VALUE + 1; ¢ < Integer.MIN_VALUE + 3; ++¢) {
      assert iter2.hasNext();
      assert iter2.next().equals(box(¢));
    }
    assert !iter2.hasNext();
    final Iterator<Integer> iter3 = range.to(10).from(0).numbers();
    for (int ¢ = 1; ¢ < 10; ++¢) {
      assert iter3.hasNext();
      assert iter3.next().equals(box(¢));
    }
    assert !iter3.hasNext();
    assert range.to(10).interset(range.from(3)).from().equals(box(3));
    final Iterator<Integer> iter4 = range.to(10).interset(range.from(3)).numbers();
    for (int ¢ = 4; ¢ < 10; ++¢) {
      assert iter4.hasNext();
      assert iter4.next().equals(box(¢));
    }
    assert !iter4.hasNext();
    assert range.to(10).from(5).interset(range.from(3).to(8)).from().equals(box(5));
    final Iterator<Integer> iter5 = range.to(10).from(5).interset(range.from(3).to(8)).numbers();
    for (int ¢ = 6; ¢ < 8; ++¢) {
      assert iter5.hasNext();
      assert iter5.next().equals(box(¢));
    }
    assert !iter5.hasNext();
    assert range.to(10).interset(range.to(Integer.MIN_VALUE + 3)).from() == null;
    final Iterator<Integer> iter6 = range.to(10).interset(range.to(Integer.MIN_VALUE + 3)).numbers();
    for (int ¢ = Integer.MIN_VALUE + 1; ¢ < Integer.MIN_VALUE + 3; ++¢) {
      assert iter6.hasNext();
      assert iter6.next().equals(box(¢));
    }
    assert !iter6.hasNext();
    assert range.from(10).interset(range.from(3)).from().equals(box(10));
    assert range.from(2).to(5).includes(4);
    assert range.from(2).to(5).includes(2);
    assert range.from(2).to(5).includes(3);
    assert !range.from(2).to(5).includes(5);
    assert !range.from(2).to(5).includes(0);
    assert !range.from(2).includes(1);
    assert range.from(2).includes(2);
    assert range.from(2).includes(7);
    assert !range.to(2).includes(2);
    assert !range.to(2).includes(3);
    assert range.to(2).includes(1);
    final inner_range b1 = new inner_range(); 
    assert b1.includes(1);
    
    final inner_range a1 = range.from(2);
    final inner_range a2 = range.from(1);
    final range r = new range(); 
    assert(r != null); 
    assert((a1.interset(b1)).from == box(2)); 
    assert((a2.interset(a1).from == box(2)));
    
    final inner_range c1 = range.to(2);
    final inner_range c2 = range.to(1);
    assert((c2.interset(c1).to == box(1)));
    
  }
}