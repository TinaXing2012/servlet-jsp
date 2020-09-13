package miss.xing.container;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class SimpleWebContainer {

    private final int port;

    public SimpleWebContainer(int port) {
        this.port = port;
    }

    private void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        while(true) {
            Socket socket = serverSocket.accept();
            Thread socketHandler = new SocketHandler(socket);
            socketHandler.start();
        }
    }

    public static void main(String[] args) throws IOException {
        SimpleWebContainer container = new SimpleWebContainer(8888);
        container.start();
    }
}
