/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.book.BookDAO;
import sample.book.BookDTO;
import sample.user.UserDAO;
//import sample.account.AccountDAO;

/**
 *
 * @author HP
 */
public class LoginServlet extends HttpServlet {

    private final String INVALID_PAGE = "invalid.html";
    private final String USER_PAGE = "user.jsp";
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
        PrintWriter out = response.getWriter();
        String url = INVALID_PAGE;
        HttpSession session = request.getSession();
        try {
            String phone = request.getParameter("txtPhone");
            String password = request.getParameter("txtPassword");
            UserDAO dao = new UserDAO();
            int result = dao.checkLogin(phone, password);
            if (result == 0) {
                url = USER_PAGE;
                String name=dao.getUserName(phone);
                session.setAttribute("USERNAME", name);
                BookDAO bookDAO=new BookDAO();
                bookDAO.showAll();
                List<BookDTO> list=bookDAO.getListBooks();
                for(int i=0;i<list.size();i++){
                    System.out.println(list.get(i).getName());
                }
                session.setAttribute("ALLBOOKS", list);
            } else if (result == 1) {
                url = ADMIN_PAGE;
                String name=dao.getUserName(phone);
                session.setAttribute("USERNAME", name);
            }
        } catch (NamingException ex) {
            log("LoginServlet_ClassNotFound " + ex.getMessage());
        } catch (SQLException ex) {
            log(this.getClass().getName() + " SQL " + ex.getMessage());
        } finally {
            response.sendRedirect(url);
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
