package tests;

import org.junit.*;

import il.org.spartan.utils.*;

@SuppressWarnings("unused") public class Int_tests {
   @SuppressWarnings("static-method") @Test public void basic_test() {
    new Int();
    Int b = new Int(3);
    assert b.equals(b);
    assert b.inner==3;
    assert Int.valueOf(0).inner==0;
  }
  
   @SuppressWarnings({ "boxing", "static-method" }) @Test public void set_get_change_test() {
     Int a = new Int(), b = new Int(3);
     a.set(4);
     assert a.get()==4;
     a.set(-6);
     assert a.get()!=4;
     assert a.get()==-6;
     b.set(Integer.MAX_VALUE);
     assert b.get()==Integer.MAX_VALUE;
     b.set(Integer.MIN_VALUE);
     assert b.get()==Integer.MIN_VALUE;
     b.clear();
     assert b.get()==0;
     b.step();
     assert b.inner()==b.get(); 
     assert b.next()==2;
     assert b.next()==Int.valueOf(3).get();
     assert "3".equals(b + "");
   }
   
   @SuppressWarnings("static-method") @Test public void math_test() {
     Int a = new Int(5), b = new Int(3);
     a.add(b);
     assert a.get()==8;
     a.add(-10);
     assert a.get()==-2;
     b.add(a);
     a.add(a);
     assert b.get()==1;
     assert a.get()==-4;
     }
   
}
