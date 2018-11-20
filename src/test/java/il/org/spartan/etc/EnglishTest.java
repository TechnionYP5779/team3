package il.org.spartan.etc;

import java.util.*;

import org.junit.*;

import il.org.spartan.utils.*;

public class EnglishTest {
  @SuppressWarnings({ "static-method" }) @Test public void basic_test() {
    final String abc = "abc";
    final String zero = "";
    assert(English.Inflection.stem(abc).get().equals("abc"));
    assert(English.Inflection.stem(zero).get().equals(""));
    assert(English.Inflection.stem(abc).getEd().equals("abced"));
    assert(English.Inflection.stem(zero).getEd().equals("ed"));
    assert(English.Inflection.stem(abc).getIng().equals("abcing"));
    assert(English.Inflection.stem(zero).getIng().equals("ing"));
    assert(English.plurales(abc, 1).equals("one abc"));
    assert(English.plurales(abc, 2).equals("2 abces"));
    assert(English.upperFirstLetter("").charAt(0)=='g');
    assert(English.upperFirstLetter("abv").charAt(0)=='A');
    assert(English.unknownIfNull(null).equals("???"));
    assert(English.unknownIfNull("123").equals("123"));
    assert(English.unknownIfNull(null,x->x).equals("???"));
    assert(English.unknownIfNull("123",x->x).equals("123"));
    assert(English.trimAbsolute("12345",4,"").equals("1234"));
    assert(English.trimAbsolute("123",4,"").equals("123"));
    assert(English.trim("123").equals("123"));
    assert(English.time(1).equals("0.00"));
    assert(English.repeat(5, 'a').equals("aaaaa"));
    assert(English.pronounce('a').equals("aey"));
    assert(English.pronounce('b').equals("bee"));
    assert(English.pronounce('c').equals("see"));
    assert(English.pronounce('d').equals("dee"));
    assert(English.pronounce('e').equals("eae"));
    assert(English.pronounce('f').equals("eff"));
    assert(English.pronounce('g').equals("gee"));
    assert(English.pronounce('h').equals("eitch"));
    assert(English.pronounce('i').equals("eye"));
    assert(English.pronounce('j').equals("jay"));
    assert(English.pronounce('k').equals("kay"));
    assert(English.pronounce('l').equals("ell"));
    assert(English.pronounce('m').equals("em"));
    assert(English.pronounce('n').equals("en"));
    assert(English.pronounce('o').equals("oh"));
    assert(English.pronounce('p').equals("pee"));
    assert(English.pronounce('q').equals("queue"));
    assert(English.pronounce('r').equals("ar"));
    assert(English.pronounce('s').equals("ess"));
    assert(English.pronounce('t').equals("tee"));
    assert(English.pronounce('u').equals("you"));
    assert(English.pronounce('v').equals("vee"));
    assert(English.pronounce('x').equals("exx"));
    assert(English.pronounce('y').equals("why"));
    assert(English.pronounce('z').equals("zee"));
    assert(English.pronounce('Z').equals("zee"));
    assert(English.pronounce('w').equals("some character"));
    assert(English.plurals("verb",2).equals("2 verbs"));
    assert(English.plurals("verb",1).equals("one verb"));
    
    assert(English.plurals("verb",new Int(2)).equals("2 verbs"));
    assert(English.plurals("verb",new Int(1)).equals("one verb"));
    assert(English.plurals("verb",(Int)null).equals("??? verbs"));
    
    assert(English.plurals("verb",Integer.valueOf(2)).equals("2 verbs"));
    assert(English.plurals("verb",Integer.valueOf(1)).equals("one verb"));
    assert(English.plurals("verb",(Integer)null).equals("??? verbs"));
    
    assert(English.plurales("verb",new Int(2)).equals("2 verbes"));
    assert(English.plurales("verb",new Int(1)).equals("one verb"));
    assert(English.plurales("verb",(Int)null).equals("??? verbes"));
    
    
    assert(English.plurales("verb",Integer.valueOf(2)).equals("2 verbes"));
    assert(English.plurales("verb",Integer.valueOf(1)).equals("one verb"));
    assert(English.plurales("verb",(Integer)null).equals("??? verbes"));
    
    assert(English.name("1".getClass()).equals("String"));
    assert(English.name("1".getClass()).equals("String"));
    assert(English.isAcronym("212"));
    List<String> li = new ArrayList<>();
    li.add(0,"1");
    li.add(1,"2");
    
    assert(English.list(li).equals("1 and 2"));
    List<String> li2 = new ArrayList<>();
    li2.add(0,"1");
    assert(English.list(li2).equals("1"));
    
    assert(English.lowerFirstLetter("Abc").equals("abc"));
    assert(English.lowerFirstLetter("").charAt(0)=='g');
    assert(English.indefinite("String").equals("a String"));
    
    
    
    
    
    assert(English.list(new ArrayList<>()).equals("nothing"));
    

  }
}
