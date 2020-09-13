package miss.xing.container;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SimpleWebContainer {

    private final int port;
    private final String configFileName;
    private Map<String, HttpServlet> handlers = new HashMap<>();

    public SimpleWebContainer(int port, String configFileName) {
        this.port = port;
        this.configFileName = configFileName;
    }

    private void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket socket = serverSocket.accept();
            Thread socketHandler = new SocketHandler(socket, handlers);
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
        properties.forEach((key, value) -> handlers.put((String) key, getServletInstance((String) value)));

    }

    private HttpServlet getServletInstance(String className) {
        try {
            return (HttpServlet) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) throws IOException {
        SimpleWebContainer container = new SimpleWebContainer(8888, "config.properties");
        container.loadPropertiesFile();
        container.handlers.forEach((url, httpServlet) -> {
            System.out.println(url);
            httpServlet.doGet();
        });
        container.start();
    }
}
