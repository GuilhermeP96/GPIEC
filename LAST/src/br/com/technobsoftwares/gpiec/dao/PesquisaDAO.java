/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.dao;

import br.com.technobsoftwares.gpiec.ConnectionFactory;
import br.com.technobsoftwares.gpiec.formulario.FrmInConsUser;
import br.com.technobsoftwares.gpiec.modelo.Pesquisa;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;

/**
 *
 * @author lab
 */
public class PesquisaDAO {
    private Connection connection;
    public PesquisaDAO()
    {
        this.connection = new ConnectionFactory().getConnection();
    }
    public void pesquisar(Pesquisa pesquisa, JTextField txtpesquisa){
	TextAutoCompleter pes = new TextAutoCompleter(txtpesquisa);
	try {
	    PreparedStatement selecao = this.connection.prepareStatement("SELECT nome FROM usuario;");
            ResultSet rs =selecao.executeQuery();
	    while (rs.next()) {	
		pes.addItem(rs.getString("nome"));
	    }
	} catch (SQLException e) {
	     throw new RuntimeException(e);
	}
    }
    public void pesquisarSobrenome(Pesquisa pesquisa, JTextField txtpesquisa){
	TextAutoCompleter pes = new TextAutoCompleter(txtpesquisa);
	try {
	    PreparedStatement selecao = this.connection.prepareStatement("SELECT sobrenome FROM usuario;");
            ResultSet rs =selecao.executeQuery();
	    while (rs.next()) {	
		pes.addItem(rs.getString("sobrenome"));
	    }
	} catch (SQLException e) {
	     throw new RuntimeException(e);
	}
    }
}
