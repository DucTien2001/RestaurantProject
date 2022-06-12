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

@WebServlet(name = "accountMngServlet", urlPatterns = {"/accmng"})
public class accountMngServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        String url = "/accountmanager.jsp";
        
        String action = request.getParameter("action");
        if(action == null){
            action = "display_accounts";
        }
        
        if(action.equals("display_accounts")){
            List<Account> list = AccountDB.selectAccounts();
            request.setAttribute("accounts", list);
            request.setAttribute(url, url);
        }
        
        else if(action.equals("display_account")){
            int account_ID = Integer.parseInt(request.getParameter("id"));
            
            Account account = AccountDB.selectAccount(account_ID);
            session.setAttribute("account", account);
            
            url = "/updateaccount.jsp";
        }
        else if (action.equals("update_account")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            int isSell = Integer.parseInt(request.getParameter("isSell"));
            int isAdmin = Integer.parseInt(request.getParameter("isAdmin"));

            Account account = (Account) session.getAttribute("account");        
            account.setId(id);
            account.setUser(user);
            account.setPass(pass);
            account.setIsSell(isSell);
            account.setIsAdmin(isAdmin);
            AccountDB.update(account);

            List<Account> accounts = AccountDB.selectAccounts();            
            request.setAttribute("accounts", accounts);   
            //url = "/productmanager.jsp";
        }
        else if (action.equals("delete_account")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Account account = AccountDB.selectAccount(id);
            AccountDB.delete(account);
            
            List<Account> accounts = AccountDB.selectAccounts();            
            request.setAttribute("accounts", accounts);  
            
            url = "accountmanager.jsp";
        }
        else if (action.equals("insert_account")) {
            int id = Integer.parseInt(request.getParameter("id"));
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            int isSell = Integer.parseInt(request.getParameter("isSell"));
            int isAdmin = Integer.parseInt(request.getParameter("isAdmin"));

            Account account = new Account();        
            account.setId(id);
            account.setUser(user);
            account.setPass(pass);
            account.setIsSell(isSell);
            account.setIsAdmin(isAdmin);
            AccountDB.insert(account);

            List<Account> accounts = AccountDB.selectAccounts();            
            request.setAttribute("accounts", accounts);   
            //url = "/productmanager.jsp";
        }
        request.getRequestDispatcher(url).forward(request, response);
    }
    
    public static void main(String[] args) {
        Account a = AccountDB.selectAccount(1);
        System.out.println(a);
        
        List <Account> as = AccountDB.selectAccounts();
        System.out.println(as);
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
