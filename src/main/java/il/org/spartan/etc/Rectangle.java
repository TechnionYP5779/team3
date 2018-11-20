package il.org.spartan.etc;

import fluent.ly.*;
import il.org.spartan.utils.*;
import static fluent.ly.unbox.*;
import static fluent.ly.box.*;
public class Rectangle {
  Pair<Double, Double> first;
  Pair<Double, Double> second;

  @SuppressWarnings({ "rawtypes", "unchecked" }) public Rectangle(final double x1, final double y1, final double x2, final double y2) {
    first = new Pair(box(x1), box(y1));
    second = new Pair(box(x2), box(y2));
  }

  @SuppressWarnings("null") public double firstX() {
    return unbox(first.first);
  }

  @SuppressWarnings("null") public double firstY() {
    return unbox(first.second);
  }

  @SuppressWarnings("null") public double secondX() {
    return unbox(second.first);
  }

  @SuppressWarnings("null") public double secondY() {
    return unbox(second.second);
  }

  @SuppressWarnings("null") public double area() {
    return Math.abs((unbox(first.first) - unbox(second.first)) * (unbox(first.second) - unbox(second.second)));
  }

  @SuppressWarnings({ "rawtypes", "unchecked" }) public void changeFirst(final double x1, final double y1) {
    first = new Pair(box(x1), box(y1));
  }

  @SuppressWarnings({ "rawtypes", "unchecked" }) public void changeSecond(final double x2, final double y2) {
    second = new Pair(box(x2), box(y2));
  }

  @SuppressWarnings("null") public double perimiter() {
    return Math.abs(2.0 * (unbox(first.first) - unbox(second.first)))
        + 2.0 * Math.abs(unbox(first.second) - unbox(second.second));
  }
}
