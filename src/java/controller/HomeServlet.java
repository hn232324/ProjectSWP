/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAO;
import dal.DAOAccount;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import model.Account;
import model.Debit;

/**
 *
 * @author Manh
 */
public class HomeServlet extends HttpServlet {
   
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomeController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeController at " + request.getContextPath() + "</h1>");
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
        
        String aid_raw = request.getParameter("aid");
        DAOAccount p = new DAOAccount();
        
        int aid;
        try {
            aid = Integer.parseInt(aid_raw);
            int count = p.getTotalDebit(aid);
            int endPage = count / 5;
            if (count % 5 != 0) {
                endPage++;
            }
            String indexPage = request.getParameter("index");
            if (indexPage == null) {
                indexPage = "1";
            }
            int index = Integer.parseInt(indexPage);
            List<Debit> listPA = p.pagingDebit(index, aid);
            request.setAttribute("tag", index);
            request.setAttribute("endP", endPage);
            request.setAttribute("listPA", listPA);
        } catch (NumberFormatException e) {

        }

        request.getRequestDispatcher("debit.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        String indexPage = request.getParameter("index");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone_raw = request.getParameter("phone");
        int phone = 0;
        try {
            phone = Integer.parseInt(phone_raw);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        String total_raw = request.getParameter("total");
        long total = 0;
        try {
            total = Long.parseLong("total_raw");
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        Calendar c = Calendar.getInstance();

        Account a = (Account) request.getSession().getAttribute("acc");
            
        SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String createDate = f.format(c.getTime());
        String updateDate = f.format(c.getTime());
        Debit d = new Debit(0, name, address, phone, email, total, createDate, updateDate, a.getId());
       
        DAO dao = new DAO();
        dao.add(d);

        response.sendRedirect("home?aid=" + a.getId()+"&index="+indexPage);
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