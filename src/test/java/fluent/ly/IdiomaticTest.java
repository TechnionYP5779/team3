package fluent.ly;

import static fluent.ly.azzert.*;

import java.util.function.*;

import org.junit.*;

import fluent.ly.idiomatic.*;

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
    assert idiomatic.quote("ABBA").equals("'ABBA'");
  }

  @SuppressWarnings("boxing") @Test public void use13() {
    assert idiomatic.incase(true, 4) == 4;
    assert idiomatic.incase(false, 4) == null;
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

  @SuppressWarnings("null") @Test public void use14() {
    final Supplier<String> s = () -> "12534";
    assert idiomatic.eval(s).get().equals("12534");
  }

  @SuppressWarnings("boxing") @Test public void use15() {
    assert idiomatic.unless(true, 4) == null;
    assert idiomatic.unless(false, 4) == 4;
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
    final Runnable myRunnable = () -> System.out.println("Runnable running");
    final Runner r = idiomatic.run(myRunnable);
    assert r != null;
  }
}
