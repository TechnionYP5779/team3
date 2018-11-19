package il.org.spartan.tables;

import org.junit.*;

import il.org.spartan.tables.TableRenderer.*;

@SuppressWarnings({ "static-method" }) public class TableRendererTest {
  String NL = System.getProperty("line.separator");

  @Test public void afterHeader() {
    builtin.MARKDOWN.setHeaderCount(1);
    assert builtin.TEX.afterHeader().equals("\\midrule" + NL);
    assert builtin.TEX2.afterHeader().equals("\\hline" + NL);
    assert builtin.MARKDOWN.afterHeader().equals("| --- |" + NL);
  }

  @Test public void afterTable() {
    assert builtin.TEX.afterTable().equals("\\bottomrule" + NL);
    assert builtin.TEX2.afterTable().equals("\\hline" + NL);
    assert builtin.MARKDOWN.afterTable().equals(NL);
  }

  @Test public void arraySeparator() {
    assert builtin.TEX.arraySeparator().equals(", ");
    assert builtin.TEX2.arraySeparator().equals(", ");
  }

  @Test public void beforeFooter() {
    assert builtin.TEX.beforeFooter().equals("\\midrule" + NL);
    assert builtin.TEX2.beforeFooter().equals("\\hline" + NL);
  }

  @Test public void beforeTable() {
    assert builtin.TEX.beforeTable().equals("\\toprule" + NL);
    assert builtin.TEX2.beforeTable().equals("\\hline" + NL);
    assert builtin.MARKDOWN.beforeTable().equals(NL);
  }

  @Test public void nil() {
    assert builtin.TEX.nil().equals("$\\#$");
  }

  @Test public void recordEnd() {
    assert builtin.TEX.recordEnd().equals(" \\\\" + NL);
    assert builtin.MARKDOWN.recordEnd().equals(" |" + NL);
  }

  @Test public void footerEnd() {
    assert builtin.TEX2.footerEnd().equals("\\\\" + NL);
    assert builtin.CSV.footerEnd().equals(NL);
  }

  @Test public void recordSeparator() {
    assert builtin.TEX.recordSeparator().equals("\t&\t");
    assert builtin.TEX2.recordSeparator().equals("\t&\t");
    assert builtin.CSV.recordSeparator().equals(",");
    assert builtin.MARKDOWN.recordSeparator().equals(" | ");
  }

  @Test public void render() {
    assert builtin.TEX.render(Statistic.Σ).equals("\\hfill$\\Sum$");
    assert builtin.TEX.render(Statistic.σ).equals("\\hfill$\\sigma$");
    assert builtin.TEX.render(Statistic.min).equals("\\hfill$\\min$");
    assert builtin.TEX.render(Statistic.max).equals("\\hfill$\\max$");
    assert builtin.TEX.render(Statistic.median).equals("\\hfillmedian");
  }

  @Test public void recordBegin() {
    assert builtin.MARKDOWN.recordBegin().equals("|");
  }

  @Test public void tab() {
    assert TableRenderer.tab().equals("\t");
  }

  @Test public void empty() {
    assert TableRenderer.empty().equals("");
  }
}
