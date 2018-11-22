package il.org.spartan.etc;

import static il.org.spartan.Utils.*;

import il.org.spartan.utils.*;
import static fluent.ly.unbox.*;
import static fluent.ly.box.*;
public class Rectangle {
  Pair<Double, Double> first;
  Pair<Double, Double> second;

  public Rectangle(final double x1, final double y1, final double x2, final double y2) {
    first = new Pair<>(box(x1), box(y1));
    second = new Pair<>(box(x2), box(y2));
  }

  public double firstX() {
    return unbox(cantBeNull(first.first));
  }

  public double firstY() {
    return unbox(cantBeNull(first.second));
  }

  public double secondX() {
    return unbox(cantBeNull(second.first));
  }

  public double secondY() {
    return unbox(cantBeNull(second.second));
  }

  public double area() {
    return Math.abs((unbox(cantBeNull(first.first)) - unbox(cantBeNull(second.first))) * (unbox(cantBeNull(first.second)) - unbox(cantBeNull(second.second))));
  }

  public void changeFirst(final double x1, final double y1) {
    first = new Pair<>(box(x1), box(y1));
  }

  public void changeSecond(final double x2, final double y2) {
    second = new Pair<>(box(x2), box(y2));
  }

  public double perimiter() {
    return Math.abs(2.0 * (unbox(cantBeNull(first.first)) - unbox(cantBeNull(second.first))))
        + 2.0 * Math.abs(unbox(cantBeNull(first.second)) - unbox(cantBeNull(second.second)));

  }
}
