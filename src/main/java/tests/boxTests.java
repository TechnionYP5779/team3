package tests;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("boxing")  public class boxTests {
  @Test public void boxAdds() {
    Boolean b = box.box(true);
    Boolean b1 = Boolean.valueOf(true);
    azzert.that(b1.equals(b), is(true));
    
    
    boolean[] arr = {true, false, true};
    Boolean[] b2 = box.box(arr);
    Boolean[] arr1 = {true, false, true};
    for(int i=0;i<3;i++) {
      azzert.that(b2[i].equals(arr1[i]), is(true));
    }
    
    
    byte num = 10; 
    Byte by = box.box(num);
    Byte n = Byte.valueOf(num);
    azzert.that(by.equals(n), is(true));
    
    
    byte[] arrb = {10,1,4}; 
    Byte[] arrBy = box.box(arrb);
    Byte[] arrb1 = {10,1,4}; 
    for(int i=0;i<3;i++) {
      azzert.that(arrBy[i].equals(arrb1[i]), is(true));
    }
    
    
    Character cb = box.box('a');
    Character c1 = Character.valueOf('a');
    azzert.that(cb.equals(c1), is(true));
    
    char[] arrc = {'a', 'b', 'c'}; 
    Character[] arrcb = box.box(arrc);
    Character[] arrc1 = {'a', 'b', 'c'}; 
    for(int i=0;i<3;i++) {
      azzert.that(arrcb[i].equals(arrc1[i]), is(true));
    }
    
    
    Double db = box.box(5.0);
    Double d1 = Double.valueOf(5.0);
    azzert.that(db.equals(d1), is(true));
    
    
    double[] arrd = {5.0, 6.1, 7.2}; 
    Double[] arrdb = box.box(arrd);
    Double[] arrd1 = {5.0, 6.1, 7.2}; 
    for(int i=0;i<3;i++) {
      azzert.that(arrdb[i].equals(arrd1[i]), is(true));
    }
    
    float f = 56; 
    Float fb = box.box(f);
    Float f1 = Float.valueOf(56);
    azzert.that(fb.equals(f1), is(true));
    
    
    float[] arrf = {56f,50f,40f}; 
    Float[] arrfb = box.box(arrf);
    Float[] arrf1 = {56f,50f,40f}; 
    for(int i=0;i<3;i++) {
      azzert.that(arrfb[i].equals(arrf1[i]), is(true));
    }
    
    
    int i = 56; 
    Integer ib = box.box(i);
    Integer i1 = Integer.valueOf(56);
    azzert.that(ib.equals(i1), is(true));
    
    
    int[] arri = {56,50,40}; 
    Integer[] arrib = box.box(arri);
    Integer[] arri1 = {56,50,40}; 
    for(int j=0;j<3;j++) {
      azzert.that(arrib[j].equals(arri1[j]), is(true));
    }
    
    
    long l = 56; 
    Long lb = box.box(l);
    Long l1 = Long.valueOf(56);
    azzert.that(lb.equals(l1), is(true));
    
    
    long[] arrl = {56L,50L,40L}; 
    Long[] arrlb = box.box(arrl);
    Long[] arrl1 = {56L,50L,40L}; 
    for(int j=0;j<3;j++) {
      azzert.that(arrlb[j].equals(arrl1[j]), is(true));
    }
    
    
    short s = 5; 
    Short sb = box.box(s);
    Short s1 = Short.valueOf("5");
    azzert.that(sb.equals(s1), is(true));
    
    
    short[] arrs = {5,6,7}; 
    Short[] arrsb = box.box(arrs);
    Short[] arrs1 = {5,6,7}; 
    for(int j=0;j<3;j++) {
      azzert.that(arrsb[j].equals(arrs1[j]), is(true));
    }
    
    
    
    
    
    Boolean ITb = box.it(true);
    Boolean ITb1 = Boolean.valueOf(true);
    azzert.that(ITb1.equals(ITb), is(true));
    
    
    boolean[] ITarr = {true, false, true};
    Boolean[] ITb2 = box.it(ITarr);
    Boolean[] ITarr1 = {true, false, true};
    for(int j=0;j<3;j++) {
      azzert.that(ITb2[j].equals(ITarr1[j]), is(true));
    }
    
    
    byte ITnum = 10; 
    Byte ITby = box.it(ITnum);
    Byte ITn = Byte.valueOf(ITnum);
    azzert.that(ITby.equals(ITn), is(true));
    
    
    byte[] ITarrb = {10,1,4}; 
    Byte[] ITarrBy = box.it(ITarrb);
    Byte[] ITarrb1 = {10,1,4}; 
    for(int j=0;j<3;j++) {
      azzert.that(ITarrBy[j].equals(ITarrb1[j]), is(true));
    }
    
    
    Character ITcb = box.it('a');
    Character ITc1 = Character.valueOf('a');
    azzert.that(ITcb.equals(ITc1), is(true));
    
    char[] ITarrc = {'a', 'b', 'c'}; 
    Character[] ITarrcb = box.it(ITarrc);
    Character[] ITarrc1 = {'a', 'b', 'c'}; 
    for(int j=0;j<3;j++) {
      azzert.that(ITarrcb[j].equals(ITarrc1[j]), is(true));
    }
    
    
    Double ITdb = box.it(5.0);
    Double ITd1 = Double.valueOf(5.0);
    azzert.that(ITdb.equals(ITd1), is(true));
    
    
    double[] ITarrd = {5.0, 6.1, 7.2}; 
    Double[] ITarrdb = box.it(ITarrd);
    Double[] ITarrd1 = {5.0, 6.1, 7.2}; 
    for(int j=0;j<3;j++) {
      azzert.that(ITarrdb[j].equals(ITarrd1[j]), is(true));
    }
    
    float ITf = 56; 
    Float ITfb = box.it(ITf);
    Float ITf1 = Float.valueOf(56);
    azzert.that(ITfb.equals(ITf1), is(true));
    
    
    float[] ITarrf = {56f,50f,40f}; 
    Float[] ITarrfb = box.it(ITarrf);
    Float[] ITarrf1 = {56f,50f,40f}; 
    for(int j=0;j<3;j++) {
      azzert.that(ITarrfb[j].equals(ITarrf1[j]), is(true));
    }
    
    
    int ITi = 56; 
    Integer ITib = box.it(ITi);
    Integer ITi1 = Integer.valueOf(56);
    azzert.that(ITib.equals(ITi1), is(true));
    
    
    int[] ITarri = {56,50,40}; 
    Integer[] ITarrib = box.it(ITarri);
    Integer[] ITarri1 = {56,50,40}; 
    for(int j=0;j<3;j++) {
      azzert.that(ITarrib[j].equals(ITarri1[j]), is(true));
    }
    
    
    long ITl = 56; 
    Long ITlb = box.it(ITl);
    Long ITl1 = Long.valueOf(56);
    azzert.that(ITlb.equals(ITl1), is(true));
    
    
    long[] ITarrl = {56L,50L,40L}; 
    Long[] ITarrlb = box.it(ITarrl);
    Long[] ITarrl1 = {56L,50L,40L}; 
    for(int j=0;j<3;j++) {
      azzert.that(ITarrlb[j].equals(ITarrl1[j]), is(true));
    }
    
    
    short ITs = 5; 
    Short ITsb = box.it(ITs);
    Short ITs1 = Short.valueOf("5");
    azzert.that(ITsb.equals(ITs1), is(true));
    
    
    short[] ITarrs = {5,6,7}; 
    Short[] ITarrsb = box.it(ITarrs);
    Short[] ITarrs1 = {5,6,7}; 
    for(int j=0;j<3;j++) {
      azzert.that(ITarrsb[j].equals(ITarrs1[j]), is(true));
    }
  }
}
