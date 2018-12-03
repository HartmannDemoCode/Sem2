package presentation;

import data.Image;
import data.ImageMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Nov 17, 2016
 */
@WebServlet(name = "ImageControl", urlPatterns = {"/ImageControl", "/index.html"})
@MultipartConfig //Without this we cannot get the input parameters from the response....
public class Upload2DBControl extends HttpServlet {

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
        int[] imageIds = im.getAllImageIds();
        request.getSession().setAttribute("images", imageIds);
        response.sendRedirect("showimages.jsp");
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
        request.getSession().setAttribute("images", im.getAllImageIds());
        String delete = request.getParameter("delete");
        if (delete == null) //Then we come from uploadimage.jsp
        {
            String name = request.getParameter("imagename");
            Part filePart = request.getPart("imagefile");
            InputStream image = filePart.getInputStream();
            String contentType = filePart.getContentType();

            im.insertImg(name, contentType, image);
            response.getWriter().print("Det lykkedes at uploade billedet: " + name);
        } else { //come from showimages.jsp with delete intention
            int id = Integer.parseInt(delete);
            if(im.deleteImage(id)){
                
                response.getWriter().print("Det lykkedes at slette billedet med id: "+id);
            }
        }
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
