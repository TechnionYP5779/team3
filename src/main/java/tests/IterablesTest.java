package tests;

import static il.org.spartan.Utils.*;
import static org.junit.Assert.*;

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
      assertEquals(3, iterables.count(iterable.over(null, "One", null, "Two", null, "Three")));
    }

    @Test public void countEmpty() {
      assertEquals(0, iterables.count(iterables.<String> empty()));
    }

    @Test public void countSingleton() {
      assertEquals(1, iterables.count(iterable.singleton(new Object())));
    }

    @Test public void countThree() {
      assertEquals(3, iterables.count(iterable.over("One", "Two", "Three")));
    }
    
    @Test public void alternateNullArguments() {
      Iterable<String> it1 = iterable.over("a","b","c");
      Iterable<String> it2 = null;
      azzert.assertCollectionsEqual(as.list(it1), as.list(iterables.alternate(it1, it2)));
      azzert.assertCollectionsEqual(as.list(it1), as.list(iterables.alternate(it2, it1)));
    }
    
    @Test public void altenateEqualLengths() {
      Iterable<String> it1 = iterable.over("a","c","e");
      Iterable<String> it2 = iterable.over("b","d","f");
      Iterable<String> expected = iterable.over("a","b","c","d","e","f");
      azzert.assertCollectionsEqual(as.list(expected), as.list(iterables.alternate(it1, it2)));
    }
    
    @Test public void alternateDifferentLen() {
      Iterable<String> it1 = iterable.over("a","c","e", "g", "h");
      Iterable<String> it2 = iterable.over("b","d","f");
      Iterable<String> expected = iterable.over("a","b","c","d","e","f", "g", "h");
      azzert.assertCollectionsEqual(as.list(expected), as.list(iterables.alternate(it1, it2)));
    }
}
