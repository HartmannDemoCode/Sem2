/*

 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import usingdb.Image;
import usingdb.ImageMapper;

/**
 *
 * @author tha
 */
@WebServlet(name = "ShowImages", urlPatterns = {"/ShowImages"})
public class ShowImages extends HttpServlet {
    ImageMapper im = new ImageMapper();
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
        String param = request.getParameter("send2jsp");
        boolean send2jsp = false;
        if(param != null)
            send2jsp = Boolean.valueOf(param);
        ImageMapper im = new ImageMapper();
        List<Image> images = null;
        try {
            images = im.loadImages();
            System.out.println("send2jsp: "+send2jsp);
            if(send2jsp) { //if this flag is set - it is because we want to go to showImages.jsp holding the list of images to show on this page
                RequestDispatcher dispatcher = request.getRequestDispatcher("showImages.jsp");
                request.setAttribute("images", im.loadImages());
                dispatcher.forward(request, response);
                return;
            }else{ //The flag is not set so we display the images directly from this servlet.
                output(response, request, images);
                return;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }            
    }
    /*This method is writing text to the response output stream to be send to the browser*/
    private void output(HttpServletResponse response, HttpServletRequest request, List<Image> images) throws IOException {
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowImages</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h3>Servlet ShowImages at from the imageviewer</h3>");
            //Just show image 1 and 2:
//            out.println("<img src=\""+request.getContextPath()+"/ShowImage?imgno=1\">");
//            out.println("<img src=\""+request.getContextPath()+"/ShowImage?imgno=2\">");
            
            out.println("<h3>ShowImages from the list of images loaded from the ImageMapper</h3>");
            for (Image image : images) {
                out.println("<img src=\""+request.getContextPath()+"/ImageViewer?imgno="+image.getId()+"\">");
            }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
