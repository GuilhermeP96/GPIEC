/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;
import br.com.technobsoftwares.gpiec.modelo.Status_2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Shutdown
 */
public class Status_2DAO {
    private Connection connection;
     //Contrutor - classe de uma classe, executa um comando antes de uma classe ser executada
        public Status_2DAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void pesquisar(Status_2 status_2){
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from status_2;");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                status_2.setStatus_2(rs.getString("status_2"));
            }
//            tst.close();
            rs.close();
            stmt.close();
//            teste.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
