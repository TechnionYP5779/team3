package il.org.spartan.utils;

import java.util.*;
import java.util.stream.*;

public class RealList {
  private List<Pair<Double,Double>> li;
  private List<Double> x;
  private List<Double> y;
  
  public RealList(){
    li=new ArrayList<>();
    x=new ArrayList<>();
    y=new ArrayList<>();
  }

  @SuppressWarnings({ "unchecked", "rawtypes", "boxing" }) public void record(double d, double e) {
    li.add(new Pair(d,e));
    x.add(d);
    y.add(e);
  }

  public int count() {
    return li.size();
  }
 @SuppressWarnings({ "rawtypes", "boxing" }) public static double first(Pair x){
    return 1. * x.first;
  }
 @SuppressWarnings({ "rawtypes", "boxing" }) public static double second(Pair x){
   return 1. * x.first;
 }
  


  @SuppressWarnings({ "rawtypes", "unchecked" }) public Iterator iteratorX() {
    @SuppressWarnings("unused") List $=new ArrayList<Pair<Double,Double>>(li);
    
    Collections.sort($,new Comparator<Pair<Double,Double>>(){
      @Override public int compare(final Pair first,final Pair second){
        return (int) (first(first)- first(second));
      }
    });
    return $.iterator();
  }
  
  @SuppressWarnings({ "rawtypes", "unchecked" }) public Iterator iteratorY() {
    @SuppressWarnings("unused") List $=new ArrayList<Pair<Double,Double>>(li);
    
    Collections.sort($,new Comparator<Pair<Double,Double>>(){
      @Override public int compare(final Pair first,final Pair second){
        return (((Double) (first).second).intValue() -  ((Double) second.second).intValue());
      }
    });
    return $.iterator();
  }


    @SuppressWarnings("boxing") public double LinearRegressionpredict(double predictForDependentVariable) {
        if (x.size() != y.size())
            throw new IllegalStateException("Must have equal X and Y data points");

        Integer numberOfDataValues = x.size();

        List<Double> xSquared = x
                .stream()
                .map(position -> Math.pow(position, 2))
                .collect(Collectors.toList());

        List<Double> xMultipliedByY = IntStream.range(0, numberOfDataValues)
                .mapToDouble(i -> x.get(i) * y.get(i))
                .boxed()
                .collect(Collectors.toList());

        Double xSummed = x
                .stream()
                .reduce((prev, next) -> prev + next)
                .get();

        Double ySummed = y
                .stream()
                .reduce((prev, next) -> prev + next)
                .get();

        Double sumOfXSquared = xSquared
                .stream()
                .reduce((prev, next) -> prev + next)
                .get();

        Double sumOfXMultipliedByY = xMultipliedByY
                .stream()
                .reduce((prev, next) -> prev + next)
                .get();

        double slopeNominator = numberOfDataValues * sumOfXMultipliedByY - ySummed * xSummed;
        Double slopeDenominator = numberOfDataValues * sumOfXSquared - Math.pow(xSummed, 2);
        Double $ = slopeNominator / slopeDenominator;

        double interceptNominator = ySummed - $ * xSummed;
        double interceptDenominator = numberOfDataValues;
        Double intercept = interceptNominator / interceptDenominator;

        return ($ * predictForDependentVariable) + intercept;
    }
    @SuppressWarnings("boxing") public double averageX(){
      if(x.size()==0)
        return 0;
      Double $ = x
          .stream()
          .reduce((prev, next) -> prev + next)
          .get();
      return $/ x.size();
    }
    @SuppressWarnings("boxing") public double averageY(){
      if(y.size()==0)
        return 0;
      Double $ = y
          .stream()
          .reduce((prev, next) -> prev + next)
          .get();
      return $/ y.size();
    }
  
}
