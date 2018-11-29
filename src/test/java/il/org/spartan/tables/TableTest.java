package il.org.spartan.tables;

import static il.org.spartan.Utils.*;

import java.io.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class TableTest {
  @Test public void Table1() {
    try (Table t = new Table(box.it(11245)); Table t2 = new Table("", TableRenderer.builtin.values())) {
      assert t.equals(t2);
    }
  }

  @Test public void Table2() {
    try (Table t = new Table("1".getClass()); Table t1 = new Table(box.it(1)); Table t2 = new Table("123", TableRenderer.builtin.TEX);) {
      assert t1 != null;
      assert t != null;
      t.reset();
      assert t2 != null;
    }
  }

  @Test public void Table3() {
    try (Table t = new Table("a", cantBeNull(System.getProperty("user.dir")));) {
      assert t != null;
    }
  }

  @Test public void Table4() {
    try (Table t = new Table("1".getClass(), cantBeNull(System.getProperty("user.dir")));) {
      assert t != null;
    }
  }

  @Test public void baseName() {
    try (Table t = new Table("1".getClass(), cantBeNull(System.getProperty("user.dir")));) {
      assert t != null;
      assert t.baseName().contains("/") || t.baseName().contains("\\");
    }
  }

  @Test public void close() {
    try (Table t = new Table("1".getClass(), cantBeNull(System.getProperty("user.dir")));) {
      assert t.add(Statistic.NA).length() == 1;
    }
  }

  @After public void col() {
    new File(".csv").delete();
    new File(".markdown").delete();
    new File(".tex").delete();
    new File(".tex2").delete();
    new File(".txt").delete();
    new File("a.csv").delete();
    new File("a.markdown").delete();
    new File("a.tex").delete();
    new File("a.tex2").delete();
    new File("a.txt").delete();
  }

  @Test public void noStatistics() {
    try (Table t = new Table("1".getClass(), cantBeNull(System.getProperty("user.dir")));) {
      assert t.noStatistics() == t;
      t.nl();
      assert t.length() == 2;
    }
  }

  @Test public void description() {
    try (Table t = new Table("1".getClass(), cantBeNull(System.getProperty("user.dir")));) {
      assert t.description().contains("The table has");
    }
  }
}
