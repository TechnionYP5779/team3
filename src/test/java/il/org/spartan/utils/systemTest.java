package il.org.spartan.utils;

import java.util.*;

import org.junit.*;

public class systemTest {
  
  @Test @SuppressWarnings({ "deprecation", "static-method", "resource" }) public void basic_test() {
    if (!system.isWindows())
      return;
    assert (system.isWindows());
    assert (system.bash("echo 12") == null);
    assert (system.callingClassUniqueWriter() != null);
    assert (system.ephemeral(null) != null);
    assert (system.dumpOutput(null) == null);
    assert ("x=1".equals(system.essence("x=1")));
    assert ("abc.essence".equals(system.essenced("abc")));
    assert ("CWD".equals(system.folder2File(".")));
    assert (system.isBalanced("()"));
    assert (system.isBalanced("([{}])"));
    assert (!system.isBalanced(")"));
    assert (!system.isBalanced("]"));
    assert (!system.isBalanced("}"));
    assert ("systemTest".equals(system.myShortClassName()));
    assert ("sun.reflect.NativeMethodAccessorImpl".equals(system.myCallerFullClassName()));
    assert (system.now().contains("-"));
    assert ("\nabc".equals(system.read(new Scanner("abc"))));
    assert (system.runScript() != null);
    assert (system.shellEssenceMetrics("text") == null);
    assert ("User".equals(system.userName()));
    assert (system.wc("") == 0);
    assert (system.wc("a b c") == 3);
    assert (system.wc(null) == 0);
  }
}
