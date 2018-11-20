package il.org.spartan.utils;

import java.io.*;


import org.junit.*;

public class FileUtilsTest {
  @SuppressWarnings("resource") @Test public void test() {
    try {
    PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
    writer.println("The first line");

    writer.close();
    assert(FileUtils.findAllJavaFiles("").isEmpty());
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    try {
      assert(FileUtils.read("the-file-name.txt")!=null);
      FileUtils.writeToFile("the-file-name.txt","The second line");
      assert(FileUtils.read("the-file-name.txt").equals("The second line"));
      
      
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  
}
