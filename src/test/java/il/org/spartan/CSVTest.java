package il.org.spartan;

import static il.org.spartan.Utils.*;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

import java.io.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class CSVTest {
  public enum M {
    a, b;
  }

  @Test public void combine1() {
    assert "56,50,40".equals(cantBeNull(CSV.combine(cantBeNull(box(new int[] { 56, 50, 40 })))));
  }

  @Test public void combine2() {
    assert CSV.combine(new Class<?>[] { Integer.class, Long.class }).equals(Integer.class.getName() + "," + Long.class.getName());
  }

  @Test public void combine3() {
    assert "a,b".equals(CSV.combine(new M[] { M.a, M.b }));
  }

  @Test public void load() throws IOException {
    final File f = new File("test.csv");
    final StringBuilder b = new StringBuilder();
    b.append("1");
    b.append(",");
    b.append("2");
    b.append("\n");
    b.append("1");
    b.append(",");
    b.append("2");
    b.append("\n");
    try (PrintWriter p = new PrintWriter(f)) {
      p.write(b + "");
      p.close();
    }
    final String[][] s = CSV.load(f);
    final StringBuffer results = new StringBuffer();
    final String separator = ",";
    for (final String[] element : s) {
      results.append('[');
      for (int j = 0; j < element.length; ++j)
        if (j > 0)
          results.append(element[j]);
        else
          results.append(element[j]).append(separator);
      results.append(']');
    }
    azzert.that(results + "", is("[1,2][1,2]"));
    f.delete();
  }

  @Test public void save() throws IOException {
    final File f = new File("test.csv");
    @NotNull final String[][] values = new @NotNull String[2][2];
    values[0][0] = "1";
    values[0][1] = "2";
    values[1][0] = "1";
    values[1][1] = "2";
    CSV.save(f, values);
    f.delete();
  }

  @Test public void splitToClasses() {
    azzert.that(new String[0], is(CSV.splitToClasses("")));
    azzert.that(new Class<?>[] { Integer.class, String.class, Long.class },
        is(CSV.splitToClasses("java.lang.Integer,java.lang.String,java.lang.Long")));
  }

  @Test public void unescape() {
    assert CSV.unescape("\\0") == null;
    azzert.that(CSV.unescape("\\n"), is("\n"));
    azzert.that(CSV.unescape("\\r"), is("\r"));
    azzert.that(CSV.unescape("\\t"), is("\t"));
    azzert.that(CSV.unescape("\\."), is(","));
    azzert.that(CSV.unescape("\\\\"), is("\\"));
  }

  @Test public void escape() {
    azzert.that(CSV.escape(null), is("\\0"));
  }
}
