package tests;

import java.util.*;

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
    
    //box7
    azzert.assertTrue( b.from(3).from().equals(Integer.valueOf(3)));
    azzert.assertTrue( range.to(2).from(3).from().equals(Integer.valueOf(3)));
    azzert.assertTrue( b.from().equals(Integer.valueOf(3)));
    
    //box8
    
    Iterator<Integer> iter = range.from(-2).numbers();
    for (int i=-1; i<2; i++) {
      azzert.assertTrue(iter.hasNext());
      azzert.assertTrue(iter.next().equals(Integer.valueOf(i)));
    }
    Iterator<Integer> iter2 = range.to(Integer.MIN_VALUE+3).numbers();
    
    for (int i=Integer.MIN_VALUE+1; i <(Integer.MIN_VALUE+3);i++) {
      azzert.assertTrue(iter2.hasNext());
      azzert.assertTrue(iter2.next().equals(Integer.valueOf(i)));
    }
    azzert.assertTrue(!iter2.hasNext());
    
    Iterator<Integer> iter3 = range.to(10).from(0).numbers();
    for (int i=1; i <10 ;i++) {
      azzert.assertTrue(iter3.hasNext());
      azzert.assertTrue(iter3.next().equals(Integer.valueOf(i)));
    }
    azzert.assertTrue(!iter3.hasNext());
    
  }
}