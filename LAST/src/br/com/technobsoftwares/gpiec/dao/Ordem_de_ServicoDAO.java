/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;
import br.com.technobsoftwares.gpiec.formulario.FrmInAbreOS;
import br.com.technobsoftwares.gpiec.formulario.FrmInMinhasOS;
import br.com.technobsoftwares.gpiec.modelo.Ordem_de_Servico;
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
public class Ordem_de_ServicoDAO {
    public static int teste_id_os;
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
"		ordemservico.systemdate AS 'Data de Entrada',\n" +
"		statusos.situacao AS 'Status',\n" +
"		data_fechamento AS 'Data de Fechamento'\n" +
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
            }
            
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Ordem_de_Servico> getLista(){
        try {
            List<Ordem_de_Servico> oss = new ArrayList<Ordem_de_Servico>();
            PreparedStatement stmt = this.connection.prepareStatement("select idordemservico AS 'Código',\n" +
"		local_2.local_2 AS 'Local', \n" +
"		pc.nomepc AS 'Computador',\n" +
"		usuario.login AS 'User',\n" +
"		tipoproblema.tipoproblema AS 'Serviço',\n" +
"		tituloproblema AS 'Título',\n" +
"		detalhesproblema AS 'Descrição',\n" +
"		ordemservico.systemdate AS 'Data de Entrada',\n" +
"		statusos.situacao AS 'Status',\n" +
"		data_fechamento AS 'Data de Fechamento'\n" +
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
}
