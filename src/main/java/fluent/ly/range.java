package fluent.ly;

//import java.util.*;
//import java.util.stream.*;


public class range {
  
  public static class inner_range{
  //params
    Integer from;
    boolean from_defined;
    
    
    //funcs & methods
    inner_range() {
      from_defined=false;
    }

    void set_from(int f) {
      from=new Integer(f);
      from_defined=true;
    }
    
    public Integer from() {
      if(from_defined){
        return from;
      }
      return null;
    }
    
    public inner_range to(int t) {
      return this;
    }
    public inner_range from(int f) {
      this.set_from(f);
      return this;
    }
  }
 //--------------------------------------------------------------- 
  
  public static inner_range from(int f) {
    inner_range f_range=new inner_range();
    f_range.set_from(f);
    return f_range;    
  }
  
  public static inner_range to(int t) {
    return new inner_range();
  }
 

}



