/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ärendehanteringssystem;

/**
 *
 * @author lenawikman
 */
public class Ärendehanteringssystem {
    
    static CaseController bc = new CaseController();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new RegisterTask().setVisible(true);
    }
    
}
