package il.org.spartan.utils;

import org.junit.*;

@SuppressWarnings("static-method")  public class BinaryTest {
  @Test public void and() {
    assert(Binary.and(Binary.T, Binary.T) == Binary.T);
    assert(Binary.asBoolean(Binary.T) == Binary.T);
    assert(Binary.eq(Binary.T, Binary.T) == Binary.T);
    assert(Binary.eq(Binary.F, Binary.T) != Binary.T);
    assert(Binary.not(Binary.T) == Binary.F);
    assert(Binary.not(Binary.F) != Binary.F);
    assert(Binary.or(Binary.T, Binary.T) == Binary.T);
    assert(Binary.T.hashCode() == 1);
  }
}
