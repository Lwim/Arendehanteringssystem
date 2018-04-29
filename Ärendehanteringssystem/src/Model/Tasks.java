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
    private int caseNr;
    private String description; 
    private String taskStatus; 
    private double timeBudget; 
    
    public Tasks() {
    }

    public Tasks(int taskNr, int caseNr, String description, String taskStatus, double timeBudget) {
        this.taskNr = taskNr;
        this.caseNr = caseNr;
        this.description = description;
        this.taskStatus = taskStatus;
        this.timeBudget = timeBudget;
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
    public double getTimebudget () {
        return timeBudget;
    }  

    public int getCaseNr() {
        return caseNr;
    }

    public void setCaseNr(int caseNr) {
        this.caseNr = caseNr;
    }


    
    
}  

