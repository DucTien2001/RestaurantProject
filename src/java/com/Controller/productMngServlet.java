package com.Controller;

import com.business.Menu;
import com.data.MenuDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "productMngServlet", urlPatterns = {"/promng"})
public class productMngServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        
        String url = "/productmanager.jsp";
        
        String action = request.getParameter("action");
        if(action == null){
            action = "display_menus";
        }
        
        if(action.equals("display_menus")){
            List<Menu> list = MenuDB.selectMenus();
            request.setAttribute("menus", list);
            request.setAttribute(url, url);
        }
        
        else if(action.equals("display_menu")){
            int menu_ID = Integer.parseInt(request.getParameter("menuId"));
            
            Menu menu = MenuDB.selectMenu(menu_ID);
            session.setAttribute("menu", menu);
            
            url = "/updateproduct.jsp";
        }
        else if (action.equals("update_menu")) {
            int menuId = Integer.parseInt(request.getParameter("menuId"));
            String menuName = request.getParameter("menuName");
            String typeOfFood = request.getParameter("typeOfFood");
            String quantity = request.getParameter("quantity");
            String price = request.getParameter("price");
            String picture = request.getParameter("picture");
            String detail = request.getParameter("detail");

            Menu menu = (Menu) session.getAttribute("menu");        
            menu.setMenuId(menuId);
            menu.setMenuName(menuName);
            menu.setTypeOfFood(typeOfFood);
            menu.setQuantity(quantity);
            menu.setPrice(price);
            menu.setPicture(picture);
            menu.setDetail(detail);
            MenuDB.update(menu);

            List<Menu> menus = MenuDB.selectMenus();            
            request.setAttribute("menus", menus);   
            //url = "/productmanager.jsp";
        }
        else if (action.equals("delete_menu")) {
            int menuId = Integer.parseInt(request.getParameter("menuId"));
            Menu menu = MenuDB.selectMenu(menuId);
            MenuDB.delete(menu);
            
            List<Menu> menus = MenuDB.selectMenus();            
            request.setAttribute("Menus", menus);  
            
            url = "productmanager.jsp";
        }
        else if (action.equals("insert_menu")) {
            int menuId = Integer.parseInt(request.getParameter("menuId"));
            String menuName = request.getParameter("menuName");
            String typeOfFood = request.getParameter("typeOfFood");
            String quantity = request.getParameter("quantity");
            String price = request.getParameter("price");
            String picture = request.getParameter("picture");
            String detail = request.getParameter("detail");

            Menu menu = new Menu();        
            menu.setMenuId(menuId);
            menu.setMenuName(menuName);
            menu.setTypeOfFood(typeOfFood);
            menu.setQuantity(quantity);
            menu.setPrice(price);
            menu.setPicture(picture);
            menu.setDetail(detail);
            MenuDB.insert(menu);

            List<Menu> menus = MenuDB.selectMenus();            
            request.setAttribute("menus", menus);   
            //url = "/productmanager.jsp";
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

    
    
    public static void main(String[] args) {
        Menu m = MenuDB.selectMenu(1);
        System.out.println(m);
    }
}
