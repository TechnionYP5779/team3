package il.org.spartan.utils;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class systemTest {
  
  @Test public void basic_test() {
    if (!system.isWindows())
      return;
    assert (system.isWindows());
    assert (system.bash("echo 12") == null);
    assert (system.callingClassUniqueWriter() != null);
    assert (system.ephemeral(null) != null);
    assert (system.dumpOutput(null) == null);
    assert ("abc.essence".equals(system.essenced("abc")));
    assert ("CWD".equals(system.folder2File(".")));
    assert (system.isBalanced("()"));
    assert (system.isBalanced("([{}])"));
    assert (!system.isBalanced(")"));
    assert (!system.isBalanced("]"));
    assert (!system.isBalanced("}"));
    assert ("systemTest".equals(system.myShortClassName()));
    assert (system.myCallerFullClassName()!=null);
    assert (system.now().contains("-"));
    try (
      Scanner s = new Scanner("abc");){
      assert ("\nabc".equals(system.read(s)));
      s.close();
    }
    assert (system.runScript() != null);
    assert (system.shellEssenceMetrics("text") == null);
    assert (system.userName()!=null);
    assert (system.wc("") == 0);
    assert (system.wc("a b c") == 3);
    assert (system.wc(null) == 0);
  }
}
