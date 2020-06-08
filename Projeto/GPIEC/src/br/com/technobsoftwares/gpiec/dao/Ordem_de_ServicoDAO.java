/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;
import br.com.technobsoftwares.gpiec.formulario.FrmInAbreOS;
import br.com.technobsoftwares.gpiec.formulario.FrmInMinhasOS;
import br.com.technobsoftwares.gpiec.formulario.FrmMenuAdmin;
import br.com.technobsoftwares.gpiec.modelo.Ordem_de_Servico;
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
public class Ordem_de_ServicoDAO {
    public static int teste_id_os, teste_id_servico;
    UsuarioDAO loginp = new UsuarioDAO();

    private Connection connection;
    
    public Ordem_de_ServicoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void pesquisa_pc(Ordem_de_Servico ordem_servico){
        try {
            PreparedStatement teste = this.connection.prepareStatement("SELECT idpc FROM pc WHERE nomepc LIKE '"+FrmInAbreOS.nome_pc+"';");

            ResultSet rs = teste.executeQuery();
            
            while(rs.next()){
                Ordem_de_Servico os = new Ordem_de_Servico();
                teste_id_os = rs.getInt("idpc");
            }
            
            teste.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void pesquisa_servico(Ordem_de_Servico ordem_servico){
        try {
            PreparedStatement teste = this.connection.prepareStatement("SELECT idtipoproblema FROM tipoproblema WHERE tipoproblema LIKE '"+FrmInAbreOS.nome_servico+"';");

            ResultSet rs = teste.executeQuery();
            
            while(rs.next()){
                Ordem_de_Servico os = new Ordem_de_Servico();
                teste_id_servico = rs.getInt("idtipoproblema");
            }
            
            teste.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void adiciona(Ordem_de_Servico ordem_servico){
        try{
            String sql = "INSERT INTO ordemservico(fkidpc, fkidusuario, fkidtipoproblema, fkidstatusos, tituloproblema, "
                    + "detalhesproblema) VALUES (?,?,?,?,?,?);";
           
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, ordem_servico.getFk_id_pc());
            stmt.setInt(2, ordem_servico.getFk_id_usuario());
            stmt.setInt(3, ordem_servico.getFk_id_tipo_problema());
            stmt.setInt(4, ordem_servico.getFk_id_status());
            stmt.setString(5, ordem_servico.getTitulo_os());
            stmt.setString(6, ordem_servico.getDetalhes_os());            
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void pesquisar(Ordem_de_Servico os){
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select idordemservico AS 'Código',\n" +
"		local_2.local_2 AS 'Local', \n" +
"		pc.nomepc AS 'Computador',\n" +
"		usuario.login AS 'User',\n" +
"		tipoproblema.tipoproblema AS 'Serviço',\n" +
"		tituloproblema AS 'Título',\n" +
"		detalhesproblema AS 'Descrição',\n" +
"		DATE_FORMAT(ordemservico.systemdate, '%d/%m/%Y') AS 'Data de Entrada',\n" +
"		statusos.situacao AS 'Status',\n" +
"		data_fechamento AS 'Data de Fechamento',\n" +
"		ordemservico.comentariosfechamento AS 'Comentário'\n" +                    
"		FROM ordemservico\n" +
"		INNER JOIN local_2 INNER JOIN pc\n" +
"		ON ordemservico.fkidpc=pc.idpc AND local_2.idlocal_2=pc.fkidlocal_2\n" +
"		INNER JOIN usuario\n" +
"		ON usuario.idusuario = ordemservico.fkidusuario\n" +
"		INNER JOIN tipoproblema\n" +
"		ON tipoproblema.idtipoproblema = ordemservico.fkidtipoproblema\n" +
"		INNER JOIN statusos\n" +
"		ON statusos.idstatusos = ordemservico.fkidstatusos" +
"		WHERE ordemservico.idordemservico like "+os.getId_ordem_servico()+" AND usuario.login like '"+loginp.loginuser+"';");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                os.setId_ordem_servico(rs.getInt("Código"));
                os.setFk_pc(rs.getString("Computador"));
                os.setFk_usuario(rs.getString("User"));
                os.setFk_tipo_problema(rs.getString("Serviço"));
                os.setFk_status(rs.getString("Status"));
                os.setTitulo_os(rs.getString("Título"));
                os.setDetalhes_os(rs.getString("Descrição"));           
                os.setData_entrada(rs.getString("Data de Entrada"));
                if (!"Fechada".equals(os.getFk_status())) {
                    os.setData_fechamento("NÃO FINALIZADA");
                }else{
                    os.setData_fechamento(rs.getString("Data de Fechamento"));
                }               
                os.setLocal_os(rs.getString("Local"));
                if ("NÃO FINALIZADA".equals(os.getData_fechamento())) {
                    os.setComentarios_fechamento("NÃO FINALIZADA");
                }               
                else if ("".equals(rs.getString("Comentário"))) {
                    os.setComentarios_fechamento("NENHUM COMENTÁRIO");
                }else{
                    os.setComentarios_fechamento(rs.getString("Comentário"));
                }
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void pesquisarNaoFechadas(Ordem_de_Servico os){
        try {
            PreparedStatement stmt = this.connection.prepareStatement("select idordemservico AS 'Código',\n" +
"		local_2.local_2 AS 'Local', \n" +
"		pc.nomepc AS 'Computador',\n" +
"		usuario.login AS 'User',\n" +
"		tipoproblema.tipoproblema AS 'Serviço',\n" +
"		tituloproblema AS 'Título',\n" +
"		detalhesproblema AS 'Descrição',\n" +
"		DATE_FORMAT(ordemservico.systemdate, '%d/%m/%Y') AS 'Data de Entrada',\n" +
"		statusos.situacao AS 'Status',\n" +
"		data_fechamento AS 'Data de Fechamento',\n" +
"		ordemservico.comentariosfechamento AS 'Comentário'\n" +                    
"		FROM ordemservico\n" +
"		INNER JOIN local_2 INNER JOIN pc\n" +
"		ON ordemservico.fkidpc=pc.idpc AND local_2.idlocal_2=pc.fkidlocal_2\n" +
"		INNER JOIN usuario\n" +
"		ON usuario.idusuario = ordemservico.fkidusuario\n" +
"		INNER JOIN tipoproblema\n" +
"		ON tipoproblema.idtipoproblema = ordemservico.fkidtipoproblema\n" +
"		INNER JOIN statusos\n" +
"		ON statusos.idstatusos = ordemservico.fkidstatusos" +
"		WHERE ordemservico.idordemservico = "+os.getId_ordem_servico()+" and statusos.situacao like 'Aberta' or ordemservico.idordemservico = "+os.getId_ordem_servico()+" and statusos.situacao like 'Em andamento'");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                os.setId_ordem_servico(rs.getInt("Código"));
                os.setFk_pc(rs.getString("Computador"));
                os.setFk_usuario(rs.getString("User"));
                os.setFk_tipo_problema(rs.getString("Serviço"));
                os.setFk_status(rs.getString("Status"));
                os.setTitulo_os(rs.getString("Título"));
                os.setDetalhes_os(rs.getString("Descrição"));           
                os.setData_entrada(rs.getString("Data de Entrada"));
                if (!"Fechada".equals(os.getFk_status())) {
                    os.setData_fechamento("NÃO FINALIZADA");
                }else{
                    os.setData_fechamento(rs.getString("Data de Fechamento"));
                }               
                os.setLocal_os(rs.getString("Local"));
                if ("NÃO FINALIZADA".equals(os.getData_fechamento())) {
                    os.setComentarios_fechamento("NÃO FINALIZADA");
                }               
                else if ("".equals(rs.getString("Comentário"))) {
                    os.setComentarios_fechamento("NENHUM COMENTÁRIO");
                }else{
                    os.setComentarios_fechamento(rs.getString("Comentário"));
                }
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Ordem_de_Servico> getListaMinhasOs(){
        try {
            List<Ordem_de_Servico> oss = new ArrayList<Ordem_de_Servico>();
            PreparedStatement stmt = this.connection.prepareStatement("select idordemservico AS 'Código',\n" +
"		local_2.local_2 AS 'Local', \n" +
"		pc.nomepc AS 'Computador',\n" +
"		usuario.login AS 'User',\n" +
"		tipoproblema.tipoproblema AS 'Serviço',\n" +
"		tituloproblema AS 'Título',\n" +
"		detalhesproblema AS 'Descrição',\n" +
"		DATE_FORMAT(ordemservico.systemdate, '%d/%m/%Y') AS 'Data de Entrada',\n" +
"		statusos.situacao AS 'Status',\n" +
"		data_fechamento AS 'Data de Fechamento',\n" +
"		ordemservico.comentariosfechamento AS 'Comentário'\n" +                         
"		FROM ordemservico\n" +
"		INNER JOIN local_2 INNER JOIN pc\n" +
"		ON ordemservico.fkidpc=pc.idpc AND local_2.idlocal_2=pc.fkidlocal_2\n" +
"		INNER JOIN usuario\n" +
"		ON usuario.idusuario = ordemservico.fkidusuario\n" +
"		INNER JOIN tipoproblema\n" +
"		ON tipoproblema.idtipoproblema = ordemservico.fkidtipoproblema\n" +
"		INNER JOIN statusos\n" +
"		ON statusos.idstatusos = ordemservico.fkidstatusos" +
"		WHERE usuario.login like '"+loginp.loginuser+"';");
                             
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Ordem_de_Servico os = new Ordem_de_Servico();

                os.setId_ordem_servico(rs.getInt("Código"));
                os.setFk_pc(rs.getString("Computador"));
                os.setFk_usuario(rs.getString("User"));
                os.setFk_tipo_problema(rs.getString("Serviço"));
                os.setFk_status(rs.getString("Status"));
                os.setTitulo_os(rs.getString("Título"));
                os.setDetalhes_os(rs.getString("Descrição"));           
                os.setData_entrada(rs.getString("Data de Entrada"));
                if (!"Fechada".equals(os.getFk_status())) {
                    os.setData_fechamento("NÃO FINALIZADA");
                }else{
                    os.setData_fechamento(rs.getString("Data de Fechamento"));
                } 
                os.setLocal_os(rs.getString("Local")); 
                
                if ("NÃO FINALIZADA".equals(os.getData_fechamento())) {
                    os.setComentarios_fechamento("NÃO FINALIZADA");
                }               
                else if ("".equals(rs.getString("Comentário"))) {
                    os.setComentarios_fechamento("NENHUM COMENTÁRIO");
                }else{
                    os.setComentarios_fechamento(rs.getString("Comentário"));
                }
                
                //Adicionando o objeto a lista
                oss.add(os);
            } 
            rs.close();
            stmt.close();
            return  oss;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
    
    public List<Ordem_de_Servico> getListaNaoFechadas(){
        try {
            List<Ordem_de_Servico> oss = new ArrayList<Ordem_de_Servico>();
            PreparedStatement stmt = this.connection.prepareStatement("select idordemservico AS 'Código',\n" +
"		local_2.local_2 AS 'Local', \n" +
"		pc.nomepc AS 'Computador',\n" +
"		usuario.login AS 'User',\n" +
"		tipoproblema.tipoproblema AS 'Serviço',\n" +
"		tituloproblema AS 'Título',\n" +
"		detalhesproblema AS 'Descrição',\n" +
"		DATE_FORMAT(ordemservico.systemdate, '%d/%m/%Y') AS 'Data de Entrada',\n" +
"		statusos.situacao AS 'Status'\n" +
"		FROM ordemservico\n" +
"		INNER JOIN local_2 INNER JOIN pc\n" +
"		ON ordemservico.fkidpc=pc.idpc AND local_2.idlocal_2=pc.fkidlocal_2\n" +
"		INNER JOIN usuario\n" +
"		ON usuario.idusuario = ordemservico.fkidusuario\n" +
"		INNER JOIN tipoproblema\n" +
"		ON tipoproblema.idtipoproblema = ordemservico.fkidtipoproblema\n" +
"		INNER JOIN statusos\n" +
"		ON statusos.idstatusos = ordemservico.fkidstatusos\n" +
"		WHERE statusos.situacao like 'Aberta' or statusos.situacao like 'Em andamento';");
                             
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Ordem_de_Servico os = new Ordem_de_Servico();

                os.setId_ordem_servico(rs.getInt("Código"));
                os.setFk_pc(rs.getString("Computador"));
                os.setFk_usuario(rs.getString("User"));
                os.setFk_tipo_problema(rs.getString("Serviço"));
                os.setFk_status(rs.getString("Status"));
                os.setTitulo_os(rs.getString("Título"));
                os.setDetalhes_os(rs.getString("Descrição"));           
                os.setData_entrada(rs.getString("Data de Entrada"));
//                if (!"Fechada".equals(os.getFk_status())) {
//                    os.setData_fechamento("NÃO FINALIZADA");
//                }else{
//                    os.setData_fechamento(rs.getString("Data de Fechamento"));
//                } 
                os.setLocal_os(rs.getString("Local"));                
                
                //Adicionando o objeto a lista
                oss.add(os);
            } 
            rs.close();
            stmt.close();
            return  oss;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
    
    public List<Ordem_de_Servico> getListaOs(){
        try {
            List<Ordem_de_Servico> oss = new ArrayList<Ordem_de_Servico>();
            PreparedStatement stmt = this.connection.prepareStatement("select idordemservico AS 'Código',\n" +
"		local_2.local_2 AS 'Local', \n" +
"		pc.nomepc AS 'Computador',\n" +
"		usuario.login AS 'User',\n" +
"		tipoproblema.tipoproblema AS 'Serviço',\n" +
"		tituloproblema AS 'Título',\n" +
"		detalhesproblema AS 'Descrição',\n" +
"		DATE_FORMAT(ordemservico.systemdate, '%d/%m/%Y') AS 'Data de Entrada',\n" +
"		statusos.situacao AS 'Status',\n" +
"		data_fechamento AS 'Data de Fechamento',\n" +
"		ordemservico.comentariosfechamento AS 'Comentário'\n" +                         
"		FROM ordemservico\n" +
"		INNER JOIN local_2 INNER JOIN pc\n" +
"		ON ordemservico.fkidpc=pc.idpc AND local_2.idlocal_2=pc.fkidlocal_2\n" +
"		INNER JOIN usuario\n" +
"		ON usuario.idusuario = ordemservico.fkidusuario\n" +
"		INNER JOIN tipoproblema\n" +
"		ON tipoproblema.idtipoproblema = ordemservico.fkidtipoproblema\n" +
"		INNER JOIN statusos\n" +
"		ON statusos.idstatusos = ordemservico.fkidstatusos ORDER BY idordemservico;");
                             
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Ordem_de_Servico os = new Ordem_de_Servico();

                os.setId_ordem_servico(rs.getInt("Código"));
                os.setFk_pc(rs.getString("Computador"));
                os.setFk_usuario(rs.getString("User"));
                os.setFk_tipo_problema(rs.getString("Serviço"));
                os.setFk_status(rs.getString("Status"));
                os.setTitulo_os(rs.getString("Título"));
                os.setDetalhes_os(rs.getString("Descrição"));           
                os.setData_entrada(rs.getString("Data de Entrada"));
                if (!"Fechada".equals(os.getFk_status())) {
                    os.setData_fechamento("NÃO FINALIZADA");
                }else{
                    os.setData_fechamento(rs.getString("Data de Fechamento"));
                } 
                os.setLocal_os(rs.getString("Local")); 
                
                if ("NÃO FINALIZADA".equals(os.getData_fechamento())) {
                    os.setComentarios_fechamento("NÃO FINALIZADA");
                }               
                else if ("".equals(rs.getString("Comentário"))) {
                    os.setComentarios_fechamento("NENHUM COMENTÁRIO");
                }else{
                    os.setComentarios_fechamento(rs.getString("Comentário"));
                }
                
                //Adicionando o objeto a lista
                oss.add(os);
            } 
            rs.close();
            stmt.close();
            return  oss;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    } 

    public List<Ordem_de_Servico> getListaOsUsuarios(){
        try {
            List<Ordem_de_Servico> oss = new ArrayList<Ordem_de_Servico>();
            PreparedStatement stmt = this.connection.prepareStatement("select idordemservico AS 'Código',\n" +
"		local_2.local_2 AS 'Local', \n" +
"		pc.nomepc AS 'Computador',\n" +
"		usuario.login AS 'User',\n" +
"		tipoproblema.tipoproblema AS 'Serviço',\n" +
"		tituloproblema AS 'Título',\n" +
"		detalhesproblema AS 'Descrição',\n" +
"		DATE_FORMAT(ordemservico.systemdate, '%d/%m/%Y') AS 'Data de Entrada',\n" +
"		statusos.situacao AS 'Status',\n" +
"		data_fechamento AS 'Data de Fechamento',\n" +
"		ordemservico.comentariosfechamento AS 'Comentário'\n" +                         
"		FROM ordemservico\n" +
"		INNER JOIN local_2 INNER JOIN pc\n" +
"		ON ordemservico.fkidpc=pc.idpc AND local_2.idlocal_2=pc.fkidlocal_2\n" +
"		INNER JOIN usuario\n" +
"		ON usuario.idusuario = ordemservico.fkidusuario\n" +
"		INNER JOIN tipoproblema\n" +
"		ON tipoproblema.idtipoproblema = ordemservico.fkidtipoproblema\n" +
"		INNER JOIN statusos\n" +
"		ON statusos.idstatusos = ordemservico.fkidstatusos" +
"		WHERE usuario.login like '"+FrmMenuAdmin.nome_usuario_relat+"';");
                             
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Ordem_de_Servico os = new Ordem_de_Servico();

                os.setId_ordem_servico(rs.getInt("Código"));
                os.setFk_pc(rs.getString("Computador"));
                os.setFk_usuario(rs.getString("User"));
                os.setFk_tipo_problema(rs.getString("Serviço"));
                os.setFk_status(rs.getString("Status"));
                os.setTitulo_os(rs.getString("Título"));
                os.setDetalhes_os(rs.getString("Descrição"));           
                os.setData_entrada(rs.getString("Data de Entrada"));
                if (!"Fechada".equals(os.getFk_status())) {
                    os.setData_fechamento("NÃO FINALIZADA");
                }else{
                    os.setData_fechamento(rs.getString("Data de Fechamento"));
                } 
                os.setLocal_os(rs.getString("Local")); 
                
                if ("NÃO FINALIZADA".equals(os.getData_fechamento())) {
                    os.setComentarios_fechamento("NÃO FINALIZADA");
                }               
                else if ("".equals(rs.getString("Comentário"))) {
                    os.setComentarios_fechamento("NENHUM COMENTÁRIO");
                }else{
                    os.setComentarios_fechamento(rs.getString("Comentário"));
                }
                
                //Adicionando o objeto a lista
                oss.add(os);
            } 
            rs.close();
            stmt.close();
            return  oss;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
    
    public List<Ordem_de_Servico> getListaOsStatus(){
        try {
            List<Ordem_de_Servico> oss = new ArrayList<Ordem_de_Servico>();
            PreparedStatement stmt = this.connection.prepareStatement("select idordemservico AS 'Código',\n" +
"		local_2.local_2 AS 'Local', \n" +
"		pc.nomepc AS 'Computador',\n" +
"		usuario.login AS 'User',\n" +
"		tipoproblema.tipoproblema AS 'Serviço',\n" +
"		tituloproblema AS 'Título',\n" +
"		detalhesproblema AS 'Descrição',\n" +
"		DATE_FORMAT(ordemservico.systemdate, '%d/%m/%Y') AS 'Data de Entrada',\n" +
"		statusos.situacao AS 'Status',\n" +
"		data_fechamento AS 'Data de Fechamento',\n" +
"		ordemservico.comentariosfechamento AS 'Comentário'\n" +                         
"		FROM ordemservico\n" +
"		INNER JOIN local_2 INNER JOIN pc\n" +
"		ON ordemservico.fkidpc=pc.idpc AND local_2.idlocal_2=pc.fkidlocal_2\n" +
"		INNER JOIN usuario\n" +
"		ON usuario.idusuario = ordemservico.fkidusuario\n" +
"		INNER JOIN tipoproblema\n" +
"		ON tipoproblema.idtipoproblema = ordemservico.fkidtipoproblema\n" +
"		INNER JOIN statusos\n" +
"		ON statusos.idstatusos = ordemservico.fkidstatusos" +
"		WHERE statusos.situacao like '"+FrmMenuAdmin.nome_os_status_relat+"';");
                             
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Ordem_de_Servico os = new Ordem_de_Servico();

                os.setId_ordem_servico(rs.getInt("Código"));
                os.setFk_pc(rs.getString("Computador"));
                os.setFk_usuario(rs.getString("User"));
                os.setFk_tipo_problema(rs.getString("Serviço"));
                os.setFk_status(rs.getString("Status"));
                os.setTitulo_os(rs.getString("Título"));
                os.setDetalhes_os(rs.getString("Descrição"));           
                os.setData_entrada(rs.getString("Data de Entrada"));
                if (!"Fechada".equals(os.getFk_status())) {
                    os.setData_fechamento("NÃO FINALIZADA");
                }else{
                    os.setData_fechamento(rs.getString("Data de Fechamento"));
                } 
                os.setLocal_os(rs.getString("Local")); 
                
                if ("NÃO FINALIZADA".equals(os.getData_fechamento())) {
                    os.setComentarios_fechamento("NÃO FINALIZADA");
                }               
                else if ("".equals(rs.getString("Comentário"))) {
                    os.setComentarios_fechamento("NENHUM COMENTÁRIO");
                }else{
                    os.setComentarios_fechamento(rs.getString("Comentário"));
                }
                
                //Adicionando o objeto a lista
                oss.add(os);
            } 
            rs.close();
            stmt.close();
            return  oss;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
    
    public List<Ordem_de_Servico> getListaOsTipoServico(){
        try {
            List<Ordem_de_Servico> oss = new ArrayList<Ordem_de_Servico>();
            PreparedStatement stmt = this.connection.prepareStatement("select idordemservico AS 'Código',\n" +
"		local_2.local_2 AS 'Local', \n" +
"		pc.nomepc AS 'Computador',\n" +
"		usuario.login AS 'User',\n" +
"		tipoproblema.tipoproblema AS 'Serviço',\n" +
"		tituloproblema AS 'Título',\n" +
"		detalhesproblema AS 'Descrição',\n" +
"		DATE_FORMAT(ordemservico.systemdate, '%d/%m/%Y') AS 'Data de Entrada',\n" +
"		statusos.situacao AS 'Status',\n" +
"		data_fechamento AS 'Data de Fechamento',\n" +
"		ordemservico.comentariosfechamento AS 'Comentário'\n" +                         
"		FROM ordemservico\n" +
"		INNER JOIN local_2 INNER JOIN pc\n" +
"		ON ordemservico.fkidpc=pc.idpc AND local_2.idlocal_2=pc.fkidlocal_2\n" +
"		INNER JOIN usuario\n" +
"		ON usuario.idusuario = ordemservico.fkidusuario\n" +
"		INNER JOIN tipoproblema\n" +
"		ON tipoproblema.idtipoproblema = ordemservico.fkidtipoproblema\n" +
"		INNER JOIN statusos\n" +
"		ON statusos.idstatusos = ordemservico.fkidstatusos" +
"		WHERE tipoproblema.tipoproblema like '"+FrmMenuAdmin.nome_os_tproblema_relat+"';");
                             
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Ordem_de_Servico os = new Ordem_de_Servico();

                os.setId_ordem_servico(rs.getInt("Código"));
                os.setFk_pc(rs.getString("Computador"));
                os.setFk_usuario(rs.getString("User"));
                os.setFk_tipo_problema(rs.getString("Serviço"));
                os.setFk_status(rs.getString("Status"));
                os.setTitulo_os(rs.getString("Título"));
                os.setDetalhes_os(rs.getString("Descrição"));           
                os.setData_entrada(rs.getString("Data de Entrada"));
                if (!"Fechada".equals(os.getFk_status())) {
                    os.setData_fechamento("NÃO FINALIZADA");
                }else{
                    os.setData_fechamento(rs.getString("Data de Fechamento"));
                } 
                os.setLocal_os(rs.getString("Local")); 
                
                if ("NÃO FINALIZADA".equals(os.getData_fechamento())) {
                    os.setComentarios_fechamento("NÃO FINALIZADA");
                }               
                else if ("".equals(rs.getString("Comentário"))) {
                    os.setComentarios_fechamento("NENHUM COMENTÁRIO");
                }else{
                    os.setComentarios_fechamento(rs.getString("Comentário"));
                }
                
                //Adicionando o objeto a lista
                oss.add(os);
            } 
            rs.close();
            stmt.close();
            return  oss;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
    
    public void pega(Ordem_de_Servico os){
        String sql = "update ordemservico set fkidstatusos=? where idordemservico=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, os.getFk_id_status());
            stmt.setInt(2, os.getId_ordem_servico());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void fecha(Ordem_de_Servico os){
        String sql = "update ordemservico set fkidstatusos=?, comentariosfechamento=?, data_fechamento=? where idordemservico=?;";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, os.getFk_id_status());
            stmt.setString(2, os.getComentarios_fechamento());
            stmt.setString(3, os.getData_fechamento());
            stmt.setInt(4, os.getId_ordem_servico());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void RelatorioDeOsUsuarios() throws JRException, SQLException {
        JasperReport report = JasperCompileManager
                .compileReport("relatorios/reportOsUsuario.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(getListaOsUsuarios()));
        JasperExportManager.exportReportToPdfFile(print, "relatorios/reportOsUsuario.pdf");
        System.out.println("Relatório gerado!");
    }    
    
    public void ChamaRelOsUsuarios(){
        try {
            java.awt.Desktop.getDesktop().open(new File("relatorios/reportOsUsuario.pdf"));           
        } catch (Exception e) {
            System.out.println("Deu ruim! / "+e);
        }
    }
    
    public void RelatorioDeOs() throws JRException, SQLException {
        JasperReport report = JasperCompileManager
                .compileReport("relatorios/reportOsUsuario.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(getListaOs()));
        JasperExportManager.exportReportToPdfFile(print, "relatorios/reportOsUsuario.pdf");
        System.out.println("Relatório gerado!");
    }    
    
    public void ChamaRelOs(){
        try {
            java.awt.Desktop.getDesktop().open(new File("relatorios/reportOsUsuario.pdf"));           
        } catch (Exception e) {
            System.out.println("Deu ruim! / "+e);
        }
    }
    
    public void RelatorioDeOsNaoFechadas() throws JRException, SQLException {
        JasperReport report = JasperCompileManager
                .compileReport("relatorios/reportOsNaoFechadas.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(getListaNaoFechadas()));
        JasperExportManager.exportReportToPdfFile(print, "relatorios/reportOsNaoFechadas.pdf");
        System.out.println("Relatório gerado!");
    }    
    
    public void ChamaRelOsNaoFechadas(){
        try {
            java.awt.Desktop.getDesktop().open(new File("relatorios/reportOsNaoFechadas.pdf"));           
        } catch (Exception e) {
            System.out.println("Deu ruim! / "+e);
        }
    }
    
    public void RelatorioDeOsStatus() throws JRException, SQLException {  
        JasperReport report = JasperCompileManager
                .compileReport("relatorios/reportOsUsuario.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(getListaOsStatus()));
        JasperExportManager.exportReportToPdfFile(print, "relatorios/reportOsUsuario.pdf");
        System.out.println("Relatório gerado!");
    }    
    
    public void ChamaRelOsStatus(){
        try {
            java.awt.Desktop.getDesktop().open(new File("relatorios/reportOsUsuario.pdf"));           
        } catch (Exception e) {
            System.out.println("Deu ruim! / "+e);
        }
    }
    
    public void RelatorioDeOsTipoServico() throws JRException, SQLException {  
        JasperReport report = JasperCompileManager
                .compileReport("relatorios/reportOsUsuario.jrxml");
        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(getListaOsTipoServico()));
        JasperExportManager.exportReportToPdfFile(print, "relatorios/reportOsUsuario.pdf");
        System.out.println("Relatório gerado!");
    }    
    
    public void ChamaRelOsTipoServico(){
        try {
            java.awt.Desktop.getDesktop().open(new File("relatorios/reportOsUsuario.pdf"));           
        } catch (Exception e) {
            System.out.println("Deu ruim! / "+e);
        }
    }
}
