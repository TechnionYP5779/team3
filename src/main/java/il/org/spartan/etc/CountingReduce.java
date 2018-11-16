package il.org.spartan.etc;

import fluent.ly.*;
import il.org.spartan.utils.*;

/** Reducer that concatenate strings
 * @author Yossi Gil
 * @since 2017-03-19 */
public class CountingReduce extends Reduce<Integer> {
  @SuppressWarnings("null") @Override public final Integer reduce(final Integer i1, final Integer i2) {
    return box.box(unbox.unbox(i1) + unbox.unbox(i2));
  }

  @Override public final Integer reduce() {
    return box.box(0);
  }
}