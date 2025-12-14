/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsystemcw;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author krasipetranov
 */
public class ProductActivityManagement {
    private Map<Integer, Product> products;
    private int nextProductId;
    private int nextActivityId;
    
    public Activity[] bubbleSortActivities(Activity[] activities) {
        int n = activities.length;
        Activity[] sorted = Arrays.copyOf(activities, n);
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sorted[j].getActivityQuantity() > sorted[j + 1].getActivityQuantity()) {
                    Activity temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        return sorted;
    }
    
    public Product linearSearchProduct(int productId) {
        for (Product product : products.values()) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }
    
    public ProductActivityManagement() {
        this.products = new HashMap<>();
        this.nextProductId = 1;
        this.nextActivityId = 1;
    }
    
    public void createProduct(String productName, int initialQuantity) {
        Product product = new Product(nextProductId++, productName, LocalDate.now(), initialQuantity);
        products.put(product.getProductId(), product);
        
        Activity initialActivity = new Activity(nextActivityId++, "AddToStock", 
                                                initialQuantity, LocalDate.now());
        product.addActivity(initialActivity);
        
        System.out.println("Product created successfully: " + product);
    }
    
    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in the system.");
            return;
        }
        
        System.out.println("\n=== ALL PRODUCTS ===");
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }
    
    public void deleteProduct(int productId) {
        Product product = linearSearchProduct(productId);
        
        if (product != null) {
            products.remove(productId);
            System.out.println("Product deleted successfully: ID " + productId);
        } else {
            System.out.println("Product not found with ID: " + productId);
        }
    }
    
    public void updateProductActivity(int productId, String activityType, int quantity) {
        Product product = linearSearchProduct(productId);
        
        if (product == null) {
            System.out.println("Product not found!");
            return;
        }
        
        if (quantity <= 0) {
            System.out.println("Quantity must be positive!");
            return;
        }
        
        if (activityType.equals("RemoveFromStock") && quantity > product.getQuantity()) {
            System.out.println("Cannot remove more than available quantity!");
            return;
        }
        
        Activity activity = new Activity(nextActivityId++, activityType, 
                                         quantity, LocalDate.now());
        product.addActivity(activity);
        product.updateQuantity(quantity, activityType);
        
        System.out.println("Activity added: " + activity);
        System.out.println("Updated product quantity: " + product.getQuantity());
    }
    
    public void displaySortedActivities(int productId) {
        Product product = linearSearchProduct(productId);
        
        if (product == null) {
            System.out.println("Product not found!");
            return;
        }
        
        CustomLinkedList<Activity> activities = product.getActivities();
        
        if (activities.isEmpty()) {
            System.out.println("No activities for this product.");
            return;
        }
        
        Object[] activityArray = activities.toArray();
        Activity[] activityArr = new Activity[activityArray.length];
        for (int i = 0; i < activityArray.length; i++) {
            activityArr[i] = (Activity) activityArray[i];
        }
        
        Activity[] sortedActivities = bubbleSortActivities(activityArr);
        
        System.out.println("\n=== Last " + activityArray.length + " ACTIVITIES FOR PRODUCT ID " + productId + " (SORTED BY QUANTITY) ===");
        for (int i = 0; i < Math.min(4, sortedActivities.length); i++) {
            System.out.println((i + 1) + ". " + sortedActivities[i]);
        }
    }
}
