package com.Controller;

import com.business.Account;
import com.data.AccountDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "signupServlet", urlPatterns = {"/signup"})
public class signupServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String fullname = request.getParameter("fullname");
            String password = request.getParameter("password");
            String confirmpassword = request.getParameter("confirmpassword");
            
            Boolean check = AccountDB.accountUserExists(fullname);
            if(check == true){
                request.setAttribute("mess", "Account already exists!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else if(!password.equals(confirmpassword)){
                request.setAttribute("mess", "Password and confirm password do not match!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                Account acc = new Account();
                    acc.setUser(fullname);
                    acc.setPass(password);
                    acc.setIsSell(0);
                    acc.setIsAdmin(0);
                    AccountDB.insert(acc);
                    
                    request.setAttribute("mess", "Sign Up Success");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
            }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
