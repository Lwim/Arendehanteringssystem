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
/**
 *
 * @author lenawikman
 */
public class CaseController {
    static final String host="jdbc:mysql://localhost:3306/arendehantering?zeroDateTimeBehavior=convertToNull";
    static final String username="root";
    static final String password="";
    
    private Connection con = null;
    private final PreparedStatement insertMsg;
    private final PreparedStatement deleteMsg;
    private final PreparedStatement selectAllMsg;
    
    private final String MSG_INSERT = "INSERT INTO msg (message) VALUES(?)";
    private final String MSG_DELETE = "DELETE FROM msg WHERE messageID = ?";
    private final String MSG_SELECT = "SELECT * FROM msg";
    
    ArrayList<Case> caseList = new ArrayList();
        //deklarering av array caseList
    
    ArrayList<Tasks> taskList = new ArrayList();
        //deklarering av array taskList 
    
    Case c;
    Tasks a;

    public CaseController() throws SQLException {
        connectToDb();
        selectAllMsg = con.prepareStatement(MSG_SELECT);
        insertMsg = con.prepareStatement(MSG_INSERT);
        deleteMsg = con.prepareStatement(MSG_DELETE);
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
}