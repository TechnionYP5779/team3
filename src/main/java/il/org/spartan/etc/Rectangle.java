package il.org.spartan.etc;

import il.org.spartan.utils.*;

public class Rectangle {
  Pair<Double,Double> first;
  Pair<Double,Double> second;
  @SuppressWarnings({ "rawtypes", "unchecked", "boxing" }) public Rectangle(double x1 ,double y1 , double x2 ,double y2){
    first=new Pair(x1,y1);
    second=new Pair(x2,y2);
  }
  @SuppressWarnings("boxing") public double firstX() {
    return first.first;
  }
  @SuppressWarnings("boxing") public double firstY() {
    return first.second;
  }
  @SuppressWarnings("boxing") public double secondX() {
    return second.first;
  }
  @SuppressWarnings("boxing") public double secondY() {
    return second.second;
  }
  @SuppressWarnings("boxing") public double area() {
    return Math.abs((first.first- second.first)*(first.second-second.second) );
  }
  @SuppressWarnings({ "rawtypes", "unchecked", "boxing" }) public void changeFirst(double x1, double y1) {
    first=new Pair(x1,y1);
    
  }
  @SuppressWarnings({ "rawtypes", "unchecked", "boxing" }) public void changeSecond(double x2, double y2) {
    second=new Pair(x2,y2);
    
  }
  @SuppressWarnings("boxing") public double perimiter() {
    return Math.abs(2.0 * (first.first - second.first)) + 2.0 * Math.abs(first.second - second.second) ;
  }
  
}
