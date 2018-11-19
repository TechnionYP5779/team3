package fluent.ly;

/** This interface contains methods that do nothing and document the fact that
 * some Object or value are not used in a function. Calling these functions
 * suppresses the "variable unused" warning that would usually be caused.
 * @author Yossi Gil
 * @since 2017-04-16 */
public interface forget {
  /** Suppresses "variable unused" warning on a variable number of arguments.
   * @param _1 The first object to be ignored.
   * @param _2 The rest of the varargs. */
   static void all(final Object _1, final Object... _2) {
     forget.it(_1);
     forget.it(_2);
    /**/ }

  /** Suppresses "variable unused" warning on a boolean.
   * @param __ The boolean to be ignored. */
  static void it(final boolean __) {
    forget.it(__);
    /**/ }

  /** Suppresses "variable unused" warning on a double.
   * @param __ The double to be ignored. */
  static void it(final double __) {
    forget.it(__);
    /**/ }

  /** Suppresses "variable unused" warning on a long.
   * @param __ The long to be ignored. */
  static void it(final long __) {
    forget.it(__);
    /**/ }

  /** Suppresses "variable unused" warning on an Object.
   * @param __ The object to be ignored. */
  static void it(final Object __) {
    forget.it(__);
    /**/ }
}
