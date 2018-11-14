package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class stringTest {
  @Test public void use0() {
    azzert.assertTrue(string.atod("5.5") == 5.5);

  }

  @Test public void use1() {
    azzert.assertTrue(string.atof("5.5") == 5.5);

  }

  @Test public void use2() {
    azzert.assertTrue(string.atoi("5") == 5);

  }

  @Test public void use3() {
    azzert.assertTrue(string.atol("5") == 5);

  }

  @Test public void use4() {
    azzert.assertTrue(string.capitalize("aAAAA").equals("Aaaaa"));

  }

  @Test public void use5() {
    azzert.assertTrue(string.cat("a", "b").equals("ab"));

  }

  @Test public void use6() {
    azzert.assertTrue(string.cat(new String[] { "a" }, new String[] { "b", "c" }).equals("abc"));

  }

  @Test public void use7() {
    azzert.assertTrue(string.dtoa(5.5).equals("5.5"));

  }

  @Test public void use8() {
    assert string.eq("a", "a");
    assert !string.eq("a", "A");
    assert !string.eq(null, "a");
    assert string.eq(null, null);

  }

  @Test public void use9() {
    assert string.esc("a").equals("a");
    assert string.esc("\n").equals("\\n");
    assert string.esc("\r").equals("\\r");
    assert string.esc("\t").equals("\\t");
    assert string.esc("\f").equals("\\f");
    assert string.esc("\b").equals("\\b");
    assert string.esc("\\").equals("\\\\");
    assert string.esc(null).equals("(null)");
  }

  @Test public void use10() {
    assert string.expandLeadingTabs("bla").equals("bla");
  }

  @Test public void use11() {
    assert string.fill(5, 'a').equals("aaaaa");
    assert string.fill(2, "aa").equals("aaaa");

  }

  @Test public void use12() {
    azzert.assertTrue(string.ftoa((1 / 2)).equals("0.0"));

  }

  @Test public void use13() {
    assert string.isDouble("4.4");
    assert !string.isDouble("a");
    assert string.isInt("1");
    assert !string.isInt("1.1");
    assert string.isLong("1");
    assert !string.isLong("...");
    assert string.isFloat("1");
    assert !string.isFloat("...");
  }

  @Test public void use14() {
    assert string.itoa(5).equals("5");
  }

  @Test @SuppressWarnings("null") public void ordinalTest() {
    azzert.assertTrue(string.ordinal(1).equals("1st"));
    azzert.assertTrue(string.ordinal(2).equals("2nd"));
    azzert.assertTrue(string.ordinal(3).equals("3th"));
    azzert.assertTrue(string.ordinal(11).equals("11th"));
    azzert.assertTrue(string.ordinal(12).equals("12th"));
  }

  @Test @SuppressWarnings("null") public void pluralizeTest() {
    azzert.assertTrue(string.pluralize(0, "cat").equals("no cats"));
    azzert.assertTrue(string.pluralize(1, "cat").equals("cat"));
    azzert.assertTrue(string.pluralize(2, "cat").equals("two cats"));
    azzert.assertTrue(string.pluralize(3, "cat").equals("three cats"));
    azzert.assertTrue(string.pluralize(4, "cat").equals("four cats"));
    azzert.assertTrue(string.pluralize(5, "cat").equals("five cats"));
    azzert.assertTrue(string.pluralize(6, "cat").equals("six cats"));
    azzert.assertTrue(string.pluralize(7, "cat").equals("seven cats"));
    azzert.assertTrue(string.pluralize(8, "cat").equals("eight cats"));
    azzert.assertTrue(string.pluralize(9, "cat").equals("nine cats"));
    azzert.assertTrue(string.pluralize(999, "cat").equals("999 cats"));
  }
  
  @Test @SuppressWarnings("null") public void use15() {
    azzert.assertTrue(string.javaCase("AaaA").equals("aaaA"));
    azzert.assertTrue(string.javaCase("").equals(""));
    azzert.assertTrue(string.last("blabla") == 'a');
    azzert.assertTrue(string.lowCounter(-1).equals(""));
    azzert.assertTrue(string.lowCounter(0).equals("a"));
    azzert.assertTrue((string.lowCounter(5)).equals("f"));
    azzert.assertTrue(string.delta(1, 1) == 0.0);
    azzert.assertTrue(string.wrap("with", "s").equals("withswith"));
    azzert.assertTrue(string.wrap('a', "s").equals("asa"));
    azzert.assertTrue(string.visualize("balkjg\n").equals("balkjg\\n"));
    azzert.assertTrue(string.upCounter(-1).equals(""));
    azzert.assertTrue(string.upCounter(0).equals("A"));
    azzert.assertTrue((string.upCounter(5)).equals("F"));
    azzert.assertTrue((string.strip("blabla")).equals("labl"));
    azzert.assertTrue(string.sprintf(new String[] {}).equals(""));
    azzert.assertTrue(string.sprintf(new String[] { "a" }).equals("a"));
    azzert.assertTrue(string.sprintf(new String[] { "a", "b" }).equals("a"));
    azzert.assertTrue(string.repeat(2, "n").equals("nn"));
  }
  
}
