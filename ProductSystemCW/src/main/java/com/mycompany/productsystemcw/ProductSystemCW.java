/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productsystemcw;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *  
 * @author krasipetranov
 */
public class ProductSystemCW {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        int option;
        
         do {
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Add Activity to Product");
            System.out.println("4. Remove Activity from Product");
            System.out.println("5. Sort Activities by Quantity");
            System.out.println("6. Search Activity by ID in Product");
            System.out.println("7. Print Product Details");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            option = sc.nextInt();

            switch (option) {

                case 1 -> {
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String productName = sc.nextLine();

                    System.out.print("Enter Product Quantity: ");
                    int quality = sc.nextInt();

                    Product p = new Product(id, productName, new Date(), quality);
                    products.add(p);
                    System.out.println("Product added successfully!");
                }

                case 2 -> {
                    for (Product p : products) {
                        System.out.println("ID: " + p.getProductID() + ", Name: " + p.getProductName());
                    }
                }

                case 3 -> {
                    System.out.print("Enter Product ID to add activity: ");
                    int productId = sc.nextInt();
                    Product p = findProduct(products, productId);

                    if (p == null) {
                        System.out.println("Product not found!");
                        break;
                    }

                    System.out.print("Enter Activity ID: ");
                    int activityId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Activity Name: ");
                    String activityName = sc.nextLine();

                    System.out.print("Enter Activity Quantity: ");
                    int activityQuantity = sc.nextInt();

                    Activity a = new Activity(activityId, activityName, activityQuantity, new Date());
                    p.addActivity(a);

                    System.out.println("Activity added.");
                }

                case 4 -> {
                    System.out.print("Enter Product ID: ");
                    int productId = sc.nextInt();
                    Product p = findProduct(products, productId);

                    if (p == null) {
                        System.out.println("Product not found!");
                        break;
                    }

                    System.out.print("Enter activity index to remove activity: ");
                    int index = sc.nextInt();
                    p.removeActivity(index);
                    System.out.println("Activity removed.");
                }

                case 5 -> {
                    System.out.print("Enter Product ID: ");
                    int productId = sc.nextInt();
                    Product p = findProduct(products, productId);

                    if (p == null) {
                        System.out.println("Product not found!");
                        break;
                    }

                    p.sortActivitiesByQuantity();
                    System.out.println("Activities sorted by quantity.");
                }

                case 6 -> {
                    System.out.print("Enter Product ID: ");
                    int productId = sc.nextInt();
                    Product p = findProduct(products, productId);

                    if (p == null) {
                        System.out.println("Product not found!");
                        break;
                    }

                    System.out.print("Enter Activity ID: ");
                    int activityId = sc.nextInt();

                    int index = p.getActivities().searchByActivityID(activityId);
                    if (index >= 0)
                        System.out.println("Activity found at index: " + index);
                    else
                        System.out.println("Activity not found.");
                }

                case 7 -> {
                    System.out.print("Enter Product ID: ");
                    int productId = sc.nextInt();
                    Product p = findProduct(products, productId);

                    if (p != null) {
                        p.printProduct();
                    } else {
                        System.out.println("Product not found!");
                    }
                }

                case 0 -> System.out.println("Exiting");

                default -> System.out.println("Invalid option!");
            }

        } while (option != 0);

        sc.close();
    }

    private static Product findProduct(ArrayList<Product> products, int id) {
        for (Product p : products) {
            if (p.getProductID() == id) {
                return p;
            }
        }
        return null;
    }
 }
    
