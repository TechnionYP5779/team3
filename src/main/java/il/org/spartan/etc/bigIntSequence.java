package il.org.spartan.etc;

import java.math.*;
import java.util.*;

public class bigIntSequence {
  public static class bla implements Iterable<BigInteger>, Iterator<BigInteger> {
    private BigInteger current;
    private BigInteger step;
    private BigInteger end;

    public bla(final BigInteger start, final BigInteger step, final BigInteger end) {
      this.current = start;
      this.step = step;
      this.end = end;
    }

    public bla from(final BigInteger start) {
      this.current = start;
      return this;
    }

    public bla step(final BigInteger step1) {
      this.step = step1;
      return this;
    }

    public bla to(final BigInteger end1) {
      this.end = end1;
      return this;
    }

    @Override public Iterator<BigInteger> iterator() {
      return new bla(current, step, end);
    }

    @Override public BigInteger next() {
      final BigInteger $ = current;
      current = current.add(step);
      return $;
    }

    @Override public boolean hasNext() {
      return end == null || current.compareTo(end) < 0;
    }
  }

  public static bla from(final BigInteger start) {
    return new bla(start, BigInteger.ZERO, null);
  }

  public static bla step(final BigInteger step) {
    return new bla(BigInteger.ZERO, step, null);
  }

  public static bla to(final BigInteger end) {
    return new bla(BigInteger.ZERO, BigInteger.ZERO, end);
  }
}
