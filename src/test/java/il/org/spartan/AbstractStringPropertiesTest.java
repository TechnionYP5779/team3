package il.org.spartan;

import java.util.*;

import org.junit.*;

import il.org.spartan.AbstractStringProperties.*;

@SuppressWarnings( "static-method" ) public class AbstractStringPropertiesTest {

  @Test public void CSV() {
    assert("".equals(Renderer.CSV.headerEnd()));
    assert("1".equals(Renderer.CSV.makeField("1")));
    assert("".equals(Renderer.CSV.makeField(null)));
    assert("".equals(Renderer.CSV.allBottom()));
    assert("".equals(Renderer.CSV.allTop()));
    assert("".equals(Renderer.CSV.lineBegin()));
    assert("".equals(Renderer.CSV.lineEnd()));
  }
  
  @Test public void MATRIX() {
    assert("".equals(Renderer.MATRIX.allBottom()));
    assert("".equals(Renderer.MATRIX.allTop()));
    assert(" ".equals(Renderer.MATRIX.delimiter()));
    assert("".equals(Renderer.MATRIX.headerEnd()));
    assert("".equals(Renderer.MATRIX.lineBegin()));
    assert("".equals(Renderer.MATRIX.lineEnd()));
    assert("  1".equals(Renderer.MATRIX.makeField("1")));
  }
  
  @Test public void LaTeX() {
    assert("\\bottomrule\n".equals(Renderer.LaTeX.allBottom()));
    assert("\\toprule\n".equals(Renderer.LaTeX.allTop()));
    assert(" &\t\t".equals(Renderer.LaTeX.delimiter()));
    assert("\n\\midrule".equals(Renderer.LaTeX.headerEnd()));
    assert("".equals(Renderer.LaTeX.lineBegin()));
    assert("\\\\".equals(Renderer.LaTeX.lineEnd()));
    assert("1".equals(Renderer.LaTeX.makeField("1")));
  }
  
  @Test public void AbstractStringProperties() {
    
    List<String> list = new ArrayList<>(); 
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");
    list.add("5");
    
    assert("1,2,3,4,5".equals(AbstractStringProperties.Renderer.CSV.makeLine(list)));
  }
}
