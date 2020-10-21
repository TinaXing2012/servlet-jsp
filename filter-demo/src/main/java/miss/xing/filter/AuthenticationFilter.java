package miss.xing.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AuthenticationFilter ---1-------");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("AuthenticationFilter ---2-------");
    }
}
