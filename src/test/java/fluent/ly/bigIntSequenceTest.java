package fluent.ly;

import java.math.*;
import java.util.*;

import org.junit.*;

import il.org.spartan.etc.*;

public class bigIntSequenceTest {
  @SuppressWarnings("static-method") @Test
  public void testDefaults() {
    Iterable<BigInteger> seq1 = bigIntSequence.from(BigInteger.ONE);
    azzert.assertTrue(seq1.iterator().hasNext());
    azzert.assertTrue(seq1.iterator().next().equals(BigInteger.ONE));   //test start is set
    Iterator<BigInteger> it = seq1.iterator();
    it.next();
    azzert.assertTrue(it.next().equals(BigInteger.ONE));    //test default step is zero
    
    
    Iterable<BigInteger> seq2 = bigIntSequence.to(BigInteger.valueOf(10)).step(BigInteger.ONE);
    boolean valuesGood = true;
    int tst = 0;
    it = seq2.iterator();
    for(BigInteger i : seq2) {
      if(i.compareTo(BigInteger.valueOf(tst++)) != 0)
      {
        valuesGood = false;
        break;
      }
      it.next();
    }
    azzert.assertTrue(valuesGood);
    azzert.assertTrue(tst == 10);
    azzert.assertFalse(it.hasNext());
    
    
    Iterable<BigInteger> seq3 = bigIntSequence.step(BigInteger.valueOf(2)).from(BigInteger.valueOf(6)).to(BigInteger.valueOf(20));
    valuesGood = true;
    tst = 6;
    it = seq3.iterator();
    for(BigInteger i : seq3) {
      if(i.compareTo(BigInteger.valueOf(tst)) != 0)
      {
        valuesGood = false;
        break;
      }
      it.next();
      tst += 2;
    }
    azzert.assertTrue(valuesGood);
    azzert.assertTrue(tst == 20);
    azzert.assertFalse(it.hasNext());
  }
}
