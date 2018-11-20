package il.org.spartan.etc;

import static fluent.ly.box.*;

import java.util.*;

import org.junit.*;

import il.org.spartan.utils.*;

@SuppressWarnings("static-method") public class EnglishTest {
  @Test public void basic_test() {
    final String abc = "abc", zero = "";
    assert ("abc".equals(English.Inflection.stem(abc).get()));
    assert ("".equals(English.Inflection.stem(zero).get()));
    assert ("abced".equals(English.Inflection.stem(abc).getEd()));
    assert ("ed".equals(English.Inflection.stem(zero).getEd()));
    assert ("abcing".equals(English.Inflection.stem(abc).getIng()));
    assert ("ing".equals(English.Inflection.stem(zero).getIng()));
    assert ("one abc".equals(English.plurales(abc, 1)));
    assert ("2 abces".equals(English.plurales(abc, 2)));
    assert (English.upperFirstLetter("").charAt(0) == 'g');
    assert (English.upperFirstLetter("abv").charAt(0) == 'A');
    assert ("???".equals(English.unknownIfNull(null)));
    assert ("123".equals(English.unknownIfNull("123")));
    assert ("???".equals(English.unknownIfNull(null, λ -> λ)));
    assert ("123".equals(English.unknownIfNull("123", λ -> λ)));
    assert ("1234".equals(English.trimAbsolute("12345", 4, "")));
    assert ("123".equals(English.trimAbsolute("123", 4, "")));
    assert ("123".equals(English.trim("123")));
    assert ("0.00".equals(English.time(1)));
    assert ("aaaaa".equals(English.repeat(5, 'a')));
    assert ("aey".equals(English.pronounce('a')));
    assert ("bee".equals(English.pronounce('b')));
    assert ("see".equals(English.pronounce('c')));
    assert ("dee".equals(English.pronounce('d')));
    assert ("eae".equals(English.pronounce('e')));
    assert ("eff".equals(English.pronounce('f')));
    assert ("gee".equals(English.pronounce('g')));
    assert ("eitch".equals(English.pronounce('h')));
    assert ("eye".equals(English.pronounce('i')));
    assert ("jay".equals(English.pronounce('j')));
    assert ("kay".equals(English.pronounce('k')));
    assert ("ell".equals(English.pronounce('l')));
    assert ("em".equals(English.pronounce('m')));
    assert ("en".equals(English.pronounce('n')));
    assert ("oh".equals(English.pronounce('o')));
    assert ("pee".equals(English.pronounce('p')));
    assert ("queue".equals(English.pronounce('q')));
    assert ("ar".equals(English.pronounce('r')));
    assert ("ess".equals(English.pronounce('s')));
    assert ("tee".equals(English.pronounce('t')));
    assert ("you".equals(English.pronounce('u')));
    assert ("vee".equals(English.pronounce('v')));
    assert ("exx".equals(English.pronounce('x')));
    assert ("why".equals(English.pronounce('y')));
    assert ("zee".equals(English.pronounce('z')));
    assert ("zee".equals(English.pronounce('Z')));
    assert ("some character".equals(English.pronounce('w')));
    assert ("2 verbs".equals(English.plurals("verb", 2)));
    assert ("one verb".equals(English.plurals("verb", 1)));
    assert ("2 verbs".equals(English.plurals("verb", new Int(2))));
    assert ("one verb".equals(English.plurals("verb", new Int(1))));
    assert ("??? verbs".equals(English.plurals("verb", (Int) null)));
    assert ("2 verbs".equals(English.plurals("verb", box(2))));
    assert ("one verb".equals(English.plurals("verb", box(1))));
    assert ("??? verbs".equals(English.plurals("verb", (Integer) null)));
    assert ("2 verbes".equals(English.plurales("verb", new Int(2))));
    assert ("one verb".equals(English.plurales("verb", new Int(1))));
    assert ("??? verbes".equals(English.plurales("verb", (Int) null)));
    assert ("2 verbes".equals(English.plurales("verb", box(2))));
    assert ("one verb".equals(English.plurales("verb", box(1))));
    assert ("??? verbes".equals(English.plurales("verb", (Integer) null)));
    assert ("String".equals(English.name("1".getClass())));
    assert ("String".equals(English.name("1".getClass())));
    assert (English.isAcronym("212"));
    List<String> li = new ArrayList<>();
    li.add(0, "1");
    li.add(1, "2");
    assert ("1 and 2".equals(English.list(li)));
    List<String> li2 = new ArrayList<>();
    li2.add(0, "1");
    assert ("1".equals(English.list(li2)));
    assert ("abc".equals(English.lowerFirstLetter("Abc")));
    assert (English.lowerFirstLetter("").charAt(0) == 'g');
    assert ("a String".equals(English.indefinite("String")));
    assert ("nothing".equals(English.list(new ArrayList<>())));
  }
}
