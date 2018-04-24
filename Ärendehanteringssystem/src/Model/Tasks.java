/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author lenawikman
 */
public class Tasks {
    
    private int taskNr; 
    private String description; 
    private String taskStatus; 
    private double timeBudget; 
    
    public Tasks() {
    }
    
    public int getTaskNr() {
        return taskNr;
    }
    
    public void setTaskNr(int taskNr ) {
        this.taskNr = taskNr;
    }
     
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getTaskStatus() {
        return taskStatus;
    }
    
      public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
   
    public void setTimebudget (double timeBudget) {
        this.timeBudget = timeBudget;
    }  
    public double getTimebudge () {
        return timeBudget;
    }  
}  

