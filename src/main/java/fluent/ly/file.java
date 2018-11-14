package fluent.ly;

import java.io.*;
import java.nio.file.*;

import org.jetbrains.annotations.*;

import il.org.spartan.etc.*;

/** File utils
 * @author Ori Marcovitch
 * @since Dec 4, 2016 */
public class file {
  private static void delete(final @NotNull String path) {
    if (file.exists(path))
      new File(path).delete();
  }

  private static void rename(final @NotNull String from, final @NotNull String to) {
    file.delete(to);
    final Path source = Paths.get(from);
    try {
      Files.move(source, source.resolveSibling(to));
    } catch (final IOException ¢) {
      note.io(¢);
    }
  }

  @NotNull public static String read(final @NotNull File f) throws IOException {
    @SuppressWarnings("null") final @NotNull String ls = System.getProperty("line.separator");
    System.err.println(ls.compareTo("\n"));
    final @NotNull StringBuilder $ = new StringBuilder();
    try (@NotNull BufferedReader reader = new BufferedReader(new FileReader(f))) {
      for (String line = reader.readLine(); line != null; line = reader.readLine())
        $.append(line).append(ls);
    }
    return $ + "";
  }

  private static boolean exists(final @NotNull String path) {
    final File $ = new File(path);
    return $.exists() && !$.isDirectory();
  }

  public static void renameToCSV(final @NotNull String old) {
    file.rename(old, old + ".csv");
  }
}
