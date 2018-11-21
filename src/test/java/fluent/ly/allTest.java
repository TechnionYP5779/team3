package fluent.ly;

import org.junit.*;

import an.*;

@SuppressWarnings("static-method") public class allTest {
  @Test public void notNull() {
    assert(all.notNull(iterable.over("a", "b", "c"))); 
    assert (!all.notNull((Iterable<String> )null)); 
  }
  
  @Test public void notNull1() {
    assert(all.notNull(new String[] { "a", "b" })); 
    assert (!all.notNull((String [])null)); 
  }  
  
}
