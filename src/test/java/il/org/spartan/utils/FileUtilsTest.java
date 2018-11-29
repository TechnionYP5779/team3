package il.org.spartan.utils;

import java.io.*;

import org.junit.*;

@SuppressWarnings("static-method") public class FileUtilsTest {
  @Test public void test() {
    try (PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8")) {
      writer.println("The first line");
      writer.close();
      assert (FileUtils.findAllJavaFiles("").isEmpty());
    } catch (Exception ¢) {
      ¢.printStackTrace();
    }
    try {
      assert (FileUtils.read("the-file-name.txt") != null);
      FileUtils.writeToFile("the-file-name.txt", "The second line");
      assert ("The second line".equals(FileUtils.read("the-file-name.txt")));
    } catch (IOException ¢) {
      ¢.printStackTrace();
    }
    (new File("the-file-name.txt")).delete();
  }
}
