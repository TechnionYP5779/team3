package il.org.spartan.utils;

import java.util.*;
import java.util.stream.*;

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

  @SuppressWarnings({ "unchecked", "rawtypes"}) public void record(double d, double e) {
    li.add(new Pair(box.box(d),box.box(e)));
    x.add(box.box(d));
    y.add(box.box(e));

  }

  public int count() {
    return li.size();
  }
 @SuppressWarnings({ "rawtypes", "null"}) public static double first(Pair x){
    return unbox.unbox((Double) x.first);
  }
 @SuppressWarnings({ "rawtypes", "null" }) public static double second(Pair x){
   return unbox.unbox((Double) x.first);
 }
  

  @SuppressWarnings({ "rawtypes", "unchecked" }) public Iterator iteratorX() {
    @SuppressWarnings("unused") List $ = new ArrayList<Pair<Double, Double>>(li);
    Collections.sort($, new Comparator<Pair<Double, Double>>() {
      @Override public int compare(final Pair first, final Pair second) {
        return (int) (first(first) - first(second));
      }
    });
    return $.iterator();
  }

  @SuppressWarnings({ "rawtypes", "unchecked" }) public Iterator iteratorY() {
    List $=new ArrayList<>(li);
    
    Collections.sort($,new Comparator<Pair<Double,Double>>(){
      @Override public int compare(final Pair first,final Pair second){
        return (((Double) first.second).intValue() -  ((Double) second.second).intValue());
      }
    });
    return $.iterator();
  }


    @SuppressWarnings("null") public double LinearRegressionpredict(double predictForDependentVariable) {

    Integer numberOfDataValues = box.box(x.size());

    List<Double> xSquared = x
            .stream()
            .map(position -> box.box(Math.pow(unbox.unbox(position), 2)))
            .collect(Collectors.toList());

    List<Double> xMultipliedByY = IntStream.range(0, unbox.unbox(numberOfDataValues))
            .mapToDouble(i -> unbox.unbox(x.get(i)) * unbox.unbox(y.get(i)))
            .boxed()
            .collect(Collectors.toList());

    Double xSummed = x
            .stream()
            .reduce((prev, next) -> box.box(unbox.unbox(prev) +unbox.unbox(next)))
            .get();

    Double ySummed = y
            .stream()
            .reduce((prev, next) -> box.box(unbox.unbox(prev) +unbox.unbox(next)))
            .get();

    Double sumOfXSquared = xSquared
            .stream()
            .reduce((prev, next) -> box.box(unbox.unbox(prev) +unbox.unbox(next)))
            .get();

    Double sumOfXMultipliedByY = xMultipliedByY
            .stream()
            .reduce((prev, next) -> box.box(unbox.unbox(prev) +unbox.unbox(next)))
            .get();

    double slopeNominator = unbox.unbox(numberOfDataValues) * unbox.unbox(sumOfXMultipliedByY) - unbox.unbox(ySummed) * unbox.unbox(xSummed);
    double slopeDenominator = unbox.unbox(numberOfDataValues) * unbox.unbox(sumOfXSquared) - Math.pow(xSummed, 2);
    double slope = slopeNominator / slopeDenominator;

    double interceptNominator = unbox.unbox(ySummed) - slope * unbox.unbox(xSummed);
    double interceptDenominator = unbox.unbox(numberOfDataValues);
    double intercept = interceptNominator / interceptDenominator;

    return (slope * predictForDependentVariable) + intercept;
    }
    @SuppressWarnings("null") public double averageX(){
      return x.isEmpty() ? 0 : unbox.unbox(x.stream().reduce((prev, next) -> box.box(unbox.unbox(prev) + unbox.unbox(next))).get()) / x.size();
    }
    @SuppressWarnings({ "null" }) public double averageY(){
      return y.isEmpty() ? 0 : unbox.unbox(y.stream().reduce((prev, next) -> box.box(unbox.unbox(prev) + unbox.unbox(next))).get()) / y.size();
    }
  
}
