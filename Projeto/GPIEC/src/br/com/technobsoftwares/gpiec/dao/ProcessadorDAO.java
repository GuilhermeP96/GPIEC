/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;import br.com.technobsoftwares.gpiec.modelo.Processador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
/**
 *
 * @author Shutdown
 */
public class ProcessadorDAO {
    private Connection connection;
     //Contrutor - classe de uma classe, executa um comando antes de uma classe ser executada
    public ProcessadorDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Processador processador){
        String sql = "INSERT INTO processador(marca, nome"
                + " VALUES (?,?)";
        try {
            //prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, processador.getMarca());
            stmt.setString(2, processador.getNome());
            
            //Executa:
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void pesquisarNome(Processador processador){
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select idprocessador, marca, nome where"
                    + " nome like "
                    +processador.getNome());

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                processador.setIdprocessador(rs.getInt("idestabilizadprocessador"));
                processador.setMarca(rs.getString("marca"));
                processador.setNome(null);
            }
//            tst.close();
            rs.close();
            stmt.close();
//            teste.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void alterar(Processador processador){
        String sql = "update processador set marca=?, "+
                "nome=?"+
                " where idprocessador=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, processador.getMarca());
            stmt.setString(2, processador.getNome());
            stmt.setInt(3, processador.getIdprocessador());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletar(Processador processador){
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from processador where idprocessador=?");
            stmt.setInt(1, processador.getIdprocessador());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Processador> getLista(){
        try {
            List<Processador> processadores = new ArrayList<Processador>();
            PreparedStatement stmt = this.connection.prepareStatement("select idprocessador, marca, nome " 
            +"FROM processador;");
            //PreparedStatement teste = this.connection.prepareStatement("select tipousuario from tipousuario inner join usuario on usuario.fkidtipousuario = tipousuario.idtipousuario where usuario.fkidtipousuario like ?;");
                             
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Processador processador = new Processador();

                processador.setIdprocessador(rs.getInt("idprocessador"));
                processador.setMarca(rs.getString("marca"));
                processador.setNome(rs.getString("nome"));
               
                
                
                //Adicionando o objeto a lista
                processadores.add(processador);
            } 
            rs.close();
            stmt.close();
            return  processadores;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
}



