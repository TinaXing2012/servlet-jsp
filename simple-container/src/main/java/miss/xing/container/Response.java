package miss.xing.container;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Response {

    private OutputStream out;
    private PrintWriter printWriter;

    public Response(OutputStream out){
        this.out = out;
        this.printWriter = new PrintWriter(out);
    }

    public OutputStream getOutputStream() {
        return out;
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }
}
