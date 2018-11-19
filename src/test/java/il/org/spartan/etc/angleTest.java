package il.org.spartan.etc;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class angleTest {
  @Test public void creatAngle() {
    angle.degree(20);
    angle.radians(1);
    angle.pi();
    angle.halfPi();
  }

  @Test public void angleAdd1() {
    final angle aHp = angle.halfPi();
    final angle ad = angle.degree(20);
    azzert.assertTrue(aHp.add(ad).degrees() == 110);
  }

  @Test public void anglePiDegrees() {
    final angle ap = angle.pi();
    azzert.assertTrue(ap.degrees() == 180);
  }

  @Test public void anglePiDegrees2() {
    final angle ap = angle.pi();
    azzert.assertTrue(ap.radians() == Math.PI);
  }

  @Test public void angleRad() {
    final angle ar = angle.radians(1);
    azzert.assertTrue(ar.radians() == 1);
  }

  @Test public void angleSubtracted() {
    final angle aHp = angle.halfPi();
    final angle ap = angle.pi();
    azzert.assertTrue(ap.subtracted(aHp).degrees() == aHp.degrees());
  }

  @Test public void angleOf() {
    azzert.assertTrue(angle.of(20).degrees() == 20);
  }

  @Test public void angleAdd() {
    final angle ap = angle.pi();
    azzert.assertTrue(ap.add(20).degrees() == 200);
  }

  @Test public void angleSubtracted2() {
    final angle ap = angle.pi();
    azzert.assertTrue(ap.subtracted(20).degrees() == 160);
  }

  @Test public void angleNegated() {
    azzert.assertTrue(new angle(20.0).negated().degrees() == new angle(-20).degrees());
  }
}
