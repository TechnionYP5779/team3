package il.org.spartan.utils;

import org.junit.*;

@SuppressWarnings("static-method") public class StrTest {
  @Test public void test() {
    Str st=new Str();
    st=new Str("abc");
    st.set("0");
    assert(st.inner().equals("0"));
    assert(st.isEmptyx()==false);
    assert(st.notEmpty());
  }
}
