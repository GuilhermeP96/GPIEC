/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;
import br.com.technobsoftwares.gpiec.modelo.Local_2;
import java.io.File;
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
 * @author User
 */
public class Local_2DAO {
    //Connection é uma classe do java que esta vazia 
    private Connection connection;
     //Contrutor - classe de uma classe, executa um comando antes de uma classe ser executada
    public Local_2DAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    public void adiciona(Local_2 local){
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
    
    public void pesquisar(Local_2 local){
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select idlocal_2, local_2, desc_local, COUNT(pc.fkidlocal_2) from local_2 INNER JOIN pc ON pc.fkidlocal_2 = local_2.idlocal_2 where idlocal_2 = "+local.getId_local()+" GROUP BY idlocal_2;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                local.setId_local(rs.getInt("idlocal_2"));
                local.setNome_local(rs.getString("local_2"));
                if ("".equals(rs.getString("desc_local"))) {
                    local.setDesc_local("SEM DESCRIÇÃO");
                }else{
                    local.setDesc_local(rs.getString("desc_local"));
                }
                local.setQtd_local(rs.getInt("COUNT(pc.fkidlocal_2)"));
                
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void alterar(Local_2 local){
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
    
    public void deletar(Local_2 local){
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from local_2 where idlocal_2=?");
            stmt.setInt(1, local.getId_local());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Local_2> getLista(){
        try {
            List<Local_2> locais = new ArrayList<Local_2>();
            PreparedStatement stmt = this.connection.prepareStatement("select idlocal_2, local_2, desc_local, COUNT(pc.fkidlocal_2) from local_2 INNER JOIN pc ON pc.fkidlocal_2 = local_2.idlocal_2 GROUP BY idlocal_2;");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Local_2 local = new Local_2();
                
                local.setId_local(rs.getInt("idlocal_2"));
                local.setNome_local(rs.getString("local_2"));
                if ("".equals(rs.getString("desc_local"))) {
                    local.setDesc_local("SEM DESCRIÇÃO");
                }else{
                    local.setDesc_local(rs.getString("desc_local"));
                }
                local.setQtd_local(rs.getInt("COUNT(pc.fkidlocal_2)"));
                
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
    
    public void RelatorioLocais() throws JRException, SQLException {
        JasperReport report = JasperCompileManager
                .compileReport("relatorios/reportLocal.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(getLista()));
        JasperExportManager.exportReportToPdfFile(print, "relatorios/reportLocal.pdf");
        System.out.println("Relatório gerado!");
    }    
    
    public void ChamaRelLocais(){
        try {
            java.awt.Desktop.getDesktop().open(new File("relatorios/reportLocal.pdf"));           
        } catch (Exception e) {
            System.out.println("Deu ruim! / "+e);
        }
    }
}
