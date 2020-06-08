/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.teste;

import br.com.technobsoftwares.gpiec.ConnectionFactory;

/**
 *
 * @author A01
 */
public class TesteConexao {
    public static void main (String [] args)
    {
        new ConnectionFactory().getConnection();
        System.out.println("Conexão criada com sucesso.");
    }
}
