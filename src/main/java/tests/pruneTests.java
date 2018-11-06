package tests;

import static org.junit.Assert.*;

import static fluent.ly.azzert.*;

import java.util.*;
import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({ "static-method" }) 
public class pruneTests {
  @Nullable final String[] alternatingArray = new @Nullable String[] { null, "A", null, null, "B", null, null, null, "C", null };
  @NotNull final String[] nonNullArray = { "1", "2", "4" };
  @NotNull private final List<String> sparseCollection = as.list(null, null, null, null, null, "A", null, null, null, "B", null, "C", null, null,
      null, null, null);

  @Test public void nullsNotNullArrayLength() {
    assertEquals(nonNullArray.length, prune.nulls(nonNullArray).length);
  }

  @SuppressWarnings({ }) @Test public void nullsNullArrayItems() {
    assertEquals("1", prune.nulls(nonNullArray)[0]);
    assertEquals("2", prune.nulls(nonNullArray)[1]);
    assertEquals("4", prune.nulls(nonNullArray)[2]);
  }

  @Test public void nullsPruneArrayAltenatingItems() {
    assertEquals("A", prune.nulls(alternatingArray)[0]);
    assertEquals("B", prune.nulls(alternatingArray)[1]);
    assertEquals("C", prune.nulls(alternatingArray)[2]);
  }

  @Test public void nullsPruneArrayAltenatingLength() {
    assertEquals(3, prune.nulls(alternatingArray).length);
  }

  @Test public void nullsPruneSparseCollectionContents() {
    final String[] a = prune.nulls(sparseCollection).toArray(new String[3]);
    assertEquals("A", a[0]);
    assertEquals("B", a[1]);
    assertEquals("C", a[2]);
    assertEquals(3, a.length);
  }

  @Test public void nullsPruneSparseCollectionLength() {
    assertEquals(3, prune.nulls(sparseCollection).size());
  }

  @Test public void nullsPrunNotNull() {
    assert prune.nulls(sparseCollection) != null;
  }

  @SuppressWarnings("static-method") @Test public void whitesEmptyArray() {
    assertEquals(0, prune.whites().length);
  }

  @Test public void whitesEmptyList() {
    assertEquals(0, prune.whites().length);
  }
  
  @SuppressWarnings("null") @NotNull final String @NotNull [] alternatingArray1 = new String[] { null, "A", null, null, "B", null, null, null, "C", null };
  @NotNull final String @NotNull [] nonNullArray1 = { "1", "2", "4" };
  @NotNull final Supplier<List<String>> x = new Supplier<List<String>>() {
    @Override public List<String> get() {
      List<String> $ = an.empty.list();
      $.add(null);
      $.add(null);
      $.add(null);
      $.add(null);
      $.add(null);
      $.add("A");
      $.add(null);
      $.add(null);
      $.add(null);
      $.add("B");
      $.add(null);
      $.add("C");
      $.add(null);
      $.add(null);
      $.add(null);
      $.add(null);
      return $;
    }
  };
  @NotNull private List<String> sparseCollection1 = new Supplier<List<String>>() {
    @Override @NotNull public List<String> get() {
      @NotNull List<String> $ = an.empty.list();
      $.add(null);
      $.add(null);
      $.add(null);
      $.add(null);
      $.add(null);
      $.add("A");
      $.add(null);
      $.add(null);
      $.add(null);
      $.add("B");
      $.add(null);
      $.add("C");
      $.add(null);
      $.add(null);
      $.add(null);
      $.add(null);
      return $;
    }
  }.get();

  @Test public void testNotNullArrayItems() {
    azzert.that(prune.nulls(nonNullArray)[0], is("1"));
    azzert.that(prune.nulls(nonNullArray)[1], is("2"));
    azzert.that(prune.nulls(nonNullArray)[2], is("4"));
  }

  @Test public void testNotNullArrayLength() {
    azzert.that(prune.nulls(nonNullArray).length, is(nonNullArray.length));
  }

  @Test public void testPruneArrayAltenatingItems() {
    azzert.that(prune.nulls(alternatingArray)[0], is("A"));
    azzert.that(prune.nulls(alternatingArray)[1], is("B"));
    azzert.that(prune.nulls(alternatingArray)[2], is("C"));
  }

  @Test public void testPruneArrayAltenatingLength() {
    azzert.that(prune.nulls(alternatingArray).length, is(3));
  }

  @Test public void testPruneSparseCollectionContents() {
    final @NotNull String[] a = prune.nulls(sparseCollection).toArray(new String[3]);
    azzert.that(a[0], is("A"));
    azzert.that(a[1], is("B"));
    azzert.that(a[2], is("C"));
    azzert.that(a.length, is(3));
  }

  @Test public void testPruneSparseCollectionLength() {
    azzert.that(prune.nulls(sparseCollection).size(), is(3));
  }

  @Test public void testPrunNotNull() {
    assert prune.nulls(sparseCollection) != null;
  }


}
