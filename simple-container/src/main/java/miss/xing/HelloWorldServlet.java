package miss.xing;

import miss.xing.container.HttpServlet;

public class HelloWorldServlet extends HttpServlet {

    @Override
    public void doGet() {
        System.out.println("HelloWorldServlet doGet()....");
    }
}
