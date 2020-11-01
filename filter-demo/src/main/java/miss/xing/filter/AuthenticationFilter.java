package miss.xing.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("AuthenticationFilter ---1-------");

//        http://localhost:8080/filter_demo_war_exploded/login

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String action = req.getServletPath();
        if("/".equals(action) || "/login".equals(action) || "/login.jsp".equals(action)){
            filterChain.doFilter(servletRequest, servletResponse);
        } else{
            Object isLoggedObj = req.getSession().getAttribute("isLoggedIn");
            if(isLoggedObj != null){
                boolean isLoggedIn = (Boolean) isLoggedObj;
                if(isLoggedIn){
                    filterChain.doFilter(servletRequest, servletResponse);
                    return;
                }
            }
//            http://localhost:8080/filter_demo_war_exploded/
            String path = req.getContextPath()+ "/";
            resp.sendRedirect(path);
        }
//        System.out.println("AuthenticationFilter ---2-------");
    }
}
