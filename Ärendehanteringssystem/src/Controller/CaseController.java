/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import Model.Case;
import Model.Tasks;
/**
 *
 * @author lenawikman
 */
public class CaseController {
    static final String host="jdbc:mysql://localhost:3306/arendehantering?zeroDateTimeBehavior=convertToNull";
    static final String username="root";
    static final String password="";
    
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