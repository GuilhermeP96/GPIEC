/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;
import br.com.technobsoftwares.gpiec.formulario.FrmInAbreOS;
import br.com.technobsoftwares.gpiec.modelo.Computador;
import br.com.technobsoftwares.gpiec.modelo.Local;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ComputadorDAO {  
    private Connection connection;
    
    public ComputadorDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public List<Computador> getLista(){
        try {
            Local local = new Local();
            List<Computador> pcs = new ArrayList<Computador>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from pc inner join local_2 on fkidlocal_2 = idlocal_2 where fkidlocal_2 like "+FrmInAbreOS.os);  
            
            //stmt.setInt(1, local.getId_local());
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {                
                //Criando o objeto Contato
                Computador pc = new Computador();
                
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
