package il.org.spartan;

import java.util.*;

import org.junit.*;

import il.org.spartan.AbstractStringProperties.*;

@SuppressWarnings( "static-method" ) public class AbstractStringPropertiesTest {

  @Test public void CSV() {
    assert(Renderer.CSV.headerEnd().equals(""));
    assert(Renderer.CSV.makeField("1").equals("1"));
    assert(Renderer.CSV.makeField(null).equals(""));
    assert(Renderer.CSV.allBottom().equals(""));
    assert(Renderer.CSV.allTop().equals(""));
    assert(Renderer.CSV.lineBegin().equals(""));
    assert(Renderer.CSV.lineEnd().equals(""));
  }
  
  @Test public void MATRIX() {
    assert(Renderer.MATRIX.allBottom().equals(""));
    assert(Renderer.MATRIX.allTop().equals(""));
    assert(Renderer.MATRIX.delimiter().equals(" "));
    assert(Renderer.MATRIX.headerEnd().equals(""));
    assert(Renderer.MATRIX.lineBegin().equals(""));
    assert(Renderer.MATRIX.lineEnd().equals(""));
    assert(Renderer.MATRIX.makeField("1").equals("  1"));
  }
  
  @Test public void LaTeX() {
    assert(Renderer.LaTeX.allBottom().equals("\\bottomrule\n"));
    assert(Renderer.LaTeX.allTop().equals("\\toprule\n"));
    assert(Renderer.LaTeX.delimiter().equals(" &\t\t"));
    assert(Renderer.LaTeX.headerEnd().equals("\n\\midrule"));
    assert(Renderer.LaTeX.lineBegin().equals(""));
    assert(Renderer.LaTeX.lineEnd().equals("\\\\"));
    assert(Renderer.LaTeX.makeField("1").equals("1"));
  }
  
  @Test public void AbstractStringProperties() {
    
    List<String> list = new ArrayList<>(); 
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");
    list.add("5");
    
    assert(AbstractStringProperties.Renderer.CSV.makeLine(list).equals("1,2,3,4,5"));
  }
  
  @Test public void AbstractStringProperties1() {
   
  }
}
