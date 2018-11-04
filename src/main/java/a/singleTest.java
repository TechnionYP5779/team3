package a;
import java.util.*;
import org.junit.*;




import org.jetbrains.annotations.*;

import fluent.ly.*;

public class singleTest {
  @SuppressWarnings("boxing") static int n = 5;
  
  @SuppressWarnings({ "cast", "boxing", "static-method" }) @Test public void lisTest(){
    assert(singleton.list(5) instanceof List<?>);
    assert(singleton.list(5).size()==1);
    assert(singleton.list(null)==null);
    assert(singleton.list("5")==null);
  }
  
  @SuppressWarnings({ "cast", "boxing", "static-method" }) @Test public void arrayTest(){
    assert(singleton.array(5) instanceof Object[]);
    assert(singleton.array(5).length==1);
    assert(singleton.array(null)==null);
    assert(singleton.array("5")==null);
  }
  
  
  
  
}
