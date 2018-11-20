package a;

import java.util.*;
import static fluent.ly.box.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({ "cast", "static-method" }) public class SingletonTest {
  static int n = 5;

  @Test public void lisTest() {
    assert singleton.list(box(5)) instanceof List<?>;
    assert singleton.list(box(5)).size() == 1;
    assert singleton.list(null).isEmpty();
  }

  @Test public void arrayTest() {
    assert singleton.array(box(5)) instanceof Object[];
    assert ((Object[]) singleton.array(box(6))).length == 1;
  }
}
