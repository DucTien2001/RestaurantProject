package com.business;

import java.text.NumberFormat;

public class LineItem {

    private Menu menu;
    private int soluong;

    public LineItem() {
    }

    public void setMenu(Menu m) {
        menu = m;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setQuantity(int soluong) {
        this.soluong = soluong;
    }

    public int getQuantity() {
        return soluong;
    }

    public double getTotal() {
        double total = Double.valueOf(menu.getPrice()) * soluong;
        return total;
    }

    public String getTotalCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }

}
