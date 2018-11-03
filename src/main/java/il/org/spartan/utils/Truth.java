package il.org.spartan.utils;

import java.io.*;
import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import an.*;
import fluent.ly.*;

public enum Truth {
  T("true"), //
  F("false"), //
  X("Assertion exception"), //
  N("Null pointer exception"), //
  R("Runtime exception"), //
  Ħ("Throwable of some other kind");
  public static Truth truthOf(final BooleanSupplier $) {
    try {
      return $.getAsBoolean() ? T : F;
    } catch (final NullPointerException ¢) {
      forget.it(¢);
      return N;
    } catch (final AssertionError ¢) {
      forget.it(¢);
      return X;
    } catch (final RuntimeException ¢) {
      forget.it(¢);
      return R;
    } catch (final Throwable ¢) {
      forget.it(¢);
      return Ħ;
    }
  }

  Truth not() {
    return this == T ? F : //
        this == F ? T : //
            this;
  }

  Truth or(final Truth other) {
    return this == T ? this : other;
  }

  Truth and(final Truth other) {
    return this == F ? this : other;
  }

  public static String letterOf(final BooleanSupplier ¢) {
    return truthOf(¢) + "";
  }

  @NotNull public final String description;

  Truth(final @NotNull String description) {
    this.description = description;
  }

  @Override public String toString() {
    return description;
  }
  
  @SuppressWarnings("static-method")
  public static class Tests {
    @Test
    public void testTruthOf() {
      azzert.assertTrue(Truth.truthOf(() -> true) == T);
      azzert.assertTrue(Truth.truthOf(() -> false) == F);
      azzert.assertTrue(Truth.truthOf(() -> {throw new NullPointerException();}) == N);
      azzert.assertTrue(Truth.truthOf(null) == N);
      azzert.assertTrue(Truth.truthOf(() -> {throw new AssertionError();}) == X);
      azzert.assertTrue(Truth.truthOf(() -> {throw new RuntimeException();}) == R);
      azzert.assertTrue(Truth.truthOf(() -> {throw new IOError(null);}) == Ħ);
    }
    
    @Test
    public void testOps() {
      azzert.assertTrue(T.not() == F);
      azzert.assertTrue(F.not() == T);
      
      azzert.assertTrue(T.and(T) == T);
      azzert.assertTrue(T.and(F) == F);
      azzert.assertTrue(F.and(T) == F);
      azzert.assertTrue(F.and(F) == F);
      
      azzert.assertTrue(T.or(T) == T);
      azzert.assertTrue(T.or(F) == T);
      azzert.assertTrue(F.or(T) == T);
      azzert.assertTrue(F.or(F) == F);
    }
    
    @Test
    public void testLetterOf() {
      azzert.assertTrue(Truth.letterOf(() -> true).equals(T.toString()));
      azzert.assertTrue(Truth.letterOf(() -> false).equals(F.toString()));
      azzert.assertTrue(Truth.letterOf(() -> {throw new NullPointerException();}).equals(N.toString()));
      azzert.assertTrue(Truth.letterOf(null).equals(N.toString()));
      azzert.assertTrue(Truth.letterOf(() -> {throw new AssertionError();}).equals(X.toString()));
      azzert.assertTrue(Truth.letterOf(() -> {throw new RuntimeException();}).equals(R.toString()));
      azzert.assertTrue(Truth.letterOf(() -> {throw new IOError(null);}).equals(Ħ.toString()));
    }
  }
}
