package com.business;

import com.data.InvoiceDB;
import java.util.ArrayList;

public class Cart {

    private ArrayList<LineItem> items;

    public Cart() {
        items = new ArrayList<LineItem>();
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }

    public void addItem(LineItem item) {
//        String.valueOf()
        Integer code = item.getMenu().getMenuId();
        int quantity = item.getQuantity();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getMenu().getMenuId().equals(code)) {
                lineItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(LineItem item) {
//        String code = String.valueOf(item.getMenu().getMenuId());
        Integer code = item.getMenu().getMenuId();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getMenu().getMenuId().equals(code)) {
                items.remove(i);
                return;
            }
        }
    }
}
