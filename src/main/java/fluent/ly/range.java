package fluent.ly;

//import java.util.*;
//import java.util.stream.*;


public class range {
  
  //params
  int from;
//  boolean from_defined;
  //funcs & methods
  private range() {
//    from_defined=false;
  }

  private void set_from(int f) {
    from=f;
//    from_defined=true;
  }
  
  public static range from(int f) {
    range f_range=new range();
    f_range.set_from(f);
    return f_range;    
  }
  
  public int from() {
    return from;
  }
 
}



