package il.org.spartan.tables;

import org.junit.*;

import fluent.ly.*;

import static il.org.spartan.Utils.*;

@SuppressWarnings({"static-method","resource"}) public class TableTest {
  
  @Test public void Table1() {
    assert ((new Table(box.it(11245))).equals(new Table("", TableRenderer.builtin.values())));
  }
  @Test public void Table2() {
    assert(new Table(box.it(1))!=null);
    assert(new Table("1".getClass())!=null);
    assert(new Table("123", TableRenderer.builtin.TEX) != null); 
  }
  
  @Test public void Table3() {
    assert(new Table("123",cantBeNull(System.getProperty("user.dir"))) != null); 
  }
  
  @Test public void Table4() {
    assert(new Table("1".getClass(),cantBeNull(System.getProperty("user.dir"))) != null); 
  }
  
  @Test public void baseName() {
    Table t = new Table("1".getClass(), cantBeNull(System.getProperty("user.dir"))); 
    assert(t != null); 
    assert(t.baseName().contains("/") || t.baseName().contains("\\") ); 
  }
  
  @Test public void close() {
    Table t = new Table("1".getClass(), cantBeNull(System.getProperty("user.dir"))); 
    assert(t.add(Statistic.NA).length()==1);
    t.close(); 
  }
  
  @Test public void col() {
    Table t = new Table("1".getClass(), cantBeNull(System.getProperty("user.dir"))); 
    assert("{null=1, 1=1.5}".equals(t.col("1", 1.5) + ""));
    assert("{null=1, 1=1.5, 2=2}".equals(t.col("2", 2) + ""));
    assert("{null=1, 1=1.5, 2=2, 3=3}".equals(t.col("3", 3L) + ""));
   
  }
  @Test public void noStatistics() {
    Table t = new Table("1".getClass(), cantBeNull(System.getProperty("user.dir"))); 
    assert(t.noStatistics() == t);
    t.nl();
    assert(t.length() == 2);
  }
    
  @Test public void description() {
    assert ((new Table("1".getClass(), cantBeNull(System.getProperty("user.dir")))).description().contains("The table has"));
  }
 
}
