/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.formulario;

import br.com.technobsoftwares.gpiec.dao.Ordem_de_ServicoDAO;
import br.com.technobsoftwares.gpiec.modelo.Ordem_de_Servico;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class FrmInGerenciaOS extends javax.swing.JInternalFrame {
    boolean contad_fecha; 
    /**
     * Creates new form FrmiInGerenciaOS
     */
    public FrmInGerenciaOS() {
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
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtaDesc1 = new javax.swing.JTextArea();
        btnCanc = new javax.swing.JButton();
        fmtDataAbert = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaDesc = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        txtJustif = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtServiço = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtComp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtLocal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbMetodo = new javax.swing.JComboBox();
        btnCons = new javax.swing.JButton();
        txtCons = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCatch = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        txtUser = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Gerenciamento de O.S"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Serviço", "Usuário", "Titulo", "Status", "Local", "Computador", "Data de Abertura", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl);
        if (tbl.getColumnModel().getColumnCount() > 0) {
            tbl.getColumnModel().getColumn(0).setPreferredWidth(0);
            tbl.getColumnModel().getColumn(1).setPreferredWidth(0);
            tbl.getColumnModel().getColumn(2).setPreferredWidth(0);
            tbl.getColumnModel().getColumn(4).setPreferredWidth(0);
            tbl.getColumnModel().getColumn(5).setPreferredWidth(0);
            tbl.getColumnModel().getColumn(6).setPreferredWidth(0);
            tbl.getColumnModel().getColumn(7).setPreferredWidth(0);
        }

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 1230, 200));

        txtaDesc1.setColumns(20);
        txtaDesc1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtaDesc1.setLineWrap(true);
        txtaDesc1.setRows(5);
        txtaDesc1.setWrapStyleWord(true);
        txtaDesc1.setEnabled(false);
        txtaDesc1.setDocument(new UpperCaseDocument());
        jScrollPane2.setViewportView(txtaDesc1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 300, 100));

        btnCanc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCanc.setText("Sair");
        btnCanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancActionPerformed(evt);
            }
        });
        jPanel1.add(btnCanc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 470, -1, 30));

        try {
            fmtDataAbert.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fmtDataAbert.setEnabled(false);
        fmtDataAbert.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(fmtDataAbert, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 330, 150, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Data de Abertura:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 310, -1, -1));

        txtaDesc.setColumns(20);
        txtaDesc.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtaDesc.setLineWrap(true);
        txtaDesc.setRows(5);
        txtaDesc.setWrapStyleWord(true);
        txtaDesc.setEnabled(false);
        jScrollPane1.setViewportView(txtaDesc);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 300, 100));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Descrição:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, -1, 20));

        txtJustif.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtJustif.setEnabled(false);
        jPanel1.add(txtJustif, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 180, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Titulo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Serviço:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, -1));

        txtServiço.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtServiço.setEnabled(false);
        jPanel1.add(txtServiço, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 180, 30));

        txtStatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtStatus.setEnabled(false);
        jPanel1.add(txtStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 260, 150, 30));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Status:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 240, -1, -1));

        txtComp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtComp.setEnabled(false);
        jPanel1.add(txtComp, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, 150, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Computador:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, -1, -1));

        txtLocal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtLocal.setEnabled(false);
        jPanel1.add(txtLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 150, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Local:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, -1, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Método de Pesquisa:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, -1, -1));

        cmbMetodo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbMetodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Código", "Serviço", "Titulo", "Local", "Computador", "Equipamento", "Data de Abertura", "Data de Fechamento" }));
        jPanel1.add(cmbMetodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, 132, 30));

        btnCons.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCons.setText("Consultar");
        btnCons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsActionPerformed(evt);
            }
        });
        jPanel1.add(btnCons, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, 30));

        txtCons.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConsActionPerformed(evt);
            }
        });
        txtCons.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConsCaracteresConsulta(evt);
            }
        });
        jPanel1.add(txtCons, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 40, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Insira o código:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Comentários de Fechamento:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, -1, -1));

        btnCatch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCatch.setText("Pegar OS");
        btnCatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatchActionPerformed(evt);
            }
        });
        jPanel1.add(btnCatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 240, 110, 30));

        btnClose.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnClose.setText("Fechar OS");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 280, 110, 30));

        txtUser.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtUser.setEnabled(false);
        jPanel1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 400, 150, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Usuário:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 380, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1250, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblAncestorAdded
        Ordem_de_ServicoDAO dao = new Ordem_de_ServicoDAO();
        List<Ordem_de_Servico> oss = dao.getListaNaoFechadas();
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setNumRows(0);
        for (Ordem_de_Servico os : oss) {
            model.addRow(new Object[]{
                os.getId_ordem_servico(),
                os.getFk_tipo_problema(),
                os.getFk_usuario(),
                os.getTitulo_os(),
                os.getFk_status(),
                os.getLocal_os(),
                os.getFk_pc(),
                os.getData_entrada(),
                os.getDetalhes_os(),
            });
        }
    }//GEN-LAST:event_tblAncestorAdded

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        if (evt.getClickCount() ==  1) {
            Ordem_de_Servico os = new Ordem_de_Servico();
            txtCons.setText(tbl.getValueAt(tbl.getSelectedRow(), 0).toString());
            txtServiço.setText(tbl.getValueAt(tbl.getSelectedRow(), 1).toString());
            txtUser.setText(tbl.getValueAt(tbl.getSelectedRow(), 2).toString());
            txtJustif.setText(tbl.getValueAt(tbl.getSelectedRow(), 3).toString());
            txtStatus.setText(tbl.getValueAt(tbl.getSelectedRow(), 4).toString());
            txtLocal.setText(tbl.getValueAt(tbl.getSelectedRow(), 5).toString());
            txtComp.setText(tbl.getValueAt(tbl.getSelectedRow(), 6).toString());
            fmtDataAbert.setText(tbl.getValueAt(tbl.getSelectedRow(), 7).toString());
            txtaDesc.setText(tbl.getValueAt(tbl.getSelectedRow(), 8).toString());

            Ordem_de_ServicoDAO dao = new Ordem_de_ServicoDAO();
            os.setId_ordem_servico(Integer.parseInt(txtCons.getText()));
            dao.pesquisar(os);
        }
    }//GEN-LAST:event_tblMouseClicked

    private void btnCancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancActionPerformed

    private void btnConsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsActionPerformed
        try {
            Ordem_de_Servico os = new Ordem_de_Servico();
            Ordem_de_ServicoDAO dao = new Ordem_de_ServicoDAO();
            os.setId_ordem_servico(Integer.parseInt(txtCons.getText()));
            dao.pesquisarNaoFechadas(os);

            txtServiço.setText(os.getFk_tipo_problema());
            txtJustif.setText(os.getTitulo_os());
            txtaDesc.setText(os.getDetalhes_os());
            txtComp.setText(os.getFk_pc());
            txtStatus.setText(os.getFk_status());
            fmtDataAbert.setText(os.getData_entrada());
            txtLocal.setText(os.getLocal_os());
            txtUser.setText(os.getFk_usuario());

            if (txtServiço.getText().equals("")) {
                txtCons.setText("");
                JOptionPane.showMessageDialog(null, "Ordem de Serviço não registrada ou já fechada!");
                txtCons.requestFocus();
            }         
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Insira um ID válido!");
            txtCons.requestFocus();
        }
    }//GEN-LAST:event_btnConsActionPerformed

    private void txtConsCaracteresConsulta(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsCaracteresConsulta
        String cons = txtCons.getText();

        if (cmbMetodo.getSelectedItem() == "Código") {
            //método para contar
            int quantCaracteres = cons.length();
            if (quantCaracteres > 2){
                cons = cons.substring (0, cons.length() - 1);
                txtCons.setText(cons);
            }
            //método apenas numeros
            String caracteres="0123456789";
            if(!caracteres.contains(evt.getKeyChar()+"")){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtConsCaracteresConsulta

    private void btnCatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatchActionPerformed
        if ((!"".equals(txtServiço.getText())) && ("Aberta".equals(txtStatus.getText()))) {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja alterar o status dessa Ordem de Serviço para 'Em andamento'?");
            if (resposta == 0 ) {
                Ordem_de_Servico os = new Ordem_de_Servico();

                os.setId_ordem_servico(Integer.parseInt(txtCons.getText()));
                os.setFk_id_status(2);

                Ordem_de_ServicoDAO dao = new Ordem_de_ServicoDAO();
                dao.pega(os);

                JOptionPane.showMessageDialog(null, "Status alterado com sucesso!");
                tblAncestorAdded(null);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma Ordem de Serviço que ainda esteja em aberto!");
        }          
    }//GEN-LAST:event_btnCatchActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        if (!"".equals(txtServiço.getText())) {
            if (contad_fecha == false) {
                int resposta = JOptionPane.showConfirmDialog(null, "Deseja alterar o status dessa Ordem de Serviço para 'Fechada'?");
                if (resposta == 0 ) {
                    JOptionPane.showMessageDialog(null, "Caso queira realizar algum comentário de fechamento, o campo será habilitado agora. Para fechar definitivamente a Ordem de Serviço, basta "
                            + "clicar novamente no botão 'Fechar OS'.");
                    txtaDesc1.setEnabled(true);
                    contad_fecha = true;
                }
            }else{
                Date data = new Date();  
                SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");  

                Ordem_de_Servico os = new Ordem_de_Servico();

                os.setId_ordem_servico(Integer.parseInt(txtCons.getText()));
                os.setFk_id_status(3);
                os.setComentarios_fechamento(txtaDesc1.getText());
                os.setData_fechamento(formatador.format(data));

                Ordem_de_ServicoDAO dao = new Ordem_de_ServicoDAO();
                dao.fecha(os);

                contad_fecha = false;
                tblAncestorAdded(null);
                
                txtCons.setText("");
                txtServiço.setText("");
                txtJustif.setText("");
                txtaDesc.setText("");
                txtaDesc1.setText("");
                txtLocal.setText("");
                txtComp.setText("");
                txtStatus.setText("");
                fmtDataAbert.setText("");
                txtUser.setText("");
                
                JOptionPane.showMessageDialog(null, "Ordem de Serviço fechada com sucesso!");
                txtCons.requestFocus();
            }   
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma Ordem de Serviço primeiro!");
            txtCons.requestFocus();
        }           
    }//GEN-LAST:event_btnCloseActionPerformed

    private void txtConsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConsActionPerformed
        btnConsActionPerformed(null);
    }//GEN-LAST:event_txtConsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCanc;
    private javax.swing.JButton btnCatch;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCons;
    private javax.swing.JComboBox cmbMetodo;
    private javax.swing.JFormattedTextField fmtDataAbert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtComp;
    private javax.swing.JTextField txtCons;
    private javax.swing.JTextField txtJustif;
    private javax.swing.JTextField txtLocal;
    private javax.swing.JTextField txtServiço;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextArea txtaDesc;
    private javax.swing.JTextArea txtaDesc1;
    // End of variables declaration//GEN-END:variables
}
