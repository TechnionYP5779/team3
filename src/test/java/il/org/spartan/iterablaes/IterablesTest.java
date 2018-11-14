package il.org.spartan.iterablaes;

import static il.org.spartan.Utils.*;

import org.junit.*;

import an.*;
import fluent.ly.*;
import il.org.spartan.iterables.*;

@SuppressWarnings("static-method") public class IterablesTest {
  @Test public void containsDegenerate() {
    azzert.nay(contains("Hello"));
  }

  @Test public void containseturnsFalseTypical() {
    azzert.nay(contains("Hello", null, "x", "y", null, "z", "w", "u", "v"));
  }

  @Test public void containsSimple() {
    azzert.aye("", contains("Hello", "e"));
  }

  @Test public void containsTypical() {
    azzert.aye("", contains("Hello", "a", "b", "c", "d", "e", "f"));
  }

  @Test public void containsWithNulls() {
    azzert.aye("", contains("Hello", null, "a", "b", null, "c", "d", "e", "f", null));
  }

  @Test public void countDoesNotIncludeNull() {
    azzert.assertTrue(iterables.count(iterable.over(null, "One", null, "Two", null, "Three")) == 3);
  }

  @Test public void countEmpty() {
    azzert.assertTrue(iterables.count(iterables.<String> empty()) == 0);
  }

  @Test public void countSingleton() {
    azzert.assertTrue(1 == iterables.count(iterable.singleton(new Object())));
  }

  @Test public void countThree() {
    azzert.assertTrue(3 == iterables.count(iterable.over("One", "Two", "Three")));
  }

  @Test public void alternateNullArguments() {
    final Iterable<String> it1 = iterable.over("a", "b", "c");
    final Iterable<String> it2 = null;
    azzert.assertCollectionsEqual(as.list(it1), as.list(iterables.alternate(it1, it2)));
    azzert.assertCollectionsEqual(as.list(it1), as.list(iterables.alternate(it2, it1)));
  }

  @Test public void altenateEqualLengths() {
    final Iterable<String> it1 = iterable.over("a", "c", "e");
    final Iterable<String> it2 = iterable.over("b", "d", "f");
    final Iterable<String> expected = iterable.over("a", "b", "c", "d", "e", "f");
    azzert.assertCollectionsEqual(as.list(expected), as.list(iterables.alternate(it1, it2)));
  }

  @Test public void alternateDifferentLen1() {
    final Iterable<String> it1 = iterable.over("a", "c", "e", "g", "h");
    final Iterable<String> it2 = iterable.over("b", "d", "f");
    final Iterable<String> expected = iterable.over("a", "b", "c", "d", "e", "f", "g", "h");
    azzert.assertCollectionsEqual(as.list(expected), as.list(iterables.alternate(it1, it2)));
  }

  @Test public void alternateDifferentLen2() {
    final Iterable<String> it1 = iterable.over("a", "c", "e");
    final Iterable<String> it2 = iterable.over("b", "d", "f", "g");
    final Iterable<String> expected = iterable.over("a", "b", "c", "d", "e", "f", "g");
    azzert.assertCollectionsEqual(as.list(expected), as.list(iterables.alternate(it1, it2)));
  }
}
