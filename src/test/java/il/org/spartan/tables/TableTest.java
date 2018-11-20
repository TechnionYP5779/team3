package il.org.spartan.tables;

import org.junit.*;

import fluent.ly.*;

import static il.org.spartan.Utils.*;

@SuppressWarnings({"static-method","resource"}) public class TableTest {
  
  @Test public void Table1() {
    Integer n = box.it(11245);
    Table t = new Table(n);
    Table t1= new Table("",TableRenderer.builtin.values()); 
    assert(t.equals(t1));
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
    assert(t.baseName().contains("\\")); 
  }
  
  @Test public void close() {
    Table t = new Table("1".getClass(), cantBeNull(System.getProperty("user.dir"))); 
    assert(t.add(Statistic.NA).length()==1);
    t.close(); 
  }
  
  @Test public void col() {
    Table t = new Table("1".getClass(), cantBeNull(System.getProperty("user.dir"))); 
    Table t1 = t.col("1", 1.5);
    assert(t1.toString().equals("{null=1, 1=1.5}"));
    assert(t.col("2", 2).toString().equals("{null=1, 1=1.5, 2=2}"));
    assert(t.col("3",(long) 3).toString().equals("{null=1, 1=1.5, 2=2, 3=3}"));
   
  }
  @Test public void noStatistics() {
    Table t = new Table("1".getClass(), cantBeNull(System.getProperty("user.dir"))); 
    assert(t.noStatistics() == t);
    t.nl();
    assert(t.length() == 2);
  }
    
  @Test public void description() {
    Table t = new Table("1".getClass(), cantBeNull(System.getProperty("user.dir"))); 
    assert(t.description().contains("The table has"));
  }
 
}
