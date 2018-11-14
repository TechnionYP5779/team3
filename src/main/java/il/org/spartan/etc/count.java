package il.org.spartan.etc;

public interface count {
  static <T> int of(final Iterable<T> ts) {
    int $ = 0;
    for (@SuppressWarnings("unused") final T __ : ts)
      ++$;
    return $;
  }
}
