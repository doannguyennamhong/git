/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.student.UpdateError;

/**
 *
 * @author HP
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {

    private final String SEARCH_PAGE = "staff.jsp";

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
        String id = request.getParameter("txtId");
        String studentClass = request.getParameter("txtClass");
        String address1 = request.getParameter("txtAddress1");
        String address2 = request.getParameter("txtAddress2");
        String statusDescription = request.getParameter("seStatus");
        String phone = request.getParameter("txtPhone");
        String searchURL=request.getParameter("searchURL");
        String searchValue = URLEncoder.encode(request.getParameter("lastSearchValue"), StandardCharsets.UTF_8.toString());
        String url=SEARCH_PAGE;
        String urlRewriting = searchURL+"Servlet"
                + "?btAction=Search"
                + "&txtSearchValue="
                + searchValue;
        int status = 0;
        float phoneNumber = 0;
        boolean foundErr = false;
        UpdateError errors = new UpdateError();
//        try {
//            /* TODO output your page here. You may use following sample code. */
//            StudentDAO dao = new StudentDAO();
//            if (statusDescription.equals("studying")) {
//                status = 0;
//            } else if (statusDescription.equals("break")) {
//                status = 1;
//            } else if (statusDescription.equals("dropout")) {
//                status = 2;
//            }
//            try {
//                phoneNumber = Float.parseFloat(phone);
//                if (phoneNumber < 0) {
//                    errors.setPhoneFormatErr("Phone wrong format");
//                    foundErr = true;
//                } else if (phone.trim().length() < 10 || phone.trim().length() > 11) {
//                    errors.setPhoneLengthErr("Phone required input from 10 to 11 number");
//                    foundErr = true;
//                }
//            } catch (NumberFormatException ex) {
//                errors.setPhoneFormatErr("Phone wrong format");
//                foundErr = true;
//            }
//            if (studentClass.trim().length() < 1 || studentClass.trim().length() > 6) {
//                foundErr = true;
//                errors.setClassLengthErr("Class required input from 1 to 6 characters");
//            }
//            if (address1.trim().length() < 1 || address1.trim().length() > 250) {
//                foundErr = true;
//                errors.setAddress1LengthErr("Address1 required input and max 250 characters");
//            }
//            if (foundErr) {
//                request.setAttribute("UPDATEERR", errors);
//                url=urlRewriting;
//            } else {
//                boolean result = dao.updateStudent(id, studentClass, address1, address2, status, phone);
//                if (result) {
//                    url = urlRewriting;
//                }
//            }
//        } catch (NamingException ex) {
//            log("UpdateServlet_ClassNotFound " + ex.getMessage());
//        } catch (SQLException ex){ 
//            log(this.getClass().getName() + " SQL " + ex.getMessage());
//        } finally {
//            RequestDispatcher rd=request.getRequestDispatcher(url);
//            rd.forward(request, response);
//            out.close();
//        }
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
