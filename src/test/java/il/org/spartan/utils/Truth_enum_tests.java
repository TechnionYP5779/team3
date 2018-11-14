package il.org.spartan.utils;

import java.io.*;

import org.junit.*;

import fluent.ly.*;


@SuppressWarnings("static-method") public class Truth_enum_tests {
  @Test public void testTruthOf() {
    azzert.assertTrue( Truth.truthOf(() -> true) == Truth.T);
    azzert.assertTrue( Truth.truthOf(() -> false) == Truth.F);
    azzert.assertTrue( Truth.truthOf(() -> {
      throw new NullPointerException();
    }) == Truth.N);
    azzert.assertTrue( Truth.truthOf(null) == Truth.N);
    azzert.assertTrue( Truth.truthOf(() -> {
      throw new AssertionError();
    }) == Truth.X);
    azzert.assertTrue( Truth.truthOf(() -> {
      throw new RuntimeException();
    }) == Truth.R);
    azzert.assertTrue( Truth.truthOf(() -> {
      throw new IOError(null);
    }) == Truth.Ħ);
  }

  @Test public void testLetterOf() {
    azzert.assertTrue( Truth.letterOf(() -> true).equals(Truth.T + ""));
    azzert.assertTrue( Truth.letterOf(() -> false).equals(Truth.F + ""));
    azzert.assertTrue( Truth.letterOf(() -> {
      throw new NullPointerException();
    }).equals(Truth.N + ""));
    azzert.assertTrue( Truth.letterOf(null).equals(Truth.N + ""));
    azzert.assertTrue( Truth.letterOf(() -> {
      throw new AssertionError();
    }).equals(Truth.X + ""));
    azzert.assertTrue( Truth.letterOf(() -> {
      throw new RuntimeException();
    }).equals(Truth.R + ""));
    azzert.assertTrue( Truth.letterOf(() -> {
      throw new IOError(null);
    }).equals(Truth.Ħ + ""));
  }
}
