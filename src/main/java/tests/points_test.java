package tests;



import java.util.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.*;

public class points_test {
  @SuppressWarnings({ "static-method", "rawtypes", "boxing" }) @Test public void MajorGeneralTest() {
   RealList li= new RealList();
   li.record(1.0,1.0);
   azzert.assertTrue(li.count()==1);
   li.record(2.0, 2.0);
   li.record(3.0, 1.3);
   li.record(4.0, 3.75);
   li.record(5.0, 2.25);
   
   azzert.assertTrue(Math.abs(li.LinearRegressionpredict(1)-1.21) <=0.001);
   azzert.assertTrue(Math.abs(li.LinearRegressionpredict(2)-1.64) <=0.01);
   azzert.assertTrue(li.averageX()==3.0);
   azzert.assertTrue(li.averageY()==2.06);
   
   Iterator<Pair> ite=li.iteratorX();

   azzert.assertTrue(ite.next().first .equals(1.0));
   azzert.assertTrue(ite.next().first .equals(2.0));
   Iterator<Pair> ite2=li.iteratorY();
   azzert.assertTrue(ite2.next().second .equals(1.0));
   
   azzert.assertTrue(ite2.next().second .equals(1.3));
   
   
  }
  
}
