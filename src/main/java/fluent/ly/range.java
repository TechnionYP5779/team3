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
      to_defined=from_defined = false;
    }

    void set_from(int f) {
      from=Integer.valueOf(f);
      from_defined=true;
    }
    void set_to(int f) {
      to=Integer.valueOf(f);
      to_defined=true;
    }
    
    public Integer from() {
      return from_defined ? from : null;
    }
    
    public inner_range to(int ¢) {
      this.set_to(¢);
      return this;
    }
    public inner_range from(int f) {
      this.set_from(f);
      return this;
    }
    
    public inner_range interset (inner_range param) {
      
      inner_range $ = new inner_range();
      if(param.from_defined) {
        if(this.from_defined&&(this.from.intValue()>param.from.intValue())) {
          $.set_from(this.from.intValue());
        }else {
          $.set_from(param.from.intValue());
        }
      }else {
        if(this.from_defined) {
          $.set_from(this.from.intValue());
        }
      }


      if(param.to_defined) {
        if(this.to_defined&&(this.to.intValue()<param.to.intValue())) {
          $.set_to(this.to.intValue());
        }else {
          $.set_to(param.to.intValue());
        }
      }else {
        if(this.to_defined) {
          $.set_to(this.to.intValue());
        }
      }
      return $;
      
    }
    
    public boolean includes(int a) {
      if (from_defined) {
        if (a >= from.intValue()) {
          if (to_defined) {
            return a < to.intValue();
          }
          return true;
        }
        return false;
      }
      return to_defined ? a < to.intValue() : true;
    }
    
    public Iterator<Integer> numbers(){
      return from_defined ? iterator() : new MyIterator(Integer.valueOf(Integer.MIN_VALUE));
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
        return !to_defined ? true : curr.intValue() < to.intValue() - 1;
      }

      @Override public Integer next() {
        return curr = Integer.valueOf(curr.intValue() + 1);
      }

  }
    
  }
 //--------------------------------------------------------------- 
  
  public static inner_range from(int f) {
    inner_range $=new inner_range();
    $.set_from(f);
    return $;    
  }
  
  public static inner_range to(int t) {
    inner_range $=new inner_range();
    $.set_to(t);
    return $;  
  }
 

}



