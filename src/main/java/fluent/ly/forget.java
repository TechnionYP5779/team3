package fluent.ly;

/** This interface contains methods that do nothing and document the fact that
 * some Object or value are not used in a function. Calling these functions
 * suppresses the "variable unused" warning that would usually be caused.
 * @author Yossi Gil
 * @since 2017-04-16 */
@SuppressWarnings("unused") public interface forget {
  /** Suppresses "variable unused" warning on a variable number of arguments.
   * @param _1 The first object to be ignored.
   * @param _2 The rest of the varargs. */
   static void all(final Object _1, final Object... _2) {
     
    /**/ }

  /** Suppresses "variable unused" warning on a boolean.
   * @param __ The boolean to be ignored. */
  static void it(final boolean __) {
    /**/ }

  /** Suppresses "variable unused" warning on a double.
   * @param __ The double to be ignored. */
  static void it(final double __) {
    /**/ }

  /** Suppresses "variable unused" warning on a long.
   * @param __ The long to be ignored. */
  static void it(final long __) {
    /**/ }

  /** Suppresses "variable unused" warning on an Object.
   * @param __ The object to be ignored. */
  static void it(final Object __) {
    /**/ }
  
  
  
  static void ______unused(final long l, final Object... os) {
    forget.it(l);
    forget.all(os);
  }

  /** A do nothing method to document the fact that some <code>Object</code>(s)
   * parameter(s) (or local variable(s)) are not used by a function. Calling this
   * method saves the caller the trouble of suppressing a "variable unused"
   * warnings on the argument(s).
   * @param ____ the unused parameters */
  static void ______unused(final Object... ____) {
    unused(____);
  }
  
  
  static void unuse(final long __, final Object... ____) {
    forget.it(__);
    forget.it(____);
  }

  /** A do nothing method to document the fact that a <code><b>double</b></code>
   * parameter, along with a optional list of {@link Object}s are not used by a
   * function, and to suppress the warning.
   * @param __   the unused parameter
   * @param ____ more unused parameters */
  static void unused(final double __, final double... ____) {
    forget.it(__);
    forget.it(____);
  }

  static void unused(final double __, final Object... ____) {
    forget.it(__);
    forget.it(____);
  }

  /** A do nothing method to document the fact that a <code><b>long</b></code>
   * parameter, along with a optional list of {@link Object}s are not used by a
   * function, and to suppress the warning.
   * @param __   the unused parameter
   * @param ____ more unused parameters */
  static void unused(final int __, final int... ____) {
    forget.it(__);
    forget.it(____);
  }

  /** A do nothing method to document the fact that a <code><b>long</b></code>
   * parameter, along with a optional list of {@link Object}s are not used by a
   * function, and to suppress the warning.
   * @param __   the unused parameter
   * @param ____ more unused parameters */
  static void unused(final long __, final long... ____) {
    forget.it(__);
    forget.it(____);
  }

  /** A do nothing method to document the fact that some <code>Object</code>(s)
   * parameter(s) (or local variable(s)) are not used by a function. Calling this
   * method saves the caller the trouble of suppressing a "variable unused"
   * warnings on the argument(s).
   * @param ____ the unused parameters */
  static void unused(final Object... ____) {
    forget.it(____);
  }

 
  
  
}
