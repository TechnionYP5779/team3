package fluent.ly;

import org.junit.*;


@SuppressWarnings("static-method") public class zeroTest {
   @Test public void zerotest() {
    Object o1 = new Object(); 
    Object o2 = new Object(); 
    azzert.assertTrue(zero.forgetting(o1, o2) == 0); 
    azzert.assertTrue(zero.forget(true) == 0);
    azzert.assertTrue(zero.forget(1.0) == 0); 
    azzert.assertTrue(zero.forget(5L) == 0); 
  }
}
