package tests;
import java.util.*;
import org.junit.*;

import a.*;



public class singleTest {
  static int n = 5;
  
  @SuppressWarnings({ "cast", "boxing", "static-method" }) @Test public void lisTest(){
    assert(singleton.list(5) instanceof List<?>);
    assert(singleton.list(5).size()==1);
    assert(singleton.list(null).size()==0);
   
  }
  
  @SuppressWarnings({ "cast", "boxing", "static-method" }) @Test public void arrayTest(){
    assert(singleton.array(5) instanceof Object[]);
    Object[] arr = singleton.array(6);
    assert(arr.length==1);
  }
  
  
  
  
}
