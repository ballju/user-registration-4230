
package com.cs4230final.userregistration;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.*;

public class ChangeInfo extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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
        try {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ChangeInfo</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ChangeInfo at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object u = session.getAttribute("user");
        
        if (u != null) {
            User user = (User)u;
            
            String oldEmail = user.getEmail();
            
            String email = request.getParameter("email");
            String pass1 = request.getParameter("pass1");
            String pass2 = request.getParameter("pass2");
            String first = request.getParameter("first");
            String last = request.getParameter("last");
            
            if (!email.equals(""))
                user.setEmail(email);
            if (!pass1.equals(""))
                user.setPassWord(pass1);
            if (!first.equals(""))
                user.setFirstName(first);
            if (!last.equals(""))
                user.setLastName(last);
            
            user = UserService.updateUserInfo(oldEmail, user);
            
            if(user.getPassWord() != null && !user.getPassWord().equals("")) {
                user = UserService.updateUserPassword(user);
            }
            
            user.setPassWord(null);
            session.setAttribute("user", user);
            
            response.sendRedirect("welcome.jsp");
        }
        else {
            String message = URLEncoder.encode("You must be logged in to do that", "UTF-8"); 
            
            response.sendRedirect("login.jsp?message=" + message);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Changes user info.";
    }// </editor-fold>
}
