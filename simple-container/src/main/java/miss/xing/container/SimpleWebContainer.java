package miss.xing.container;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Properties;

public class SimpleWebContainer {

    private final int port;
    private final String configFileName;

    public SimpleWebContainer(int port, String configFileName) {
        this.port = port;
        this.configFileName = configFileName;
    }

    private void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket socket = serverSocket.accept();
            Thread socketHandler = new SocketHandler(socket);
            socketHandler.start();
        }
    }

    private void loadPropertiesFile() throws IOException {
        InputStream input = getClass().getClassLoader().getResourceAsStream(configFileName);
        if (input == null) {
            throw new RuntimeException("Unable to find file: " + configFileName);
        }

        Properties properties = new Properties();
        properties.load(input);
        properties.forEach((key, value) -> System.out.println(key + ", " + value));

    }

    public static void main(String[] args) throws IOException {
        SimpleWebContainer container = new SimpleWebContainer(8888, "config.properties");
        container.loadPropertiesFile();
        container.start();
    }
}
