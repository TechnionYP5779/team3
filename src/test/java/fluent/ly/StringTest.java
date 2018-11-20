package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class StringTest {
  @Test public void use0() {
    assert string.atod("5.5") == 5.5;
  }

  @Test public void use1() {
    assert string.atof("5.5") == 5.5;
  }

  @Test public void use2() {
    assert string.atoi("5") == 5;
  }

  @Test public void use3() {
    assert string.atol("5") == 5;
  }

  @Test public void use4() {
    assert "Aaaaa".equals(string.capitalize("aAAAA"));
  }

  @Test public void use5() {
    assert "ab".equals(string.cat("a", "b"));
  }

  @Test @SuppressWarnings("null") public void use6() {
    assert "abc".equals(string.cat(new String[] { "a" }, new String[] { "b", "c" }));
  }

  @Test public void use7() {
    assert "5.5".equals(string.dtoa(5.5));
  }

  @Test public void use8() {
    assert string.eq("a", "a");
    assert !string.eq("a", "A");
    assert !string.eq(null, "a");
    assert string.eq(null, null);
  }

  @Test public void use9() {
    assert "a".equals(string.esc("a"));
    assert "\\n".equals(string.esc("\n"));
    assert "\\r".equals(string.esc("\r"));
    assert "\\t".equals(string.esc("\t"));
    assert "\\f".equals(string.esc("\f"));
    assert "\\b".equals(string.esc("\b"));
    assert "\\\\".equals(string.esc("\\"));
    assert "(null)".equals(string.esc(null));
  }

  @Test public void use10() {
    assert "bla".equals(string.expandLeadingTabs("bla"));
  }

  @Test public void use11() {
    assert "aaaaa".equals(string.fill(5, 'a'));
    assert "aaaa".equals(string.fill(2, "aa"));
  }

  @Test public void use12() {
    assert "0.0".equals(string.ftoa(0));
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
    assert "5".equals(string.itoa(5));
  }

  @Test public void ordinalTest() {
    assert "1st".equals(string.ordinal(1));
    assert "2nd".equals(string.ordinal(2));
    assert "3th".equals(string.ordinal(3));
    assert "11th".equals(string.ordinal(11));
    assert "12th".equals(string.ordinal(12));
  }

  @Test public void pluralizeTest() {
    assert "no cats".equals(string.pluralize(0, "cat"));
    assert "cat".equals(string.pluralize(1, "cat"));
    assert "two cats".equals(string.pluralize(2, "cat"));
    assert "three cats".equals(string.pluralize(3, "cat"));
    assert "four cats".equals(string.pluralize(4, "cat"));
    assert "five cats".equals(string.pluralize(5, "cat"));
    assert "six cats".equals(string.pluralize(6, "cat"));
    assert "seven cats".equals(string.pluralize(7, "cat"));
    assert "eight cats".equals(string.pluralize(8, "cat"));
    assert "nine cats".equals(string.pluralize(9, "cat"));
    assert "999 cats".equals(string.pluralize(999, "cat"));
  }

  @Test @SuppressWarnings("null") public void use15() {
    assert "aaaA".equals(string.javaCase("AaaA"));
    assert "".equals(string.javaCase(""));
    assert string.last("blabla") == 'a';
    assert "".equals(string.lowCounter(-1));
    assert "a".equals(string.lowCounter(0));
    assert "f".equals(string.lowCounter(5));
    assert string.delta(1, 1) == 0.0;
    assert "withswith".equals(string.wrap("with", "s"));
    assert "asa".equals(string.wrap('a', "s"));
    assert "balkjg\\n".equals(string.visualize("balkjg\n"));
    assert "".equals(string.upCounter(-1));
    assert "A".equals(string.upCounter(0));
    assert "F".equals(string.upCounter(5));
    assert "labl".equals(string.strip("blabla"));
    assert "".equals(string.sprintf(new String[] {}));
    assert "a".equals(string.sprintf(new String[] { "a" }));
    assert "a".equals(string.sprintf(new String[] { "a", "b" }));
    assert "nn".equals(string.repeat(2, "n"));
  }
}
