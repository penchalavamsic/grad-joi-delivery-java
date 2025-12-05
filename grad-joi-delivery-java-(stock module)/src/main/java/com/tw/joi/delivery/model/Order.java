package com.tw.joi.delivery.model;

import java.util.List;

public class Order {
    private List<String> items;

    public Order() {
    }

    public Order(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
