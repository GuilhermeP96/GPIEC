/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;
import br.com.technobsoftwares.gpiec.modelo.Memoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author A01
 */
public class MemoriaDAO {
    private Connection connection;
    public MemoriaDAO()
    {
        this.connection = new ConnectionFactory().getConnection();
    }
    public void adicionar(Memoria memoria)
    {
        String sql = "INSERT INTO memoria (marca, frequencia, tamanho) VALUES (?,?,?);";
        try 
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, memoria.getMarca());
            stmt.setString(2, memoria.getFrequencia());
            stmt.setString(3, memoria.getTamanho());
            //Executa:
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException e) 
        {
            
        }
    }
    public void pesquisar(Memoria memoria)
    {
        try 
        {
           PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM memoria WHERE idmemoria="+memoria.getIdmemoria());
           ResultSet rs = stmt.executeQuery();
           while (rs.next())
           {
               // criando o objeto memoria
               memoria.setIdmemoria(rs.getInt("idmemoria"));
               memoria.setMarca(rs.getString("marca"));
               memoria.setFrequencia(rs.getString("frequencia"));
               memoria.setTamanho(rs.getString("tamanho"));               
           }
           rs.close();
           stmt.close();
        } 
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
    }
    
    public void alterar(Memoria memoria)
    {                                                     
        String sql = "UPDATE memoria SET marca=?,"+" frequencia=?,"+" tamanho=?,"+" WHERE idmemoria=?;";
        try 
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, memoria.getMarca());
            stmt.setString(2, memoria.getFrequencia());
            stmt.setString(3, memoria.getTamanho());
            stmt.setInt(4, memoria.getIdmemoria());
            //Executa:
            stmt.execute();
            stmt.close();
        } catch (SQLException e) 
        {
           throw new RuntimeException(e);   
        }
    }
    public void remover(Memoria memoria)
    {
        try 
        {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM memoria WHERE idmemoria=?;");
            stmt.setInt(1, memoria.getIdmemoria());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException e) 
        {
            throw new RuntimeException(e);  
        }
    }
    
        public List<Memoria> getLista(){
        try {
            List<Memoria> memorias = new ArrayList<Memoria>();
            PreparedStatement stmt = this.connection.prepareStatement("select idmemoria, marca, frequencia, tamanho" +
"	FROM memoria;");
            //PreparedStatement teste = this.connection.prepareStatement("select tipousuario from tipousuario inner join usuario on usuario.fkidtipousuario = tipousuario.idtipousuario where usuario.fkidtipousuario like ?;");
                             
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Memoria memoria = new Memoria();

                memoria.setIdmemoria(rs.getInt("idmemoria"));
                memoria.setMarca(rs.getString("descricao"));
                memoria.setFrequencia(rs.getString("frequencia"));
                memoria.setTamanho(rs.getString("tamanho"));
               
                
                
                //Adicionando o objeto a lista
                memorias.add(memoria);
            } 
            rs.close();
            stmt.close();
            return  memorias;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
}
