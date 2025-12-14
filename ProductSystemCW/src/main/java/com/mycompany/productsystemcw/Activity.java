/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.productsystemcw;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author krasipetranov
 */
public class Activity {
    private int activityId;
    private String activityName; 
    private int activityQuantity;
    private LocalDate activityDate;
    
    public Activity(int activityId, String activityName, int activityQuantity, LocalDate activityDate) {
        this.activityId = activityId;
        this.activityName = activityName;
        this.activityQuantity = activityQuantity;
        this.activityDate = activityDate;
    }
    
    public int getActivityId() { return activityId; }
    public String getActivityName() { return activityName; }
    public int getActivityQuantity() { return activityQuantity; }
    public LocalDate getActivityDate() { return activityDate; }
    
    public void setActivityId(int activityId) { this.activityId = activityId; }
    public void setActivityName(String activityName) { this.activityName = activityName; }
    public void setActivityQuantity(int activityQuantity) { this.activityQuantity = activityQuantity; }
    public void setActivityDate(LocalDate activityDate) { this.activityDate = activityDate; }
    
    @Override
    public String toString() {
        return "Activity ID: " + activityId + 
               ", Type: " + activityName + 
               ", Quantity: " + activityQuantity + 
               ", Date: " + activityDate;
    }
}
