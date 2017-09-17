/*

 */
package servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tha
 */
@WebServlet(name = "Print2PDF", urlPatterns = {"/Print2PDF"})
public class Print2PDF extends HttpServlet {

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
//        String url = request.getRequestURL().toString();
//        String applicationUrl = url.substring(0, url.lastIndexOf("/"));
//        applicationUrl += "/article2PDF.jsp";
//        System.out.println("URL: "+applicationUrl);
//        URLConnection connection = new URL(applicationUrl).openConnection();
//        //connection.setRequestProperty("Cookie", "JSESSIONID=" + request.getSession().getId());
//        InputStream source = connection.getInputStream();
//        
//        response.setContentType("application/pdf");
//	response.addHeader("Content-Disposition", "attachment; filename=" + "arcticle.pdf");
	//response.setContentLength((int) pdfFile.length());

	
//	OutputStream responseOutputStream = response.getOutputStream();
//        int bytes;
//        while ((bytes = source.read()) != -1) {
//                responseOutputStream.write(bytes);
//        }
//        responseOutputStream.flush();
//        responseOutputStream.close();
        String pdfFileName = "pdf-test.pdf";
		String contextPath = getServletContext().getRealPath(File.separator);
		File pdfFile = new File(contextPath + pdfFileName);

		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename=" + pdfFileName);
		response.setContentLength((int) pdfFile.length());

		FileInputStream fileInputStream = new FileInputStream(pdfFile);
		OutputStream responseOutputStream = response.getOutputStream();
		int bytes;
		while ((bytes = fileInputStream.read()) != -1) {
			responseOutputStream.write(bytes);
		}
                responseOutputStream.flush();
                responseOutputStream.close();
                
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
