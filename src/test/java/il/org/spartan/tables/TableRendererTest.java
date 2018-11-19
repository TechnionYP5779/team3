package il.org.spartan.tables;

import org.junit.*;

import il.org.spartan.tables.TableRenderer.*;

public class TableRendererTest {
  String NL = System.getProperty("line.separator");
  @Test public void afterHeader() {
    assert(builtin.TEX.afterHeader().equals("\\midrule" + NL));
    assert(builtin.TEX2.afterHeader().equals("\\hline" + NL));
  }
  @Test public void afterTable() {
    assert(builtin.TEX.afterTable().equals("\\bottomrule" + NL));
    assert(builtin.TEX2.afterTable().equals("\\hline" + NL));
  }
  @Test public void arraySeparator() {
    assert(builtin.TEX.arraySeparator().equals(", "));
    assert(builtin.TEX2.arraySeparator().equals(", "));
  }
  
  @Test public void beforeFooter() {
    assert(builtin.TEX.beforeFooter().equals("\\midrule" + NL));
    assert(builtin.TEX2.beforeFooter().equals("\\hline" + NL));
  }
  
  @Test public void beforeTable() {
    assert(builtin.TEX.beforeTable().equals("\\toprule" + NL));
    assert(builtin.TEX2.beforeTable().equals("\\hline" + NL));
  }
  @Test public void nil() {
    assert(builtin.TEX.nil().equals("$\\#$"));
  } 
  @Test public void recordEnd() {
   assert(builtin.TEX.recordEnd().equals(" \\\\" + NL));
  } 
  @Test public void footerEnd() {
    assert(builtin.TEX2.footerEnd().equals(" \\\\" + NL));
   } 
  @Test public void recordSeparator() {
    assert(builtin.TEX.recordSeparator().equals("\t&\t"));
    assert(builtin.TEX2.recordSeparator().equals("\t&\t"));
  } 
  @Test public void render() {
    assert(builtin.TEX.render(Statistic.Σ) == "\\hfill$\\Sum$"); 
    assert(builtin.TEX.render(Statistic.σ) == "\\hfill$\\sigma$"); 
    assert(builtin.TEX.render(Statistic.min) == "\\hfill$\\$"); 
    //assert(builtin.TEX.render(Statistic.max) == "\\hfill"); 
    //assert(builtin.TEX.render(Statistic.median) == "\\hfill"); 
    
  } 
}
