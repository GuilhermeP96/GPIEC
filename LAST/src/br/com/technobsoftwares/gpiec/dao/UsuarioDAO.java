/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;
import br.com.technobsoftwares.gpiec.formulario.FrmInCadUser;
import br.com.technobsoftwares.gpiec.formulario.FrmMenuAdmin;
import br.com.technobsoftwares.gpiec.modelo.Tipo_Usuario;
import br.com.technobsoftwares.gpiec.modelo.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author lab
 */
public class UsuarioDAO {
    public static int t;
    public static String a;
    public static int idloginuser;
    public static String loginuser;
    
    public static boolean cad_user;
    public static boolean cad_grupo;
    public static boolean cad_patrimonio;
    public static boolean cad_local;
    public static boolean cad_soft;
    public static boolean cad_hard;
    public static boolean cons_user;
    public static boolean cons_grupo;
    public static boolean cons_patrimonio;
    public static boolean cons_local;
    public static boolean cons_soft;
    public static boolean cons_hard;
    public static boolean relat_user;
    public static boolean relat_grupo;
    public static boolean relat_patrimonio;
    public static boolean relat_local;
    public static boolean relat_soft;
    public static boolean relat_hard;
    public static boolean abrir_os;
    public static boolean fechar_os;
    public static boolean edit_os;
    public static boolean relat_os;
//    public static int teste_id_tuser;                
                
    //Connection é uma classe do java que esta vazia 
    private Connection connection;
     //Contrutor - classe de uma classe, executa um comando antes de uma classe ser executada
    public UsuarioDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
//    public void pesquisa_grupo(Usuario usuario){
//        try {
//            PreparedStatement teste = this.connection.prepareStatement("SELECT idtipousuario FROM tipousuario WHERE nomepc LIKE '"+FrmInCadUser.nometipouser+"';");
//
//            ResultSet rs = teste.executeQuery();
//            
//            while(rs.next()){
//                Tipo_Usuario tu = new Tipo_Usuario();
//                teste_id_tuser = rs.getInt("idtipousuario");
//            }
//            
//            teste.close();
//            rs.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    
    public void adiciona(Usuario usuario){
        String sql = "INSERT INTO usuario(fkidtipousuario, nome, sobrenome, cpf, telefone, email,"
                + " login, senha, fkddd) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            //prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, usuario.getFk_tipo_user());
            stmt.setString(2, usuario.getNome_user());
            stmt.setString(3, usuario.getSobrenome_user());
            stmt.setString(4, usuario.getCpf_user());
            stmt.setString(5, usuario.getTel_user());
            stmt.setString(6, usuario.getEmail_user());
            stmt.setString(7, usuario.getLogin_user());
            stmt.setString(8, usuario.getSenha_user());
            stmt.setInt(9, usuario.getFk_ddd());
            
            //Executa:
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void pesquisar(Usuario usuario){
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select idusuario, nome, sobrenome, cpf, email, telefone, fkidtipousuario, date_format(systemdate, '%d-%m-%Y'), login from usuario where"
                    + " idusuario like "
                    +usuario.getId_user());
//            PreparedStatement teste = this.connection.prepareStatement("select * from usuario inner join ddd where fkddd like idddd ="
//                    +usuario.getId_user());
            ResultSet rs = stmt.executeQuery();
//            ResultSet tst = teste.executeQuery();
            while (rs.next()){

                usuario.setId_user(rs.getInt("idusuario"));
                usuario.setNome_user(rs.getString("nome"));
                usuario.setSobrenome_user(rs.getString("sobrenome"));
                usuario.setCpf_user(rs.getString("cpf"));
                usuario.setEmail_user(rs.getString("email"));
                usuario.setTel_user(rs.getString("telefone"));           
                usuario.setFk_tipo_user(rs.getInt("fkidtipousuario"));
                usuario.setData_cad(rs.getString("date_format(systemdate, '%d-%m-%Y')"));
                usuario.setLogin_user(rs.getString("login"));
//                usuario.setFk_ddd(tst.getInt("ddd"));
            }
//            tst.close();
            rs.close();
            stmt.close();
//            teste.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void pesquisarNome(Usuario usuario){
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select idusuario, nome, sobrenome, cpf, email, telefone, fkidtipousuario, date_format(systemdate, '%d-%m-%Y'), login from usuario where"
                    + " usuario.nome like '"
                    +usuario.getNome_user()+"';");
//            PreparedStatement teste = this.connection.prepareStatement("select * from usuario inner join ddd where fkddd like idddd ="
//                    +usuario.getId_user());
            ResultSet rs = stmt.executeQuery();
//            ResultSet tst = teste.executeQuery();
            while (rs.next()){

                usuario.setId_user(rs.getInt("idusuario"));
                usuario.setNome_user(rs.getString("nome"));
                usuario.setSobrenome_user(rs.getString("sobrenome"));
                usuario.setCpf_user(rs.getString("cpf"));
                usuario.setEmail_user(rs.getString("email"));
                usuario.setTel_user(rs.getString("telefone"));           
                usuario.setFk_tipo_user(rs.getInt("fkidtipousuario"));
                usuario.setData_cad(rs.getString("date_format(systemdate, '%d-%m-%Y')"));
                usuario.setLogin_user(rs.getString("login"));
//                usuario.setFk_ddd(tst.getInt("ddd"));
            }
//            tst.close();
            rs.close();
            stmt.close();
//            teste.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void logar(Usuario usuario, JFrame frame){
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select * from usuario where login like ? "
                    + "and senha like ?");
            PreparedStatement teste = this.connection.prepareStatement("select tipousuario from tipousuario inner join usuario on usuario.fkidtipousuario = tipousuario.idtipousuario where usuario.fkidtipousuario like ?;");
            
            
            stmt.setString(1, usuario.getLogin_user());
            stmt.setString(2, usuario.getSenha_user());
            
            //preferencias_grupo.setString(1, usuario.getLogin_user());
            
            ResultSet rs = stmt.executeQuery();

            
           if (rs.next()) {
                t = rs.getInt("fkidtipousuario");
                idloginuser = rs.getInt("idusuario");
                loginuser = rs.getString("login");
                JOptionPane.showMessageDialog(null, "Bem vindo Administrador(a) " + usuario.getLogin_user());
                frame.dispose();
                FrmMenuAdmin menuadmin = new FrmMenuAdmin();
                menuadmin.show();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Usuário não encontrado!",
                    JOptionPane.ERROR_MESSAGE);
            }
           
            PreparedStatement preferencias_grupo = this.connection.prepareStatement("select * from tipousuario inner join usuario on usuario.fkidtipousuario = tipousuario.idtipousuario where usuario.login like '"+usuario.getLogin_user()+"';");

           
            teste.setInt(1, t);
           
            ResultSet ts = teste.executeQuery();

            if (ts.next()) {
                a = ts.getString("tipousuario");
            }
            
            
            ResultSet gs = preferencias_grupo.executeQuery();
            if (gs.next()) {
                
                cad_user = gs.getBoolean("cad_user");
                cad_grupo = gs.getBoolean("cad_grupo");
                cad_patrimonio = gs.getBoolean("cad_patrimonio");
                cad_local = gs.getBoolean("cad_local");
                cad_soft = gs.getBoolean("cad_soft");
                cad_hard = gs.getBoolean("cad_hard");
                cons_user = gs.getBoolean("cons_user");
                cons_grupo = gs.getBoolean("cons_grupo");
                cons_patrimonio = gs.getBoolean("cons_patrimonio");
                cons_local = gs.getBoolean("cons_local");
                cons_soft = gs.getBoolean("cons_soft");
                cons_hard = gs.getBoolean("cons_hard");               
                relat_user = gs.getBoolean("edit_user");
                relat_grupo = gs.getBoolean("edit_grupo");
                relat_patrimonio = gs.getBoolean("edit_patrimonio");
                relat_local = gs.getBoolean("edit_local");
                relat_soft = gs.getBoolean("edit_soft");
                relat_hard = gs.getBoolean("edit_hard");
                abrir_os = gs.getBoolean("abrir_os");
                fechar_os = gs.getBoolean("fechar_os");
                edit_os = gs.getBoolean("edit_os");
                relat_os = gs.getBoolean("relat_os");

                
            }
            
            gs.close();
            preferencias_grupo.close();
            rs.close();
            stmt.close();
            ts.close();
            teste.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void alterar(Usuario usuario){
        String sql = "update usuario set nome=?,"+" sobrenome=?,"+" cpf=?,"+" email=?,"+
                " fkidtipousuario=?,"+" telefone=?,"+" login=? "+" where idusuario=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, usuario.getNome_user());
            stmt.setString(2, usuario.getSobrenome_user());
            stmt.setString(3, usuario.getCpf_user());
            stmt.setString(4, usuario.getEmail_user());
            stmt.setInt(5, usuario.getFk_tipo_user());
            stmt.setString(6, usuario.getTel_user());
            stmt.setString(7, usuario.getLogin_user());
            stmt.setInt(8, usuario.getId_user());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletar(Usuario usuario){
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from usuario where idusuario=?");
            stmt.setInt(1, usuario.getId_user());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Usuario> getLista(){
        try {
            List<Usuario> usuarios = new ArrayList<Usuario>();
            PreparedStatement stmt = this.connection.prepareStatement("select idusuario, tipousuario.tipousuario, nome, sobrenome, cpf, telefone, email, date_format(systemdate, '%d-%m-%Y'), login, senha\n" +
"	FROM usuario\n" +
"		INNER JOIN tipousuario ON usuario.fkidtipousuario=tipousuario.idtipousuario;");
            //PreparedStatement teste = this.connection.prepareStatement("select tipousuario from tipousuario inner join usuario on usuario.fkidtipousuario = tipousuario.idtipousuario where usuario.fkidtipousuario like ?;");
                             
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Usuario usuario = new Usuario();

                usuario.setId_user(rs.getInt("idusuario"));
                usuario.setNome_user(rs.getString("nome"));
                usuario.setSobrenome_user(rs.getString("sobrenome"));
                usuario.setCpf_user(rs.getString("cpf"));
                usuario.setEmail_user(rs.getString("email"));
                usuario.setData_cad(rs.getString("date_format(systemdate, '%d-%m-%Y')"));
                usuario.setLogin_user(rs.getString("login"));
                usuario.setTel_user(rs.getString("telefone"));
                usuario.setFk_tipo(rs.getString("tipousuario"));
                
                
                //Adicionando o objeto a lista
                usuarios.add(usuario);
            } 
            rs.close();
            stmt.close();
            return  usuarios;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
}
