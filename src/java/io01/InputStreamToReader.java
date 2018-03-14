package io01;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamToReader {

  public static void main(String[] args) {
    StringBuffer stringBuffer = new StringBuffer();
    try {
      FileInputStream fileInputStream = new FileInputStream(
          "d:" + File.separatorChar + "resource.txt");
      FileDescriptor fd = fileInputStream.getFD();

      System.out.println(File.separatorChar);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
