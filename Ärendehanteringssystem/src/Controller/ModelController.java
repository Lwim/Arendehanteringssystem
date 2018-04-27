/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Case;
import Model.Tasks;
import java.util.ArrayList;

/**
 *
 * @author lenawikman
 */
public class ModelController {
    
    ArrayList<Case> caseList = new ArrayList();
        //deklarering av array caseList
    
    ArrayList<Tasks> taskList = new ArrayList();
        //deklarering av array taskList 
    
    Case c;
    Tasks a;
    
    
    //spara case i ArrayList
    public void addCase(Case Case){
        caseList.add(Case);
    
}
    //spara task i ArrayList
    public void addTask(Tasks task){
        taskList.add(task);
    }
    
    public void regCase (String caseNr, String instructions, String category, String caseStatus){
        c = new Case();
        int nr = Integer.parseInt(caseNr);
        c.setCaseNr(nr);
        c.setCategory(category);
        c.setCaseStatus(caseStatus);
        c.setInstructions(instructions);
        addCase(c);
    }
    
    public void regTask(int taskNr, int caseNr, String description, String taskStatus, double timeBudget){
        a = new Tasks();
        a.setTaskNr(taskNr);
        a.setCaseNr(caseNr);
        a.setDescription(description);
        a.setTaskStatus(taskStatus);
        a.setTimebudget(timeBudget);
        addTask(a);
    }
    
    
}
