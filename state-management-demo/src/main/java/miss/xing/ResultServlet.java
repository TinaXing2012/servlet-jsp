package miss.xing;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import miss.xing.model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.stream.Stream;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();

//        The code below is the result display page for Request Scope.
       /* String playlist = (String) req.getAttribute("playlist");
        User user = (User) req.getAttribute("user");
        System.out.println(user.getFirstName());

        out.println("playlist: " + playlist);
        out.println("user: " + user.getFirstName() + " " + user.getLastName());
*/

//        The code below is the result page for Cookie Exchange
//        Cookie[] cookies = req.getCookies();
//        out.println("user: " + this.getCookieValueByName(cookies, "user").get());
//        out.println("playlist: " + this.getCookieValueByName(cookies, "playlist").orElse("Cannot find playlist Cookie"));

//        The code below is result page for HttpSession/LoginServlet demo
//        HttpSession session = req.getSession();
//        out.println("is Logged In? " + session.getAttribute("isLoggedIn"));
//        User user = (User) session.getAttribute("user");
//        if (user != null) {
//            out.println(user.getFirstName() + " " + user.getLastName());
//        } else {
//            out.println("No User Session Attribute");
//        }

//        The below code is the result page for ApplicationScope demo
        out.println("App Name: " + getServletContext().getAttribute("AppName"));
        out.println("Author: " + getServletContext().getAttribute("Author"));


    }

    private Optional<String> getCookieValueByName(Cookie[] cookies, String name) {
        return Stream.of(cookies)
                .filter(cookie -> name.equals(cookie.getName()))
                .map(Cookie::getValue)
                .findAny();
    }

}
