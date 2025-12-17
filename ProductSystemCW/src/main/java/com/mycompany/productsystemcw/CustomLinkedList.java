/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsystemcw;

/**
 *
 * @author krasipetranov and Matthew Cooke
 */
public class CustomLinkedList<T> {
    private Node<T> head;
    private int size;
    private int capacity; 
// stores data for the linked list and links to the next node   
    private static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
// creating the linkedList 
    public CustomLinkedList() {
        this.head = null;
        this.size = 0;
        this.capacity = Integer.MAX_VALUE; 
    }
//makes the linkList have no limit by icreasing the limit as data is added   
    public CustomLinkedList(int capacity) {
        this.head = null;
        this.size = 0;
        this.capacity = capacity;
    }
    
// add the new element to the front of the list
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
        
      
        if (size > capacity) {
            removeLast();
        }
    }
    
//adds the new element to the back of the list
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        
       
        if (size > capacity) {
            removeFirst();
        }
    }
    
//removes the first element from the list
    public T removeFirst() {
        if (head == null) return null;
        
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }
    
// removes the last element from the list   
    public T removeLast() {
        if (head == null) return null;
        
        if (head.next == null) {
            T data = head.data;
            head = null;
            size--;
            return data;
        }
        
        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        
        T data = current.next.data;
        current.next = null;
        size--;
        return data;
    }
    

    public T get(int index) {
        if (index < 0 || index >= size) return null;
        
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
 // set the size of the list to 0 if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }
    
 
    public int size() {
        return size;
    }
    
    // converts the list into an array
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = head;
        int index = 0;
        
        while (current != null) {
            array[index++] = current.data;
            current = current.next;
        }
        
        return array;
    }
    
// display all elements in the list with their index
    public void display() {
        Node<T> current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.data);
            current = current.next;
            index++;
        }
    }
}