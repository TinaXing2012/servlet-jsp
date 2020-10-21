package miss.xing.filter;

import jakarta.servlet.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Enumeration;

public class RequestLoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init()... Called only once");
        Enumeration<String> names = filterConfig.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println(name + " : " + filterConfig.getInitParameter(name));
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("RequestLoggingFilter doFilter...1..." + LocalDateTime.now());
        servletRequest.setAttribute("handsomeguy", "Edward");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("RequestLoggingFilter doFilter...2..." + LocalDateTime.now());
        servletResponse.getWriter().println("Edward is very handsome!!!");
    }

    @Override
    public void destroy() {
        System.out.println("destroy()... Called only once");
    }
}
