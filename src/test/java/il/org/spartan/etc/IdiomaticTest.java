package il.org.spartan.etc;


import static fluent.ly.box.*;
import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.etc.idiomatic.*;

@SuppressWarnings("static-method")
public class IdiomaticTest {
  @Test public void use0() {
    assert new Storer<>(this) != null;
  }

  @Test public void use08() {
    isNull(idiomatic.unless(true).eval(() -> new Object()));
  }

  @Test public void use09() {
    assert idiomatic.unless(false).eval(() -> new Object()) != null;
  }

  @Test public void use1() {
    assert new Storer<>(this) != null;
    new Storer<>(this).when(true);
  }

  @Test public void use10() {
    assert idiomatic.when(true).eval(() -> new Object()) != null;
  }

  @Test public void use11() {
    isNull(idiomatic.when(false).eval(() -> new Object()));
  }

  @Test public void use12() {
    assert "'ABBA'".equals(idiomatic.quote("ABBA"));
  }

  @Test public void use13() {
    azzert.that(idiomatic.incase(true, box(4)), is(box(4)));
    assert idiomatic.incase(false, box(4)) == null;
  }

  @Test public void use2() {
    assert idiomatic.take(this) != null;
    isNull(idiomatic.take(this).when(false));
  }

  @Test public void use3() {
    azzert.that(idiomatic.take(this).when(true), is(this));
  }

  @Test public void use4() {
    isNull(idiomatic.take(this).when(false));
  }

  @Test public void use5() {
    azzert.that(idiomatic.take(this).unless(false), is(this));
  }

  @Test public void use6() {
    isNull(idiomatic.take(this).unless(true));
  }

  @Test public void use7() {
    isNull(idiomatic.take(this).unless(true));
    isNull(idiomatic.take(null).unless(true));
    isNull(idiomatic.take(null).unless(false));
  }

  @Test public void use14() {
    assert "12534".equals(idiomatic.eval(() -> "12534").get());
  }

  @Test public void use15() {
    assert idiomatic.unless(true, box(4)) == null;
    azzert.that(idiomatic.unless(false, box(4)), is(4));
  }

  @Test public void use16() {
    assert idiomatic.unless(true) == idiomatic.ignore;
    assert idiomatic.unless(false) == idiomatic.eval;
  }

  @Test public void use17() {
    assert idiomatic.when(false) == idiomatic.ignore;
    assert idiomatic.when(true) == idiomatic.eval;
  }

  @Test public void use18() {
    assert idiomatic.run(() -> System.out.println("Runnable running")) != null;
  }
}
