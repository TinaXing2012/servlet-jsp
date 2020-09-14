package miss.xing.container;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Map;

public class SocketHandler extends Thread {

    private Socket socket;
    private Map<String, HttpServlet> handlers;

    public SocketHandler(Socket s, Map<String, HttpServlet> handlers) {
        this.socket = s;
        this.handlers = handlers;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            Request request = new Request(in);
            if (!request.parse()) {
                out.println("HTTP/1.1 500 Internal Server Error");
                out.println("Content-Type: text/plain");
                out.println(); // \r\n
                out.println("<html><body>Cannot process your request </body></html> ");
                out.flush();
            }

            System.out.println("Method: " + request.getMethod());
            System.out.println("Path: " + request.getPath());
            request.getRequestParameters().forEach((key, value) -> System.out.println("Param Name: " + key + ", param value: " + value));
            request.getHeaders().forEach((key, value) -> System.out.println("header Name: " + key + ", header value: " + value));

            out = new PrintWriter(socket.getOutputStream());
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html");
            out.println(); // \r\n

            out.println("<html><body>Current Time: ");
            out.println(LocalDateTime.now());
            out.println("</body></html>");
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
