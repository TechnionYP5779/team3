package il.org.spartan.etc;

import fluent.ly.*;
import il.org.spartan.utils.*;

public class Rectangle {
  Pair<Double, Double> first;
  Pair<Double, Double> second;

  @SuppressWarnings({ "rawtypes", "unchecked" }) public Rectangle(final double x1, final double y1, final double x2, final double y2) {
    first = new Pair(box.box(x1), box.box(y1));
    second = new Pair(box.box(x2), box.box(y2));
  }

  @SuppressWarnings("null") public double firstX() {
    return unbox.unbox(first.first);
  }

  @SuppressWarnings("null") public double firstY() {
    return unbox.unbox(first.second);
  }

  @SuppressWarnings("null") public double secondX() {
    return unbox.unbox(second.first);
  }

  @SuppressWarnings({ "null" }) public double secondY() {
    return unbox.unbox(second.second);
  }

  @SuppressWarnings("null") public double area() {
    return Math.abs((unbox.unbox(first.first) - unbox.unbox(second.first)) * (unbox.unbox(first.second) - unbox.unbox(second.second)));
  }

  @SuppressWarnings({ "rawtypes", "unchecked" }) public void changeFirst(final double x1, final double y1) {
    first = new Pair(box.box(x1), box.box(y1));
  }

  @SuppressWarnings({ "rawtypes", "unchecked" }) public void changeSecond(final double x2, final double y2) {
    second = new Pair(box.box(x2), box.box(y2));
  }

  @SuppressWarnings("null") public double perimiter() {
    return Math.abs(2.0 * (unbox.unbox(first.first) - unbox.unbox(second.first)))
        + 2.0 * Math.abs(unbox.unbox(first.second) - unbox.unbox(second.second));
  }
}
