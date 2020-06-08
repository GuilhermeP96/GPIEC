/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;
import br.com.technobsoftwares.gpiec.formulario.FrmInAbreOS;
import br.com.technobsoftwares.gpiec.modelo.Pc;
import br.com.technobsoftwares.gpiec.modelo.Local_2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class PcDAO {  
    private Connection connection;
    public static int os;
    
    public PcDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void pesquisa_local(Local_2 local){
        try {
            PreparedStatement teste = this.connection.prepareStatement("SELECT idlocal_2 FROM local_2 WHERE local_2 LIKE '"+FrmInAbreOS.nome_local+"';");

            ResultSet rs = teste.executeQuery();
            
            while(rs.next()){
                os = rs.getInt("idlocal_2");
            }
            
            teste.close();
            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Pc> getLista(){
        try {
            Local_2 local = new Local_2();
            List<Pc> pcs = new ArrayList<Pc>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from pc inner join local_2 on fkidlocal_2 = idlocal_2 where fkidlocal_2 = "+os);  
            
            //stmt.setInt(1, local.getId_local());
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Pc pc = new Pc();
                
                pc.setId_pc(rs.getInt("idpc"));
                pc.setFk_id_mouse(rs.getInt("fkidmouse"));
                pc.setFk_id_teclado(rs.getInt("fkidteclado"));
                pc.setFk_id_num_serie_monitor(rs.getInt("fkidnseriemonitor"));
                pc.setFk_id_num_serie_estabilizador(rs.getInt("fkidnserieestabilizador"));
                pc.setFk_id_local(rs.getInt("fkidlocal_2"));
                pc.setFk_id_status(rs.getInt("fkidstatus_2"));
                pc.setFk_id_num_serie_gabinete(rs.getInt("fkidnseriegabinete"));
                pc.setNome_pc(rs.getString("nomepc"));
                
                //Adicionando o objeto a lista
                pcs.add(pc);
            }
            rs.close();
            stmt.close();
            return  pcs;
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
}
