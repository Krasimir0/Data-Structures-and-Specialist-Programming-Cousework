/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsystemcw;

import java.time.LocalDate;

/**
 *
 * @author krasipetranov and Matthew cooke
 */
public class Product {
   private int productId;
    private String productName;
    private LocalDate entryDate;
    private int quantity;
    private CustomLinkedList<Activity> activities; 
    
    public Product(int productId, String productName, LocalDate entryDate, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.entryDate = entryDate;
        this.quantity = quantity;
        this.activities = new CustomLinkedList<>(4); 
    }
    
  //these all get used to get information about the product that the use is creating
    public int getProductId() {
        return productId; 
    }
    
    public String getProductName() {
        return productName; 
    }
    
    public LocalDate getEntryDate() {
        return entryDate; 
    }

    public int getQuantity() { 
        return quantity; 
    }
    
    public CustomLinkedList<Activity> getActivities() { 
        return activities; 
    }
    
    
    public void addActivity(Activity activity) {
        activities.addFirst(activity); 
    }
    
    //this is done so that the user can chage the quantity of a product without delating the product
    public void updateQuantity(int change, String activityType) {
        if (activityType.equals("AddToStock")) {
            quantity += change;
        } else if (activityType.equals("RemoveFromStock")) {
            quantity -= change;
            if (quantity < 0) quantity = 0;
        }
    }
    
    @Override
    public String toString() {
        return "ID: " + productId + 
               ", Name: " + productName + 
               ", Entry Date: " + entryDate + 
               ", Quantity: " + quantity;
    }
}
