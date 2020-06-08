/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;
import br.com.technobsoftwares.gpiec.modelo.Tipopatrimonio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class TipopatrimonioDAO {
    //Connection é uma classe do java que esta vazia 
    private Connection connection;
     //Contrutor - classe de uma classe, executa um comando antes de uma classe ser executada
    public TipopatrimonioDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public List<Tipopatrimonio> getLista(){
        try {
            List<Tipopatrimonio> tipo_patrimonios = new ArrayList<Tipopatrimonio>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from tipopatrimonio");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Tipopatrimonio tipo_patrimonio = new Tipopatrimonio();
                tipo_patrimonio.setIdtipopatrimonio(rs.getInt("idtipopatrimonio"));
                tipo_patrimonio.setTipo(rs.getString("tipo"));
                
                //Adicionando o objeto a lista
                tipo_patrimonios.add(tipo_patrimonio);
            }
            rs.close();
            stmt.close();
            return  tipo_patrimonios;
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
}
