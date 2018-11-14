package a;

import java.util.*;

import org.junit.*;


import fluent.ly.*;

public class singleTest {
  static int n = 5;

  @SuppressWarnings({ "cast", "boxing", "static-method" }) @Test public void lisTest() {
    azzert.assertTrue( singleton.list(5) instanceof List<?>);
    azzert.assertTrue( singleton.list(5).size() == 1);
    azzert.assertTrue( singleton.list(null).size() == 0);
  }

  @SuppressWarnings({ "cast", "boxing", "static-method" }) @Test public void arrayTest() {
    azzert.assertTrue( singleton.array(5) instanceof Object[]);
    final Object[] arr = singleton.array(6);
    azzert.assertTrue( arr.length == 1);
  }
}
