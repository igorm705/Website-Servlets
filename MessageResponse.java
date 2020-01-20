package demoservlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 * /**
 *  * This servlet returns from ServletContext to "chat.html" a string
 *  * with previous messages. it is called from "chat.html"
 *  */

@WebServlet(name = "MessageResponse")
public class MessageResponse extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw=response.getWriter();

    //creating ServletContext object
        ServletContext context=getServletContext();

        //Getting the value of the initialization parameter and printing it
        String msg = (String)context.getAttribute( "message" );
        //<String> messages = new ArrayList<String>(); // Create an ArrayList object
       // ArrayList<String> messages = (ArrayList<String>)context.getAttribute( "message" );

        if (msg == null) {
            msg = "Welcome to chat";
        }


        pw.println(msg);

        pw.close();
    }
}
