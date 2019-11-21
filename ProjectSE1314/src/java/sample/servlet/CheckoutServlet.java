/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.book.BookDAO;
import sample.cart.CartDAO;
import sample.cart.CartObj;

/**
 *
 * @author HP
 */
public class CheckoutServlet extends HttpServlet {

    private final String CART_PAGE = "cart.jsp";

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
        boolean result = false;
        int ranNum = 0;
        String products = "";
        try {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            CartObj cart = (CartObj) session.getAttribute("CART");
            String phone = (String) session.getAttribute("PHONE");
            String orderID = "OID";
            CartDAO dao = new CartDAO();
            try {
                do {
                    ranNum = (int) (Math.random() * 9000) + 1000;
                    orderID += ranNum;
                } while (dao.checkOrderIDExisted(orderID));
            } catch (Exception ex) {
                log(ex.getMessage());
            }
            if (cart != null) {
                Map<String, Integer> items = cart.getItems();
                if (items != null) {
                    for (Map.Entry item : items.entrySet()) {
                        String name = (String) item.getKey();
                        BookDAO bookDAO=new BookDAO();
                        int quantity = (int) item.getValue();
                        products += quantity + " " + name + ", ";
                    }
                    
                    LocalDate date=LocalDate.now();
                    result=dao.checkOut(orderID, phone, LocalDate.MAX, products, );
                }
                if (result) {
                    session.removeAttribute("CART");
                }
            }
        } finally {

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
