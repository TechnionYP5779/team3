package an;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class EmptyTest {
  @Test public void testListEmpty() {
    assert empty.list().isEmpty();
    assert empty.list().isEmpty();
  }

  @Test public void testIterator() {
    assert !empty.iterable().iterator().hasNext();
    azzert.assertNull(empty.iterable().iterator().next());
  }
}
