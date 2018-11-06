package fluent.ly;

import org.junit.*;

/** This interface contains methods that do nothing and document the fact that some Object or value are not used in a function.
 * Calling these functions suppresses the "variable unused" warning that would usually be caused.
 * @author Yossi Gil
 * @since 2017-04-16 */
public interface forget {
  /**
   * Suppresses "variable unused" warning on a variable number of arguments.
   * @param _1 The first object to be ignored.
   * @param _2 The rest of the varargs.
   */
  @SuppressWarnings("unused") static void all(final Object _1, final Object... _2) {
    /**/ }

  /**
   * Suppresses "variable unused" warning on a boolean.
   * @param __ The boolean to be ignored.
   */
  @SuppressWarnings("unused") static void it(final boolean __) {
    /**/ }

  /**
   * Suppresses "variable unused" warning on a double.
   * @param __ The double to be ignored.
   */
  @SuppressWarnings("unused") static void it(final double __) {
    /**/ }

  /**
   * Suppresses "variable unused" warning on a long.
   * @param __ The long to be ignored.
   */
  @SuppressWarnings("unused") static void it(final long __) {
    /**/ }

  /**
   * Suppresses "variable unused" warning on an Object.
   * @param __ The object to be ignored.
   */
  @SuppressWarnings("unused") static void it(final Object __) {
    /**/ }
  
}
