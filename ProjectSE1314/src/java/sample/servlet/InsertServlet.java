/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.book.BookDAO;

/**
 *
 * @author HP
 */
@WebServlet(name = "InsertServlet", urlPatterns = {"/InsertServlet"})
public class InsertServlet extends HttpServlet {

    private final String ADMIN_PAGE = "admin.jsp";

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
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String bookID = request.getParameter("txtBookID");
        String name = request.getParameter("txtName");
        String type = request.getParameter("txtType");
        String image = request.getParameter("txtImage");
        String price = request.getParameter("txtPrice");
        String url = ADMIN_PAGE;
        System.out.println("haha");
        boolean foundErr = false;
        try {
            /* TODO output your page here. You may use following sample code. */
            try {
                int bookPrice = Integer.parseInt(price);
                BookDAO dao = new BookDAO();
                boolean result = dao.insertBook(bookID, name, type, image, bookPrice);
                if(result){
                    request.setAttribute("INSERTSUCCESS", "Create Success");
                    System.out.println("hihi");
                }
            } catch (NumberFormatException ex) {
                log(ex.getMessage());
            } catch (NamingException ex) {
                log("InsertServlet_ClassNotFound " + ex.getMessage());
            } catch (SQLException ex) {
                log(this.getClass().getName() + " SQL " + ex.getMessage());
            }
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
