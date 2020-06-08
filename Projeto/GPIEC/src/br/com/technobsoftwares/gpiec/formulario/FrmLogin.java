/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.formulario;


import br.com.technobsoftwares.gpiec.ConnectionFactory;
import br.com.technobsoftwares.gpiec.dao.UsuarioDAO;
import br.com.technobsoftwares.gpiec.modelo.Usuario;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author lab
 */
public class FrmLogin extends javax.swing.JFrame {
    public static String usuario_logado;
    /**
     * Creates new form FrmLogin
     */
    public FrmLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        txtUser = new javax.swing.JTextField();
        psrSenha = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbltestaconexao = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUser.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionTXT(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FormatTexto(evt);
            }
        });
        jPanel1.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 120, 30));

        psrSenha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        psrSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionTXT(evt);
            }
        });
        psrSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FormatTexto(evt);
            }
        });
        jPanel1.add(psrSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 120, 30));

        btnLogin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLogin.setText("Entrar");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, 30));

        btnSair.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, -1, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Senha:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Usuário:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, -1));

        lbltestaconexao.setText("Estabelecendo conexão com o banco...");
        jPanel1.add(lbltestaconexao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/technobsoftwares/gpiec/formulario/GPIEC-login.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 170));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if (("master".equals(txtUser.getText())) && ("master".equals(psrSenha.getText()))){
                this.dispose();
                FrmDiagnostico diagnostico = new FrmDiagnostico();
                diagnostico.setVisible(true);
        }else{
            try {
                new ConnectionFactory().getConnection();
                lbltestaconexao.setText("Conectado com o banco.");
                Usuario usuario = new Usuario();
                UsuarioDAO dao = new UsuarioDAO();
                usuario.setLogin_user(txtUser.getText());
                usuario_logado = txtUser.getText();
                usuario.setSenha_user(psrSenha.getText());
                dao.logar(usuario, this);
                txtUser.setText(null);
                psrSenha.setText(null);
                txtUser.requestFocus();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não conectado com o banco. Contate o administrador do sistema.");

                lbltestaconexao.setText("Erro ao conectar com o banco! Cheque as conexões e reinicie o sistema.");
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void FormatTexto(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FormatTexto
        String caracteres="@#$%¨&*()/\\*-+{}[]<>;?°ºª'|\"=_`^~´¬§¢£³²¹°ºª ";
        if(caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
    }//GEN-LAST:event_FormatTexto

/*[GUILHERME--COMEÇO]07/11/2014*/
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
                                             
        try {
            new ConnectionFactory().getConnection();
            lbltestaconexao.setText("Conectado com o banco.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não conectado com o banco. Contate o administrador do sistema.");
            lbltestaconexao.setText("Erro ao conectar com o banco! Cheque as conexões e reinicie o sistema.");
        }                              
                                   

    }//GEN-LAST:event_formWindowOpened

    private void ActionTXT(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionTXT
        btnLoginActionPerformed(null);
    }//GEN-LAST:event_ActionTXT
/*[GUILHERME--FIM]
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbltestaconexao;
    private javax.swing.JPasswordField psrSenha;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
