package il.org.spartan.tables;

import org.junit.*;

import il.org.spartan.tables.TableRenderer.*;

@SuppressWarnings("static-method") public class TableRendererTest {
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
    assert ", ".equals(builtin.TEX.arraySeparator());
    assert ", ".equals(builtin.TEX2.arraySeparator());
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
    assert "$\\#$".equals(builtin.TEX.nil());
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
    assert "\t&\t".equals(builtin.TEX.recordSeparator());
    assert "\t&\t".equals(builtin.TEX2.recordSeparator());
    assert ",".equals(builtin.CSV.recordSeparator());
    assert " | ".equals(builtin.MARKDOWN.recordSeparator());
  }

  @Test public void render() {
    assert "\\hfill$\\Sum$".equals(builtin.TEX.render(Statistic.Σ));
    assert "\\hfill$\\sigma$".equals(builtin.TEX.render(Statistic.σ));
    assert "\\hfill$\\min$".equals(builtin.TEX.render(Statistic.min));
    assert "\\hfill$\\max$".equals(builtin.TEX.render(Statistic.max));
    assert "\\hfillmedian".equals(builtin.TEX.render(Statistic.median));
  }

  @Test public void recordBegin() {
    assert "|".equals(builtin.MARKDOWN.recordBegin());
  }

  @Test public void tab() {
    assert "\t".equals(TableRenderer.tab());
  }

  @Test public void empty() {
    assert "".equals(TableRenderer.empty());
  }
}
