package il.org.spartan.utils;

import java.util.*;
import java.util.stream.*;
import static il.org.spartan.Utils.*;
import fluent.ly.*;

public class RealList {
  private List<Pair<Double, Double>> li;
  private List<Double> x;
  private List<Double> y;

  public RealList() {
    li = new ArrayList<>();
    x = new ArrayList<>();
    y = new ArrayList<>();
  }

  public void record(double d, double e) {
    li.add(new Pair<>(box.box(d), box.box(e)));
    x.add(box.box(d));
    y.add(box.box(e));
  }

  public int count() {
    return li.size();
  }

  public static double first(Pair<Double, Double> x) {
    return unbox.unbox( cantBeNull(x.first));
  }

  public static double second(Pair<Double, Double> x) {
    return unbox.unbox( cantBeNull(x.second));
  }

  public Iterator<Pair<Double, Double>> iteratorX() {
    List<Pair<Double, Double>> $ = new ArrayList<>(li);
    forget.it($);
    Collections.sort($, new Comparator<Pair<Double, Double>>() {
      @Override public int compare(final Pair<Double, Double> first, final Pair<Double, Double> second) {
        return (int) (first(first) - first(second));
      }
    });
    return $.iterator();
  }

  public Iterator<Pair<Double, Double>> iteratorY() {
    List<Pair<Double, Double>> $ = new ArrayList<>(li);
    Collections.sort($, new Comparator<Pair<Double, Double>>() {
      @Override public int compare(final Pair<Double, Double> first, final Pair<Double, Double> second) {
        return (( first.second).intValue() - ( second.second).intValue());
      }
    });
    return $.iterator();
  }

  public double LinearRegressionpredict(double predictForDependentVariable) {
    Integer $ = box.box(x.size());
    List<Double> xSquared = x.stream().map(position -> box.box(Math.pow(unbox.unbox(cantBeNull(position)), 2))).collect(Collectors.toList()),
        xMultipliedByY = IntStream.range(0, unbox.unbox(cantBeNull($))).mapToDouble(λ -> unbox.unbox(cantBeNull(x.get(λ))) * unbox.unbox(cantBeNull(y.get(λ)))).boxed()
            .collect(Collectors.toList());
    Double xSummed = x.stream().reduce((prev, next) -> box.box(unbox.unbox(cantBeNull(prev)) + unbox.unbox(cantBeNull(next)))).get(),
        ySummed = y.stream().reduce((prev, next) -> box.box(unbox.unbox(cantBeNull(prev)) + unbox.unbox(cantBeNull(next)))).get(),
        sumOfXMultipliedByY = xMultipliedByY.stream().reduce((prev, next) -> box.box(unbox.unbox(cantBeNull(prev)) + unbox.unbox(cantBeNull(next)))).get();
    double slopeNominator = unbox.unbox(cantBeNull($)) * unbox.unbox(cantBeNull(sumOfXMultipliedByY)) - unbox.unbox(cantBeNull(ySummed)) * unbox.unbox(cantBeNull(xSummed)),
        slopeDenominator = unbox.unbox(cantBeNull($))
            * unbox.unbox(cantBeNull(xSquared.stream().reduce((prev, next) -> box.box(unbox.unbox(cantBeNull(prev)) + unbox.unbox(cantBeNull(next)))).get()))
            - Math.pow(unbox.unbox(cantBeNull(xSummed)), 2);
    return slopeNominator * predictForDependentVariable / slopeDenominator
        + (unbox.unbox(cantBeNull(ySummed)) - slopeNominator / slopeDenominator * unbox.unbox(cantBeNull(xSummed))) / unbox.unbox(cantBeNull($));
  }

  public double averageX() {
    return x.isEmpty() ? 0 : unbox.unbox(cantBeNull(x.stream().reduce((prev, next) -> box.box(unbox.unbox(cantBeNull(prev)) + unbox.unbox(cantBeNull(next)))).get())) / x.size();
  }

  public double averageY() {
    return y.isEmpty() ? 0 : unbox.unbox(cantBeNull(y.stream().reduce((prev, next) -> box.box(unbox.unbox(cantBeNull(prev)) + unbox.unbox(cantBeNull(next)))).get())) / y.size();
  }
}
