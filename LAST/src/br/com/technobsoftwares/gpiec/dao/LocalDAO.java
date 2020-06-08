/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;
import br.com.technobsoftwares.gpiec.modelo.Local;
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
public class LocalDAO {
    //Connection é uma classe do java que esta vazia 
    private Connection connection;
     //Contrutor - classe de uma classe, executa um comando antes de uma classe ser executada
    public LocalDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void adiciona(Local local){
        String sql = "INSERT INTO local_2(local_2, desc_local) VALUES (?,?)";
        try {
            //prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, local.getNome_local());
            stmt.setString(2, local.getDesc_local());
            
            //Executa:
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void pesquisar(Local local){
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from local_2 where idlocal_2 ="
                    +local.getId_local());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                local.setId_local(rs.getInt("idlocal_2"));
                local.setNome_local(rs.getString("local_2"));
                local.setDesc_local(rs.getString("desc_local"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void alterar(Local local){
        String sql = "update local_2 set local_2=?,"+" desc_local=?"+" where idlocal_2=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, local.getNome_local());
            stmt.setString(2, local.getDesc_local());
            stmt.setInt(3, local.getId_local());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void deletar(Local local){
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from local_2 where idlocal_2=?");
            stmt.setInt(1, local.getId_local());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Local> getLista(){
        try {
            List<Local> locais = new ArrayList<Local>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from local_2");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Local local = new Local();
                
                local.setId_local(rs.getInt("idlocal_2"));
                local.setNome_local(rs.getString("local_2"));
                local.setDesc_local(rs.getString("desc_local"));
                
                //Adicionando o objeto a lista
                locais.add(local);
            }
            rs.close();
            stmt.close();
            return  locais;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
}
