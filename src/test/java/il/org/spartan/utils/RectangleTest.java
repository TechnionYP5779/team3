package il.org.spartan.utils;

import org.junit.*;
import il.org.spartan.etc.*;

public class RectangleTest {
  @Test @SuppressWarnings("static-method") public void test() {
    final Rectangle rec = new Rectangle(1.0, 1.0, 2.0, 2.0);
    assert rec != null;
    assert rec.firstX() == 1.0;
    assert rec.firstY() == 1.0;
    assert rec.secondX() == 2.0;
    assert rec.secondY() == 2.0;
    assert rec.area() == 1.0;
    rec.changeFirst(0.0, 0.0);
    assert rec.area() == 4.0;
    rec.changeSecond(0.0, 1.0);
    assert rec.area() == 0.0;
    rec.changeSecond(2.0, 1.0);
    assert rec.perimiter() == 6.0;
  }
}
