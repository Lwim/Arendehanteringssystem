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
public class Case {
    
    private int caseNr; 
    private String category; 
    private String caseStatus; 
    private String instructions; 
    
    public Case() {
}
   
    public int getCaseNr() {
        return caseNr;
    }
    
    public void setCaseNr(int caseNr ) {
        this.caseNr = caseNr;
    }
     
    public String getCategory() {
        return category;
    }
   
    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getCaseStatus() {
        return caseStatus;
    }
  
    public void setCaseStatus (String caseStatus) {
        this.caseStatus = caseStatus;
    }   
}
  

