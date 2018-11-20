package fluent.ly;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings("static-method") public class HasTest {
  @Nullable private final String nul = null;

  @Test public void seriesA01() {
    azzert.aye(has.nulls(nul));
  }

  @Test public void seriesA02() {
    azzert.nay(has.nulls("A"));
  }
}
