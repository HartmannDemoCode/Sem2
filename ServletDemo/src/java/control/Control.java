package control;

import domain.Car;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Sep 17, 2017
 */
@WebServlet(name="Control", urlPatterns={"/Control"})
public class Control extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Car> cars = new ArrayList();
        cars.add(new Car("Audi", "A3", "2014"));
        cars.add(new Car("Audi", "A6", "2011"));
        cars.add(new Car("Merzedes", "190D", "1999"));
        cars.add(new Car("Toyota", "Yaris", "2004"));
        cars.add(new Car("Toyota", "Land Cruiser", "2003"));
        cars.add(new Car("Fiat", "Panda", "2012"));
        cars.add(new Car("Fiat", "500", "1998"));
        
        String hiddenTxt = request.getParameter("origin");
        String inputTxt = request.getParameter("inputTxt");
        
        request.setAttribute("userInput", inputTxt);
        HttpSession session = request.getSession();
        session.setAttribute("carList", cars);
        request.getRequestDispatcher("output.jsp").forward(request, response);
//        response.sendRedirect("http://www.google.com"); //Use this to load a resource from a different domain.
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
