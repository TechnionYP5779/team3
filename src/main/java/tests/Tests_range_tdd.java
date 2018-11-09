package tests;

import org.junit.*;

import fluent.ly.*;
//import il.org.spartan.utils.*;

public class Tests_range_tdd {
  
  @SuppressWarnings("static-method") @Test public void test() {
    //box2
    range a = range.from(2);
    assert a!=null;
    assert a.getClass().equals(range.class);
    
    //box3
    assert a.from()==2;
    assert range.from(2).from()==2;
  }
}