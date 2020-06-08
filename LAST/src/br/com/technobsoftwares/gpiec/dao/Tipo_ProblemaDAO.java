/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;
import br.com.technobsoftwares.gpiec.modelo.Tipo_Problema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Tipo_ProblemaDAO {
    
    private Connection connection;
    
    public Tipo_ProblemaDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public List<Tipo_Problema> getLista(){
        try {
            List<Tipo_Problema> tproblemas = new ArrayList<Tipo_Problema>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from tipoproblema");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Tipo_Problema tproblema = new Tipo_Problema();
                
                tproblema.setId_tipo_problema(rs.getInt("idtipoproblema"));
                tproblema.setTipo_problema(rs.getString("tipoproblema"));
                
                //Adicionando o objeto a lista
                tproblemas.add(tproblema);
            }
            rs.close();
            stmt.close();
            return  tproblemas;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
}
