package il.org.spartan.utils;

import java.util.*;

import org.junit.*;

public class systemTest {
  
  @SuppressWarnings({ "deprecation", "static-method", "resource" }) @Test public void basic_test() {
    if(system.isWindows()) {
    assert(system.isWindows()==true);
    assert(system.bash("echo 12")==null);
    assert(system.callingClassUniqueWriter()!=null);
    assert(system.ephemeral(null)!=null);
    assert(system.dumpOutput(null)==null);
    assert(system.essence("x=1").equals("x=1"));
    assert(system.essenced("abc").equals("abc.essence"));
    assert(system.folder2File(".").equals("CWD"));
    assert(system.isBalanced("()"));
    assert(system.isBalanced("([{}])"));
    assert(system.isBalanced(")")==false);
    assert(system.isBalanced("]")==false);
    assert(system.isBalanced("}")==false);
    assert(system.myShortClassName().equals("systemTest"));
    
    assert(system.myCallerFullClassName().equals("sun.reflect.NativeMethodAccessorImpl"));
    assert(system.now().contains("-"));
    assert(system.read(new Scanner("abc")).equals("\nabc"));
    
    assert(system.runScript()!=null);
    assert(system.shellEssenceMetrics("text")==null);
    assert(system.userName().equals("User"));
    assert(system.wc("")==0);
    assert(system.wc("a b c")==3);
    assert(system.wc(null)==0);
    }
    
    
  }
}
