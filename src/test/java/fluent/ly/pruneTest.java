package fluent.ly;


import static fluent.ly.azzert.*;

import java.util.*;
import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;
import static il.org.spartan.Utils.*;

import il.org.spartan.etc.*;

@SuppressWarnings("static-method") public class pruneTest {
  @Nullable final String[] alternatingArray = new @Nullable String[] { null, "A", null, null, "B", null, null, null, "C", null };
  @NotNull final String[] nonNullArray = { "1", "2", "4" };
  @NotNull private final List<String> sparseCollection = as.list(null, null, null, null, null, "A", null, null, null, "B", null, "C", null, null,
      null, null, null);

  @Test public void nullsNotNullArrayLength() {
    azzert.that(nonNullArray.length, is(prune.nulls(cantBeNull(nonNullArray)).length));
  }

  @Test public void nullsNullArrayItems() {
    azzert.that(prune.nulls(cantBeNull(nonNullArray))[0], is("1"));
    azzert.that(prune.nulls(cantBeNull(nonNullArray))[1], is("2"));
    azzert.that(prune.nulls(cantBeNull(nonNullArray))[2], is("4"));
  }

  @Test public void nullsPruneArrayAltenatingItems() {
    azzert.that(prune.nulls(cantBeNull(alternatingArray))[0], is("A"));
    azzert.that(prune.nulls(cantBeNull(alternatingArray))[1], is("B"));
    azzert.that(prune.nulls(cantBeNull(alternatingArray))[2], is("C"));
  }

  @Test public void nullsPruneArrayAltenatingLength() {
    azzert.that(prune.nulls(cantBeNull(alternatingArray)).length, is(3));
  }

  @Test public void nullsPruneSparseCollectionContents() {
    final String[] a = prune.nulls(sparseCollection).toArray(new String[3]);
    azzert.that(a[0], is("A"));
    azzert.that(a[1], is("B"));
    azzert.that(a[2], is("C"));
    azzert.that(a.length, is(3));
  }

  @Test public void nullsPruneSparseCollectionLength() {
    azzert.that(prune.nulls(sparseCollection).size(), is(3));
  }

  @Test public void nullsPrunNotNull() {
    assert prune.nulls(sparseCollection) != null;
  }

  @Test public void whitesEmptyArray() {
    azzert.that(prune.whites().length, is(0));
  }

  @Test public void whitesEmptyList() {
    azzert.that(prune.whites().length, is(0));
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

  @Test public void testNotNullArrayItems() {
    azzert.that(prune.nulls(cantBeNull(nonNullArray))[0], is("1"));
    azzert.that(prune.nulls(cantBeNull(nonNullArray))[1], is("2"));
    azzert.that(prune.nulls(cantBeNull(nonNullArray))[2], is("4"));
  }

  @Test public void testNotNullArrayLength() {
    azzert.that(prune.nulls(cantBeNull(nonNullArray)).length, is(nonNullArray.length));
  }

  @Test public void testPruneArrayAltenatingItems() {
    azzert.that(prune.nulls(cantBeNull(alternatingArray))[0], is("A"));
    azzert.that(prune.nulls(cantBeNull(alternatingArray))[1], is("B"));
    azzert.that(prune.nulls(cantBeNull(alternatingArray))[2], is("C"));
  }

  @Test public void testPruneArrayAltenatingLength() {
    azzert.that(prune.nulls(cantBeNull(alternatingArray)).length, is(3));
  }

  @Test @SuppressWarnings("null") public void testPruneSparseCollectionContents() {
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
