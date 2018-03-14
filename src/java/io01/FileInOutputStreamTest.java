package io01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInOutputStreamTest {

  public static void main(String[] args) {
    try {
      FileInputStream fileInputStream = new FileInputStream("d:/resource.txt");

      byte[] bytes = new byte[4];

      FileOutputStream fileOutputStream = new FileOutputStream("d:/des.txt");

      int hasRead = 0;

     /* while (fileInputStream.read(bytes) != -1) {
        fileOutputStream.write(bytes);
      }*/

      while ((hasRead = fileInputStream.read(bytes)) != -1) {
        // 每次读取了多少个字节,就写入多少个字节
        fileOutputStream.write(bytes, 0, hasRead);
      }


    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
