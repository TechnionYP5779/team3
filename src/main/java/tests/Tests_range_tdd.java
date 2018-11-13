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
    
  //box9
    azzert.assertTrue(range.to(10).interset(range.from(3)).from().equals(Integer.valueOf(3)));
    Iterator<Integer> iter4 =range.to(10).interset(range.from(3)).numbers();
    for (int i=4; i <10 ;i++) {
      azzert.assertTrue(iter4.hasNext());
      azzert.assertTrue(iter4.next().equals(Integer.valueOf(i)));
    }
    azzert.assertTrue(!iter4.hasNext());
    
    azzert.assertTrue(range.to(10).from(5).interset(range.from(3).to(8)).from().equals(Integer.valueOf(5)));
    Iterator<Integer> iter5 =range.to(10).from(5).interset(range.from(3).to(8)).numbers();
    for (int i=6; i <8 ;i++) {
      azzert.assertTrue(iter5.hasNext());
      azzert.assertTrue(iter5.next().equals(Integer.valueOf(i)));
    }
    azzert.assertTrue(!iter5.hasNext());
    
    azzert.assertTrue(range.to(10).interset(range.to(Integer.MIN_VALUE+3)).from()==null);
    Iterator<Integer> iter6 =range.to(10).interset(range.to(Integer.MIN_VALUE+3)).numbers();
    for (int i=Integer.MIN_VALUE+1; i <(Integer.MIN_VALUE+3);i++) {
      azzert.assertTrue(iter6.hasNext());
      azzert.assertTrue(iter6.next().equals(Integer.valueOf(i)));
    }
    azzert.assertTrue(!iter6.hasNext());
    azzert.assertTrue(range.from(10).interset(range.from(3)).from().equals(Integer.valueOf(10)));
    
    //box10
    azzert.assertTrue(range.from(2).to(5).includes(4));
    azzert.assertTrue(range.from(2).to(5).includes(2));
    azzert.assertTrue(range.from(2).to(5).includes(3));
    azzert.assertTrue(!range.from(2).to(5).includes(5));
    azzert.assertTrue(!range.from(2).to(5).includes(0));
    
    azzert.assertTrue(!range.from(2).includes(1));
    azzert.assertTrue(range.from(2).includes(2));
    azzert.assertTrue(range.from(2).includes(7));
    
    azzert.assertTrue(!range.to(2).includes(2));
    azzert.assertTrue(!range.to(2).includes(3));
    azzert.assertTrue(range.to(2).includes(1));
  }
}