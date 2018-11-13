package tests;

import org.junit.*;

import fluent.ly.*;
//import il.org.spartan.utils.*;
import fluent.ly.range.*;

public class Tests_range_tdd {
  
  @SuppressWarnings("static-method") @Test public void test() {
    //box2
    range r=new range();
    inner_range a = range.from(2);
    assert a!=null;
    assert a.getClass().equals(inner_range.class);
    
    //box3
    assert a.from()==2;
    assert range.from(2).from()==2;
    
    //box4
    assert a.to(6).getClass().equals(inner_range.class);
    assert range.from(2).to(6).getClass().equals(inner_range.class);
    
    //box5
    inner_range b = range.to(2);
    assert b!=null;
    assert b.getClass().equals(inner_range.class);
  }
}