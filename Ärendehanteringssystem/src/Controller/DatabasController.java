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
import java.sql.*;
/**
 *
 * @author lenawikman
 */
public class DatabasController {
    static final String host="jdbc:mysql://127.0.0.1:3306/arendehantering?zeroDateTimeBehavior=convertToNull";
    static final String username="root";
    static final String password="elisama"; //ange eventuellt lösenord
    
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
    public void setAttributesToCase(String arendeNr, String instructions, String category) throws SQLException{
        String status = "aktiv"; //Vilka är de olika statusarna? 
        
        connectToDb();
        Statement stmt =(Statement)con.createStatement();
        
        String insert = "INSERT INTO arende VALUES" +"("+ arendeNr +", "+ "\""+ instructions +"\", "+ "\""+status+"\", " +"\""+ category+"\");";
        System.out.println(insert); //test query
        stmt.executeUpdate(insert);
        
        closeDbConnection();
    }
    
    
}