package tests;

import java.io.*;

import org.junit.*;

import il.org.spartan.utils.*;


  @SuppressWarnings("static-method")
  public class Truth_enum_tests {
    @Test
    public void testTruthOf() {
      assert Truth.truthOf(() -> true) == Truth.T;
      assert Truth.truthOf(() -> false) == Truth.F;
      assert Truth.truthOf(() -> {
        throw new NullPointerException();
      }) == Truth.N;
      assert Truth.truthOf(null) == Truth.N;
      assert Truth.truthOf(() -> {
        throw new AssertionError();
      }) == Truth.X;
      assert Truth.truthOf(() -> {
        throw new RuntimeException();
      }) == Truth.R;
      assert Truth.truthOf(() -> {
        throw new IOError(null);
      }) == Truth.Ħ;
    }
    
    @Test
    public void testLetterOf() {
      assert Truth.letterOf(() -> true).equals(Truth.T + "");
      assert Truth.letterOf(() -> false).equals(Truth.F + "");
      assert Truth.letterOf(() -> {
        throw new NullPointerException();
      }).equals(Truth.N + "");
      assert Truth.letterOf(null).equals(Truth.N + "");
      assert Truth.letterOf(() -> {
        throw new AssertionError();
      }).equals(Truth.X + "");
      assert Truth.letterOf(() -> {
        throw new RuntimeException();
      }).equals(Truth.R + "");
      assert Truth.letterOf(() -> {
        throw new IOError(null);
      }).equals(Truth.Ħ + "");
    }
  }

