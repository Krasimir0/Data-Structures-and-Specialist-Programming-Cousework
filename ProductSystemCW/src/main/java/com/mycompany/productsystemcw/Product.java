/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsystemcw;

import java.util.Date;

/**
 *
 * @author krasipetranov
 */
public class Product {
    private int productID;
    private String productName;
    private Date productEntryDate;
    private int productQuantity;

    
    private final ActivityLinkedList activities;

   
    public Product(int productID, String productName, Date productEntryDate, int productQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.productEntryDate = productEntryDate;
        this.productQuantity = productQuantity;
        this.activities = new ActivityLinkedList();
    }

    // Getters and Setters
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getProductEntryDate() {
        return productEntryDate;
    }

    public void setProductEntryDate(Date productEntryDate) {
        this.productEntryDate = productEntryDate;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public ActivityLinkedList getActivities() {
        return activities;
    }

    
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

   
    
    public void removeActivity(int index) {
        activities.remove(index);
    }

    
    public void sortActivitiesByQuantity() {
        activities.sortByQuantity();
    }

    public void printProduct() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + productName);
        System.out.println("Entry Date: " + productEntryDate);
        System.out.println("Quantity: " + productQuantity);
        System.out.print("Activities: ");
        activities.print();
        System.out.println();
    }
}
