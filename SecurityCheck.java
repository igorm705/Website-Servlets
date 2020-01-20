package demoservlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/** checks if name of user is existing in a session. In case if yes - allowed for
 * user  is "null" in session  - returns him to "login.html.*/

@WebServlet(name = "SecurityCheck")
public class SecurityCheck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();

            //get OBJECT from session and convert it to string
            String str = session.getAttribute("name").toString();

            response.setContentType("text/plain");
            response.getWriter().write("");

        } catch (Exception e) {
            response.setContentType("text/plain");
            response.getWriter().write("bad");
        }
    }
}
