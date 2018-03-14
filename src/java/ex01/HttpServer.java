package ex01;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

  public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";

  private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

  private boolean shutdown = false;

  private void await() {
    ServerSocket serverSocket = null;
    int port = 8080;
    try {
      serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }

    while (!shutdown) {
      Socket socket = null;
      InputStream input = null;
      OutputStream output = null;
      try {
        socket = serverSocket.accept();
        input = socket.getInputStream();
        output = socket.getOutputStream();
        Request_1 request = new Request_1(input);
        request.parse();
        Response_1 response = new Response_1(output);
        response.setRequest(request);
        response.sendStaticResource();
        socket.close();
        shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
      } catch (Exception e) {
        e.printStackTrace();
        continue;
      }
    }
  }

  public static void main(String[] args) {
    HttpServer server = new HttpServer();
    server.await();

  }
}
