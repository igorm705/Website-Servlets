package demoservlets;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * This servlet is called from "chat.html" and prints string "Welcome
 *   " and name of connected user. This name this servlet takes from session.
 */
@WebServlet(name = "Welcome", urlPatterns = {"/welcome"} )
public class Welcome extends HttpServlet {
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            HttpSession session = request.getSession();

            //get OBJECT from session and convert it to string
            String str = session.getAttribute("name").toString();

            String greetings = "Hello " + str;

            response.setContentType("text/plain");
            response.getWriter().write(greetings);
        } catch (Exception e) {
            //RequestDispatcher rd = request.getRequestDispatcher("/login.html");
           // response.sendRedirect("/login.html");
        }
    }
}
