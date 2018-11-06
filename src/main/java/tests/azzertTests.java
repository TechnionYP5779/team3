package tests;

import java.util.*;

import org.hamcrest.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method")
public class azzertTests {
  
  @SuppressWarnings("boxing") @Test
  public  void testStuff()
  {
    List<Integer> lst = new ArrayList<>();
    lst.add(0);
    lst.add(1);
    lst.add(2);
    lst.add(3);
    List<Integer> lst2 = new ArrayList<>(lst);
    Integer[] arr = {0,1,2,3};
    azzert.assertCollectionsEqual(lst, lst2);
    azzert.assertCollectionsEqual(lst, arr);
    azzert.assertCollectionsEqual("bla", lst, lst2);
    azzert.assertCollectionsEqual("bla", lst, arr);
    azzert.assertCollectionsEqual("bla", arr, lst);

    azzert.assertContains(lst2, 1);
    azzert.assertContains("bla", lst2, 1);
    azzert.assertNotContains(lst2, 15);
    azzert.assertNotContains("bla", lst2, 15);
    
    azzert.assertEquals(true, Boolean.valueOf(true));
    azzert.assertEquals(Boolean.valueOf(true), true);
    azzert.assertEquals(1, Integer.valueOf(1));
    azzert.assertEquals(Integer.valueOf(1), 1);
    
    azzert.assertEquals("bla", true, true);
    azzert.assertEquals("bla", true, Boolean.valueOf(true));
    azzert.assertEquals("bla", Boolean.valueOf(true), true);
    azzert.assertEquals("bla", 1, Integer.valueOf(1));
    azzert.assertEquals("bla", Integer.valueOf(1), 1);
    azzert.assertEquals("bla", 1, 1);
    azzert.assertFalse(false);
    azzert.assertFalse("bla", false);
    
    azzert.assertNotEquals(new Object(), "bla");
    azzert.assertNotEquals("bla", new Object(), "bla");
    azzert.assertNotEquals("notBla", "bla");
    azzert.assertNotEquals("bla", "notBla", "bla");
    
    azzert.assertNull(null);
    azzert.assertNull("bla", null);
    azzert.isNull("bla", null);
    
    azzert.assertPositive(15);
    azzert.positive(15);
    azzert.assertZero(0);
    
    azzert.assertSubset(lst, lst2);
    
    azzert.assertTrue(true);
    azzert.assertTrue("bla", true);
    
    azzert.comparesEqualTo(true);
    azzert.comparesEqualTo((byte) 1);
    azzert.comparesEqualTo((char) 1);
    azzert.comparesEqualTo((short) 1);
    azzert.comparesEqualTo(1.0);
    azzert.comparesEqualTo(1.0f);
    azzert.comparesEqualTo(1);
    azzert.comparesEqualTo(1L);
    azzert.containsString("bla");
    azzert.endsWith("bla");
    azzert.falze(false);
    
    azzert.greaterThan(true);
    azzert.greaterThan((byte) 1);
    azzert.greaterThan((char) 1);
    azzert.greaterThan((short) 1);
    azzert.greaterThan(1.0);
    azzert.greaterThan(1.0f);
    azzert.greaterThan(1);
    azzert.greaterThan(1L);
    
    azzert.greaterThanOrEqualTo(true);
    azzert.greaterThanOrEqualTo((byte) 1);
    azzert.greaterThanOrEqualTo((char) 1);
    azzert.greaterThanOrEqualTo((short) 1);
    azzert.greaterThanOrEqualTo(1.0);
    azzert.greaterThanOrEqualTo(1.0f);
    azzert.greaterThanOrEqualTo(1);
    azzert.greaterThanOrEqualTo(1L);
    
    azzert.equals("bla", lst, lst2);
    azzert.equalTo(1);
    
    azzert.instanceOf(String.class);
    azzert.isA(String.class);
    
    azzert.is(true);
    azzert.is((byte) 1);
    azzert.is((char) 1);
    azzert.is((short) 1);
    azzert.is(1.0);
    azzert.is(1.0f);
    azzert.is(1);
    azzert.is(1L);
    azzert.is(azzert.is(1));
    
    azzert.lessThan(true);
    azzert.lessThan((byte) 1);
    azzert.lessThan((char) 1);
    azzert.lessThan((short) 1);
    azzert.lessThan(1.0);
    azzert.lessThan(1.0f);
    azzert.lessThan(1);
    azzert.lessThan(1L);
    
    azzert.lessThanOrEqualTo(true);
    azzert.lessThanOrEqualTo((byte) 1);
    azzert.lessThanOrEqualTo((char) 1);
    azzert.lessThanOrEqualTo((short) 1);
    azzert.lessThanOrEqualTo(1.0);
    azzert.lessThanOrEqualTo(1.0f);
    azzert.lessThanOrEqualTo(1);
    azzert.lessThanOrEqualTo(1L);
    
    azzert.not(true);
    azzert.not((byte) 1);
    azzert.not((char) 1);
    azzert.not((short) 1);
    azzert.not(1.0);
    azzert.not(1.0f);
    azzert.not(1);
    azzert.not(1L);
    azzert.not(azzert.is(1));
    
    azzert.notNull(new Object());
    azzert.notNull("bla", new Object());
    
    azzert.startsWith("bla");
   
  }
}
