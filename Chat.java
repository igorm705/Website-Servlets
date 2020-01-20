package demoservlets;



import javax.servlet.RequestDispatcher;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;

/**  This servlet includes page "chat.html",  get the name of  the user from a session
 *  in order to welcome him. In the method "doPost" the servlet add new message to string
 *  of previous messages and saves it in ServletContext. */
@WebServlet(name = "Chat", urlPatterns = "/Chat")
    public class Chat extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = null ;
        try {


            HttpSession session = request.getSession();

            //get OBJECT from session and convert it to string
            String str = session.getAttribute("name").toString();

            RequestDispatcher rd = request.getRequestDispatcher("/chat.html");
            rd.include(request, response);

        } catch (Exception e) {
            RequestDispatcher rd=request.getRequestDispatcher("/login.html");
            rd.include(request, response);

           // if (out!=null)
         //       out.println(e);
        }
        out.close();
    }

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    HttpSession session = request.getSession();

        //get OBJECT from session and convert it to string
        String name = session.getAttribute("name").toString();


        String str = request.getParameter("message");

        //merge name of user and his message
        str = "<p>" + name + ": "+ str + "</p>";


        //-----------------from Welcome servlet-------------------
    response.setContentType("text/html");
    PrintWriter pw=response.getWriter();

    //creating ServletContext object
    ServletContext context=getServletContext();

   // ArrayList<String> messages = new ArrayList<String>(); // Create an ArrayList object
    //Getting the value of the initialization parameter and printing it
    String msg = (String)context.getAttribute( "message" );

    if (msg == null) {
        msg = "Welcome to chat";
    }

    msg = msg + str;

   // messages = (ArrayList<String>)context.getAttribute( "message" );

//
    //--------------------------------------------------------

    context = request.getSession().getServletContext();
    context.setAttribute("message", msg);


 response.setContentType( "text/html" );

    RequestDispatcher rd=request.getRequestDispatcher("/chat.html");
    rd.include(request, response);
    }

}
