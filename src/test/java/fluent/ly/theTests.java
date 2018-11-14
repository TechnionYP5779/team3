package fluent.ly;

import java.util.*;

import org.junit.*;



public class theTests {
  
  @SuppressWarnings({ "boxing", "null", "unused", "static-method" }) @Test public void testos() {
    azzert.assertTrue(the.nil()==null);
    azzert.assertTrue(the.nth("1","2").equals(" #1/2"));
    azzert.assertTrue(the.nth(1,2).equals(" #1/2"));
    azzert.assertTrue(the.nth(1,new ArrayList<Integer>()).equals(" #1/0"));
    azzert.assertTrue(the.penultimateOf(new ArrayList<Integer>())==null);
    List<Integer> li=new ArrayList<Integer>();
    li.add(0,0);
    li.add(1,1);
    li.add(2,2);
    li.add(3,3);
    azzert.assertTrue(the.previous(1, li).equals(0));
    azzert.assertTrue(the.previous(1, null)==null);
    azzert.assertTrue(the.tailOf(li).size()==3);
    azzert.assertTrue(the.tailOf("123").equals("23"));
    azzert.assertTrue(the.rest(1,li).size()==2);
    azzert.assertTrue(the.headOf(li).equals(0));
    azzert.assertTrue(the.headOf(null)==null);
    azzert.assertTrue(the.headOf(new ArrayList<Integer>())==null);
    azzert.assertTrue(the.ith("123",0)=='1');
    azzert.assertTrue(the.max(0,1,2,3,4,5)==5);
    azzert.assertTrue(the.min(0,1,2,3,4,5)==0);
    Integer[] anArray;

    // allocates memory for 10 integers
    anArray = new Integer[10];
       
    // initialize first element
    anArray[0] = 100;
    // initialize second element
    anArray[1] = 200;
    // and so forth
    anArray[2] = 300;
    anArray[3] = 400;
    anArray[4] = 500;
    anArray[5] = 600;
    anArray[6] = 700;
    anArray[7] = 800;
    anArray[8] = 900;
    anArray[9] = 1000;

    azzert.assertTrue(the.lastOf(anArray)==1000);
    azzert.assertTrue(the.tailOf(anArray).length==9);
    azzert.assertTrue(the.sqr(2)==4);
    azzert.assertTrue(the.lastOf(li).equals(3));
    
    
    
    
  }
}
