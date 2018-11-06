package il.org.spartan.utils;

import java.io.*;
import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;

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
      assert Truth.truthOf(() -> true) == T;
      assert Truth.truthOf(() -> false) == F;
      assert Truth.truthOf(() -> {
        throw new NullPointerException();
      }) == N;
      assert Truth.truthOf(null) == N;
      assert Truth.truthOf(() -> {
        throw new AssertionError();
      }) == X;
      assert Truth.truthOf(() -> {
        throw new RuntimeException();
      }) == R;
      assert Truth.truthOf(() -> {
        throw new IOError(null);
      }) == Ħ;
    }
    
    @Test
    public void testOps() {
      assert T.not() == F;
      assert F.not() == T;
      
      assert T.and(T) == T;
      assert T.and(F) == F;
      assert F.and(T) == F;
      assert F.and(F) == F;
      
      assert T.or(T) == T;
      assert T.or(F) == T;
      assert F.or(T) == T;
      assert F.or(F) == F;
    }
    
    @Test
    public void testLetterOf() {
      assert Truth.letterOf(() -> true).equals(T + "");
      assert Truth.letterOf(() -> false).equals(F + "");
      assert Truth.letterOf(() -> {
        throw new NullPointerException();
      }).equals(N + "");
      assert Truth.letterOf(null).equals(N + "");
      assert Truth.letterOf(() -> {
        throw new AssertionError();
      }).equals(X + "");
      assert Truth.letterOf(() -> {
        throw new RuntimeException();
      }).equals(R + "");
      assert Truth.letterOf(() -> {
        throw new IOError(null);
      }).equals(Ħ + "");
    }
  }
}
