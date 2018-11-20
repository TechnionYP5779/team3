package il.org.spartan;



import java.io.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class CSVTest {
  public enum M{
    a,b; 
  }
  
  
  @Test public void combine1() {
    int[] arr = { 56, 50, 40 };
    Integer[] cs = box.box(arr); 
    assert(CSV.combine(cs).equals("56,50,40")); 
  }
  
   @Test public void combine2() {
    Class<?>[] cs = {Integer.class, Long.class}; 
    assert(CSV.combine(cs).equals(Integer.class.getName() + "," + Long.class.getName())); 
  }
   
   @Test public void combine3() {
     Enum[] cs = {M.a, M.b}; 
     assert(CSV.combine(cs).equals("a,b")); 
   }
   @Test public void load() throws IOException {
      File f=  new File("test.csv");
      PrintWriter p = new PrintWriter(f); 
      StringBuilder b = new StringBuilder();
      b.append("1"); 
      b.append(","); 
      b.append("2"); 
      b.append("\n"); 
      
      b.append("1"); 
      b.append(","); 
      b.append("2"); 
      b.append("\n"); 
      
      p.write(b.toString());
      p.close();
      String[][] s = CSV.load(f); 
           
      StringBuffer results = new StringBuffer();
      String separator = ","; 
      for (int i = 0; i < s.length; ++i)
      {
        results.append('[');
        for (int j = 0; j < s[i].length; ++j)
          if (j > 0)
            results.append(s[i][j]);
          else
            results.append(s[i][j]).append(separator);
        results.append(']');
      }
      azzert.that(results.toString(), azzert.is("[1,2][1,2]")); 
   }
   @Test public void save() throws IOException{
     File f=  new File("test.csv");
     String[][] values = new String[2][2];
     values[0][0] = "1"; 
     values[0][1] = "2"; 
     values[1][0] = "1"; 
     values[1][1] = "2";
     
     CSV.save(f,values); 
   }
   
   @Test public void splitToClasses() throws ClassNotFoundException {
     String s = "java.lang.Integer,java.lang.String,java.lang.Long"; 
     Class<?>[] c = {Integer.class, String.class, Long.class};
     CSV.splitToClasses(s);
    
   }
}

