/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ärendehanteringssystem;
import View.CaseMenu;

/**
 *
 * @author lenawikman
 */
public class Ärendehanteringssystem {
    
    static int CaseNumber = 1000; //löpnummer för ärenden
    static int Tasknumber = 1000; //löpnummer för arbetsuppgifter
   
    
    public static void main(String[] args) {
        
        new CaseMenu().setVisible(true);
    }
    
}
