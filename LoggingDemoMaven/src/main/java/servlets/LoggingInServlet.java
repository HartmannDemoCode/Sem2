package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import configuration.Conf;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import javax.ws.rs.core.Context;
import loggingdemo.LoggingDemo;
=======
import domain.logging.LoggingDemo;
>>>>>>> loggingdemo

/**
 *
 * @author tha
 */
@WebServlet(urlPatterns = {"/LoggingInServlet"})
public class LoggingInServlet extends HttpServlet {
    @Context
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        LoggingDemo ld = new LoggingDemo();
        System.out.println("CONTEXT: "+getServletContext().getRealPath(""));
        ld.run();
//        run();
        //This method is bound to the servlet and is therefore less flexible if e.g. the presentation layer is changed:
//        getServletContext().log("TEST LOGGGING----------------------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!-----------------------");
        //System.out should be printed on ubuntu server to: /var/log/tomcat8/catalina.out:
        System.out.println("TEST IF this goes into CATALINAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA.out");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoggingInServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoggingInServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    static final Logger LOGGER = Conf.getLogger();
    public void run() throws IOException{
        //Just log a message.
//        addHandlers();
        LOGGER.log(Level.OFF, "Only this message will be logged");
        //Log a message: First anounce sevirity level, then the message and then a list of objects to be inserted in the message.
        LOGGER.log(Level.SEVERE, "This is the {0} to be {1}", new Object[]{"message", "logged"});
        //Log a Throwable
        LOGGER.log(Level.SEVERE, "Message to be logged", new RuntimeException("ERROR"));
        //Log with the hierachy: the chain of responsibility pattern
//        Logger hierachicalLogger = createHierachyOfLoggers();
//        hierachicalLogger.log(Level.SEVERE, "hierachical logging message", new RuntimeException("Hierachical logging of exception"));
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
