package com.bookTable;

import com.Cart.cartServlet;
import com.Mail.javaMailUtil;
import com.business.Booktable;
import com.data.BookDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "tableServlet", urlPatterns = {"/bookTable"})
public class tableServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/book.html";

        // get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // default action
        }

        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/book.jsp";    // the "join" page
        } else if (action.equals("add")) {
            // get parameters from the request
            String cusName = request.getParameter("cusName");
            String cusPhone = request.getParameter("cusPhone");
            String cusEmail = request.getParameter("cusEmail");
            String idTable = request.getParameter("idTable");
            String people = request.getParameter("people");
            String time = request.getParameter("time");

            // store data in User object
            Booktable book = new Booktable();
            book.setCusName(cusName);
            book.setCusPhone(cusPhone);
            book.setCusEmail(cusEmail);
            book.setIdTable(idTable);
            book.setPeople(people);
            book.setTime(time);

            // validate the parameters
            String message;
            if (BookDB.tableExists(book.getIdTable())) {
                message = "This table has been booked.<br>"
                        + "Please choose another table. Thank you";
                url = "/book.jsp";
            } else {
                System.out.println(cusEmail);
                try {
                    javaMailUtil.sendMail(cusEmail);
                } catch (Exception ex) {
                    Logger.getLogger(cartServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                message = "";
                url = "/thanks.jsp";
                BookDB.insert(book);
            }
            request.setAttribute("book", book);
            request.setAttribute("message", message);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}