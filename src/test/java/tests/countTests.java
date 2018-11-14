package tests;

import java.util.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.etc.*;

@SuppressWarnings("static-method") public class countTests {
  @Test public void usecase0() {
    azzert.assertTrue( count.of(Arrays.asList(new String[] { "abc", "klm", "xyz", "pqr" })) == 4);
  }

  @Test public void usecase1() {
    azzert.assertTrue( count.of(Arrays.asList(new String[] {})) == 0);
  }
}
