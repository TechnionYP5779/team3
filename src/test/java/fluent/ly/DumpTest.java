package fluent.ly;

import java.io.*;
import java.lang.management.*;

import org.junit.*;

import il.org.spartan.*;

public class DumpTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  @Before
  public void setUpStreams() {
      System.setOut(new PrintStream(outContent));
      System.setErr(new PrintStream(errContent));
  }

  @After
  public void restoreStreams() {
      System.setOut(originalOut);
      System.setErr(originalErr);
  }
  
  @Test
  public void test() {
    dump.go(ManagementFactory.getClassLoadingMXBean());
    dump.go(Utils.cantBeNull(ManagementFactory.getMemoryPoolMXBeans()), "a", "b");
    dump.go(ManagementFactory.getRuntimeMXBean());
    dump.go(getClass());
    dump.go(new String[] {"a", "b"}, "a", "b");
    dump.go((Object)null, "a", "b");
    assert outContent + "" != null;
  }
}
