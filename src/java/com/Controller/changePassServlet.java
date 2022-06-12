package com.Controller;

import com.business.Account;
import com.data.AccountDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "changePassServlet", urlPatterns = {"/changepass"})
public class changePassServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        
        String url = "/changepass.jsp";
        
        String action = request.getParameter("action");
        if(action == null){
            action = "display_user";
        }
        if(action.equals("display_user")){
            //String user = session.getAttribute(acc.username);
            
            //Account account = AccountDB.selectAccountByUser(user);
            session.setAttribute("account", a);
            
            url = "/changepass.jsp";
        }
        else if (action.equals("update_user")) {
            int accId = Integer.parseInt(request.getParameter("accId"));
            String user = request.getParameter("user");
            String password = request.getParameter("password");
            String newpassword = request.getParameter("newpassword");
            String confirmpassword = request.getParameter("confirmpassword");
            int isSell = Integer.parseInt(request.getParameter("isSell"));
            int isAdmin = Integer.parseInt(request.getParameter("isAdmin"));

            Account account = AccountDB.selectAccountUserPass(user, password);
            //Boolean check = AccountDB.accountUserExists(fullname);
            if(account == null){
                request.setAttribute("mess", "Incorrect password!");
                url = "/changepass.jsp";
            } else if(!newpassword.equals(confirmpassword)){
                request.setAttribute("mess", "New password and confirm new password do not match!");
                    url = "/changepass.jsp";
            } else {
                Account acc = new Account();
                    acc.setId(accId);
                    acc.setUser(user);
                    acc.setPass(newpassword);
                    acc.setIsSell(isSell);
                    acc.setIsAdmin(isAdmin);
                    AccountDB.update(acc);

                    request.setAttribute("mess", "Change password successfully");
                    url = "/changepass.jsp";
            }
        }
        request.getRequestDispatcher(url).forward(request, response);
        
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
