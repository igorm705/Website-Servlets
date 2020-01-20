package demoservlets;

        import javax.servlet.RequestDispatcher;
        import javax.servlet.ServletException;
            import javax.servlet.annotation.WebServlet;
            import javax.servlet.http.HttpServlet;
            import javax.servlet.http.HttpServletRequest;
            import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;
        import java.io.IOException;
            import java.io.PrintWriter;

/** this servlet includes page "login.html" - first page of this web-application.
 *  It requires input name of user, saves it in a session and redirects to servlet "Chat".
 In case of empty input of name the servlet reports "Missing name" and returns to "login.html".*/

@WebServlet( name="LoginServlet", urlPatterns = "/LoginServlet"  )
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // response.setContentType("text/html");
        PrintWriter out = response.getWriter();
//        request.getRequestDispatcher("link.html").include(request, response);

        String name = request.getParameter("name");

        if (name.length() == 0) {
            //  we  split login.html in 2 files and insert the message in between
            request.getRequestDispatcher("login1.html").include(request, response);
            out.print("missing name!");
            request.getRequestDispatcher("login2.html").include(request, response);
            out.close();
        } else {

            //  request.setAttribute("attributeName",name);
            String str = request.getParameter("name");
            HttpSession session = request.getSession();
            session.setAttribute("name", str);

            response.sendRedirect("Chat");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/Chat");
        rd.forward(request, response);
    }
}
