package il.org.spartan.utils;

import static il.org.spartan.Utils.*;

import static fluent.ly.box.*;
import static fluent.ly.unbox.*;

import java.util.*;
import java.util.stream.*;

import fluent.ly.*;

public class RealList {
  private final List<Pair<Double, Double>> li;
  private final List<Double> x;
  private final List<Double> y;

  public RealList() {
    li = new ArrayList<>();
    x = new ArrayList<>();
    y = new ArrayList<>();
  }

  public void record(final double d, final double e) {
    li.add(new Pair<>(box(d), box(e)));
    x.add(box(d));
    y.add(box(e));
  }

  public int count() {
    return li.size();
  }

  public static double first(final Pair<Double, Double> x) {
    return unbox(cantBeNull(x.first));
  }

  public Iterator<Pair<Double, Double>> iteratorX() {
    final List<Pair<Double, Double>> $ = new ArrayList<>(li);
    forget.it($);
    Collections.sort($, (first, second) -> (int) (first(first) - first(second)));
    return $.iterator();
  }

  public Iterator<Pair<Double, Double>> iteratorY() {
    final List<Pair<Double, Double>> $ = new ArrayList<>(li);
    Collections.sort($, (first, second) -> (first.second.intValue() - second.second.intValue()));
    return $.iterator();
  }

  public double LinearRegressionpredict(final double predictForDependentVariable) {
    final Integer $ = box(x.size());
    final List<Double> xSquared = x.stream().map(position -> box(Math.pow(unbox(cantBeNull(position)), 2))).collect(Collectors.toList()),
        xMultipliedByY = IntStream.range(0, unbox(cantBeNull($))).mapToDouble(λ -> unbox(cantBeNull(x.get(λ))) * unbox(cantBeNull(y.get(λ)))).boxed()
            .collect(Collectors.toList());
    final Double xSummed = x.stream().reduce((prev, next) -> box(unbox(cantBeNull(prev)) + unbox(cantBeNull(next)))).get(),
        ySummed = y.stream().reduce((prev, next) -> box(unbox(cantBeNull(prev)) + unbox(cantBeNull(next)))).get(),
        sumOfXMultipliedByY = xMultipliedByY.stream().reduce((prev, next) -> box(unbox(cantBeNull(prev)) + unbox(cantBeNull(next)))).get();
    final double slopeNominator = unbox(cantBeNull($)) * unbox(cantBeNull(sumOfXMultipliedByY))
        - unbox(cantBeNull(xSummed)) * unbox(cantBeNull(ySummed)),
        slopeDenominator = unbox(cantBeNull($))
            * unbox(cantBeNull(xSquared.stream().reduce((prev, next) -> box(unbox(cantBeNull(prev)) + unbox(cantBeNull(next)))).get()))
            - Math.pow(unbox(cantBeNull(xSummed)), 2);
    return slopeNominator * predictForDependentVariable / slopeDenominator
        + (unbox(cantBeNull(ySummed)) - slopeNominator / slopeDenominator * unbox(cantBeNull(xSummed))) / unbox(cantBeNull($));
  }

  public double averageX() {
    return x.isEmpty() ? 0
        : unbox(cantBeNull(x.stream().reduce((prev, next) -> box(unbox(cantBeNull(prev)) + unbox(cantBeNull(next)))).get())) / x.size();
  }

  public double averageY() {
    return y.isEmpty() ? 0
        : unbox(cantBeNull(y.stream().reduce((prev, next) -> box(unbox(cantBeNull(prev)) + unbox(cantBeNull(next)))).get())) / y.size();
  }
}
