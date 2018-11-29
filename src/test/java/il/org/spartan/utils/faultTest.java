package il.org.spartan.utils;

import static fluent.ly.box.*;

import org.junit.*;

@SuppressWarnings("static-method") public class faultTest {
  @Test public void done() {
    assert fault.done().contains("Stack trace: [[[.................");
  }

  @Test public void trace() {
    assert fault.trace().contains("java.lang.AssertionError");
  }

  @Test public void dump() {
    assert fault.dump().contains("FAULT:");
  }

  @Test public void unreachable() {
    assert !fault.unreachable();
  }

  @Test public void bool() {
    assert !fault.bool(box(1));
  }

  @Test public void specifically() {
    final String value = fault.specifically("test failed because", box(1));
    assert value.contains("FAULT:") && value.contains("test failed because");
  }
}
