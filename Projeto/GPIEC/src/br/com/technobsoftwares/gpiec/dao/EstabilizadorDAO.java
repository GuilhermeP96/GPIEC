/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;import br.com.technobsoftwares.gpiec.modelo.Estabilizador;
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
public class EstabilizadorDAO {
    private Connection connection;
     //Contrutor - classe de uma classe, executa um comando antes de uma classe ser executada
    public EstabilizadorDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Estabilizador estabilizador){
        String sql = "INSERT INTO estabilizador(modelo"
                + " VALUES (?)";
        try {
            //prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, estabilizador.getModelo());
            
            //Executa:
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void pesquisarModelo(Estabilizador estabilizador){
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select idestabilizador, modelo, from estabilizador where"
                    + " estabilizador.modelo like '"
                    +estabilizador.getModelo()+"';");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                estabilizador.setIdestabilizador(rs.getInt("idestabilizador"));
                estabilizador.setModelo(rs.getString("modelo"));
            }
//            tst.close();
            rs.close();
            stmt.close();
//            teste.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void alterar(Estabilizador estabilizador){
        String sql = "update estabilizador set modelo=?"
                +" where idestabilizador=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, estabilizador.getModelo());
            stmt.setInt(2, estabilizador.getIdestabilizador());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletar(Estabilizador estabilizador){
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from estabilizador where idestabilizador=?");
            stmt.setInt(1, estabilizador.getIdestabilizador());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Estabilizador> getLista(){
        try {
            List<Estabilizador> estabilizadores = new ArrayList<Estabilizador>();
            PreparedStatement stmt = this.connection.prepareStatement("select idestabilizador, modelo" 
            +"FROM estabilizador;");
            //PreparedStatement teste = this.connection.prepareStatement("select tipousuario from tipousuario inner join usuario on usuario.fkidtipousuario = tipousuario.idtipousuario where usuario.fkidtipousuario like ?;");
                             
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Estabilizador estabilizador = new Estabilizador();

                estabilizador.setIdestabilizador(rs.getInt("idestabilizador"));
                estabilizador.setModelo(rs.getString("modelo"));
               
                
                
                //Adicionando o objeto a lista
                estabilizadores.add(estabilizador);
            } 
            rs.close();
            stmt.close();
            return  estabilizadores;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
 
    
    public void RelatorioDeEstabilizadores() throws JRException, SQLException {
        JasperReport report = JasperCompileManager
                .compileReport("relatorios/report1.jrxml"); //criar relatório...
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(getLista()));
        JasperExportManager.exportReportToPdfFile(print, "relatorios/report1.pdf");
        System.out.println("Relatório gerado!");
    }    
}

