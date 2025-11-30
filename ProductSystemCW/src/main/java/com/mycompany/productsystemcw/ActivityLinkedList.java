/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsystemcw;

/**
 *
 * @author krasipetranov
 */
public class ActivityLinkedList {
   public ListNode head;
   int size = 0;
   
   public ActivityLinkedList() {
       head = null;
   }
   
   public void add(Activity activity) {
        ListNode newNode = new ListNode(activity);

        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
   }
   
   public void add(int index, Activity activity) {
       if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }

        ListNode newNode = new ListNode(activity);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            ListNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
   }
   
   public void remove() {
        if (head == null) return;

        if (head.next == null) {
            head = null;
        } else {
            ListNode current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        size--;
   }
   
   public void remove(int index) {
       if(index >= size || index < 0) {
           System.out.println("Invalid index");
           return;
       }
       
       if(index == 0) {
           head = head.next;
       } else {
           ListNode current = head;
           for(int i = 0; i < index-1; i++) {
               current = current.next;
           }
           
           current.next = current.next.next;
       }
       size--;   
   }
   
   public int size() {
       return size;
   }
   
   public boolean isEmpty() {
       return size == 0;
   }
   
  public Activity get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return null;
        }

        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
   
   public boolean contains(Activity activity) {
        ListNode current = head;
        while (current != null) {
            if (current.data.equals(activity)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
   
   public void print() {
       ListNode current = head;
       
       while(current != null) {
           System.out.print(current.data.getActivityInfo() + " | ");
           current = current.next;
       }
   }
   
   public int searchByActivityID(int activityID) {
    ListNode current = head;
    int index = 0;

    while (current != null) {
        if (current.data.getActivityID() == activityID) {
            return index; // found
        }
        current = current.next;
        index++;
    }
      return -1; 
   }
   
   public void sortByQuantity() {
    if (head == null || head.next == null) return;

    boolean swapped;

    do {
        swapped = false;
        ListNode current = head;

        while (current.next != null) {
            if (current.data.getActivityQuantity() >
                current.next.data.getActivityQuantity()) {

                Activity temp = current.data;
                current.data = current.next.data;
                current.next.data = temp;

                swapped = true;
            }
            current = current.next;
        }

    } while (swapped);
    
  }
   
}
