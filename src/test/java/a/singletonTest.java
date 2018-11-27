package a;


import org.junit.*;

import fluent.ly.*;

@SuppressWarnings( "static-method" ) public class singletonTest {
  static int n = 5;

  @Test public void lisTest() {

    assert singleton.list(box.it(5)) != null;
    assert singleton.list(box.it(5)).size() == 1;

    assert singleton.list(null).isEmpty();
  }

  @Test public void arrayTest() {

    assert singleton.array(box.it(5)) != null;
    assert ((Object[]) singleton.array(box.it(6))).length == 1;

  }
}
