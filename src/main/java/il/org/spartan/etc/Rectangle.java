package il.org.spartan.etc;

import static il.org.spartan.Utils.*;

import fluent.ly.*;
import il.org.spartan.utils.*;

public class Rectangle {
  Pair<Double, Double> first;
  Pair<Double, Double> second;

  public Rectangle(final double x1, final double y1, final double x2, final double y2) {
    first = new Pair<>(box.box(x1), box.box(y1));
    second = new Pair<>(box.box(x2), box.box(y2));
  }

  public double firstX() {
    return unbox.unbox(cantBeNull(first.first));
  }

  public double firstY() {
    return unbox.unbox(cantBeNull(first.second));
  }

  public double secondX() {
    return unbox.unbox(cantBeNull(second.first));
  }

  public double secondY() {
    return unbox.unbox(cantBeNull(second.second));
  }

  public double area() {
    return Math.abs((unbox.unbox(cantBeNull(first.first)) - unbox.unbox(cantBeNull(second.first))) * (unbox.unbox(cantBeNull(first.second)) - unbox.unbox(cantBeNull(second.second))));
  }

  @SuppressWarnings({ "rawtypes", "unchecked" }) public void changeFirst(final double x1, final double y1) {
    first = new Pair(box.box(x1), box.box(y1));
  }

  @SuppressWarnings({ "rawtypes", "unchecked" }) public void changeSecond(final double x2, final double y2) {
    second = new Pair(box.box(x2), box.box(y2));
  }

  public double perimiter() {
    return Math.abs(2.0 * (unbox.unbox(cantBeNull(first.first)) - unbox.unbox(cantBeNull(second.first))))
        + 2.0 * Math.abs(unbox.unbox(first.second) - unbox.unbox(second.second));
  }
}
