package miss.xing.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(filterName = "authfilter")
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AuthenticationFilter ---1-------");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("AuthenticationFilter ---2-------");
    }
}
