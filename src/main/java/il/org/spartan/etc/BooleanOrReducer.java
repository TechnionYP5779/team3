package il.org.spartan.etc;

import static fluent.ly.box.*;
import il.org.spartan.utils.*;

/** Boolean or reducer
 * @author oran1248
 * @since 2017-04-20 */
public class BooleanOrReducer extends Reduce<Boolean> {
  @Override public Boolean reduce() {
    return box(false);
  }

  @Override public Boolean reduce(final Boolean r1, final Boolean r2) {
    return box(Boolean.TRUE.equals(r1) || Boolean.TRUE.equals(r2));
  }
}
