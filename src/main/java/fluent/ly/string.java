package fluent.ly;

import static fluent.ly.___.*;

import java.io.*;
import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

/** A bunch of string functions.
 * @author Yossi Gil */
public enum string {
  // No elements in this name space
  ;
  static final int MAX_FIRST = 20;
  static final int MAX_LAST = 10;

  public static double atod(final @NotNull String ¢) {
    return Double.valueOf(¢).doubleValue();
  }

  public static float atof(final @NotNull String ¢) {
    return Float.valueOf(¢).floatValue();
  }

  public static int atoi(final @NotNull String ¢) {
    return Integer.valueOf(¢).intValue();
  }

  public static long atol(final @NotNull String ¢) {
    return Long.valueOf(¢).longValue();
  }

  @NotNull public static String capitalize(final @NotNull String ¢) {
    return ¢.length() == 0 ? ¢ : (first(¢) + "").toUpperCase() + the.rest(¢).toLowerCase();
  }

  @NotNull public static String cat(final @NotNull String... ss) {
    final @NotNull StringBuilder $ = new StringBuilder("");
    for (final @NotNull String ¢ : ss)
      $.append(¢);
    return $ + "";
  }

  @NotNull public static String cat(final @NotNull String[]... sss) {
    final @NotNull StringBuilder $ = new StringBuilder("");
    for (final @NotNull String[] ¢ : sss)
      $.append(cat(¢));
    return $ + "";
  }

  public static double delta(final double a, final double d) {
    return a == d ? 0 : signum(a) != signum(d) ? Double.NaN : 2 * Math.abs(a - d) / Math.abs(a + d);
  }

  @NotNull public static String dtoa(final double ¢) {
    return ¢ + "";
  }

  public static <T> boolean eq(final @Nullable T a, final @Nullable T b) {
    return a == null ? b == null : a.equals(b);
  }

  @NotNull public static String esc(final char ¢) {
    switch (¢) {
      case '\n':
        return "\\n";
      case '\r':
        return "\\r";
      case '\t':
        return "\\t";
      case '\f':
        return "\\f";
      case '\b':
        return "\\b";
      case '\\':
        return "\\\\";
      default:
        return ¢ + "";
    }
  }

  @NotNull public static String esc(final @Nullable String s) {
    if (s == null)
      return "(null)";
    final @NotNull StringBuilder $ = new StringBuilder(s.length());
    for (int ¢ = 0; ¢ < s.length(); ++¢)
      $.append(esc(s.charAt(¢)));
    return $ + "";
  }

  @NotNull public static String expandLeadingTabs(final @NotNull String s) {
    nonnull(s);
    for (@NotNull String $ = s;;) {
      @SuppressWarnings("null") final @NotNull String newValue = $.replaceAll("(?m)^([\t]*)\t", "$1    ");
      if ($.equals(newValue))
        return $;
      $ = newValue;
    }
  }

  @NotNull public static String fill(final int i, final char c) {
    return fill(i, c + "");
  }

  @NotNull public static String fill(final int i, final @NotNull String s) {
    final @NotNull StringBuilder $ = new StringBuilder();
    for (int ¢ = 0; ¢ < i; ++¢)
      $.append(s);
    return $ + "";
  }

  public static char first(final @NotNull String ¢) {
    nonnull(¢);
    positive(¢.length());
    return ¢.charAt(0);
  }

  @NotNull public static String ftoa(final float ¢) {
    return ¢ + "";
  }

  public static boolean isDouble(final @NotNull String s) {
    try {
      Double.valueOf(s);
      return true;
    } catch (final NumberFormatException ¢) {
      forget.it(¢);
      return false;
    }
  }

  public static boolean isFloat(final @NotNull String s) {
    try {
      Float.valueOf(s);
      return true;
    } catch (final NumberFormatException ¢) {
      forget.it(¢);
      return false;
    }
  }

  public static boolean isInt(final @NotNull String s) {
    try {
      Integer.valueOf(s);
      return true;
    } catch (final NumberFormatException ¢) {
      forget.it(¢);
      return false;
    }
  }

  public static boolean isLong(final @NotNull String s) {
    try {
      Long.valueOf(s);
      return true;
    } catch (final NumberFormatException ¢) {
      forget.it(¢);
      return false;
    }
  }

  @NotNull public static String itoa(final int ¢) {
    return ¢ + "";
  }

  @NotNull public static String javaCase(final @NotNull String ¢) {
    return ¢.length() == 0 ? ¢ : (first(¢) + "").toLowerCase() + the.rest(¢);
  }

  public static char last(final @NotNull String ¢) {
    nonnull(¢);
    positive(¢.length());
    return ¢.charAt(¢.length() - 1);
  }

  @NotNull public static String lowCounter(final int ¢) {
    switch (¢) {
      case -1:
        return "";
      case 0:
        return "a";
      default:
        return tolow(¢);
    }
  }

  @NotNull public static String ltoa(final long ¢) {
    return ¢ + "";
  }

  @NotNull public static String ordinal(final int ¢) {
    nonnegative(¢);
    switch (¢ % 10) {
      case 1:
        return ¢ + (¢ == 11 ? "th" : "st");
      case 2:
        return ¢ + (¢ == 12 ? "th" : "nd");
      default:
        return ¢ + "th";
    }
  }

  @NotNull public static String paren(final Object ¢) {
    return "(" + ¢ + ")";
  }

  @NotNull public static String pluralize(final int i, final @NotNull String singular) {
    return pluralize(i, singular, singular + "s");
  }

  @NotNull public static String pluralize(final int i, final @NotNull String singular, final @NotNull String plural) {
    switch (i) {
      case 0:
        return "no " + plural;
      case 1:
        return singular;
      case 2:
        return "two " + plural;
      case 3:
        return "three " + plural;
      case 4:
        return "four " + plural;
      case 5:
        return "five " + plural;
      case 6:
        return "six " + plural;
      case 7:
        return "seven " + plural;
      case 8:
        return "eight " + plural;
      case 9:
        return "nine " + plural;
      default:
        return i + " " + plural;
    }
  }

  @NotNull public static String pretty(final @NotNull String singular, final Collection<?> a) {
    return pretty(singular, singular + "s", a);
  }

  @NotNull public static String pretty(final @NotNull String singular, final @NotNull String plural, final @Nullable Collection<?> a) {
    if (a == null || a.isEmpty())
      return "";
    if (a.size() == 1)
      return "1 " + singular + ": " + a.iterator().next() + "\n";
    @NotNull String $ = a.size() + " " + plural + ":\n";
    int n = 0;
    final @NotNull once ellipsis = new once("\t...\n");
    for (final Object ¢ : a) {
      ++n;
      $ += n > MAX_FIRST && n <= a.size() - MAX_LAST ? ellipsis : "\t" + n + ") " + ¢ + "\n";
    }
    return $;
  }

  @NotNull public static String quote(final Object ¢) {
    return wrap('\'', ¢ + "");
  }

  @NotNull public static String repeat(final int i, final char c) {
    return repeat(i, c + "");
  }

  @NotNull public static String repeat(final int i, final @NotNull String s) {
    final @NotNull StringBuffer $ = new StringBuffer();
    for (int ¢ = 0; ¢ < i; ++¢)
      $.append(s);
    return $ + "";
  }

  public static int signum(final double ¢) {
    return ¢ == 0 ? 0 : ¢ > 0 ? 1 : -1;
  }

  @NotNull public static String sprintf(final @NotNull String format, final Object... args) {
    try (Formatter $ = new Formatter()) {
      return $.format(format, args) + "";
    }
  }

  public static String sprintf(final @NotNull String[] args) {
    switch (args.length) {
      case 0:
        return "";
      case 1:
        return args[0];
      default:
        final Object @NotNull [] $ = new Object[args.length - 1];
        for (int ¢ = 1; ¢ < args.length; ++¢)
          $[¢ - 1] = args[¢];
        return new Formatter().format(args[0], $) + "";
    }
  }

  /** Strip the first and last character of a string.
   * @param ¢ a non-<code><b>null</b></code> string of length at least two to
   *          strip
   * @return <code>s</code> but without its first and last character. */
  public static String strip(final @NotNull String ¢) {
    nonnull(¢);
    require(¢.length() >= 2);
    return ¢.substring(1, ¢.length() - 1);
  }

  @NotNull public static List<String> toLines(final @NotNull String s) throws IOException {
    final @NotNull List<String> $ = new ArrayList<>();
    for (final @NotNull BufferedReader br = new BufferedReader(new StringReader(s));;) {
      final @Nullable String line = br.readLine();
      if (line == null)
        return $;
      $.add(line);
    }
  }

  @NotNull public static String upCounter(final int ¢) {
    switch (¢) {
      case -1:
        return "";
      case 0:
        return "A";
      default:
        return toup(¢);
    }
  }

  public static String visualize(final @NotNull String ¢) {
    return esc(¢).replaceAll(" ", "\\s");
  }

  @NotNull public static String wrap(final char with, final @NotNull String s) {
    return with + s + with;
  }

  @NotNull public static String wrap(final @NotNull String with, final @NotNull String s) {
    return with + s + with;
  }

  @NotNull private static String tolow(final int ¢) {
    return ¢ == 0 ? "" : tolow(¢ / 26) + (char) (¢ % 26 + 'a');
  }

  @NotNull private static String toup(final int ¢) {
    return ¢ == 0 ? "" : toup(¢ / 26) + (char) (¢ % 26 + 'A');
  }

  @SuppressWarnings("static-method") public static class TEST {
    @Test public void use0() {
      assert atod("5.5") == 5.5;
    }

    @Test public void use1() {
      assert atof("5.5") == 5.5;
    }

    @Test public void use2() {
      assert atoi("5") == 5;
    }

    @Test public void use3() {
      assert atol("5") == 5;
    }

    @Test public void use4() {
      assert "Aaaaa".equals(capitalize("aAAAA"));
    }

    @Test public void use5() {
      assert "ab".equals(cat("a", "b"));
    }

    @Test public void use6() {
      @SuppressWarnings("null") final String res = cat(new String[] { "a" }, new String[] { "b", "c" });
      assert "abc".equals(res);
    }

    @Test public void use7() {
      assert "5.5".equals(dtoa(5.5));
    }

    @Test public void use8() {
      assert eq("a", "a");
      assert !eq("a", "A");
      assert !eq(null, "a");
      assert eq(null, null);
    }

    @Test public void use9() {
      assert "a".equals(esc("a"));
      assert "\\n".equals(esc("\n"));
      assert "\\r".equals(esc("\r"));
      assert "\\t".equals(esc("\t"));
      assert "\\f".equals(esc("\f"));
      assert "\\b".equals(esc("\b"));
      assert "\\\\".equals(esc("\\"));
      assert "(null)".equals(esc(null));
    }

    @Test public void use10() {
      assert "bla".equals(expandLeadingTabs("bla"));
    }

    @Test public void use11() {
      assert "aaaaa".equals(fill(5, 'a'));
      assert "aaaa".equals(fill(2, "aa"));
    }

    @Test public void use12() {
      assert "0.0".equals(ftoa(1 / 2));
    }

    @Test public void use13() {
      assert isDouble("4.4");
      assert !isDouble("a");
      assert isInt("1");
      assert !isInt("1.1");
      assert isLong("1");
      assert !isLong("...");
      assert isFloat("1");
      assert !isFloat("...");
    }

    @Test public void use14() {
      assert "5".equals(itoa(5));
    }

    @Test public void ordinalTest() {
      assert "1st".equals(ordinal(1));
      assert "2nd".equals(ordinal(2));
      assert "3th".equals(ordinal(3));
      assert "11th".equals(ordinal(11));
      assert "12th".equals(ordinal(12));
    }

    @Test public void pluralizeTest() {
      assert "no cats".equals(pluralize(0, "cat"));
      assert "cat".equals(pluralize(1, "cat"));
      assert "two cats".equals(pluralize(2, "cat"));
      assert "three cats".equals(pluralize(3, "cat"));
      assert "four cats".equals(pluralize(4, "cat"));
      assert "five cats".equals(pluralize(5, "cat"));
      assert "six cats".equals(pluralize(6, "cat"));
      assert "seven cats".equals(pluralize(7, "cat"));
      assert "eight cats".equals(pluralize(8, "cat"));
      assert "nine cats".equals(pluralize(9, "cat"));
      assert "999 cats".equals(pluralize(999, "cat"));
    }

    @SuppressWarnings("null") @Test public void use15() {
      assert "aaaA".equals(javaCase("AaaA"));
      assert "".equals(javaCase(""));
      assert last("blabla") == 'a';
      assert "".equals(lowCounter(-1));
      assert "a".equals(lowCounter(0));
      assert "f".equals(lowCounter(5));
      assert delta(1, 1) == 0.0;
      assert "withswith".equals(wrap("with", "s"));
      assert "asa".equals(wrap('a', "s"));
      assert "balkjg\\n".equals(visualize("balkjg\n"));
      assert "".equals(upCounter(-1));
      assert "A".equals(upCounter(0));
      assert "F".equals(upCounter(5));
      assert "labl".equals(strip("blabla"));
      assert "".equals(sprintf(new String[] {}));
      assert "a".equals(sprintf(new String[] { "a" }));
      assert "a".equals(sprintf(new String[] { "a", "b" }));
      assert pretty("a", as.list(1, 2)) != null;
      assert "nn".equals(repeat(2, "n"));
    }
  }
}
