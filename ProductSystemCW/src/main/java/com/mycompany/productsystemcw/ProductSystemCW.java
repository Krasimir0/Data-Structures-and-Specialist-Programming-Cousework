/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.productsystemcw;


import java.util.Scanner;

/**
 *  
 * @author krasipetranov and Matthew Cooke
 */
public class ProductSystemCW {
    private ProductActivityManagement manager;
    private Scanner scanner;
// used for getting the input to the menu    
    public ProductSystemCW() {
        manager = new ProductActivityManagement();
        scanner = new Scanner(System.in);
    }
// creates the menu in the console 
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
            // gets input from user and does the corresponding acction
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
// creates a Product user enter a name and amount and automaticaly give it an Id 
    private void createProduct() {
        System.out.print("Enter product name: ");
        scanner.nextLine(); 
        String name = scanner.nextLine();
        
        System.out.print("Enter initial quantity: ");
        int quantity = getIntInput();
        
        manager.createProduct(name, quantity);
    }
// removes item from list  
    private void deleteProduct() {
        System.out.print("Enter product ID to delete: ");
        int id = getIntInput();
        manager.deleteProduct(id);
    }
// add to the quantity of an item     
    private void addStock() {
        System.out.print("Enter product ID: ");
        int id = getIntInput();
        
        System.out.print("Enter quantity to add: ");
        int quantity = getIntInput();
        
        manager.updateProductActivity(id, "AddToStock", quantity);
    }
// removes from quantity
    private void removeStock() {
        System.out.print("Enter product ID: ");
        int id = getIntInput();
        
        System.out.print("Enter quantity to remove/sell: ");
        int quantity = getIntInput();
        
        manager.updateProductActivity(id, "RemoveFromStock", quantity);
    }
// show the history of the last 4 changes to the product   
    private void viewActivities() {
        System.out.print("Enter product ID: ");
        int id = getIntInput();
        manager.displaySortedActivities(id);
    }
    
 // get an input from the user for the menu selection screen   
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
    
