package tests;

import org.junit.*;

import fluent.ly.*;

public class English_tests {
  @SuppressWarnings({ "static-method", "unused" }) @Test public void basic_test() {
    final String abc = "abc";
    final String zero = "";
    assert English.Inflection.stem(abc).get().equals("abc");
    assert English.Inflection.stem(zero).get().equals("");
    assert English.Inflection.stem(abc).getEd().equals("abced");
    assert English.Inflection.stem(zero).getEd().equals("ed");
    assert English.Inflection.stem(abc).getIng().equals("abcing");
    assert English.Inflection.stem(zero).getIng().equals("ing");
    assert English.plurales(abc, 1).equals("one abc");
    assert English.plurales(abc, 2).equals("2 abces");
  }
}
