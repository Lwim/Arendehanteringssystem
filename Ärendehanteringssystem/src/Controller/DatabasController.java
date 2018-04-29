/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import Model.Tasks;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author lenawikman
 */
public class DatabasController {
    static final String host="jdbc:mysql://127.0.0.1:3306/arendehantering?zeroDateTimeBehavior=convertToNull";
    static final String username="root";
    static final String password="1qaz2wsX!@"; //ange eventuellt lösenord
    
    private Connection con = null;
    private final PreparedStatement insertArende;
    private final PreparedStatement deleteArende;
    private final PreparedStatement selectArende;
    private final PreparedStatement insertArbetsuppgifter; 
    private final PreparedStatement deleteArbetsuppgifter;
    private final PreparedStatement selectArbetsuppgifter; 
    
    private final String arende_INSERT = "INSERT INTO arende (message) VALUES(?)";
    private final String arende_DELETE = "DELETE FROM arende WHERE arendeNr = ?";
    private final String arende_SELECT = "SELECT ? FROM arende";
    private final String arbetsuppgifter_INSERT = "INSERT INTO arbetsuppgifter VALUES(?)"; 
    private final String arbetsuppgifter_DELETE = "DELETE ? FROM arbetsuppgifter WHERE arbetsuppgNr = ?";
    private final String arbetsuppgifter_SELECT = "SELECT ? FROM arbetsuppgifter";
    
   
    public DatabasController() throws SQLException {
        connectToDb();
        selectArende = con.prepareStatement(arende_SELECT);
        insertArende = con.prepareStatement(arende_INSERT);
        deleteArende = con.prepareStatement(arende_DELETE);
        insertArbetsuppgifter = con.prepareStatement(arbetsuppgifter_INSERT);
        deleteArbetsuppgifter = con.prepareStatement(arbetsuppgifter_DELETE);
        selectArbetsuppgifter = con.prepareStatement(arbetsuppgifter_SELECT); 
    }
    
    public void connectToDb() throws SQLException {
        con = DriverManager.getConnection( host, username, password );
        
    }
    
    public void closeDbConnection() throws SQLException {
        con.close();
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
    
    public int getNewTaskNr () throws SQLException{
        int nextNr = 0;
        connectToDb();
        Statement stmt = con.createStatement();
        String sql = "SELECT max(arbetsuppgNr) As arbetsuppgNr FROM arbetsuppgifter";
        ResultSet rs = stmt.executeQuery(sql);
           while(rs.next()){
               nextNr = rs.getInt("arbetsuppgNr");
           }
        nextNr = nextNr + 1;
        closeDbConnection();
        
        return nextNr;
    }
    
    public List<Tasks> getTasksforCase(int caseNr) throws SQLException {
        List<Tasks> lstTasks = new ArrayList<>();
        ResultSet rs = null;
        connectToDb();
        Statement stmt = con.createStatement();
        String sql = "SELECT * FROM arbetsuppgifter WHERE arendeNr ="+caseNr+";";
        rs = stmt.executeQuery(sql);
        while(rs.next()) {
            lstTasks.add(new Tasks(rs.getInt("arbetsuppgNr"), rs.getInt("arendeNr"), rs.getString("beskrivning"), rs.getString("status"), rs.getDouble("budgeteradTid")));
        }
        closeDbConnection();
        return lstTasks;
    }
    
    public void saveCaseToDatabase(String arendeNr, String instructions, String category, String status) throws SQLException{
        connectToDb();
        Statement stmt =(Statement)con.createStatement();
        String insert = "INSERT INTO arende VALUES" +"("+ arendeNr +", "+ "\""+ instructions +"\", "+ "\""+status+"\", " +"\""+ category+"\");";
        System.out.println(insert);
        stmt.executeUpdate(insert);
        closeDbConnection();
    }
    
    public void addTaskToDatabase(int taskNr, int caseNr, String taskDesc, double timeBudget, String status) throws SQLException{
        connectToDb();
        Statement stmt =(Statement)con.createStatement();
        String insert = "INSERT INTO arbetsuppgifter (arbetsuppgNr, arendeNr, beskrivning, budgeteradTid, tidforbrukad, status) VALUES " + "("+taskNr+", "+caseNr+", '"+taskDesc+"', "+timeBudget+", 0, '"+status+"');";
        System.out.println(insert);
        stmt.executeUpdate(insert);        
        closeDbConnection();
    }
    
    
}