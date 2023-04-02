/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAOAccount;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import model.Debit;

/**
 *
 * @author Manh
 */
public class detailDebitServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String email = request.getParameter("email");
            DAOAccount dao = new DAOAccount();
            List<Debit> list = dao.getCreditByEmail(email);
            
            for (Debit i : list) {
                out.println("<tr>");
                out.println("<td style=\"flex: 100 0 auto; width: 170px;\" scope=\"row\">" + i.getId() + "</td>");
                out.println("<td style=\"flex: 100 0 auto; width: 170px;\"></td>");
                out.println("<td style=\"flex: 100 0 auto; width: 170px;\"></td>");
                out.println("<td style=\"flex: 100 0 auto; width: 170px;\">" + i.getTotal() + "</td>");
                out.println("<td style=\"flex: 100 0 auto; width: 170px;\">" + i.getCrday() + "</td>");
                out.println("<td style=\"flex: 100 0 auto; width: 170px;\">" + i.getUday() + "</td>");
                out.println("                <td style=\"flex: 100 0 auto; width: 170px;\" id=\"myTd\">\n"
                        + "                                                                    <div style=\"right: 0px; flex: 332 0 auto; width: 270px; max-width: 270px;\" class=\"myDiv\">\n"
                        + "                                                                        <button class=\"btn btn-primary\" type=\"button\"  title=\"Chi tiết\" data-bs-toggle=\"modal\" data-bs-target=\"\"><i class=\"bi bi-info-circle-fill\">Chi tiết</i></button>\n"
                        + "                                                                        <button class=\"btn btn-success\" type=\"button\" title=\"Cộng\" data-bs-toggle=\"modal\" data-bs-target=\"\"><i class=\"bi bi-plus-circle-fill\"></i> </i></button>\n"
                        + "                                                                        <button class=\"btn btn-warning\" type=\"button\" title=\"Trừ\" data-bs-toggle=\"modal\" data-bs-target=\"\" ><i class=\"bi bi-dash-circle-fill\"></i></i></button>\n"
                        + "                                                                    </div>\n"
                        + "                                                                    <div style=\"display:none; right: 0px; flex: 135 0 auto; width: 135px; max-width: 135px;\" class=\"otherDiv\" >\n"
                        + "                                                                        <button class=\"btn btn-primary\" type=\"button\"  title=\"Chi tiết\" data-bs-toggle=\"modal\" data-bs-target=\"\"><i class=\"bi bi-info-circle-fill\"></i></button>\n"
                        + "                                                                        <button class=\"btn btn-success\" type=\"button\" title=\"Thêm phiếu nợ\" data-bs-toggle=\"modal\" data-bs-target=\"\"><i class=\"bi bi-plus-circle\"></i></button>\n"
                        + "                                                                        <button class=\"btn btn-warning\" type=\"button\" title=\"Sửa\" data-bs-toggle=\"modal\" data-bs-target=\"\" ><i class=\"bi bi-dash-circle-fill\"></i></button>\n"
                        + "                                                                    </div>\n"
                        + "                                                                </td>");
                out.println("</tr>");

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
