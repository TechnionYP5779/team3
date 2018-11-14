package an;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class EmptyTests {
  @Test public void testListEmpty() {
    azzert.assertTrue(empty.list().isEmpty());
    azzert.assertTrue(empty.list().isEmpty());
  }

  @Test public void testIterator() {
    azzert.assertTrue(!empty.iterable().iterator().hasNext());
    azzert.assertNull(empty.iterable().iterator().next());
  }
}
