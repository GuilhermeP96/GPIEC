/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.modelo;

/**
 *
 * @author lab
 */
public class Usuario {
    int id_user;
    private String nome_user;
    private String sobrenome_user;
    private String cpf_user;
    private String email_user;
    private String data_cad;
    private int fk_tipo_user;
    private String fk_tipo;
    private String tel_user;
    private String login_user;
    private String senha_user;
    private int fk_ddd;

    public String getFk_tipo() {
        return fk_tipo;
    }

    public void setFk_tipo(String fk_tipo) {
        this.fk_tipo = fk_tipo;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNome_user() {
        return nome_user;
    }

    public void setNome_user(String nome_user) {
        this.nome_user = nome_user;
    }

    public String getSobrenome_user() {
        return sobrenome_user;
    }

    public void setSobrenome_user(String sobrenome_user) {
        this.sobrenome_user = sobrenome_user;
    }

    public String getCpf_user() {
        return cpf_user;
    }

    public void setCpf_user(String cpf_user) {
        this.cpf_user = cpf_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getData_cad() {
        return data_cad;
    }

    public void setData_cad(String data_cad) {
        this.data_cad = data_cad;
    }

    public int getFk_tipo_user() {
        return fk_tipo_user;
    }

    public void setFk_tipo_user(int fk_tipo_user) {
        this.fk_tipo_user = fk_tipo_user;
    }

    public String getTel_user() {
        return tel_user;
    }

    public void setTel_user(String tel_user) {
        this.tel_user = tel_user;
    }

    public String getLogin_user() {
        return login_user;
    }

    public void setLogin_user(String login_user) {
        this.login_user = login_user;
    }

    public String getSenha_user() {
        return senha_user;
    }

    public void setSenha_user(String senha_user) {
        this.senha_user = senha_user;
    }

    public int getFk_ddd() {
        return fk_ddd;
    }

    public void setFk_ddd(int fk_ddd) {
        this.fk_ddd = fk_ddd;
    }
}
