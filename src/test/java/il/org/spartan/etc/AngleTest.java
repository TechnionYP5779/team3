package il.org.spartan.etc;

import org.junit.*;

@SuppressWarnings("static-method") public class AngleTest {
  @Test public void creatAngle() {
    angle.degree(20);
    angle.radians(1);
    angle.pi();
    angle.halfPi();
  }

  @Test public void angleAdd1() {
    assert angle.halfPi().add(angle.degree(20)).degrees() == 110;
  }

  @Test public void anglePiDegrees() {
    assert angle.pi().degrees() == 180;
  }

  @Test public void anglePiDegrees2() {
    assert angle.pi().radians() == Math.PI;
  }

  @Test public void angleRad() {
    assert angle.radians(1).radians() == 1;
  }

  @Test public void angleSubtracted() {
    final angle aHp = angle.halfPi();
    assert angle.pi().subtracted(aHp).degrees() == aHp.degrees();
  }

  @Test public void angleOf() {
    assert angle.of(20).degrees() == 20;
  }

  @Test public void angleAdd() {
    assert angle.pi().add(20).degrees() == 200;
  }

  @Test public void angleSubtracted2() {
    assert angle.pi().subtracted(20).degrees() == 160;
  }

  @Test public void angleNegated() {
    assert new angle(20.0).negated().degrees() == new angle(-20).degrees();
  }
}
