package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.etc.*;

public class RectangleTest {
  @SuppressWarnings({ "null", "static-method" }) @Test public void test() {
    final Rectangle rec = new Rectangle(1.0, 1.0, 2.0, 2.0);
    azzert.assertTrue(rec != null);
    azzert.assertTrue(rec.firstX() == 1.0);
    azzert.assertTrue(rec.firstY() == 1.0);
    azzert.assertTrue(rec.secondX() == 2.0);
    azzert.assertTrue(rec.secondY() == 2.0);
    azzert.assertTrue(rec.area() == 1.0);
    rec.changeFirst(0.0, 0.0);
    azzert.assertTrue(rec.area() == 4.0);
    rec.changeSecond(0.0, 1.0);
    azzert.assertTrue(rec.area() == 0.0);
    rec.changeSecond(2.0, 1.0);
    azzert.assertTrue(rec.perimiter() == 6.0);
  }
}
