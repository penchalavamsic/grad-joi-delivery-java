package com.tw.joi.delivery.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManualStoreTest {

    public static void main(String[] args) {
        shouldReturnItemsLeftAfterOrder();
    }

    public static void shouldReturnItemsLeftAfterOrder() {
        // Given
        List<String> initialStock = new ArrayList<>(Arrays.asList("Milk", "Eggs", "Bread", "Milk"));
        Store store = new Store("1", "ZoneA", initialStock);
        
        Order order = new Order();
        order.setItems(Arrays.asList("Milk", "Bread")); 
        
        // When
        store.processOrder(order);
        
        // Then
        List<String> left = store.getItems();
        
        boolean passed = true;
        if (left.size() != 2) {
            System.out.println("FAILED: Expected size 2, got " + left.size());
            passed = false;
        }
        if (!left.contains("Eggs")) {
            System.out.println("FAILED: Missing Eggs");
            passed = false;
        }
        if (!left.contains("Milk")) {
            System.out.println("FAILED: Missing Milk");
            passed = false;
        }
        
        if (passed) {
            System.out.println("shouldReturnItemsLeftAfterOrder PASSED");
            System.out.println("Items left: " + left);
        }
    }
}
