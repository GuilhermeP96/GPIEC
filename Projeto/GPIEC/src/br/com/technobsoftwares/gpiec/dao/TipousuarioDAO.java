/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;
import br.com.technobsoftwares.gpiec.formulario.FrmInCadUser;
import br.com.technobsoftwares.gpiec.modelo.Tipousuario;
import br.com.technobsoftwares.gpiec.modelo.Usuario;
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
 * @author lab
 */
public class TipousuarioDAO {
    public static int teste_id_grupos;
    
    //Connection é uma classe do java que esta vazia 
    private Connection connection;
     //Contrutor - classe de uma classe, executa um comando antes de uma classe ser executada
    public TipousuarioDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void pesquisa_grupo(Tipousuario tipo_usuario){
        try {
            PreparedStatement teste = this.connection.prepareStatement("SELECT idtipousuario FROM tipousuario WHERE tipousuario LIKE '"+FrmInCadUser.nome_grupo+"';");

            ResultSet rs = teste.executeQuery();
            
            while(rs.next()){
                Tipousuario tuser = new Tipousuario();
                teste_id_grupos = rs.getInt("idtipousuario");
            }
            
            teste.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void pesquisar(Tipousuario tipo_usuario){
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from tipousuario where idtipousuario ="
                    +tipo_usuario.getId_tipouser());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                //Criando o objeto cliente
                tipo_usuario.setId_tipouser(rs.getInt("idtipousuario"));
                tipo_usuario.setTipo_user(rs.getString("tipousuario"));               
                tipo_usuario.setCad_user(rs.getBoolean("cad_user"));
                tipo_usuario.setCad_grupo(rs.getBoolean("cad_grupo"));
                tipo_usuario.setCad_patrimonio(rs.getBoolean("cad_patrimonio"));
                tipo_usuario.setCad_local(rs.getBoolean("cad_local"));
                tipo_usuario.setCad_soft(rs.getBoolean("cad_soft"));
                tipo_usuario.setCad_hard(rs.getBoolean("cad_hard"));               
                tipo_usuario.setCons_user(rs.getBoolean("cons_user"));
                tipo_usuario.setCons_grupo(rs.getBoolean("cons_grupo"));
                tipo_usuario.setCons_patrimonio(rs.getBoolean("cons_patrimonio"));
                tipo_usuario.setCons_local(rs.getBoolean("cons_local"));
                tipo_usuario.setCons_soft(rs.getBoolean("cons_soft"));
                tipo_usuario.setCons_hard(rs.getBoolean("cons_hard"));               
                tipo_usuario.setEdit_user(rs.getBoolean("edit_user"));
                tipo_usuario.setEdit_grupo(rs.getBoolean("edit_grupo"));
                tipo_usuario.setEdit_patrimonio(rs.getBoolean("edit_patrimonio"));
                tipo_usuario.setEdit_local(rs.getBoolean("edit_local"));
                tipo_usuario.setEdit_soft(rs.getBoolean("edit_soft"));
                tipo_usuario.setEdit_hard(rs.getBoolean("edit_hard"));                
                tipo_usuario.setAbrir_os(rs.getBoolean("abrir_os"));
                tipo_usuario.setFechar_os(rs.getBoolean("fechar_os"));
                tipo_usuario.setEdit_os(rs.getBoolean("edit_os"));
                tipo_usuario.setRelat_os(rs.getBoolean("relat_os"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Tipousuario> getLista(){
        try {
            List<Tipousuario> tipo_usuarios = new ArrayList<Tipousuario>();
            PreparedStatement stmt = this.connection.prepareStatement("select idtipousuario, tipousuario, COUNT(usuario.fkidtipousuario) from tipousuario\n" +
"INNER JOIN usuario ON usuario.fkidtipousuario=tipousuario.idtipousuario GROUP BY idtipousuario;");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Tipousuario tipo_usuario = new Tipousuario();
                tipo_usuario.setId_tipouser(rs.getInt("idtipousuario"));
                tipo_usuario.setTipo_user(rs.getString("tipousuario"));
                tipo_usuario.setQtduser(rs.getInt("COUNT(usuario.fkidtipousuario)"));
                //Adicionando o objeto a lista
                tipo_usuarios.add(tipo_usuario);
            }
            rs.close();
            stmt.close();
            return  tipo_usuarios;
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }
    
    public void adiciona(Tipousuario tipo_usuario){
        String sql = "INSERT INTO tipousuario(tipousuario, cad_user, cad_grupo, cad_patrimonio, cad_local, cad_soft, cad_hard,"
                + " cons_user, cons_grupo, cons_patrimonio, cons_local, cons_soft, cons_hard,"
                    + " edit_user, edit_grupo, edit_patrimonio, edit_local, edit_soft, edit_hard,"
                        + " abrir_os, fechar_os, edit_os, relat_os) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            //prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, tipo_usuario.getTipo_user());
            stmt.setBoolean(2, tipo_usuario.isCad_user());
            stmt.setBoolean(3, tipo_usuario.isCad_grupo());
            stmt.setBoolean(4, tipo_usuario.isCad_patrimonio());
            stmt.setBoolean(5, tipo_usuario.isCad_local());
            stmt.setBoolean(6, tipo_usuario.isCad_soft());
            stmt.setBoolean(7, tipo_usuario.isCad_hard());
            stmt.setBoolean(8, tipo_usuario.isCons_user());
            stmt.setBoolean(9, tipo_usuario.isCons_grupo());
            stmt.setBoolean(10, tipo_usuario.isCons_patrimonio());
            stmt.setBoolean(11, tipo_usuario.isCons_local());
            stmt.setBoolean(12, tipo_usuario.isCons_soft());
            stmt.setBoolean(13, tipo_usuario.isCons_hard());
            stmt.setBoolean(14, tipo_usuario.isEdit_user());
            stmt.setBoolean(15, tipo_usuario.isEdit_grupo());
            stmt.setBoolean(16, tipo_usuario.isEdit_patrimonio());
            stmt.setBoolean(17, tipo_usuario.isEdit_local());
            stmt.setBoolean(18, tipo_usuario.isEdit_soft());
            stmt.setBoolean(19, tipo_usuario.isEdit_hard());
            stmt.setBoolean(20, tipo_usuario.isAbrir_os());
            stmt.setBoolean(21, tipo_usuario.isFechar_os());
            stmt.setBoolean(22, tipo_usuario.isEdit_os());
            stmt.setBoolean(23, tipo_usuario.isRelat_os());
            
            
            //Executa:
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void alterar(Tipousuario tipo_usuario){       
        String sql = "update tipousuario set tipousuario=?, cad_user=?, cad_grupo=?, cad_patrimonio=?, cad_local=?, cad_soft=?, cad_hard=?,"
                + " cons_user=?, cons_grupo=?, cons_patrimonio=?, cons_local=?, cons_soft=?, cons_hard=?,"
                    + " edit_user=?, edit_grupo=?, edit_patrimonio=?, edit_local=?, edit_soft=?, edit_hard=?,"
                        + " abrir_os=?, fechar_os=?, edit_os=?, relat_os=? where idtipousuario=?;";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, tipo_usuario.getTipo_user());
            stmt.setBoolean(2, tipo_usuario.isCad_user());
            stmt.setBoolean(3, tipo_usuario.isCad_grupo());
            stmt.setBoolean(4, tipo_usuario.isCad_patrimonio());
            stmt.setBoolean(5, tipo_usuario.isCad_local());
            stmt.setBoolean(6, tipo_usuario.isCad_soft());
            stmt.setBoolean(7, tipo_usuario.isCad_hard());
            stmt.setBoolean(8, tipo_usuario.isCons_user());
            stmt.setBoolean(9, tipo_usuario.isCons_grupo());
            stmt.setBoolean(10, tipo_usuario.isCons_patrimonio());
            stmt.setBoolean(11, tipo_usuario.isCons_local());
            stmt.setBoolean(12, tipo_usuario.isCons_soft());
            stmt.setBoolean(13, tipo_usuario.isCons_hard());
            stmt.setBoolean(14, tipo_usuario.isEdit_user());
            stmt.setBoolean(15, tipo_usuario.isEdit_grupo());
            stmt.setBoolean(16, tipo_usuario.isEdit_patrimonio());
            stmt.setBoolean(17, tipo_usuario.isEdit_local());
            stmt.setBoolean(18, tipo_usuario.isEdit_soft());
            stmt.setBoolean(19, tipo_usuario.isEdit_hard());
            stmt.setBoolean(20, tipo_usuario.isAbrir_os());
            stmt.setBoolean(21, tipo_usuario.isFechar_os());
            stmt.setBoolean(22, tipo_usuario.isEdit_os());
            stmt.setBoolean(23, tipo_usuario.isRelat_os());  
            stmt.setInt(24, tipo_usuario.getId_tipouser());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void deletar(Tipousuario tipo_usuario){
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from tipousuario where idtipousuario=?");
            stmt.setInt(1, tipo_usuario.getId_tipouser());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void RelatorioUsuariosGrupo() throws JRException, SQLException {
        JasperReport report = JasperCompileManager
                .compileReport("relatorios/reportTipoUsuario.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(getLista()));
        JasperExportManager.exportReportToPdfFile(print, "relatorios/reportTipoUsuario.pdf");
        System.out.println("Relatório gerado!");
    }    
    
    public void ChamaRelUsuariosGrupo(){
        try {
            java.awt.Desktop.getDesktop().open(new File("relatorios/reportTipoUsuario.pdf"));           
        } catch (Exception e) {
            System.out.println("Deu ruim! / "+e);
        }
    }
}


