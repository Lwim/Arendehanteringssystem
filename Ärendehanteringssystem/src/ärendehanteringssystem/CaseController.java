/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ärendehanteringssystem;

import java.util.ArrayList;
/**
 *
 * @author lenawikman
 */
public class CaseController {
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
}