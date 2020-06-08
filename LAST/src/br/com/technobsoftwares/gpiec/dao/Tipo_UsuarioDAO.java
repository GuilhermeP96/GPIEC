/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;
import br.com.technobsoftwares.gpiec.modelo.Tipo_Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lab
 */
public class Tipo_UsuarioDAO {
    //Connection é uma classe do java que esta vazia 
    private Connection connection;
     //Contrutor - classe de uma classe, executa um comando antes de uma classe ser executada
    public Tipo_UsuarioDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void pesquisar(Tipo_Usuario tipo_usuario){
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
    
    public List<Tipo_Usuario> getLista(){
        try {
            List<Tipo_Usuario> tipo_usuarios = new ArrayList<Tipo_Usuario>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from tipousuario");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Tipo_Usuario tipo_usuario = new Tipo_Usuario();
                tipo_usuario.setId_tipouser(rs.getInt("idtipousuario"));
                tipo_usuario.setTipo_user(rs.getString("tipousuario"));
                
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
    
    public void adiciona(Tipo_Usuario tipo_usuario){
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
    
    public void alterar(Tipo_Usuario tipo_usuario){
//        String sql = "update tipousuario set tipousuario=?,"+" cad_user=?,"+" cad_grupo=?,"+" cad_patrimonio=?,"+" cad_local=?,"+" cad_soft=?,"+" cad_hard=?,"
//                + " cons_user=?,"+" cons_grupo=?,"+" cons_patrimonio=?,"+" cons_local=?,"+" cons_soft=?,"+" cons_hard=?,"
//                    + " edit_user=?,"+" edit_grupo=?,"+" edit_patrimonio=?,"+" edit_local=?,"+" edit_soft=?,"+" edit_hard=?,"
//                        + " abrir_os=?,"+" fechar_os=?,"+" edit_os=?,"+" relat_os=?"+" where idtipousuario=?;";
        
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
    
    public void deletar(Tipo_Usuario tipo_usuario){
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from tipousuario where idtipousuario=?");
            stmt.setInt(1, tipo_usuario.getId_tipouser());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
