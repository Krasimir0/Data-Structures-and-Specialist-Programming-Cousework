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
public class Activity {
    private final int activityID;
    private final String activityName;
    private final int activityQuantity;
    private final Date activityDate;
    
    public Activity(int activityID, String activityName, int activityQuantity, Date activityDate) {
        this.activityID = activityID;
        this.activityName = activityName;
        this.activityQuantity = activityQuantity;
        this.activityDate = activityDate;
    }
    
    public int getActivityID() {
        return activityID;
    }

    public String getActivityName() {
        return activityName;
    }

    public int getActivityQuantity() {
        return activityQuantity;
    }

    public Date getActivityDate() {
        return activityDate;
    }
    
    public String getActivityInfo() {
        return "ID: " + activityID + ", Name: " + activityName +
               ", Quantity: " + activityQuantity + ", Date: " + activityDate;
    }
}
