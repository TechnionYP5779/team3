package fluent.ly;

import java.awt.*;

import org.junit.*;

import an.*;

@SuppressWarnings("static-method") public class allTest {
  @Test public void notNull() {
    Iterable<String> it = iterable.over("a", "b", "c"); 
    assert(all.notNull(it)); 
    Iterable<String> it1 = null; 
    assert(!all.notNull(it1)); 
  }
  
  @Test public void notNull1() {
    String[] it = {"a","b"};
    assert(all.notNull(it)); 
    String[] it1 = null;
    assert(!all.notNull(it1)); 
  }  
  
}
