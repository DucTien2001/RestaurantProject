package com.Cart;

import com.business.Cart;
import com.business.Invoice;
import com.business.LineItem;
import com.business.Menu;
import com.data.InvoiceDB;
import com.data.MenuDB;
import java.io.IOException;
import java.sql.Time;
import java.time.Instant;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.Mail.javaMailUtil;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "cartServlet", urlPatterns = {"/cart"})
public class cartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext sc = getServletContext();
        String url = "/menu";
        int quantity = 0;
        // get current action
        String action = request.getParameter("action");
        if (action.equals("checkUser")) {
            String user = request.getParameter("user");
            if (user == null || user.equals("")) {
                url = "/login.jsp";
            } else {
                action = "cart";
                if (action.equals("cart")) {
                    String productCode = request.getParameter("productCode");
                    String quantityString = request.getParameter("quantity");

                    HttpSession session = request.getSession(false);
                    Cart cart = (Cart) session.getAttribute("cart");
                    if (cart == null) {
                        cart = new Cart();
                    }
                    try {
                        quantity = Integer.parseInt(quantityString);
                        if (quantity < 0) {
//                            quantity = 0;
                            quantity = 1;
                        }
                    } catch (NumberFormatException nfe) {
//                        quantity = 0;
                        quantity = 1;
                    }
                    Invoice invoice = new Invoice();

                    invoice.setTime(Time.from(Instant.now()).toString());
                    Menu menu = null;
                    menu = MenuDB.selectMenuId(Integer.valueOf(productCode));
                    // TODO Auto-generated catch block            
                    LineItem lineItem = new LineItem();
                    lineItem.setMenu(menu);
                    lineItem.setQuantity(quantity);
                    lineItem.getMenu().getMenuName();
                    //String total = request.getParameter("total");
                    invoice.setProductName(productCode);
                    invoice.setProductQuantity(String.valueOf(quantity));
                    if (quantity > 0) {
                        cart.addItem(lineItem);
                        //invoice.setProductQuantity(String.valueOf(quantity));
                        //InvoiceDB.update(invoice);
                    } else if (quantity == 0) {
                        cart.removeItem(lineItem);
                        //invoice = InvoiceDB.selectInvoice(productCode);
                        //InvoiceDB.delete(invoice);
                    }
                    //if (quantity > 0) {
                    InvoiceDB.insert(invoice);
                    //}

                    //InvoiceDB.update(invoice);
                    session.setAttribute("invoice", invoice);
                    session.setAttribute("cart", cart);
                    url = "/cart.jsp";
                }
            }
        } else if (action.equals("checkout")) {
            HttpSession session = request.getSession();
            String email = request.getParameter("email");
            System.out.println(email);
            try {
                javaMailUtil.sendMail(email);
            } catch (Exception ex) {
                Logger.getLogger(cartServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            session.removeAttribute("cart");
            url = "/checkout.jsp";
        }
        sc.getRequestDispatcher(url)
                .forward(request, response);
    }
}
