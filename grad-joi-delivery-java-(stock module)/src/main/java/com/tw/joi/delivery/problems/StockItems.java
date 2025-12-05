package com.tw.joi.delivery.problems;
public class StockItems {
    public static void main(String[] args) {
        // 1. Setup Master Item List
        java.util.Map<String, com.tw.joi.delivery.model.Item> itemRegistry = new java.util.HashMap<>();
        itemRegistry.put("Apple", new com.tw.joi.delivery.model.Item("1", "Apple", "Fresh Red Apple", 10.0f));
        itemRegistry.put("Banana", new com.tw.joi.delivery.model.Item("2", "Banana", "Yellow Banana", 5.0f));
        itemRegistry.put("Orange", new com.tw.joi.delivery.model.Item("3", "Orange", "Juicy Orange", 8.0f));
        itemRegistry.put("Milk", new com.tw.joi.delivery.model.Item("4", "Milk", "1L Carton", 25.0f));

        // 2. Setup Store with Stock
        java.util.List<String> storeInventory = new java.util.ArrayList<>();
        // Add 2 Apples (Low Stock)
        storeInventory.add("Apple");
        storeInventory.add("Apple");
        // Add 6 Bananas (Sufficient Stock)
        for (int i = 0; i < 6; i++) storeInventory.add("Banana");
        // Add 4 Oranges (Low Stock)
        for (int i = 0; i < 4; i++) storeInventory.add("Orange");
        // Add 0 Milk (Out of Stock)

        com.tw.joi.delivery.model.Store store = new com.tw.joi.delivery.model.Store("Store-001", "ZoneA", storeInventory);

        // 3. Calculate Stock Counts
        java.util.Map<String, Integer> stockCounts = new java.util.HashMap<>();
        for (String itemName : store.getItems()) {
            stockCounts.put(itemName, stockCounts.getOrDefault(itemName, 0) + 1);
        }
        
        // Also check for items that are in registry but not in store (stock 0)
        for (String itemName : itemRegistry.keySet()) {
            stockCounts.putIfAbsent(itemName, 0);
        }

        // 4. Find and Display Items with Stock < 5
        System.out.println("Items with stock less than 5 in " + store.getStoreId() + ":");
        System.out.println("--------------------------------------------------");
        
        for (java.util.Map.Entry<String, Integer> entry : stockCounts.entrySet()) {
            String itemName = entry.getKey();
            int count = entry.getValue();

            if (count < 5) {
                com.tw.joi.delivery.model.Item item = itemRegistry.get(itemName);
                if (item != null) {
                    System.out.println("Store: " + store.getStoreId());
                    System.out.println("Item: " + item.getName());
                    System.out.println("Description: " + item.getDescription());
                    System.out.println("Price: " + item.getPrice());
                    System.out.println("Current Stock: " + count);
                    System.out.println("--------------------------------------------------");
                }
            }
        }
    }
}
