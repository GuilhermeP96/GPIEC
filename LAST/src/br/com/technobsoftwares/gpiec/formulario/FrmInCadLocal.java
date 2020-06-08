/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.formulario;

import br.com.technobsoftwares.gpiec.dao.LocalDAO;
import br.com.technobsoftwares.gpiec.modelo.Local;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author lab
 */
public class FrmInCadLocal extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmInCadLocal
     */
    public FrmInCadLocal() {
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

        jPanel1 = new javax.swing.JPanel();
        txtLocal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnCad = new javax.swing.JButton();
        btnCanc = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDesc = new javax.swing.JTextArea();
        btnLimpar = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Locais"));

        txtLocal.setDocument(new UpperCaseDocument());
        txtLocal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TeclaPressionada(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ApenasTexto(evt);
            }
        });

        jLabel1.setText("Local:*");

        btnCad.setText("Cadastrar");
        btnCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadActionPerformed(evt);
            }
        });

        btnCanc.setText("Cancelar");
        btnCanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancActionPerformed(evt);
            }
        });

        jLabel2.setText("Descrição:");

        txaDesc.setColumns(20);
        txaDesc.setLineWrap(true);
        txaDesc.setRows(5);
        txaDesc.setWrapStyleWord(true);
        txaDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TeclaPressionada(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ApenasTexto(evt);
            }
        });
        jScrollPane1.setViewportView(txaDesc);

        btnLimpar.setText("Limpar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCad)
                .addGap(18, 18, 18)
                .addComponent(btnLimpar)
                .addGap(64, 64, 64)
                .addComponent(btnCanc)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtLocal)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCanc)
                    .addComponent(btnCad)
                    .addComponent(btnLimpar))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancActionPerformed

    private void btnCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadActionPerformed
        if (!"".equals(txtLocal.getText())) {
            Local local = new Local();
            local.setNome_local(txtLocal.getText());
            if ("".equals(txaDesc.getText())) {
                local.setDesc_local("VAZIO");
            }else{
                local.setDesc_local(txaDesc.getText());            
            }
            
            LocalDAO dao = new LocalDAO();
            
            try {
                dao.adiciona(local);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            txtLocal.setText("");
            txaDesc.setText("");
            txtLocal.requestFocus();
        }else{
            JOptionPane.showMessageDialog(null, "Preencha o campo de nome do local!");
        }
    }//GEN-LAST:event_btnCadActionPerformed

    private void ApenasTexto(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ApenasTexto
        String caracteres="!@#$%¨&*()/\\*-+.,{}[]<>;:?°ºª'|\"=_`^~´¬§¢£³²¹°ºª";
        if(caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_ApenasTexto

    private void TeclaPressionada(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TeclaPressionada
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if (!"".equals(txtLocal.getText())) {
                Local local = new Local();
                local.setNome_local(txtLocal.getText());
                if ("".equals(txaDesc.getText())) {
                    local.setDesc_local("VAZIO");
                }else{
                    local.setDesc_local(txaDesc.getText());            
                }

                LocalDAO dao = new LocalDAO();

                try {
                    dao.adiciona(local);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
                txtLocal.setText("");
                txaDesc.setText("");
                txtLocal.requestFocus();
            }else{
                JOptionPane.showMessageDialog(null, "Preencha o campo de nome do local!");
            }
        }
    }//GEN-LAST:event_TeclaPressionada


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCad;
    private javax.swing.JButton btnCanc;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaDesc;
    private javax.swing.JTextField txtLocal;
    // End of variables declaration//GEN-END:variables
}