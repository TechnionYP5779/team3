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
    assert iterables.count(iterable.over(null, "One", null, "Two", null, "Three")) == 3;
  }

  @Test public void countEmpty() {
    assert iterables.count(iterables.<String> empty()) == 0;
  }

  @Test public void countSingleton() {
    assert iterables.count(iterable.singleton(new Object())) == 1;
  }

  @Test public void countThree() {
    assert iterables.count(iterable.over("One", "Two", "Three")) == 3;
  }

  @Test public void alternateNullArguments() {
    final Iterable<String> it1 = iterable.over("a", "b", "c"), it2 = null;
    azzert.assertCollectionsEqual(as.list(it1), as.list(iterables.alternate(it1, it2)));
    azzert.assertCollectionsEqual(as.list(it1), as.list(iterables.alternate(it2, it1)));
  }

  @Test public void altenateEqualLengths() {
    azzert.assertCollectionsEqual(as.list(iterable.over("a", "b", "c", "d", "e", "f")),
        as.list(iterables.alternate(iterable.over("a", "c", "e"), iterable.over("b", "d", "f"))));
  }

  @Test public void alternateDifferentLen1() {
    azzert.assertCollectionsEqual(as.list(iterable.over("a", "b", "c", "d", "e", "f", "g", "h")),
        as.list(iterables.alternate(iterable.over("a", "c", "e", "g", "h"), iterable.over("b", "d", "f"))));
  }

  @Test public void alternateDifferentLen2() {
    azzert.assertCollectionsEqual(as.list(iterable.over("a", "b", "c", "d", "e", "f", "g")),
        as.list(iterables.alternate(iterable.over("a", "c", "e"), iterable.over("b", "d", "f", "g"))));
  }
}
