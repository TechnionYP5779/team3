package tests;

import org.junit.*;

import fluent.ly.*;

public class angleTest {

  
  @SuppressWarnings("static-method") @Test public void creatAngle() {
    @SuppressWarnings("unused") angle ad = angle.degree(20); 
    @SuppressWarnings("unused")angle ar = angle.radians(1);
    @SuppressWarnings("unused")angle ap = angle.pi();
    @SuppressWarnings("unused")angle aHp = angle.halfPi();
  }
  @SuppressWarnings("static-method") @Test public void angleAdd1() {
    angle aHp = angle.halfPi();
    angle ad = angle.degree(20); 
    azzert.assertTrue((aHp.add(ad).degrees() == 110));
  }
  
  @SuppressWarnings("static-method") @Test public void anglePiDegrees() {
    angle ap = angle.pi(); 
    azzert.assertTrue(ap.degrees() == 180); 
  }
  
  @SuppressWarnings("static-method") @Test public void anglePiDegrees2() {
    angle ap = angle.pi(); 
    azzert.assertTrue(ap.radians() ==  Math.PI);
  }
  
  @SuppressWarnings("static-method") @Test public void angleRad() {
    angle ar = angle.radians(1);
    azzert.assertTrue(ar.radians() ==  1);
  }
  
  @SuppressWarnings("static-method") @Test public void angleSubtracted() {
    angle aHp = angle.halfPi();
    angle ap = angle.pi(); 
    azzert.assertTrue(ap.subtracted(aHp).degrees() == aHp.degrees());
  }
  
  @SuppressWarnings("static-method") @Test public void angleOf() { 
    azzert.assertTrue(angle.of(20).degrees() == 20); 
  }
  
  @SuppressWarnings("static-method") @Test public void angleAdd() {
    angle ap = angle.pi(); 
    azzert.assertTrue(ap.add(20).degrees() == 200); 
  }
  
  @SuppressWarnings("static-method") @Test public void angleSubtracted2() {
    angle ap = angle.pi(); 
    azzert.assertTrue(ap.subtracted(20).degrees() == 160); 
  }
 
  @SuppressWarnings("static-method") @Test public void angleNegated() {
    azzert.assertTrue(new angle(20.0).negated().degrees() == new angle(-20).degrees());
  }
 
  
}
