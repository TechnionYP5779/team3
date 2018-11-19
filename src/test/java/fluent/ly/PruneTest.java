package fluent.ly;

import static org.junit.Assert.assertEquals;

import static fluent.ly.azzert.*;
import static fluent.ly.azzert.assertEquals;

import java.util.*;
import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import il.org.spartan.*;
import il.org.spartan.etc.*;

@SuppressWarnings({ "static-method" }) public class PruneTest {
  @Nullable final String[] alternatingArray = new @Nullable String[] { null, "A", null, null, "B", null, null, null, "C", null };
  @NotNull final String[] nonNullArray = { "1", "2", "4" };
  @NotNull private final List<String> sparseCollection = as.list(null, null, null, null, null, "A", null, null, null, "B", null, "C", null, null,
      null, null, null);

  @Test public void nullsNotNullArrayLength() {
    assertEquals(nonNullArray.length, prune.nulls(Utils.cantBeNull(nonNullArray)).length);
  }

  @Test public void nullsNullArrayItems() {
    assertEquals("1", prune.nulls(Utils.cantBeNull(nonNullArray))[0]);
    assertEquals("2", prune.nulls(Utils.cantBeNull(nonNullArray))[1]);
    assertEquals("4", prune.nulls(Utils.cantBeNull(nonNullArray))[2]);
  }

  @Test public void nullsPruneArrayAltenatingItems() {
    assertEquals("A", prune.nulls(Utils.cantBeNull(alternatingArray))[0]);
    assertEquals("B", prune.nulls(Utils.cantBeNull(alternatingArray))[1]);
    assertEquals("C", prune.nulls(Utils.cantBeNull(alternatingArray))[2]);
  }

  @Test public void nullsPruneArrayAltenatingLength() {
    assertEquals(3, prune.nulls(Utils.cantBeNull(alternatingArray)).length);
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

  @Test public void whitesEmptyArray() {
    assertEquals(0, prune.whites().length);
  }

  @Test public void whitesEmptyList() {
    assertEquals(0, prune.whites().length);
  }

  final String @NotNull [] alternatingArray1 = new String[] { null, "A", null, null, "B", null, null, null, "C", null };
  @NotNull final String @NotNull [] nonNullArray1 = { "1", "2", "4" };
  @NotNull final Supplier<List<String>> x = () -> {
    final List<String> $ = an.empty.list();
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
  };
  @NotNull private final List<String> sparseCollection1 = new Supplier<List<String>>() {
    @Override @NotNull public List<String> get() {
      @NotNull final List<String> $ = an.empty.list();
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
    azzert.that(prune.nulls(Utils.cantBeNull(nonNullArray))[0], is("1"));
    azzert.that(prune.nulls(Utils.cantBeNull(nonNullArray))[1], is("2"));
    azzert.that(prune.nulls(Utils.cantBeNull(nonNullArray))[2], is("4"));
  }

  @Test public void testNotNullArrayLength() {
    azzert.that(prune.nulls(Utils.cantBeNull(nonNullArray)).length, is(nonNullArray.length));
  }

  @Test public void testPruneArrayAltenatingItems() {
    azzert.that(prune.nulls(Utils.cantBeNull(alternatingArray))[0], is("A"));
    azzert.that(prune.nulls(Utils.cantBeNull(alternatingArray))[1], is("B"));
    azzert.that(prune.nulls(Utils.cantBeNull(alternatingArray))[2], is("C"));
  }

  @Test public void testPruneArrayAltenatingLength() {
    azzert.that(prune.nulls(Utils.cantBeNull(alternatingArray)).length, is(3));
  }

  @SuppressWarnings("null") @Test public void testPruneSparseCollectionContents() {
    final @NotNull String[] a = prune.nulls(sparseCollection).toArray(new String[3]);
    azzert.that(a[0], is("A"));
    azzert.that(a[1], is("B"));
    azzert.that(a[2], is("C"));
    azzert.that(a.length, is(3));
  }

  @Test public void testPruneSparseCollectionLength() {
    azzert.that(prune.nulls(sparseCollection).size(), is(3));
  }

  @SuppressWarnings("null") @Test public void testPrunNotNull() {
    azzert.assertTrue(prune.nulls(sparseCollection) != null);
  }
}
