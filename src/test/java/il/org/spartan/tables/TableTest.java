package il.org.spartan.tables;

import org.junit.*;

import fluent.ly.*;

import static il.org.spartan.Utils.*;

import java.io.*;

@SuppressWarnings({"static-method","resource"}) public class TableTest {
  
  @Test public void Table1() {
    assert ((new Table(box.it(11245))).equals(new Table("", TableRenderer.builtin.values())));
  }
  @Test public void Table2() {
    assert(new Table(box.it(1))!=null);
    Table t = new Table("1".getClass()); 
    assert(t!=null);
    t.reset();
    t = new Table("123", TableRenderer.builtin.TEX);
    assert(t != null);
  }
  
  @Test public void Table3() {
    Table t = new Table("a",cantBeNull(System.getProperty("user.dir")));
    assert(t != null); 
    t.close();
    new File("a.csv").delete();
    new File("a.markdown").delete();
    new File("a.tex").delete();
    new File("a.tex2").delete();
    new File("a.txt").delete();
  }
  
  @Test public void Table4() {
    Table t = new Table("1".getClass(),cantBeNull(System.getProperty("user.dir"))); 
   assert(t != null); 
   t.close();
   new File(".csv").delete();
   new File(".markdown").delete();
   new File(".tex").delete();
   new File(".tex2").delete();
   (new File(".txt")).delete();
  }
  
  
  @Test public void baseName() {
    Table t = new Table("1".getClass(), cantBeNull(System.getProperty("user.dir"))); 
    assert(t != null); 
    assert(t.baseName().contains("/") || t.baseName().contains("\\") ); 
    t.close();
    new File(".csv").delete();
    new File(".markdown").delete();
    new File(".tex").delete();
    new File(".tex2").delete();
    (new File(".txt")).delete();
    
  }
  
  @Test public void close() {
    Table t = new Table("1".getClass(), cantBeNull(System.getProperty("user.dir"))); 
    assert(t.add(Statistic.NA).length()==1);
    t.close(); 
  }
  
  @Test public void col() {
    Table t = new Table("1".getClass(), cantBeNull(System.getProperty("user.dir"))); 
    t.close();
    new File(".csv").delete();
    new File(".markdown").delete();
    new File(".tex").delete();
    new File(".tex2").delete();
    new File(".txt").delete();
    assert("{null=1, 1=1.5}".equals(t.col("1", 1.5) + ""));
    assert("{null=1, 1=1.5, 2=2}".equals(t.col("2", 2) + ""));
    assert("{null=1, 1=1.5, 2=2, 3=3}".equals(t.col("3", 3L) + ""));
    
  
    
   
  }
  @Test public void noStatistics() {
    Table t = new Table("1".getClass(), cantBeNull(System.getProperty("user.dir"))); 
    assert(t.noStatistics() == t);
    t.nl();
    assert(t.length() == 2);
    t.close();
    new File(".csv").delete();
    new File(".markdown").delete();
    new File(".tex").delete();
    new File(".tex2").delete();
    (new File(".txt")).delete();
  }
    
  @Test public void description() {
    Table t = new Table("1".getClass(), cantBeNull(System.getProperty("user.dir")));
    assert (t.description().contains("The table has"));
    t.close();
    new File(".csv").delete();
    new File(".markdown").delete();
    new File(".tex").delete();
    new File(".tex2").delete();
    (new File(".txt")).delete();
  }
 
}
