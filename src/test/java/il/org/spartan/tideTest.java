package il.org.spartan;

import org.junit.*;

@SuppressWarnings( "static-method" ) public class tideTest {
  @Test public void clean() {
    assert("public class CallingMethodsInSameClass{public static void main(String[] args){printOne();printOne();printTwo();}public static void printOne(){System.out.println(\"Hello World\");}public static void printTwo(){printOne();printOne();}}"
        .equals(tide.clean("public class CallingMethodsInSameClass\r\n{\r\n  public static void main(String[] args) {\r\n"
            + "    printOne();\r\n    printOne();\r\n    printTwo();\r\n  }\r\n\r\n  public static void printOne() {\r\n"
            + "    System.out.println(\"Hello World\");\r\n  }\r\n\r\n  public static void printTwo() {\r\n    printOne();\r\n"
            + "    printOne();\r\n  }\r\n}"))); 
  }
  
  @Test public void eq() {
    assert(tide.eq("ab","ab"));
    assert(!tide.eq("ab","bc"));
    assert(tide.eq(null,null));
  }
}
