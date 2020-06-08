/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec;



import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author A01
 */
public class ConnectionFactory {
    DBDiagnostico n = new DBDiagnostico();
    public static String ipservice;
    public Connection getConnection(){
        try {
            DBDiagnostico.IP();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("ip: "+ipservice);
        System.out.println("Conectando ao banco...");
        try{
            return
            DriverManager.getConnection("jdbc:mysql://"+ipservice+"/gpiec", "Administrador", "GpiecAdmin");
            
       } catch (SQLException e){
           throw new RuntimeException(e);
     
        }
    }
    public Connection getConnectiontest(){
        
        System.out.println("ip: "+ipservice);
        System.out.println("Conectando ao banco...");
        try{
            return
            DriverManager.getConnection("jdbc:mysql://"+ipservice+"/gpiec", "Administrador", "GpiecAdmin");
            
       } catch (SQLException e){
           throw new RuntimeException(e);
     
        }
    }
    
}
