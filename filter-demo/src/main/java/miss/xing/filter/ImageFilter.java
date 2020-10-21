package miss.xing.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

import java.io.IOException;
import java.util.Enumeration;

@WebFilter(urlPatterns = {"/web/*"}, initParams = {
        @WebInitParam(name = "filter-name", value = "ImageFilter"),
        @WebInitParam(name = "description", value = "Compress Image Size")
}, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD},
servletNames = {"welcomeservlet"})
public class ImageFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("ImageFilter init()... Called only once");
        Enumeration<String> names = filterConfig.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            System.out.println(name + " : " + filterConfig.getInitParameter(name));
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("ImageFilter ****** 1 *********");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("ImageFilter ****** 2 *********");
    }

    @Override
    public void destroy() {
        System.out.println("ImageFilter destroy()... Called only once");
    }
}
