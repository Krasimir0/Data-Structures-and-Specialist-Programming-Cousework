/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsystemcw;

import java.time.LocalDate;

/**
 *
 * @author krasipetranov and Matthew Cooke
 */
// this is the set up for Activity
public class Activity {
    private int activityId;
    private String activityName; 
    private int activityQuantity;
    private LocalDate activityDate;
// this creates an object with the information needed to record the activite 
    public Activity(int activityId, String activityName, int activityQuantity, LocalDate activityDate) {
        this.activityId = activityId;
        this.activityName = activityName;
        this.activityQuantity = activityQuantity;
        this.activityDate = activityDate;
    }
    // geting the corresponding value
    public int getActivityId() {
        return activityId; 
    }
    // geting the corresponding value
    public String getActivityName() {
        return activityName; 
    }
    // geting the corresponding value
    public int getActivityQuantity() {
        return activityQuantity; 
    }
    // geting the corresponding value
    public LocalDate getActivityDate() { 
        return activityDate; 
    }
    // seting the corresponding value
    public void setActivityId(int activityId) {
        this.activityId = activityId; 
    }
    // seting the corresponding value
    public void setActivityName(String activityName) { 
        this.activityName = activityName; 
    }
    // seting the corresponding value
    public void setActivityQuantity(int activityQuantity) { 
        this.activityQuantity = activityQuantity; 
    }
    // seting the corresponding value 
    public void setActivityDate(LocalDate activityDate) { 
        this.activityDate = activityDate; 
    }
    
    @Override
    public String toString() {
        return "Activity ID: " + activityId + 
               ", Type: " + activityName + 
               ", Quantity: " + activityQuantity + 
               ", Date: " + activityDate;
    }
}
