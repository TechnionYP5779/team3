package fluent.ly;

import java.math.*;
import java.util.*;

import org.junit.*;

import il.org.spartan.etc.*;

@SuppressWarnings("static-method")public class bigIntSequenceTest {
  @Test public void testDefaults() {
    final Iterable<BigInteger> seq1 = bigIntSequence.from(BigInteger.ONE);
    assert seq1.iterator().hasNext();
    assert seq1.iterator().next().equals(BigInteger.ONE);
    Iterator<BigInteger> it = seq1.iterator();
    it.next();
    assert it.next().equals(BigInteger.ONE);
    final Iterable<BigInteger> seq2 = bigIntSequence.to(BigInteger.valueOf(10)).step(BigInteger.ONE);
    boolean valuesGood = true;
    int tst = 0;
    it = seq2.iterator();
    for (final BigInteger ¢ : seq2) {
      if (¢.compareTo(BigInteger.valueOf(tst++)) != 0) {
        valuesGood = false;
        break;
      }
      it.next();
    }
    assert valuesGood;
    assert tst == 10;
    assert !it.hasNext();
    final Iterable<BigInteger> seq3 = bigIntSequence.step(BigInteger.valueOf(2)).from(BigInteger.valueOf(6)).to(BigInteger.valueOf(20));
    valuesGood = true;
    tst = 6;
    it = seq3.iterator();
    for (final BigInteger ¢ : seq3) {
      if (¢.compareTo(BigInteger.valueOf(tst)) != 0) {
        valuesGood = false;
        break;
      }
      it.next();
      tst += 2;
    }
    assert valuesGood;
    assert tst == 20;
    assert !it.hasNext();
  }
}
