/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.formulario;

import br.com.technobsoftwares.gpiec.dao.TipousuarioDAO;
import br.com.technobsoftwares.gpiec.modelo.Tipousuario;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class FrmInCadTipoUser extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmInCadTipoUser2
     */
    public FrmInCadTipoUser() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtNomeGrup = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnCanc = new javax.swing.JButton();
        btnLim = new javax.swing.JButton();
        btnCad = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        chcConsPatr = new javax.swing.JCheckBox();
        chcEditGrupo = new javax.swing.JCheckBox();
        chcEditPatr = new javax.swing.JCheckBox();
        chcCadUser = new javax.swing.JCheckBox();
        chcCadGrupo = new javax.swing.JCheckBox();
        chcConsUser = new javax.swing.JCheckBox();
        chcCadPatr = new javax.swing.JCheckBox();
        chcEditUser = new javax.swing.JCheckBox();
        chcConsGrupo = new javax.swing.JCheckBox();
        chcRelatOS = new javax.swing.JCheckBox();
        chcEditOS = new javax.swing.JCheckBox();
        chcAbrirOS = new javax.swing.JCheckBox();
        chcFecharOS = new javax.swing.JCheckBox();
        chcConsLocal = new javax.swing.JCheckBox();
        chcConsSoft = new javax.swing.JCheckBox();
        chcConsHard = new javax.swing.JCheckBox();
        chcEditLocal = new javax.swing.JCheckBox();
        chcEditSoft = new javax.swing.JCheckBox();
        chcEditHard = new javax.swing.JCheckBox();
        chcCadSoft = new javax.swing.JCheckBox();
        chcCadHard = new javax.swing.JCheckBox();
        chcCadLocal = new javax.swing.JCheckBox();
        chcTodas = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Grupo"));
        jPanel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel2TeclaPressionada(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNomeGrup.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNomeGrup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeGrupTeclaPressionada(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomeGrupFormatNomeGrupo(evt);
            }
        });
        txtNomeGrup.setDocument(new UpperCaseDocument());
        jPanel2.add(txtNomeGrup, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 150, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Nome do Grupo:*");
        jLabel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel1TeclaPressionada(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        btnCanc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCanc.setText("Sair");
        btnCanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancActionPerformed(evt);
            }
        });
        jPanel2.add(btnCanc, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 400, -1, 30));

        btnLim.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLim.setText("Limpar");
        btnLim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimActionPerformed(evt);
            }
        });
        jPanel2.add(btnLim, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, -1, 30));

        btnCad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCad.setText("Cadastrar");
        btnCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadActionPerformed(evt);
            }
        });
        jPanel2.add(btnCad, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 100, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Permissões de Usuários"));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel1TeclaPressionada(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chcConsPatr.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcConsPatr.setText("Consultar Patrimônios");
        jPanel1.add(chcConsPatr, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, -1, 30));

        chcEditGrupo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcEditGrupo.setText("Relatório Dados de Grupos");
        jPanel1.add(chcEditGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, 30));

        chcEditPatr.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcEditPatr.setText("Relatório Dados de Patrimônios");
        jPanel1.add(chcEditPatr, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, -1, 30));

        chcCadUser.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcCadUser.setText("Cadastrar Usuários");
        jPanel1.add(chcCadUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 30));

        chcCadGrupo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcCadGrupo.setText("Cadastrar Grupos");
        jPanel1.add(chcCadGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        chcConsUser.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcConsUser.setText("Consultar Usuários");
        jPanel1.add(chcConsUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, 30));

        chcCadPatr.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcCadPatr.setText("Cadastrar Patrimônios");
        jPanel1.add(chcCadPatr, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        chcEditUser.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcEditUser.setText("Relatório Dados de Usuários");
        jPanel1.add(chcEditUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, 30));

        chcConsGrupo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcConsGrupo.setText("Consultar Grupos");
        jPanel1.add(chcConsGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, 30));

        chcRelatOS.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcRelatOS.setText("Relatório de O.S");
        jPanel1.add(chcRelatOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, -1, 30));

        chcEditOS.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcEditOS.setText("Consultar O.S");
        jPanel1.add(chcEditOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, -1, 30));

        chcAbrirOS.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcAbrirOS.setText("Abrir O.S");
        jPanel1.add(chcAbrirOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, -1, 30));

        chcFecharOS.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcFecharOS.setText("Gerencia O.S ");
        jPanel1.add(chcFecharOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, -1, 30));

        chcConsLocal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcConsLocal.setText("Consultar Locais");
        jPanel1.add(chcConsLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, -1, 30));

        chcConsSoft.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcConsSoft.setText("Consultar Software");
        jPanel1.add(chcConsSoft, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, 30));

        chcConsHard.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcConsHard.setText("Consultar Hardware");
        jPanel1.add(chcConsHard, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, -1, 30));

        chcEditLocal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcEditLocal.setText("Relatório Dados de Locais");
        jPanel1.add(chcEditLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, -1, 30));

        chcEditSoft.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcEditSoft.setText("Relatório Dados de Softwares");
        jPanel1.add(chcEditSoft, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, -1, 30));

        chcEditHard.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcEditHard.setText("Relatório Dados de Hardwares");
        jPanel1.add(chcEditHard, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, -1, 30));

        chcCadSoft.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcCadSoft.setText("Cadastrar Software");
        jPanel1.add(chcCadSoft, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 30));

        chcCadHard.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcCadHard.setText("Cadastrar Hardware");
        jPanel1.add(chcCadHard, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, 30));

        chcCadLocal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcCadLocal.setText("Cadastrar Local");
        jPanel1.add(chcCadLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 30));

        chcTodas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        chcTodas.setText("Marcar/Desmarcar Todas");
        chcTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chcTodasActionPerformed(evt);
            }
        });
        jPanel1.add(chcTodas, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, -1, 30));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 74, 950, 290));

        jLabel2.setText("* = campos obrigatórios");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 9, 980, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeGrupTeclaPressionada(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeGrupTeclaPressionada
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnCadActionPerformed(null);
        }
    }//GEN-LAST:event_txtNomeGrupTeclaPressionada

    private void txtNomeGrupFormatNomeGrupo(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeGrupFormatNomeGrupo
        String caracteres="!@#$%¨&*()/\\*-+.,{}[]<>;:?°ºª'|\"=_`^~´¬§¢£³²¹°ºª";
        if(caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_txtNomeGrupFormatNomeGrupo

    private void jLabel1TeclaPressionada(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1TeclaPressionada
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnCadActionPerformed(null);
        }
    }//GEN-LAST:event_jLabel1TeclaPressionada

    private void btnCancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancActionPerformed

    private void btnLimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimActionPerformed
        txtNomeGrup.setText("");
        
        chcCadUser.setSelected(false);
        chcCadGrupo.setSelected(false);
        chcCadHard.setSelected(false);
        chcCadLocal.setSelected(false);
        chcCadPatr.setSelected(false);
        chcCadSoft.setSelected(false);
        chcCadUser.setSelected(false);

        chcConsGrupo.setSelected(false);
        chcConsHard.setSelected(false);
        chcConsLocal.setSelected(false);
        chcConsPatr.setSelected(false);
        chcConsSoft.setSelected(false);
        chcConsUser.setSelected(false);

        chcEditGrupo.setSelected(false);
        chcEditHard.setSelected(false);
        chcEditLocal.setSelected(false);
        chcEditPatr.setSelected(false);
        chcEditSoft.setSelected(false);
        chcEditUser.setSelected(false);

        chcAbrirOS.setSelected(false);
        chcFecharOS.setSelected(false);
        chcEditOS.setSelected(false);
        chcRelatOS.setSelected(false);

        chcTodas.setSelected(false);
        
        txtNomeGrup.requestFocus();
    }//GEN-LAST:event_btnLimActionPerformed

    private void btnCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadActionPerformed
        try {
            if ("".equals(txtNomeGrup.getText())) {
                JOptionPane.showMessageDialog(null, "Preencha o campo de nome do grupo!");
                txtNomeGrup.requestFocus();
            }
            else {
                Tipousuario tusuario = new Tipousuario();
                tusuario.setTipo_user(txtNomeGrup.getText());
                tusuario.setCad_user(chcCadUser.isSelected());
                tusuario.setCad_grupo(chcCadGrupo.isSelected());
                tusuario.setCad_patrimonio(chcCadPatr.isSelected());
                tusuario.setCad_local(chcCadLocal.isSelected());
                tusuario.setCad_soft(chcCadSoft.isSelected());
                tusuario.setCad_hard(chcCadHard.isSelected());
                tusuario.setCons_user(chcConsUser.isSelected());
                tusuario.setCons_grupo(chcConsGrupo.isSelected());
                tusuario.setCons_patrimonio(chcConsPatr.isSelected());
                tusuario.setCons_local(chcConsLocal.isSelected());
                tusuario.setCons_soft(chcConsSoft.isSelected());
                tusuario.setCons_hard(chcConsHard.isSelected());
                tusuario.setEdit_user(chcEditUser.isSelected());
                tusuario.setEdit_grupo(chcEditGrupo.isSelected());
                tusuario.setEdit_patrimonio(chcEditPatr.isSelected());
                tusuario.setEdit_local(chcEditLocal.isSelected());
                tusuario.setEdit_soft(chcEditSoft.isSelected());
                tusuario.setEdit_hard(chcEditHard.isSelected());
                tusuario.setAbrir_os(chcAbrirOS.isSelected());
                tusuario.setFechar_os(chcFecharOS.isSelected());
                tusuario.setEdit_os(chcEditOS.isSelected());
                tusuario.setRelat_os(chcRelatOS.isSelected());

                TipousuarioDAO dao = new TipousuarioDAO();
                // Método Elegante:
                dao.adiciona(tusuario);

                txtNomeGrup.setText(null);
                chcCadGrupo.setSelected(false);
                chcCadHard.setSelected(false);
                chcCadLocal.setSelected(false);
                chcCadPatr.setSelected(false);
                chcCadSoft.setSelected(false);
                chcCadUser.setSelected(false);

                chcConsGrupo.setSelected(false);
                chcConsHard.setSelected(false);
                chcConsLocal.setSelected(false);
                chcConsPatr.setSelected(false);
                chcConsSoft.setSelected(false);
                chcConsUser.setSelected(false);

                chcEditGrupo.setSelected(false);
                chcEditHard.setSelected(false);
                chcEditLocal.setSelected(false);
                chcEditPatr.setSelected(false);
                chcEditSoft.setSelected(false);
                chcEditUser.setSelected(false);

                chcAbrirOS.setSelected(false);
                chcFecharOS.setSelected(false);
                chcEditOS.setSelected(false);
                chcRelatOS.setSelected(false);

                chcTodas.setSelected(false);
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
                txtNomeGrup.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Grupo já cadastrado!");
        }
    }//GEN-LAST:event_btnCadActionPerformed

    private void chcTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chcTodasActionPerformed
        if (chcTodas.isSelected()) {
            chcCadGrupo.setSelected(true);
            chcCadHard.setSelected(true);
            chcCadLocal.setSelected(true);
            chcCadPatr.setSelected(true);
            chcCadSoft.setSelected(true);
            chcCadUser.setSelected(true);

            chcConsGrupo.setSelected(true);
            chcConsHard.setSelected(true);
            chcConsLocal.setSelected(true);
            chcConsPatr.setSelected(true);
            chcConsSoft.setSelected(true);
            chcConsUser.setSelected(true);

            chcEditGrupo.setSelected(true);
            chcEditHard.setSelected(true);
            chcEditLocal.setSelected(true);
            chcEditPatr.setSelected(true);
            chcEditSoft.setSelected(true);
            chcEditUser.setSelected(true);

            chcAbrirOS.setSelected(true);
            chcFecharOS.setSelected(true);
            chcEditOS.setSelected(true);
            chcRelatOS.setSelected(true);
        } else {
            chcCadUser.setSelected(false);
            chcCadGrupo.setSelected(false);
            chcCadHard.setSelected(false);
            chcCadLocal.setSelected(false);
            chcCadPatr.setSelected(false);
            chcCadSoft.setSelected(false);
            chcCadUser.setSelected(false);

            chcConsGrupo.setSelected(false);
            chcConsHard.setSelected(false);
            chcConsLocal.setSelected(false);
            chcConsPatr.setSelected(false);
            chcConsSoft.setSelected(false);
            chcConsUser.setSelected(false);

            chcEditGrupo.setSelected(false);
            chcEditHard.setSelected(false);
            chcEditLocal.setSelected(false);
            chcEditPatr.setSelected(false);
            chcEditSoft.setSelected(false);
            chcEditUser.setSelected(false);

            chcAbrirOS.setSelected(false);
            chcFecharOS.setSelected(false);
            chcEditOS.setSelected(false);
            chcRelatOS.setSelected(false);
        }
    }//GEN-LAST:event_chcTodasActionPerformed

    private void jPanel1TeclaPressionada(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1TeclaPressionada
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnCadActionPerformed(null);
        }
    }//GEN-LAST:event_jPanel1TeclaPressionada

    private void jPanel2TeclaPressionada(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel2TeclaPressionada
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnCadActionPerformed(null);
        }
    }//GEN-LAST:event_jPanel2TeclaPressionada


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCad;
    private javax.swing.JButton btnCanc;
    private javax.swing.JButton btnLim;
    private javax.swing.JCheckBox chcAbrirOS;
    private javax.swing.JCheckBox chcCadGrupo;
    private javax.swing.JCheckBox chcCadHard;
    private javax.swing.JCheckBox chcCadLocal;
    private javax.swing.JCheckBox chcCadPatr;
    private javax.swing.JCheckBox chcCadSoft;
    private javax.swing.JCheckBox chcCadUser;
    private javax.swing.JCheckBox chcConsGrupo;
    private javax.swing.JCheckBox chcConsHard;
    private javax.swing.JCheckBox chcConsLocal;
    private javax.swing.JCheckBox chcConsPatr;
    private javax.swing.JCheckBox chcConsSoft;
    private javax.swing.JCheckBox chcConsUser;
    private javax.swing.JCheckBox chcEditGrupo;
    private javax.swing.JCheckBox chcEditHard;
    private javax.swing.JCheckBox chcEditLocal;
    private javax.swing.JCheckBox chcEditOS;
    private javax.swing.JCheckBox chcEditPatr;
    private javax.swing.JCheckBox chcEditSoft;
    private javax.swing.JCheckBox chcEditUser;
    private javax.swing.JCheckBox chcFecharOS;
    private javax.swing.JCheckBox chcRelatOS;
    private javax.swing.JCheckBox chcTodas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtNomeGrup;
    // End of variables declaration//GEN-END:variables
}