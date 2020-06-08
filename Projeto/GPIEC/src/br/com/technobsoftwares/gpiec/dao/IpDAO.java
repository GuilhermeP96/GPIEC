/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;import br.com.technobsoftwares.gpiec.modelo.Ip;
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
public class IpDAO {
    private Connection connection;
     //Contrutor - classe de uma classe, executa um comando antes de uma classe ser executada
    public IpDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Ip ip){
        String sql = "INSERT INTO ip(ip"
                + " VALUES (?)";
        try {
            //prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, ip.getIp());
            
            //Executa:
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void pesquisar(Ip ip){
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select ip where"
                    + " ip like "
                    +ip.getIdip());

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                ip.setIp(rs.getString("ip"));
            }
//            tst.close();
            rs.close();
            stmt.close();
//            teste.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void alterar(Ip ip){
        String sql = "update ip set ip=?"
                +" where idip=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, ip.getIp());
            stmt.setInt(2, ip.getIdip());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletar(Ip ip){
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from ip where idip=?");
            stmt.setInt(1, ip.getIdip());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Ip> getLista(){
        try {
            List<Ip> ips = new ArrayList<Ip>();
            PreparedStatement stmt = this.connection.prepareStatement("select ip " 
            +"FROM ip;");
            //PreparedStatement teste = this.connection.prepareStatement("select tipousuario from tipousuario inner join usuario on usuario.fkidtipousuario = tipousuario.idtipousuario where usuario.fkidtipousuario like ?;");
                             
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Ip ip = new Ip();

                ip.setIp(rs.getString("ip"));
               
                
                
                //Adicionando o objeto a lista
                ips.add(ip);
            } 
            rs.close();
            stmt.close();
            return  ips;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    } 
}

