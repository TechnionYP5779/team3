package il.org.spartan.utils;

import org.junit.*;

@SuppressWarnings("static-method") public class faultTest {
  @Test public void done() {
    assert(fault.done().contains("Stack trace: [[[.................")); 
  }
  
  @Test public void trace() {
    assert(fault.trace().contains("java.lang.AssertionError")); 
  }
  @Test public void dump() {
   assert(fault.dump().contains("FAULT:")); 
  }
  
  @Test public void unreachable() {
    assert(!fault.unreachable()); 
   }
  
  @Test public void bool() {
    Integer i = new Integer(1);
    assert(!fault.bool(i)); 
   }
  
    @Test public void specifically() {
    Integer i = new Integer(1);
    String value = fault.specifically("test failed because", i); 
    assert(value.contains("FAULT:") &&value.contains("test failed because")); 
   }
}
