package fluent.ly;

import java.util.*;

import org.junit.*;



public class theTests {
  
  @SuppressWarnings({ "null", "unused", "static-method" }) @Test public void testos() {
    azzert.assertTrue(the.nil()==null);
    azzert.assertTrue(the.nth("1","2").equals(" #1/2"));
    azzert.assertTrue(the.nth(1,2).equals(" #1/2"));
    azzert.assertTrue(the.nth(1,new ArrayList<Integer>()).equals(" #1/0"));
    azzert.assertTrue(the.penultimateOf(new ArrayList<Integer>())==null);
    List<Integer> li=new ArrayList<Integer>();
    li.add(0,box.box(0));
    li.add(1,box.box(1));
    li.add(2,box.box(2));
    li.add(3,box.box(3));
    azzert.assertTrue(the.previous(box.box(1), li).equals(box.box(0)));
    azzert.assertTrue(the.previous(box.box(1), null)==null);
    azzert.assertTrue(the.tailOf(li).size()==3);
    azzert.assertTrue(the.tailOf("123").equals("23"));
    azzert.assertTrue(the.rest(box.box(1),li).size()==2);
    azzert.assertTrue(the.headOf(li).equals(box.box(0)));
    azzert.assertTrue(the.headOf(null)==null);
    azzert.assertTrue(the.headOf(new ArrayList<Integer>())==null);
    azzert.assertTrue(the.ith("123",0)=='1');
    azzert.assertTrue(the.max(0,1,2,3,4,5)==5);
    azzert.assertTrue(the.min(0,1,2,3,4,5)==0);
    Integer[] anArray;

    // allocates memory for 10 integers
    anArray = new Integer[10];
       
    // initialize first element
    anArray[0] = box.box(100);
    // initialize second element
    anArray[1] = box.box(200);
    // and so forth
    anArray[2] = box.box(300);
    anArray[3] = box.box(400);
    anArray[4] = box.box(500);
    anArray[5] = box.box(600);
    anArray[6] = box.box(700);
    anArray[7] = box.box(800);
    anArray[8] = box.box(900);
    anArray[9] = box.box(1000);

    azzert.assertTrue(the.lastOf(anArray).equals(box.box(1000)));
    azzert.assertTrue(the.tailOf(anArray).length==9);
    azzert.assertTrue(the.sqr(2)==4);
    azzert.assertTrue(the.lastOf(li).equals(box.box(3)));
    
    
    
    
  }
}
