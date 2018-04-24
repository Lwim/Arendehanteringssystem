/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import Model.Case;
import Model.Tasks;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.*;
/**
 *
 * @author lenawikman
 */
public class CaseController {
    static final String host="jdbc:mysql://localhost:3306/arendehantering?zeroDateTimeBehavior=convertToNull";
    static final String username="root";
    static final String password=""; //ange eventuellt lösenord
    
    private Connection con = null;
    private final PreparedStatement insertArende;
    private final PreparedStatement deleteArende;
    private final PreparedStatement selectArende;
    
    private final String arende_INSERT = "INSERT INTO arende (message) VALUES(?)";
    private final String arende_DELETE = "DELETE FROM arende WHERE messageID = ?";
    private final String arende_SELECT = "SELECT ? FROM arende";
    
    ArrayList<Case> caseList = new ArrayList();
        //deklarering av array caseList
    
    ArrayList<Tasks> taskList = new ArrayList();
        //deklarering av array taskList 
    
    Case c;
    Tasks a;

    public CaseController() throws SQLException {
        connectToDb();
        selectArende = con.prepareStatement(arende_SELECT);
        insertArende = con.prepareStatement(arende_INSERT);
        deleteArende = con.prepareStatement(arende_DELETE);
    }
    
    public void connectToDb() throws SQLException {
        con = DriverManager.getConnection( host, username, password );
        
    }
    
    public void closeDbConnection() throws SQLException {
        con.close();
    }
    
    
    //spara case i ArrayList
    public void addCase(Case Case){
        caseList.add(Case);
    
}
//spara task i ArrayList
    public void addTask(Tasks task){
        taskList.add(task);
    }
    //Hämtar högsta registrerade ärendenumret och returnerar det + 1
    public int getNewCaseNr ()throws SQLException{
        int nextNr = 0;
        connectToDb();
        Statement stmt = con.createStatement();
        String sql = "SELECT max(arendeNr) As arendeNR FROM arende";
        ResultSet rs = stmt.executeQuery(sql);
           while(rs.next()){
               nextNr = rs.getInt("arendeNr");
           }
        nextNr = nextNr + 1;
        closeDbConnection();
        return nextNr;
    }
}