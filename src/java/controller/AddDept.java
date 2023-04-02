/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAOAccount;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.NumberFormat;
import java.util.Locale;
import model.Debit;

/**
 *
 * @author Manh
 */
@WebServlet(name="AddDept", urlPatterns={"/adddept"})
public class AddDept extends HttpServlet {
   
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddDept</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddDept at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
         String option = request.getParameter("abtract2");
    String note = request.getParameter("note");
    String indexPage = request.getParameter("index");
    String moneyStr = request.getParameter("money");
    int id = Integer.parseInt(request.getParameter("idConNo"));
    String id_raw = request.getParameter("id2");

    DAOAccount da = new DAOAccount();
    Debit updateDebit = da.getIdByDept(id);

    long money = Long.parseLong(moneyStr.replaceAll(",", "")); // chuyển đổi số tiền có dấu phẩy sang số nguyên

    if (option.equals("true")) {
        updateDebit.setTotal(updateDebit.getTotal() - money); // trừ khoản nợ
    } else {
        updateDebit.setTotal(updateDebit.getTotal() + money); // cộng khoản nợ
    }

    updateDebit.setNote(note);
    

    da.updateDept(updateDebit, id);
       
        response.sendRedirect("home?aid=" + id_raw+"&index="+indexPage);

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