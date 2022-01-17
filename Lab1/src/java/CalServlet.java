/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 
 */
@WebServlet(urlPatterns = {"/calservlet"})
public class CalServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet CalServlet</title>");
        out.println("</head>");
        out.println("<body>");
        String op = "";
        double f = 0;
        double s = 0;
        double result = 0;
        try {
            String fr = request.getParameter("first");
            f = Double.parseDouble(fr);
            String sc = request.getParameter("second");
            s = Double.parseDouble(sc);
            op = request.getParameter("op");
        } catch (Exception e) {
        }
        switch (op) {
            case "+":
                result = f + s;
                break;
            case "-":
                result = f - s;
                break;
            case "*":
                result = f * s;
                break;
            case "/":
                result = f / s;
                break;
        }
        out.println("<form action='calservlet' method='get'>\n"
                + "	<table>\n"
                + "		<tr>\n"
                + "		   <td>First:</td><td><input type='text' name='first' value=" + f + "></td>\n"
                + "		</tr>\n"
                + "		<tr>\n"
                + "		   <td>Second:</td><td><input type='text' name='second' value=" + s + "></td>\n"
                + "		</tr>\n"
                + "                <tr>\n"
                + "                    <td>Operator</td>\n"
                + "                    <td>\n"
                + "                        <select name='op'>\n"
                + "                            <option value='+'>+</option>\n"
                + "                            <option value='-'>-</option>\n"
                + "                            <option value='*'>*</option>\n"
                + "                            <option value='/'>/</option>\n"
                + "                        </select>\n"
                + "                    </td>\n"
                + "                </tr>\n"
                + "                <tr>\n"
                + "                    <td></td>\n"
                + "                    <td><input type='submit' value='Compute'></td>\n"
                + "                </tr\n"
                + "                <tr>\n"
                + "		   <td>Result</td><td><input type='text' value=" + result + "></td>\n"
                + "		</tr>\n"
                + "                \n"
                + "	</table>\n"
                + "	</form>");

        out.println("</body>");
        out.println("</html>");
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
//        processRequest(request, response);
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
