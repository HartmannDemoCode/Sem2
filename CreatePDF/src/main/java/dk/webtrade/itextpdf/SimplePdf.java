package dk.webtrade.itextpdf;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Nov 9, 2016
 */
@WebServlet(name = "PdfCreator", urlPatterns = {"/PdfCreator"})
public class SimplePdf extends HttpServlet {

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
        response.setContentType("application/pdf");
//        try {
//            // Get the text that will be added to the PDF
//            String text = request.getParameter("text");
//            if (text == null || text.trim().length() == 0) {
//                 text = "You didn't enter any text.";
//            }
//            Document document = new Document();
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            PdfWriter.getInstance(document, baos);
//            document.open();
//            document.add(new Paragraph(String.format(
//                "You have submitted the following text using the %s method:",
//                request.getMethod())));
//            document.add(new Paragraph(text));
//            document.close();
// 
//            // setting some response headers
//            response.setHeader("Expires", "0");
//            response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
//            response.setHeader("Pragma", "public");
//            response.setContentType("application/pdf");
//            response.setContentLength(baos.size());
//            OutputStream os = response.getOutputStream();
//            baos.writeTo(os);
//            os.flush();
//            os.close();
//        }
//        catch(DocumentException e) {
//            throw new IOException(e.getMessage());
//        }
        response.setContentType("application/pdf");
        Document document = new Document();
        try {
            PdfWriter.getInstance(document,response.getOutputStream());
            document.open();

            PdfPTable table = new PdfPTable(2);
            table.addCell("1");
            table.addCell("2");
            table.addCell("3");
            table.addCell("4");
            table.addCell("5");
            table.addCell("6");

            document.add(table);
            document.addTitle("My PDF Title");
            document.add(new Paragraph("Some content here...."));
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
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
