/* Part of the "Spartan Blog"; mutate the rest / but leave this line as is */
package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;
import static il.org.spartan.Utils.*;

/** A collection of <code><b>static</b></code> functions for converting from one
 * aggregate type to another.
 * @author Yossi Gil
 * @since Jul 8, 2014 */
public enum as {
  ;
  /** Convert an array of {@link Integer}s into an {@link Iterable}. For example,
   * to print the first Fibonacci numbers multiplied by the first prime numbers,
   * write:
   *
   * <pre>
   * for (Integer f: asIterable(1,1,2,3,5,8,13)
   *    for (Integer p: asIterable(2,3,5,7,11,13)
   *       System.out.println(f*p)
   * </pre>
   *
   * @param is what to iterate on (recall that a list of arguments of the same
   *           type is isomorphic to array parameters in Java
   * @return an {@link Iterable} over the array, which can then be used to to
   *         iterate over the parameter(s) */
  public static Iterable<Integer> asIterable(final @NotNull Integer... is) {
    // Create an object of a new <em>anonymous</em> class that
    // <code><b>implements</b></code> {@link Iterable}
    return () -> new Iterator<Integer>() {
      int current;

      @Override public boolean hasNext() {
        return current < is.length;
      }

      @Override public Integer next() {
        return is[current++];
      }
    };
  }

  public static Iterable<Integer> asIterableLambda(final @NotNull Integer... is) {
    return () -> new Iterator<Integer>() {
      int current;

      @Override public boolean hasNext() {
        return current < is.length;
      }

      @Override public Integer next() {
        return is[current++];
      }
    };
  }

  /** Converts a boolean into a bit value
   * @param $ some boolean value
   * @return 1 if the parameter is true, 0 otherwise */
  public static int bit(final boolean $) {
    return $ ? 1 : 0;
  }

  /** C like conversion of a reference to an {@link Object} into a 0/1 bit.
   * @param ¢ some object
   * @return <code>0</code> if the parameter is <code><b>null</b></code>.
   *         <code>1</code> otherwise.
   * @see as#bit(Object) */
  public static int bit(final @Nullable Object ¢) {
    return ¢ == null ? 0 : 1;
  }

  @NotNull public static List<Integer> ingeterList(final int... is) {
    final @NotNull List<Integer> $ = new ArrayList<>();
    for (final int ¢ : is)
      $.add(fluent.ly.box.it(¢));
    return $;
  }

  /** Converts a sequence of integer values into an array.
   * @param $ some sequence of values of the type parameter
   * @return parameters, organized as an array with entries whose type is the type
   *         parameter */
  public static int @NotNull [] intArray(final int... $) {
    return cantBeNull($);
  }

  /** Return a compact representation of a list of {@link Integer}s as an array of
   * type <code><b>int</b></code>.
   * @param is the list to be converted, none of the elements in it can be
   *           <code><b>null</b></code>
   * @return an array of <code><b>int</b></code>. representing the input. */
  public static int @NotNull [] intArray(final @NotNull List<Integer> is) {
    final int @NotNull [] $ = new int @NotNull [is.size()];
    for (int ¢ = 0; ¢ < $.length; ++¢)
      $[¢] = is.get(¢).intValue();
    return $;
  }

  /** Creates an iterable for an array of objects
   * @param   <T> an arbitrary type
   * @param ¢ what to iterate on
   * @return an {@link Iterable} over the parameter */
  @SafeVarargs public static <T> Iterator<T> iterator(final T... ¢) {
    return as.list(¢).iterator();
  }

  /** Converts a list of <code><b>int</b></code>s into a {@link List} of
   * {@link Integer}s
   * @param ¢ what to convert
   * @return a {@link List} of of all <code><b>int</b></code>s in the parameter */
  public static List<Integer> list(final int... ¢) {
    return as.list(box.it(cantBeNull(¢)));
  }

  /** Converts an {@link Iterable} of a given type into a {@link List} of values
   * of this type.
   * @param   <T> type of items to be converted
   * @param $ what to convert
   * @return parameter, converted to the {@link List} of the given type */
  public static <T> @NotNull List<T> list(final @Nullable Iterable<? extends T> $) {
    return $ == null ? an.empty.list() : accumulate.to(new ArrayList<T>()).add($).elements();
  }

  /** Converts a sequence of objects of some common type T into a {@link List} of
   * values
   * @param   <T> type of objects to be converted
   * @param $ what to covert
   * @return result parameter, converted into a {@link List} */
  @SafeVarargs public static <T> @NotNull List<T> list(final T... $) {
    return accumulate.to(new ArrayList< T>()).add(cantBeNull($)).elements();
  }

  /** Converts a sequence of objects of a given type into a {@link Set} of values
   * @param   <T> type of objects to be converted
   * @param ¢ what to covert
   * @return parameter, converted into a {@link Set} */
  @SafeVarargs public static <T> Set<? extends T> set(final T... ¢) {
    return accumulate.to(new HashSet<T>()).add(cantBeNull(¢)).elements();
  }

  @NotNull public static String string(final  Object $) {
    return $ == null ? "null" : as.string($ + "");
  }

  @NotNull public static String string(final char $) {
    return $ + "";
  }

  @NotNull public static String string(final @Nullable String $) {
    return $ != null ? $ : "null";
  }

  /** Converts an {@link Iterable} into an array of {@link String}.
   * @param os what to covert
   * @return an array of the parameter values, each converted to i
   *         {@link String} */
  public static String @NotNull [] strings(final Iterable<?> os) {
    final @NotNull List<@NotNull String> $ = new ArrayList<>();
    if (os != null)
      for (final @Nullable Object ¢ : os)
        if (¢ != null)
          $.add(¢ + "");
    return cantBeNull($.toArray(new String @NotNull [$.size()]));
  }

  static Iterable<Integer> asIterableEssence(final @NotNull Integer... is) {
    return () -> new Iterator<Integer>() {
      int current;

      @Override public boolean hasNext() {
        return current < is.length;
      }

      @Override public Integer next() {
        return is[current++];
      }
    };
  }

  /** Converts a sequence of values into an array.
   * @param   <T> some arbitrary type
   * @param $ some sequence of values of the type parameter
   * @return parameter, organized as an array with entries whose type is the type
   *         parameter */
  @SafeVarargs public static <T> T[] array(final T... $) {
    return $;
  }
}