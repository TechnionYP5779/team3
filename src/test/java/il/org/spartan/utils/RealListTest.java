package il.org.spartan.utils;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class RealListTest {
  @Test public void MajorGeneralTest() {
    final RealList li = new RealList();
    li.record(1.0, 1.0);
    assert li.count() == 1;
    li.record(2.0, 2.0);
    li.record(3.0, 1.3);
    li.record(4.0, 3.75);
    li.record(5.0, 2.25);
    assert Math.abs(li.LinearRegressionpredict(1) - 1.21) <= 0.001;
    assert Math.abs(li.LinearRegressionpredict(2) - 1.64) <= 0.01;
    assert li.averageX() == 3.0;
    assert li.averageY() == 2.06;
    final Iterator<Pair<Double, Double>> ite = li.iteratorX();
    assert ite.next().first.equals(box.box(1.0));
    assert ite.next().first.equals(box.box(2.0));
    final Iterator<Pair<Double, Double>> ite2 = li.iteratorY();
    assert ite2.next().second.equals(box.box(1.0));
    assert ite2.next().second.equals(box.box(1.3));
    final RealList li2 = new RealList();
    assert li2.averageX() == 0;
    assert li2.averageY() == 0;
  }
}
