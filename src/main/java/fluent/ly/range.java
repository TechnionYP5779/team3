package fluent.ly;

import java.util.*;
// import java.util.*;
// import java.util.stream.*;

public class range {
  public static class inner_range implements Iterable<Integer> {
    // params
    Integer from;
    Integer to;
    boolean from_defined;
    boolean to_defined;

    // funcs & methods
    inner_range() {
      to_defined = from_defined = false;
    }

    void set_from(final int f) {
      from = Integer.valueOf(f);
      from_defined = true;
    }

    void set_to(final int f) {
      to = Integer.valueOf(f);
      to_defined = true;
    }

    public Integer from() {
      return from_defined ? from : null;
    }

    public inner_range to(final int ¢) {
      this.set_to(¢);
      return this;
    }

    public inner_range from(final int f) {
      this.set_from(f);
      return this;
    }

    public inner_range interset(final inner_range ¢) {
      final inner_range $ = new inner_range();
      if (¢.from_defined)
        $.set_from((!this.from_defined || this.from.intValue() <= ¢.from.intValue() ? ¢.from : this.from).intValue());
      else if (this.from_defined)
        $.set_from(this.from.intValue());
      if (¢.to_defined)
        $.set_to((!this.to_defined || this.to.intValue() >= ¢.to.intValue() ? ¢.to : this.to).intValue());
      else if (this.to_defined)
        $.set_to(this.to.intValue());
      return $;
    }

    public boolean includes(final int a) {
      return !from_defined ? !to_defined || a < to.intValue() : a >= from.intValue() && (!to_defined || a < to.intValue());
    }

    public Iterator<Integer> numbers() {
      return from_defined ? iterator() : new MyIterator(Integer.valueOf(Integer.MIN_VALUE));
    }

    @Override public Iterator<Integer> iterator() {
      return new MyIterator(from);
    }

    public class MyIterator implements Iterator<Integer> {
      MyIterator(final Integer f) {
        curr = Integer.valueOf(f.intValue());
      }

      Integer curr;

      @Override public boolean hasNext() {
        return !to_defined || curr.intValue() < to.intValue() - 1;
      }

      @Override public Integer next() {
        return curr = Integer.valueOf(curr.intValue() + 1);
      }
    }
  }
  // ---------------------------------------------------------------

  public static inner_range from(final int f) {
    final inner_range $ = new inner_range();
    $.set_from(f);
    return $;
  }

  public static inner_range to(final int ¢) {
    final inner_range $ = new inner_range();
    $.set_to(¢);
    return $;
  }
}
