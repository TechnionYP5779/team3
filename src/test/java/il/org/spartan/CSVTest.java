package il.org.spartan;


import static il.org.spartan.Utils.*;
import java.io.*;
import static fluent.ly.box.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class CSVTest {
  public enum M{
    a,b; 
  }
  
  
  @Test public void combine1() {
    assert "56,50,40".equals(cantBeNull(CSV.combine(cantBeNull(box(new int[] { 56, 50, 40 }))))); 
  }
  
   @Test public void combine2() {
    assert (CSV.combine(new Class<?>[] { Integer.class, Long.class }).equals(Integer.class.getName() + "," + Long.class.getName())); 
  }
   
   @Test public void combine3() {
     assert ("a,b".equals(CSV.combine(new M[] { M.a, M.b }))); 
   }
   @Test public void load() throws IOException {
      File f=  new File("test.csv"); 
      StringBuilder b = new StringBuilder();
      b.append("1"); 
      b.append(","); 
      b.append("2"); 
      b.append("\n"); 
      
      b.append("1"); 
      b.append(","); 
      b.append("2"); 
      b.append("\n"); 
      try(PrintWriter p = new PrintWriter(f)){
        p.write(b + "");
        p.close();
      }
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
      azzert.that(results + "", azzert.is("[1,2][1,2]")); 
   }
   @Test public void save() throws IOException{
     File f=  new File("test.csv");
     @NotNull String[][] values = new @NotNull String[2][2];
     values[0][0] = "1"; 
     values[0][1] = "2"; 
     values[1][0] = "1"; 
     values[1][1] = "2";
     
     CSV.save(f,values); 
   }
   
   @Test public void splitToClasses() {
     azzert.that(new String[0], azzert.is(CSV.splitToClasses("")));
     
     azzert.that(new Class<?>[] { Integer.class, String.class, Long.class },
        azzert.is(CSV.splitToClasses("java.lang.Integer,java.lang.String,java.lang.Long")));
    
     
   }

      @Test public void unescape()  {
        assert(CSV.unescape("\\0") == null);
        azzert.that(CSV.unescape("\\n"), azzert.is("\n"));
        azzert.that(CSV.unescape("\\r"), azzert.is("\r"));
        azzert.that(CSV.unescape("\\t"), azzert.is("\t"));
        azzert.that(CSV.unescape("\\."), azzert.is(","));
        azzert.that(CSV.unescape("\\\\"), azzert.is("\\"));

      }
      
      @Test public void escape()  {
        azzert.that(CSV.escape(null), azzert.is("\\0"));

      }
}

