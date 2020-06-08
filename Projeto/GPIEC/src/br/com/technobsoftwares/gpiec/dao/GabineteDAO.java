/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;
import br.com.technobsoftwares.gpiec.Nseriegabinete;
import br.com.technobsoftwares.gpiec.modelo.Gabinete;
import br.com.technobsoftwares.gpiec.modelo.Hd;
import br.com.technobsoftwares.gpiec.modelo.Memoria;
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
public class GabineteDAO {
    private Connection connection;
     //Contrutor - classe de uma classe, executa um comando antes de uma classe ser executada
    public GabineteDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Gabinete gabinete){
        String sql = "INSERT INTO gabinete(nome,fkidhd, fkidmemoria,fkidprocessador,systemdate"
                + " VALUES (?,?,?,?,?)";
        try {
            //prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, gabinete.getNome());
            stmt.setInt(2, gabinete.getFkidhd());
            stmt.setInt(3, gabinete.getFkidmemoria());
            stmt.setInt(4, gabinete.getFkidprocessador());
            stmt.setString(5, gabinete.getSystemdate());
            
            //Executa:
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void pesquisar(Gabinete gabinete){
        try {
            
            PreparedStatement stmt = this.connection.prepareStatement("SELECT \n" +
                " nome "+    
                " hd.capacidade" +
                " memoria.tamanho" +
                " processador.nome" +
                " systemdate"+
                "  FROM gabinete \n" +
                "   INNER JOIN hd ON hd.idhd=gabinete.fkidhd \n" +
                "   INNER JOIN memoria ON memoria.idmemoria=gabinete.fkidmemoria \n" +
                "   INNER JOIN processador ON processador.idprocessador=gabinete.fkidprocessador\n" +
                "    WHERE gabinete.idgabinete like'"
                +gabinete.getIdgabinete()+"';");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                gabinete.setIdgabinete(rs.getInt("idgabinete"));
                gabinete.setNome(rs.getString("nome"));
                gabinete.setFkidhd(rs.getInt("fkidhd"));
                gabinete.setFkidmemoria(rs.getInt("fkidmemoria"));
                gabinete.setFkidprocessador(rs.getInt("fkidprocessador"));
                gabinete.setSystemdate(rs.getString("DATE_FORMAT(systemdate, '%d-%m-%Y')"));
            }
//            tst.close();
            rs.close();
            stmt.close();
//            teste.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void pesquisarNome(Gabinete gabinete){
        try {
            PreparedStatement stmt = this.connection.prepareStatement("SELECT \n" +
                " nome "+    
                " hd.capacidade" +
                " memoria.tamanho" +
                " processador.nome" +
                " systemdate"+
                "  FROM gabinete \n" +
                "   INNER JOIN hd ON hd.idhd=gabinete.fkidhd \n" +
                "   INNER JOIN memoria ON memoria.idmemoria=gabinete.fkidmemoria \n" +
                "   INNER JOIN processador ON processador.idprocessador=gabinete.fkidprocessador\n" +
                "    WHERE gabinete.nome like'"
                +gabinete.getNome()+"';");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                gabinete.setIdgabinete(rs.getInt("idgabinete"));
                gabinete.setNome(rs.getString("nome"));
                gabinete.setFkidhd(rs.getInt("fkidhd"));
                gabinete.setFkidmemoria(rs.getInt("fkidmemoria"));
                gabinete.setFkidprocessador(rs.getInt("fkidprocessador"));
                gabinete.setSystemdate(rs.getString("DATE_FORMAT(systemdate, '%d-%m-%Y')"));
            }
//            tst.close();
            rs.close();
            stmt.close();
//            teste.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void pesquisarCapHd(Gabinete gabinete){
        try {
            Hd hd = new Hd();
            PreparedStatement stmt = this.connection.prepareStatement("SELECT \n" +
                " nome "+    
                " hd.capacidade" +
                " memoria.tamanho" +
                " processador.nome" +
                " systemdate"+
                "  FROM gabinete \n" +
                "   INNER JOIN hd ON hd.idhd=gabinete.fkidhd \n" +
                "   INNER JOIN memoria ON memoria.idmemoria=gabinete.fkidmemoria \n" +
                "   INNER JOIN processador ON processador.idprocessador=gabinete.fkidprocessador\n" +
                "    WHERE hd.capacidade like'"
                +hd.getCapacidade()+"';");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                gabinete.setIdgabinete(rs.getInt("idgabinete"));
                gabinete.setNome(rs.getString("nome"));
                gabinete.setFkidhd(rs.getInt("fkidhd"));
                gabinete.setFkidmemoria(rs.getInt("fkidmemoria"));
                gabinete.setFkidprocessador(rs.getInt("fkidprocessador"));
                gabinete.setSystemdate(rs.getString("DATE_FORMAT(systemdate, '%d-%m-%Y')"));
            }
//            tst.close();
            rs.close();
            stmt.close();
//            teste.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void pesquisarTamMemoria(Gabinete gabinete){
        try {
            Memoria memoria = new Memoria();
            PreparedStatement stmt = this.connection.prepareStatement("SELECT \n" +
                " nome "+    
                " hd.capacidade" +
                " memoria.tamanho" +
                " processador.nome" +
                " systemdate"+
                "  FROM gabinete \n" +
                "   INNER JOIN hd ON hd.idhd=gabinete.fkidhd \n" +
                "   INNER JOIN memoria ON memoria.idmemoria=gabinete.fkidmemoria \n" +
                "   INNER JOIN processador ON processador.idprocessador=gabinete.fkidprocessador\n" +
                "    WHERE memoria.tamanho like'"
                +memoria.getTamanho()+"';");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){

                gabinete.setIdgabinete(rs.getInt("idgabinete"));
                gabinete.setNome(rs.getString("nome"));
                gabinete.setFkidhd(rs.getInt("fkidhd"));
                gabinete.setFkidmemoria(rs.getInt("fkidmemoria"));
                gabinete.setFkidprocessador(rs.getInt("fkidprocessador"));
                gabinete.setSystemdate(rs.getString("DATE_FORMAT(systemdate, '%d-%m-%Y')"));
            }
//            tst.close();
            rs.close();
            stmt.close();
//            teste.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void alterar(Gabinete gabinete){
        String sql = "update gabinete set nome=?, "+
                "fkidhd=?, "+
                "fkidmemoria=?, "+
                "fkidprocessador=?, "+
                "systemdate=? "+
                " where idgabinete=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, gabinete.getNome());
            stmt.setInt(2, gabinete.getFkidhd());
            stmt.setInt(3, gabinete.getFkidmemoria());
            stmt.setInt(4, gabinete.getFkidprocessador());
            stmt.setString(5, gabinete.getSystemdate());
            stmt.setInt(6, gabinete.getIdgabinete());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletar(Gabinete gabinete){
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from gabinete where idgabinete=?");
            stmt.setInt(1, gabinete.getIdgabinete());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Gabinete> getLista(){
        try {
            List<Gabinete> gabinetes = new ArrayList<Gabinete>();
            PreparedStatement stmt = this.connection.prepareStatement("select idgabinete, fkidhd, fkidmemoria,fkidprocessador, DATE_FORMAT(gabinete.systemdate, '%d/%m/%Y'), nseriegabinete.nseriefabricante FROM gabinete INNER JOIN nseriegabinete ON nseriegabinete.fkidgabinete = gabinete.idgabinete;");
            //PreparedStatement teste = this.connection.prepareStatement("select tipousuario from tipousuario inner join usuario on usuario.fkidtipousuario = tipousuario.idtipousuario where usuario.fkidtipousuario like ?;");
                             
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Gabinete gabinete = new Gabinete();
                Nseriegabinete nseriegabinete = new Nseriegabinete();

                gabinete.setIdgabinete(rs.getInt("idgabinete"));
                gabinete.setFkidhd(rs.getInt("fkidhd"));
                gabinete.setFkidhd(rs.getInt("fkidmemoria"));
                gabinete.setFkidhd(rs.getInt("fkidprocessador"));
                gabinete.setSystemdate(rs.getString("DATE_FORMAT(gabinete.systemdate, '%d/%m/%Y')"));
                nseriegabinete.setNseriefabricante(rs.getString("nseriefabricante"));
               
                
                
                //Adicionando o objeto a lista
                gabinetes.add(gabinete);
            } 
            rs.close();
            stmt.close();
            return  gabinetes;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
 
    
    public void RelatorioDeGabinetes() throws JRException, SQLException {
        JasperReport report = JasperCompileManager
                .compileReport("relatorios/report1.jrxml"); //criar relatório...
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(getLista()));
        JasperExportManager.exportReportToPdfFile(print, "relatorios/report1.pdf");
        System.out.println("Relatório gerado!");
    }    
}

