package ex01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Response_1 {

  private static final int BUFFER_SIZE = 1024;

  Request_1 request;

  OutputStream output;

  public Response_1(OutputStream output) {
    this.output = output;
  }

  public void setRequest(Request_1 request) {
    this.request = request;
  }

  public void sendStaticResource() throws IOException {
    byte[] bytes = new byte[BUFFER_SIZE];
    FileInputStream fis = null;
    try {
      File file = new File(HttpServer.WEB_ROOT, request.getUri());
      if (file.exists()) {
        fis = new FileInputStream(file);
        int ch = fis.read(bytes, 0, BUFFER_SIZE);
        while (ch != -1) {
          output.write(bytes, 0, ch);
          ch = fis.read(bytes, 0, BUFFER_SIZE);
        }
      } else {
        //file not found
        String errorMessage =
            "HTTP/1.1 404 File NOT found\r\n" + "content-type:text/html\r\n"
                + "content-length:23\r\n"
                + "\r\n" + "<h1>file not found </h1>";
        output.write(errorMessage.getBytes());
      }
    } catch (Exception e) {
      //throw if cannot instantiate a File object
      e.printStackTrace();
      //System.out.println(e.toString());;
    } finally {
      if (fis != null) {
        fis.close();
      }
    }
  }
}
