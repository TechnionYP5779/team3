package tests;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class forgetTests {
  @Test
  public void testForget() {
    forget.it(5);
    forget.it(false);
    forget.it(1.0);
    forget.it("bla");
    
    forget.all("1", "2", "3");
  }
}