package il.org.spartan.etc;

import org.junit.*;

import fluent.ly.*;

public class EnglishTest {
  @SuppressWarnings({ "static-method" }) @Test public void basic_test() {
    final String abc = "abc";
    final String zero = "";
    azzert.assertTrue(English.Inflection.stem(abc).get().equals("abc"));
    azzert.assertTrue(English.Inflection.stem(zero).get().equals(""));
    azzert.assertTrue(English.Inflection.stem(abc).getEd().equals("abced"));
    azzert.assertTrue(English.Inflection.stem(zero).getEd().equals("ed"));
    azzert.assertTrue(English.Inflection.stem(abc).getIng().equals("abcing"));
    azzert.assertTrue(English.Inflection.stem(zero).getIng().equals("ing"));
    azzert.assertTrue(English.plurales(abc, 1).equals("one abc"));
    azzert.assertTrue(English.plurales(abc, 2).equals("2 abces"));
  }
}
