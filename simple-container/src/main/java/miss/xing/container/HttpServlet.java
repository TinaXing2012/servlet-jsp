package miss.xing.container;

public abstract class HttpServlet {

    public void init(){
        System.out.println("HttpServlet Init Default Impl....");
    }

    public void service(){ //TODO: Request, Response Object as Parameters

    }

    public void doGet(){
        System.out.println("HttpServlet doGet Default Impl....");
    }

    public void doPost(){
        System.out.println("HttpServlet doPost Default Impl....");
    }
}
