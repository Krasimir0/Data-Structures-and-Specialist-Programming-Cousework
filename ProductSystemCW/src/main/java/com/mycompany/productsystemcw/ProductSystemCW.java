/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productsystemcw;


import java.util.Scanner;

/**
 *  
 * @author krasipetranov
 */
public class ProductSystemCW {
    private ProductActivityManagement manager;
    private Scanner scanner;
    
    public ProductSystemCW() {
        manager = new ProductActivityManagement();
        scanner = new Scanner(System.in);
    }
    
    public void displayMenu() {
        System.out.println("1. Create New Product");
        System.out.println("2. Display All Products");
        System.out.println("3. Delete Product");
        System.out.println("4. Add Stock");
        System.out.println("5. Remove From Stock");
        System.out.println("6. View Product Activities");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }
    
    public void run() {
        boolean running = true;
        
        while (running) {
            displayMenu();
            int choice = getIntInput();
            
            switch (choice) {
                case 1:
                    createProduct();
                    break;
                case 2:
                    manager.displayAllProducts();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    addStock();
                    break;
                case 5:
                    removeStock();
                    break;
                case 6:
                    viewActivities();
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }
    
    private void createProduct() {
        System.out.print("Enter product name: ");
        scanner.nextLine(); 
        String name = scanner.nextLine();
        
        System.out.print("Enter initial quantity: ");
        int quantity = getIntInput();
        
        manager.createProduct(name, quantity);
    }
    
    private void deleteProduct() {
        System.out.print("Enter product ID to delete: ");
        int id = getIntInput();
        manager.deleteProduct(id);
    }
    
    private void addStock() {
        System.out.print("Enter product ID: ");
        int id = getIntInput();
        
        System.out.print("Enter quantity to add: ");
        int quantity = getIntInput();
        
        manager.updateProductActivity(id, "AddToStock", quantity);
    }
    
    private void removeStock() {
        System.out.print("Enter product ID: ");
        int id = getIntInput();
        
        System.out.print("Enter quantity to remove/sell: ");
        int quantity = getIntInput();
        
        manager.updateProductActivity(id, "RemoveFromStock", quantity);
    }
    
    private void viewActivities() {
        System.out.print("Enter product ID: ");
        int id = getIntInput();
        manager.displaySortedActivities(id);
    }
    
    
    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.next();
        }
        int input = scanner.nextInt();
        return input;
    }
    
    public static void main(String[] args) {
        ProductSystemCW ui = new ProductSystemCW();
        ui.run();
    }
}
    
