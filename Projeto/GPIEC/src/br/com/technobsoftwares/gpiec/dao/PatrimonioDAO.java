/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;


import br.com.technobsoftwares.gpiec.ConnectionFactory;import br.com.technobsoftwares.gpiec.modelo.Patrimonio;
import br.com.technobsoftwares.gpiec.modelo.Tipopatrimonio;
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
public class PatrimonioDAO {
    private Connection connection;
     //Contrutor - classe de uma classe, executa um comando antes de uma classe ser executada
    public PatrimonioDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Patrimonio patrimonio){
        String sql = "INSERT INTO patrimonio(fkidtipopatrimonio, numero, systemdate "
                + " VALUES (?,?,?)";
        try {
            //prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, patrimonio.getFkidtipopatrimonio());
            stmt.setInt(2, patrimonio.getNumero());
            stmt.setString(3,patrimonio.getSystemdate());
            
            //Executa:
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void pesquisarTipo(Patrimonio patrimonio){
        try {
            Tipopatrimonio tipopatrimonio = new Tipopatrimonio();
            PreparedStatement stmt = this.connection.prepareStatement("select idpatrimonio, "
                    + "tipopatrimonio.tipo, "
                    + "numero, "
                    + "DATE_TIME(systemdate, '%d-%m-%Y às %H:%i:%s') "
                    + "INNER JOIN tipopatrimonio ON tipopatrimonio.id=patrimonio.fkidpatrimonio "
                    + " from patrimonio where"
                    + " tipopatrimonio.tipo like '"
                    +tipopatrimonio.getTipo()+"';");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                patrimonio.setIdpatrimonio(rs.getInt("idpatrimonio"));
                tipopatrimonio.setTipo(rs.getString("tipopatrimonio.tipo"));
                patrimonio.setNumero(rs.getInt("numero"));
                patrimonio.setSystemdate(rs.getString("DATE_FORMAT(systemdate, '%d-%m-%Y às %H:%i:%s')"));
            }
//            tst.close();
            rs.close();
            stmt.close();
//            teste.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
        public void pesquisarNumero(Patrimonio patrimonio){
        try {
            Tipopatrimonio tipopatrimonio = new Tipopatrimonio();
            PreparedStatement stmt = this.connection.prepareStatement("select idpatrimonio, "
                    + "tipopatrimonio.tipo, "
                    + "numero, "
                    + "DATE_TIME(systemdate, '%d-%m-%Y às %H:%i:%s') "
                    + "INNER JOIN tipopatrimonio ON tipopatrimonio.id=patrimonio.fkidpatrimonio "
                    + " from patrimonio where"
                    + " numero like '"
                    +patrimonio.getNumero()+"';");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                patrimonio.setIdpatrimonio(rs.getInt("idpatrimonio"));
                tipopatrimonio.setTipo(rs.getString("tipopatrimonio.tipo"));
                patrimonio.setNumero(rs.getInt("numero"));
                patrimonio.setSystemdate(rs.getString("DATE_FORMAT(systemdate, '%d-%m-%Y às %H:%i:%s')"));
            }
//            tst.close();
            rs.close();
            stmt.close();
//            teste.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void alterar(Patrimonio patrimonio){
        String sql = "update patrimonio set fkidpatrimonio=?, "
                + "numero=?, "
                + "systemdate=?"
                +" where idpatrimonio=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, patrimonio.getFkidtipopatrimonio());
            stmt.setInt(2, patrimonio.getNumero());
            stmt.setString(3, patrimonio.getSystemdate());
            stmt.setInt(4, patrimonio.getIdpatrimonio());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletar(Patrimonio patrimonio){
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from patrimonio where idpatrimonio=?");
            stmt.setInt(1, patrimonio.getIdpatrimonio());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Patrimonio> getLista(){
        try {
            List<Patrimonio> patrimonios = new ArrayList<Patrimonio>();
            Tipopatrimonio tipopatrimonio = new Tipopatrimonio();
            PreparedStatement stmt = this.connection.prepareStatement
                    ("select idpatrimonio, "
                    + "tipopatrimonio.tipo, "
                    + "numero, "
                    + "DATE_TIME(systemdate, '%d-%m-%Y às %H:%i:%s') "
                    + "INNER JOIN tipopatrimonio ON tipopatrimonio.id=patrimonio.fkidpatrimonio "
                    + " from patrimonio;");
            //PreparedStatement teste = this.connection.prepareStatement("select tipousuario from tipousuario inner join usuario on usuario.fkidtipousuario = tipousuario.idtipousuario where usuario.fkidtipousuario like ?;");
                             
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Patrimonio patrimonio = new Patrimonio();

                patrimonio.setIdpatrimonio(rs.getInt("idpatrimonio"));
                tipopatrimonio.setTipo(rs.getString("tipopatrimonio.tipo"));
                patrimonio.setNumero(rs.getInt("numero"));
                patrimonio.setSystemdate(rs.getString("DATE_FORMAT(systemdate, '%d-%m-%Y às %H:%i:%s')"));
               
                
                
                //Adicionando o objeto a lista
                patrimonios.add(patrimonio);
            } 
            rs.close();
            stmt.close();
            return  patrimonios;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
 
    
    public void RelatorioDePatrimonios() throws JRException, SQLException {
        JasperReport report = JasperCompileManager
                .compileReport("relatorios/report1.jrxml"); //criar relatório...
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(getLista()));
        JasperExportManager.exportReportToPdfFile(print, "relatorios/report1.pdf");
        System.out.println("Relatório gerado!");
    }    
}


