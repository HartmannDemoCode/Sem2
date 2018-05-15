/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import configuration.Conf;
import domain.exceptions.MyCustomException;
import domain.logic.Demo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tha
 */
@WebServlet(name = "DemoServlet", urlPatterns = {"/DemoServlet"})
public class DemoServlet extends HttpServlet {
    //Logger myLogger = Logger.getLogger(DemoServlet.class.getName());
    
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
            Conf.MYLOGGER.addHandler(new ConsoleHandler());
               if(Conf.PRODUCTION){
                   FileHandler fileHandler = new FileHandler(Conf.LOGFILEPATH);
                   fileHandler.setFormatter(new SimpleFormatter());
                    Conf.MYLOGGER.addHandler(fileHandler);
               }
        try (PrintWriter out = response.getWriter()) {
            Demo demo = new Demo();
            try {
                demo.doSomething();
            } catch (MyCustomException ex) {
               Conf.MYLOGGER.log(Level.SEVERE, null, ex);
               request.getSession().setAttribute("error", ex.getMessage());
               request.getRequestDispatcher("errorview.jsp").forward(request, response);
            }
        }
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
