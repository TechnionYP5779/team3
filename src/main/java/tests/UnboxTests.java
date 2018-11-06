package tests;

import java.util.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({"static-method", "boxing"})
public class UnboxTests {
    //NOTE: apparently not all functions are implemented
    
    private final double EPS = 0.001;
    
    @Test
    public void testInts() {
      int[] arr = {1,2,3,4,5,6};
      
      ArrayList<Integer> lst = new ArrayList<>();
      lst.add(1);
      lst.add(2);
      lst.add(3);
      lst.add(4);
      lst.add(5);
      lst.add(6);
      
      int[] res = unbox.it(lst);

      azzert.assertEquals(res.length, arr.length);
      int j = 0;
      for(int ¢ : arr)
        azzert.assertEquals(¢, res[j++]);
      
      Integer[] arrInt = {1,2,3,4,5,6};

      res = unbox.it(arrInt);

      azzert.assertEquals(res.length, arr.length);
      j = 0;
      for(int ¢ : arr)
        azzert.assertEquals(¢, res[j++]);
      
      azzert.assertEquals(unbox.unbox(Integer.valueOf(5)), 5);
      
      res = unbox.unbox(arrInt);

      azzert.assertEquals(res.length, arr.length);
      j = 0;
      for(int ¢ : arr)
        azzert.assertEquals(¢, res[j++]);
    }
    
    @Test
    public void testShorts() {
      short[] arr = { 1, 2, 3, 4, 5, 6 }, res;
      
      Short[] arrShort = {1,2,3,4,5,6};
      
      azzert.assertEquals(unbox.unbox(Short.valueOf((short) 5)), 5);
      
      res = unbox.unbox(arrShort);

      azzert.assertEquals(res.length, arr.length);
      int j = 0;
      for(short i : arr)
        azzert.assertEquals(i, res[j++]);
    }
    
    @Test
    public void testBytes() {
      byte[] arr = { 1, 2, 3, 4, 5, 6 }, res;
      
      Byte[] arrByte = {1,2,3,4,5,6};
      
      azzert.assertEquals(unbox.unbox(Byte.valueOf((byte) 5)), 5);
      
      res = unbox.unbox(arrByte);

      azzert.assertEquals(res.length, arr.length);
      int j = 0;
      for(byte i : arr)
        azzert.assertEquals(i, res[j++]);
    }
    
    @Test
    public void testDoubles() {
      double[] arr = {1.0,2.0,3.0,4.0,5.0,6.0};
      Double[] arrDouble = {1.0,2.0,3.0,4.0,5.0,6.0};

      double[] res = unbox.it(arrDouble);

      azzert.assertEquals(res.length, arr.length);
      int j = 0;
      for(double i : arr)
        assert Math.abs(i - res[j++]) < EPS;

      assert Math.abs(unbox.unbox(Double.valueOf(5.0)) - 5.0) < EPS;
      
      res = unbox.unbox(arrDouble);

      azzert.assertEquals(res.length, arr.length);
      j = 0;
      for(double i : arr)
        assert Math.abs(i - res[j++]) < EPS;
    }
    
    @Test
    public void testFloats() {      
      float[] arr = {1.0f,2.0f,3.0f,4.0f,5.0f,6.0f};
      Float[] arrFloat = {1.0f,2.0f,3.0f,4.0f,5.0f,6.0f};

      float[] res = unbox.it(arrFloat);

      azzert.assertEquals(res.length, arr.length);
      int j = 0;
      for(float i : arr)
        assert Math.abs(i - res[j++]) < (float) EPS;

      assert Math.abs(unbox.unbox(Float.valueOf(5.0f)) - 5.0f) < (float) EPS;
      
      res = unbox.unbox(arrFloat);

      azzert.assertEquals(res.length, arr.length);
      j = 0;
      for(float i : arr)
        assert Math.abs(i - res[j++]) < (float) EPS;
    }
    
    @Test
    public void testBools() {
      boolean[] arr = {true, false, true, true, false, false};
      
      Boolean[] arrBool = {true, false, true, true, false, false};
      
      azzert.assertEquals(unbox.unbox(Boolean.TRUE), true);
      azzert.assertEquals(unbox.unbox(Boolean.FALSE), false);
      
      boolean[] res = unbox.unbox(arrBool);

      azzert.assertEquals(res.length, arr.length);
      int j = 0;
      for(boolean i : arr)
        azzert.assertEquals(i, res[j++]);
    } 
    
    @Test
    public void testLongs() {
      long[] arr = {1,2,3,4,5,6};
      
      Long[] arrLong = {1l,2l,3l,4l,5l,6l};
      
      assert unbox.unbox(Long.valueOf(5l)) == 5l;
      
      long[] res = unbox.unbox(arrLong);

      azzert.assertEquals(res.length, arr.length);
      int j = 0;
      for(long i : arr)
        assert i == res[j++];
    }
    
    @Test
    public void testChars() {
      char[] arr = {1,2,3,4,5,6};
      
      Character[] arrChar = {1,2,3,4,5,6};
      
      azzert.assertEquals(unbox.unbox(Character.valueOf((char) 5)), 5);
      
      char[] res = unbox.unbox(arrChar);

      azzert.assertEquals(res.length, arr.length);
      int j = 0;
      for(char i : arr)
        azzert.assertEquals(i, res[j++]);
    }

}
