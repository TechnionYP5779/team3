package il.org.spartan.etc;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.etc.idiomatic.*;

@SuppressWarnings("static-method") public class Idiomatic_test {

  @Test public void use0() {
    assert new Storer<>(this) != null;
  }

  @Test public void use08() {
    azzert.isNull(idiomatic.unless(true).eval(() -> new Object()));
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
    azzert.isNull(idiomatic.when(false).eval(() -> new Object()));
  }

  @Test public void use12() {
    assert "'ABBA'".equals(idiomatic.quote("ABBA"));
  }

  @Test public void use13() {
    assert idiomatic.incase(true, box.box(4)) == box.box(4);
    assert idiomatic.incase(false, box.box(4)) == null;
  }

  @Test public void use2() {
    assert idiomatic.take(this) != null;
    azzert.isNull(idiomatic.take(this).when(false));
  }

  @Test public void use3() {
    azzert.that(idiomatic.take(this).when(true), is(this));
  }

  @Test public void use4() {
    azzert.isNull(idiomatic.take(this).when(false));
  }

  @Test public void use5() {
    azzert.that(idiomatic.take(this).unless(false), is(this));
  }

  @Test public void use6() {
    azzert.isNull(idiomatic.take(this).unless(true));
  }

  @Test public void use7() {
    azzert.isNull(idiomatic.take(this).unless(true));
    azzert.isNull(idiomatic.take(null).unless(true));
    azzert.isNull(idiomatic.take(null).unless(false));
  }

  @Test public void use14() {
    assert idiomatic.eval(() -> "12534").get().equals("12534");
  }

  @Test public void use15() {
    assert idiomatic.unless(true, box.box(4)) == null;
    assert idiomatic.unless(false, box.box(4)) == box.box(4);
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
    assert idiomatic.run(() -> {
      return;
    }) != null;
  }
}