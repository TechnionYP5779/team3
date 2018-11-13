package fluent.ly;

import java.util.*;

//import java.util.*;
//import java.util.stream.*;


public class range {
  
  public static class inner_range implements Iterable<Integer>{
  //params
    Integer from;
    Integer to;
    boolean from_defined;
    boolean to_defined;
    
    //funcs & methods
    inner_range() {
      from_defined=false;
      to_defined=false;
    }

    void set_from(int f) {
      from=new Integer(f);
      from_defined=true;
    }
    void set_to(int f) {
      to=new Integer(f);
      to_defined=true;
    }
    
    public Integer from() {
      if(from_defined){
        return from;
      }
      return null;
    }
    
    public inner_range to(int t) {
      this.set_to(t);
      return this;
    }
    public inner_range from(int f) {
      this.set_from(f);
      return this;
    }
    
    public Iterator<Integer> numbers(){
      if(from_defined) { 
      return iterator();
      }
      return new MyIterator(Integer.valueOf(Integer.MIN_VALUE));
    }

    @Override public Iterator<Integer> iterator() {
      
      return new MyIterator(from);
    }
    
    public class MyIterator implements Iterator<Integer> {

      MyIterator(Integer f){
        curr=Integer.valueOf(f.intValue());
      }
      
      Integer curr;

      @Override public boolean hasNext() {
          if (!to_defined) {
            return true;
          }
          return (curr.intValue()<to.intValue()-1);
      }

      @Override public Integer next() {
        curr=Integer.valueOf(curr.intValue()+1);
        return curr;
      }

  }
    
  }
 //--------------------------------------------------------------- 
  
  public static inner_range from(int f) {
    inner_range f_range=new inner_range();
    f_range.set_from(f);
    return f_range;    
  }
  
  public static inner_range to(int t) {
    inner_range t_range=new inner_range();
    t_range.set_to(t);
    return t_range;  
  }
 

}



