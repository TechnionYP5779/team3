package fluent.ly;

import java.util.*;

import org.junit.*;
import static fluent.ly.box.*; 

@SuppressWarnings("static-method") public class AzzertTest {
  @Test public void testStuff() {
    final List<Integer> lst = new ArrayList<>();
    lst.add(box(0));
    lst.add(box(1));
    lst.add(box(2));
    lst.add(box(3));
    final List<Integer> lst2 = new ArrayList<>(lst);
    final Integer[] arr = { box(0), box(1), box(2), box(3) };
    azzert.assertCollectionsEqual(lst, lst2);
    azzert.assertCollectionsEqual(lst, arr);
    azzert.assertCollectionsEqual("bla", lst, lst2);
    azzert.assertCollectionsEqual("bla", lst, arr);
    azzert.assertCollectionsEqual("bla", arr, lst);
    azzert.assertContains(lst2, box(1));
    azzert.assertContains("bla", lst2, box(1));
    azzert.assertNotContains(lst2, box(15));
    azzert.assertNotContains("bla", lst2, box(15));
    azzert.assertEquals(true, box(true));
    azzert.assertEquals(box(true), true);
    azzert.assertEquals(1, box(1));
    azzert.assertEquals(box(1), 1);
    azzert.assertEquals("bla", true, true);
    azzert.assertEquals("bla", true, box(true));
    azzert.assertEquals("bla", box(true), true);
    azzert.assertEquals("bla", 1, box(1));
    azzert.assertEquals("bla", box(1), 1);
    azzert.assertEquals("bla", 1, 1);
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
    azzert.equalTo(box(1));
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
