/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;
import br.com.technobsoftwares.gpiec.formulario.FrmInOpcoes;
import br.com.technobsoftwares.gpiec.formulario.FrmMenuAdmin;
import br.com.technobsoftwares.gpiec.modelo.Usuario;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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


    public boolean isCad_user() {
        return cad_user;
    }

    public void setCad_user(boolean cad_user) {
        this.cad_user = cad_user;
    }

    public boolean isCad_grupo() {
        return cad_grupo;
    }

    public void setCad_grupo(boolean cad_grupo) {
        this.cad_grupo = cad_grupo;
    }

    public boolean isCad_patrimonio() {
        return cad_patrimonio;
    }

    public void setCad_patrimonio(boolean cad_patrimonio) {
        this.cad_patrimonio = cad_patrimonio;
    }

    public boolean isCad_local() {
        return cad_local;
    }

    public void setCad_local(boolean cad_local) {
        this.cad_local = cad_local;
    }

    public boolean isCad_soft() {
        return cad_soft;
    }

    public void setCad_soft(boolean cad_soft) {
        this.cad_soft = cad_soft;
    }

    public boolean isCad_hard() {
        return cad_hard;
    }

    public void setCad_hard(boolean cad_hard) {
        this.cad_hard = cad_hard;
    }

    public boolean isCons_user() {
        return cons_user;
    }

    public void setCons_user(boolean cons_user) {
        this.cons_user = cons_user;
    }

    public boolean isCons_grupo() {
        return cons_grupo;
    }

    public void setCons_grupo(boolean cons_grupo) {
        this.cons_grupo = cons_grupo;
    }

    public boolean isCons_patrimonio() {
        return cons_patrimonio;
    }

    public void setCons_patrimonio(boolean cons_patrimonio) {
        this.cons_patrimonio = cons_patrimonio;
    }

    public boolean isCons_local() {
        return cons_local;
    }

    public void setCons_local(boolean cons_local) {
        this.cons_local = cons_local;
    }

    public boolean isCons_soft() {
        return cons_soft;
    }

    public void setCons_soft(boolean cons_soft) {
        this.cons_soft = cons_soft;
    }

    public boolean isCons_hard() {
        return cons_hard;
    }

    public void setCons_hard(boolean cons_hard) {
        this.cons_hard = cons_hard;
    }

    public boolean isRelat_user() {
        return relat_user;
    }

    public void setRelat_user(boolean relat_user) {
        this.relat_user = relat_user;
    }

    public boolean isRelat_grupo() {
        return relat_grupo;
    }

    public void setRelat_grupo(boolean relat_grupo) {
        this.relat_grupo = relat_grupo;
    }

    public boolean isRelat_patrimonio() {
        return relat_patrimonio;
    }

    public void setRelat_patrimonio(boolean relat_patrimonio) {
        this.relat_patrimonio = relat_patrimonio;
    }

    public boolean isRelat_local() {
        return relat_local;
    }

    public void setRelat_local(boolean relat_local) {
        this.relat_local = relat_local;
    }

    public boolean isRelat_soft() {
        return relat_soft;
    }

    public void setRelat_soft(boolean relat_soft) {
        this.relat_soft = relat_soft;
    }

    public boolean isRelat_hard() {
        return relat_hard;
    }

    public void setRelat_hard(boolean relat_hard) {
        this.relat_hard = relat_hard;
    }

    public boolean isAbrir_os() {
        return abrir_os;
    }

    public void setAbrir_os(boolean abrir_os) {
        this.abrir_os = abrir_os;
    }

    public boolean isFechar_os() {
        return fechar_os;
    }

    public void setFechar_os(boolean fechar_os) {
        this.fechar_os = fechar_os;
    }

    public boolean isEdit_os() {
        return edit_os;
    }

    public void setEdit_os(boolean edit_os) {
        this.edit_os = edit_os;
    }

    public boolean isRelat_os() {
        return relat_os;
    }

    public void setRelat_os(boolean relat_os) {
        this.relat_os = relat_os;
    }

//    public static int teste_id_tuser;                
                
    //Connection é uma classe do java que esta vazia 
    private Connection connection;
     //Contrutor - classe de uma classe, executa um comando antes de uma classe ser executada
    public UsuarioDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
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
            UsuarioDAO dao = new UsuarioDAO();

            PreparedStatement stmt = this.connection.prepareStatement("select * from usuario where login like ? "
                    + "and senha like ?");
            PreparedStatement teste = this.connection.prepareStatement("select tipousuario from tipousuario inner join usuario on usuario.fkidtipousuario = tipousuario.idtipousuario where usuario.fkidtipousuario like ?;");
            PreparedStatement preferencias_grupo = this.connection.prepareStatement("select * from tipousuario inner join usuario on usuario.fkidtipousuario = tipousuario.idtipousuario where usuario.login like '"+usuario.getLogin_user()+"';");            
            
            stmt.setString(1, usuario.getLogin_user());
            stmt.setString(2, usuario.getSenha_user());
            
            //preferencias_grupo.setString(1, usuario.getLogin_user());
            
            FrmInOpcoes.senhaperman = usuario.getSenha_user();
            
            ResultSet rs = stmt.executeQuery();

            
           
            
            
            ResultSet gs = preferencias_grupo.executeQuery();
            if (gs.next()) {
                
                dao.setCad_user(gs.getBoolean("cad_user"));
                dao.setCad_grupo(gs.getBoolean("cad_grupo"));
                dao.setCad_patrimonio(gs.getBoolean("cad_patrimonio"));
                dao.setCad_local(gs.getBoolean("cad_local"));
                dao.setCad_soft(gs.getBoolean("cad_soft"));
                dao.setCad_hard(gs.getBoolean("cad_hard"));
                dao.setCons_user(gs.getBoolean("cons_user"));
                dao.setCons_grupo(gs.getBoolean("cons_grupo"));
                dao.setCons_patrimonio(gs.getBoolean("cons_patrimonio"));
                dao.setCons_local(gs.getBoolean("cons_local"));
                dao.setCons_soft(gs.getBoolean("cons_soft"));
                dao.setCons_hard(gs.getBoolean("cons_hard"));               
                dao.setRelat_user(gs.getBoolean("edit_user"));
                dao.setRelat_grupo(gs.getBoolean("edit_grupo"));
                dao.setRelat_patrimonio(gs.getBoolean("edit_patrimonio"));
                dao.setRelat_local(gs.getBoolean("edit_local"));
                dao.setRelat_soft(gs.getBoolean("edit_soft"));
                dao.setRelat_hard(gs.getBoolean("edit_hard"));
                dao.setAbrir_os(gs.getBoolean("abrir_os"));
                dao.setFechar_os(gs.getBoolean("fechar_os"));
                dao.setEdit_os(gs.getBoolean("edit_os"));
                dao.setRelat_os(gs.getBoolean("relat_os"));


                
            }
            
            if (rs.next()) {
                t = rs.getInt("fkidtipousuario");
                idloginuser = rs.getInt("idusuario");
                loginuser = rs.getString("login");               
                
                JOptionPane.showMessageDialog(null, "Bem vindo "+usuario.getLogin_user()+"!");
                frame.dispose();
                FrmMenuAdmin menuadmin = new FrmMenuAdmin();
                menuadmin.show();
            }else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado!", "Usuário não encontrado!",
                    JOptionPane.ERROR_MESSAGE);
            }
                     
            teste.setInt(1, t);
           
            ResultSet ts = teste.executeQuery();

            if (ts.next()) {
                a = ts.getString("tipousuario");
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
    
    public void alterar_Senha(Usuario usuario){
        String sql = "UPDATE usuario SET senha=? WHERE login LIKE ?;";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, FrmInOpcoes.senhaperman);
            stmt.setString(2, loginuser);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {  
            throw new RuntimeException(e);
        }
    }
    
    public List<Usuario> getListaUsuarioGrupo(){
        try {
            List<Usuario> usuarios = new ArrayList<Usuario>();
            PreparedStatement stmt = this.connection.prepareStatement("select idusuario, tipousuario.tipousuario, nome, sobrenome, cpf, telefone, email, date_format(systemdate, '%d-%m-%Y'), login, senha\n" +
"	FROM usuario\n" +
"		INNER JOIN tipousuario ON usuario.fkidtipousuario=tipousuario.idtipousuario where tipousuario.tipousuario like '"+FrmMenuAdmin.nome_grupo_usuario_relat+"';");
                             
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
    
    public void RelatorioDeUsuarios() throws JRException, SQLException {
        JasperReport report = JasperCompileManager
                .compileReport("relatorios/report1.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(getLista()));
        JasperExportManager.exportReportToPdfFile(print, "relatorios/report1.pdf");
        System.out.println("Relatório gerado!");
    }    
    
    public void ChamaRel(){
        try {
            java.awt.Desktop.getDesktop().open(new File("relatorios/report1.pdf"));           
        } catch (Exception e) {
            System.out.println("Deu ruim! / "+e);
        }
    }
    
    public void RelatorioUsuariosGrupo() throws JRException, SQLException {
        JasperReport report = JasperCompileManager
                .compileReport("relatorios/report4.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(getListaUsuarioGrupo()));
        JasperExportManager.exportReportToPdfFile(print, "relatorios/report4.pdf");
        System.out.println("Relatório gerado!");
    }    
    
    public void ChamaRelUsuariosGrupo(){
        try {
            java.awt.Desktop.getDesktop().open(new File("relatorios/report4.pdf"));           
        } catch (Exception e) {
            System.out.println("Deu ruim! / "+e);
        }
    }
}
