package fluent.ly;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;
import java.util.function.*;

import org.junit.*;

@SuppressWarnings("static-method") public class nilTest {
  static String helloString = "Hello";

  @Test public void usecase0() {
    azzert.isNull(nil.ignoring(true));
  }

  @Test public void usecase1() {
    azzert.isNull(nil.ignoring(3));
  }

  @Test public void usecase2() {
    azzert.isNull(nil.ignoring(2.5));
  }

  @Test public void usecase3() {
    azzert.isNull(nil.forgetting(box(1), box(4), "hi"));
  }

  @Test public void usecase4() {
    azzert.isNull(nil.guardingly(λ -> box("hi".equals(λ))).on(null));
  }

  @Test public void t() {
    final Integer i1 = nil.guardingly(String::length).on(helloString);
    azzert.that(i1, is(5));
    final Integer i2 = nil.guardingly(String::length).on(nullString);
    azzert.that(i1, is(5));
    azzert.isNull(i2);
    final Integer i3 = nil.guardingly(f).on(nullString);
    azzert.that(i1, is(5));
    azzert.isNull(i2);
    azzert.isNull(i3);
    nil.guardingly(State::getName).on(null);
    nil.guardingly(State::getName).on(californiaCustomer.getAddress().getState());
  }

  String nullString;
  final Customer californiaCustomer = () -> () -> new State() {
    @Override public String getName() {
      return "California";
    }
  };
  final Function<String, Integer> f = String::length;
  final Customer nullAddressCustomer = () -> null;
  final Customer nullNameCustomer = () -> () -> new State() {/***/
  };
  final Customer nullStateCustomer = () -> () -> null;
  final Customer nullStateCustomer1 = () -> () -> null;

  //@formatter:off
  interface Address { State getState(); }
  interface Customer { Address getAddress(); }
  interface State {default String getName() { return null; } }
}
