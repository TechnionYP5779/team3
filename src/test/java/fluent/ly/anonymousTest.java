package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class anonymousTest {
  @Test public void usecase0() {
    assert anonymous.ly(() -> true);
  }

  @Test public void usecase1() {
    assert anonymous.ly(() -> 2) == 2;
  }

  @Test public void usecase2() {
    assert anonymous.ly(() -> 2.5) == 2.5;
  }

  @Test public void usecase3() {
    assert "hello".equals(anonymous.ly(() -> "hello"));
  }
}
