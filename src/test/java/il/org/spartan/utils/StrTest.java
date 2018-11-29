package il.org.spartan.utils;

import org.junit.*;

@SuppressWarnings("static-method") public class StrTest {
  @Test public void test() {
    final Str st = new Str("abc");
    st.set("0");
    assert "0".equals(st.inner());
    assert !st.isEmptyx();
    assert st.notEmpty();
  }
}
