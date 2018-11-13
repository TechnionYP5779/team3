package tests;

import org.junit.*;

import fluent.ly.*;
//import il.org.spartan.utils.*;
import fluent.ly.range.*;

public class Tests_range_tdd {
  
  @SuppressWarnings({ "static-method", "unused", "null" }) @Test public void test() {
    //box2
    range r=new range();
    inner_range a = range.from(2);
    azzert.assertTrue( a!=null);
    azzert.assertTrue( a.getClass().equals(inner_range.class));
    
    //box3
    azzert.assertTrue( a.from().equals(Integer.valueOf(2)));
    azzert.assertTrue( range.from(2).from().equals(Integer.valueOf(2)));
    
    //box4
    azzert.assertTrue( a.to(6).getClass().equals(inner_range.class));
    azzert.assertTrue( range.from(2).to(6).getClass().equals(inner_range.class));
    
    //box5
    inner_range b = range.to(2);
    azzert.assertTrue( b!=null);
    azzert.assertTrue( b.getClass().equals(inner_range.class));
    
    //box6
    azzert.assertTrue( a.to(6).from().equals(Integer.valueOf(2)));
    azzert.assertTrue( b.from()==null);
    azzert.assertTrue( range.to(2).from()==null);
  }
}