package il.org.spartan.tables;



import org.junit.*;



@SuppressWarnings({"static-method","resource"}) public class TableTest {
  
  @Test public void Table1() {
    Integer n = new Integer(11245);
    Table t = new Table(n);
    Table t1= new Table("",TableRenderer.builtin.values()); 
    assert(t.equals(t1));
  }
  @Test public void Table2() {
    //Table t = new Table("Integer","C:\\" );
  }
}
