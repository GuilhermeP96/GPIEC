/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;
import br.com.technobsoftwares.gpiec.modelo.Teclado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author A01
 */
public class TecladoDAO {
        private Connection connection;
    public TecladoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    // Não contém o método adicionar, editar, remover. Os valores no banco são apenas sim e não
    public void pesquisar(Teclado teclado)
    {
        try 
        {
           PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM teclado WHERE idteclado="+teclado.getIdteclado());
           ResultSet rs = stmt.executeQuery();
           while (rs.next())
           {
               // criando o objeto Recado
               teclado.setIdteclado(rs.getInt("idteclado"));
               teclado.setContemteclado(rs.getString("contemteclado"));               
           }
           rs.close();
           stmt.close();
        } 
        catch (SQLException e) 
        {
            throw new RuntimeException(e);
        }
    }
    }
