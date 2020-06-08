/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;import br.com.technobsoftwares.gpiec.modelo.Software;
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
public class SoftwareDAO {
    private Connection connection;
     //Contrutor - classe de uma classe, executa um comando antes de uma classe ser executada
    public SoftwareDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Software software){
        String sql = "INSERT INTO software(nome, descricao"
                + " VALUES (?,?)";
        try {
            //prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, software.getNome());
            stmt.setString(2, software.getDescricao());
            
            //Executa:
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void pesquisarNome(Software software){
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select idsoftware, nome, descricao where"
                    + " nome like "
                    +software.getIdsoftware());

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                software.setIdsoftware(rs.getInt("idsoftware"));
                software.setNome(rs.getString("nome"));
                software.setDescricao(rs.getString("descricao"));
            }
//            tst.close();
            rs.close();
            stmt.close();
//            teste.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void pesquisarDescricao(Software software){
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select idsoftware, nome, descricao where"
                    + " descricao like "
                    +software.getDescricao());

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                software.setIdsoftware(rs.getInt("idsoftware"));
                software.setNome(rs.getString("nome"));
                software.setDescricao(rs.getString("descricao"));
            }
//            tst.close();
            rs.close();
            stmt.close();
//            teste.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void alterar(Software software){
        String sql = "update software set nome=?, "+
                "descricao=?"+
                " where idsoftware=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, software.getNome());
            stmt.setString(2, software.getDescricao());
            stmt.setInt(3, software.getIdsoftware());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletar(Software software){
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from software where idsoftware=?");
            stmt.setInt(1, software.getIdsoftware());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Software> getLista(){
        try {
            List<Software> softwares = new ArrayList<Software>();
            PreparedStatement stmt = this.connection.prepareStatement("select idsoftware, nome, descricao " 
            +"FROM software;");
            //PreparedStatement teste = this.connection.prepareStatement("select tipousuario from tipousuario inner join usuario on usuario.fkidtipousuario = tipousuario.idtipousuario where usuario.fkidtipousuario like ?;");
                             
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Software software = new Software();

                software.setIdsoftware(rs.getInt("idestabilizadosoftware"));
                software.setNome(rs.getString("nome"));
                software.setDescricao("descricao");
               
                
                
                //Adicionando o objeto a lista
                softwares.add(software);
            } 
            rs.close();
            stmt.close();
            return  softwares;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
 
    
    public void RelatorioDeSoftwares() throws JRException, SQLException {
        JasperReport report = JasperCompileManager
                .compileReport("relatorios/report1.jrxml"); //criar relatório...
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(getLista()));
        JasperExportManager.exportReportToPdfFile(print, "relatorios/report1.pdf");
        System.out.println("Relatório gerado!");
    }    
}
