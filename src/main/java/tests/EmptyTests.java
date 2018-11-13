package tests;

import org.junit.*;

import an.*;
import fluent.ly.*;

@SuppressWarnings("static-method") public class EmptyTests {
  @Test public void testListEmpty() {
    assert empty.list().isEmpty();
    assert empty.list().isEmpty();
  }

  @Test public void testIterator() {
    assert !empty.iterable().iterator().hasNext();
    azzert.assertNull(empty.iterable().iterator().next());
  }
}
