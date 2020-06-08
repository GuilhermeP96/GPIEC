/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.technobsoftwares.gpiec.formulario;

import br.com.technobsoftwares.gpiec.dao.Local_2DAO;
import br.com.technobsoftwares.gpiec.dao.Ordem_de_ServicoDAO;
import br.com.technobsoftwares.gpiec.dao.TipousuarioDAO;
import br.com.technobsoftwares.gpiec.dao.UsuarioDAO;
import br.com.technobsoftwares.gpiec.modelo.Ordem_de_Servico;
import br.com.technobsoftwares.gpiec.modelo.Usuario;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import java.util.Date;  
import java.text.SimpleDateFormat;  
import javax.swing.ImageIcon;
  
/**
 *
 * @author lab
 */
public class FrmMenuAdmin extends javax.swing.JFrame {
    FrmInCadUser cadastrouser = null;
    FrmInConsPatrimonio relatpatrim = null;
    FrmInCadPatrimonio cadastropatrim = null;
    FrmInAbreOS cadastroos = null;
    FrmInMinhasOS minhasos = null;
    FrmInConsOS relatos = null;
    FrmInCadGabinete cadastrohardware = null;
    FrmInCadSoftware cadastrosoftware = null;
    FrmInCadLocal cadastrolocal = null;
    FrmInConsSoftware conssoftware = null;
    FrmInConsHardware conshardware = null;
    FrmInConsUser consuser = null;
    FrmInConsTipoUser consgrupo = null;
    FrmInConsLocal conslocal = null; 
    FrmInOpcoes opcoes = null;
    FrmInGerenciaOS gerenciaos = null;  
    FrmInCadTipoUser cadtipouser = null;
    public static int width;
    public static int height;   
    
    public static String nome_usuario_relat;
    public static String nome_os_status_relat;
    public static String nome_os_tproblema_relat;
    public static String nome_grupo_usuario_relat;
    /**
     * Creates new form FrmMenu
     */
    public FrmMenuAdmin() {
        initComponents(); 
        
        this.setExtendedState(FrmMenuAdmin.MAXIMIZED_BOTH);
        jDesktopPane1.setMaximumSize(this.getMaximumSize());    
        tester();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = (int) screenSize.getWidth();
        height = (int) screenSize.getHeight();  
        jLabel1.setText("Logado como: "+FrmLogin.usuario_logado);    
        jLabel2.setSize((int)width, (int)height);
        ImageIcon icon = new ImageIcon(getClass().getResource("/br/com/technobsoftwares/gpiec/formulario/GPIEC.png"));
        icon.setImage(icon.getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), 10));
        jLabel2.setIcon(icon);
    }
    
    public void tester(){
        UsuarioDAO grupos = new UsuarioDAO();
        if (grupos.isCad_user() == false) {
            menuCadUser.setEnabled(false);
        }
        if (grupos.isCad_grupo() == false) {
            MenuCadGrupo.setEnabled(false);
        }
        if (grupos.isCad_patrimonio() == false) {
            MenuCadPatrimonio.setEnabled(false);
        }
        if (grupos.isCad_local() == false) {
            menuCadLocal.setEnabled(false);
        }
        if (grupos.isCad_soft() == false) {
            menuCadSoftware.setEnabled(false);
        }
        if (grupos.isCad_hard() == false) {
            MenuCadHardware.setEnabled(false);
        }
        
        if (grupos.isCons_user() == false) {
            menuConsUser.setEnabled(false);
        }
        if (grupos.isCons_grupo() == false) {
            menuConsTipoUser.setEnabled(false);
        }
        if (grupos.isCons_patrimonio() == false) {
            MenuConsPatrimonio.setEnabled(false);
        }
        if (grupos.isCons_local() == false) {
            MenuConsLocal.setEnabled(false);
        }
        if (grupos.isCons_soft() == false) {
            MenuConSoftware.setEnabled(false);
        }
        if (grupos.isCons_hard() == false) {
            MenuConsHardware.setEnabled(false);
        }
        
        if (grupos.isRelat_user() == false) {
            menuRelUser.setEnabled(false);
        }
        if (grupos.isRelat_grupo() == false) {
            menuRelTipoUser.setEnabled(false);
        }
        if (grupos.isRelat_patrimonio() == false) {
            menuRelPatr.setEnabled(false);
        }
        if (grupos.isRelat_local() == false) {
            menuRelLocal.setEnabled(false);
        }
        if (grupos.isRelat_soft() == false) {
            menuRelSoftware.setEnabled(false);
        }
        if (grupos.isRelat_hard() == false) {
            menuRelHardware.setEnabled(false);
        }

        if (grupos.isAbrir_os() == false) {
            menuAbrirOS.setEnabled(false);
            menuMinhasOS.setEnabled(false);
        }
        if (grupos.isFechar_os() == false) {
            MenuOSnfechadas.setEnabled(false);
        }
        if (grupos.isEdit_os() == false) {
            menuConsOS.setEnabled(false);
        }
        if (grupos.isRelat_os() == false) {
            menuRelOS.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuCadastro = new javax.swing.JMenu();
        menuCadUser = new javax.swing.JMenuItem();
        MenuCadGrupo = new javax.swing.JMenuItem();
        MenuCadPatrimonio = new javax.swing.JMenuItem();
        menuCadLocal = new javax.swing.JMenuItem();
        menuCadSoftware = new javax.swing.JMenuItem();
        MenuCadHardware = new javax.swing.JMenuItem();
        MenuConsulta = new javax.swing.JMenu();
        menuConsUser = new javax.swing.JMenuItem();
        menuConsTipoUser = new javax.swing.JMenuItem();
        MenuConsPatrimonio = new javax.swing.JMenuItem();
        menuConsOS = new javax.swing.JMenuItem();
        MenuConsLocal = new javax.swing.JMenuItem();
        MenuConSoftware = new javax.swing.JMenuItem();
        MenuConsHardware = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        menuRelUser = new javax.swing.JMenu();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        menuRelTipoUser = new javax.swing.JMenuItem();
        menuRelPatr = new javax.swing.JMenu();
        menuRelOS = new javax.swing.JMenu();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        menuRelLocal = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        menuRelSoftware = new javax.swing.JMenu();
        menuRelHardware = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        menuRelTipoUser1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuRelLocal1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        MenuOS = new javax.swing.JMenu();
        menuAbrirOS = new javax.swing.JMenuItem();
        menuMinhasOS = new javax.swing.JMenuItem();
        MenuOSnfechadas = new javax.swing.JMenuItem();
        menuConfig = new javax.swing.JMenu();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(720, 450));

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 1060, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 555, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        MenuCadastro.setText("Cadastro");

        menuCadUser.setText("Usuário");
        menuCadUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadUserActionPerformed(evt);
            }
        });
        MenuCadastro.add(menuCadUser);

        MenuCadGrupo.setText("Grupo de usuário");
        MenuCadGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadGrupoActionPerformed(evt);
            }
        });
        MenuCadastro.add(MenuCadGrupo);

        MenuCadPatrimonio.setText("Patrimônio");
        MenuCadPatrimonio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadPatrimonioActionPerformed(evt);
            }
        });
        MenuCadastro.add(MenuCadPatrimonio);

        menuCadLocal.setText("Local");
        menuCadLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadLocalActionPerformed(evt);
            }
        });
        MenuCadastro.add(menuCadLocal);

        menuCadSoftware.setText("Software");
        menuCadSoftware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadSoftwareActionPerformed(evt);
            }
        });
        MenuCadastro.add(menuCadSoftware);

        MenuCadHardware.setText("Hardware");
        MenuCadHardware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadHardwareActionPerformed(evt);
            }
        });
        MenuCadastro.add(MenuCadHardware);

        jMenuBar1.add(MenuCadastro);

        MenuConsulta.setText("Consulta");

        menuConsUser.setText("Usuário");
        menuConsUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsUserActionPerformed(evt);
            }
        });
        MenuConsulta.add(menuConsUser);

        menuConsTipoUser.setText("Grupos de Usuários");
        menuConsTipoUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsTipoUserActionPerformed(evt);
            }
        });
        MenuConsulta.add(menuConsTipoUser);

        MenuConsPatrimonio.setText("Patrimônio");
        MenuConsPatrimonio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuConsPatrimonioActionPerformed(evt);
            }
        });
        MenuConsulta.add(MenuConsPatrimonio);

        menuConsOS.setText("Ordem de Serviço");
        menuConsOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsOSActionPerformed(evt);
            }
        });
        MenuConsulta.add(menuConsOS);

        MenuConsLocal.setText("Local");
        MenuConsLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuConsLocalActionPerformed(evt);
            }
        });
        MenuConsulta.add(MenuConsLocal);

        MenuConSoftware.setText("Software");
        MenuConSoftware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuConSoftwareActionPerformed(evt);
            }
        });
        MenuConsulta.add(MenuConSoftware);

        MenuConsHardware.setText("Hardware");
        MenuConsHardware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuConsHardwareActionPerformed(evt);
            }
        });
        MenuConsulta.add(MenuConsHardware);

        jMenuBar1.add(MenuConsulta);

        menuRelatorio.setText("Relatório");

        jMenu1.setText("PDF");

        menuRelUser.setText("Usuário");

        jMenuItem28.setText("Usuários por Grupo");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        menuRelUser.add(jMenuItem28);

        jMenuItem22.setText("Todos");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        menuRelUser.add(jMenuItem22);

        jMenu1.add(menuRelUser);

        menuRelTipoUser.setText("Grupos de Usuário");
        menuRelTipoUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelTipoUserActionPerformed(evt);
            }
        });
        jMenu1.add(menuRelTipoUser);

        menuRelPatr.setText("Patrimônio");
        jMenu1.add(menuRelPatr);

        menuRelOS.setText("Ordem de Serviço");

        jMenuItem24.setText("O.S por Usuário");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        menuRelOS.add(jMenuItem24);

        jMenuItem2.setText("O.S por Status");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuRelOS.add(jMenuItem2);

        jMenuItem26.setText("O.S por Tipo de Serviço");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        menuRelOS.add(jMenuItem26);

        jMenuItem27.setText("O.S por Data de Entrada");
        menuRelOS.add(jMenuItem27);

        jMenuItem19.setText("O.S por Data de Fechamento");
        menuRelOS.add(jMenuItem19);

        jMenuItem1.setText("O.S não Fechadas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuRelOS.add(jMenuItem1);

        jMenuItem25.setText("Todas");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        menuRelOS.add(jMenuItem25);

        jMenu1.add(menuRelOS);

        menuRelLocal.setText("Locais");
        menuRelLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelLocalActionPerformed(evt);
            }
        });
        jMenu1.add(menuRelLocal);

        jMenuItem7.setText("Computador");
        jMenu1.add(jMenuItem7);

        menuRelSoftware.setText("Software");
        jMenu1.add(menuRelSoftware);

        menuRelHardware.setText("Hardware");
        jMenu1.add(menuRelHardware);

        menuRelatorio.add(jMenu1);

        jMenu2.setText("Excel");

        jMenuItem8.setText("Usuário");
        jMenu2.add(jMenuItem8);

        menuRelTipoUser1.setText("Grupos de Usuário");
        menuRelTipoUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelTipoUser1ActionPerformed(evt);
            }
        });
        jMenu2.add(menuRelTipoUser1);

        jMenuItem5.setText("Patrimônio");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem3.setText("Ordem de Serviço");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        menuRelLocal1.setText("Locais");
        menuRelLocal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelLocal1ActionPerformed(evt);
            }
        });
        jMenu2.add(menuRelLocal1);

        jMenuItem6.setText("Computador");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem4.setText("Software");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem9.setText("Hardware");
        jMenu2.add(jMenuItem9);

        menuRelatorio.add(jMenu2);

        jMenuBar1.add(menuRelatorio);

        MenuOS.setText("Ordem de Serviço");

        menuAbrirOS.setText("Abrir O.S");
        menuAbrirOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAbrirOSActionPerformed(evt);
            }
        });
        MenuOS.add(menuAbrirOS);

        menuMinhasOS.setText("Minhas O.S");
        menuMinhasOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMinhasOSActionPerformed(evt);
            }
        });
        MenuOS.add(menuMinhasOS);

        MenuOSnfechadas.setText("O.S não fechadas");
        MenuOSnfechadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuOSnfechadasActionPerformed(evt);
            }
        });
        MenuOS.add(MenuOSnfechadas);

        jMenuBar1.add(MenuOS);

        menuConfig.setText("Configurações");
        menuConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuConfigMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuConfig);

        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1094, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
        this.dispose();
        new FrmLogin().show();
    }//GEN-LAST:event_menuSairMouseClicked

    private void menuCadUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadUserActionPerformed
        try {
            if (evt.getSource() == menuCadUser) {
                if (cadastrouser == null) {
                    cadastrouser = new FrmInCadUser();
                    jDesktopPane1.add(cadastrouser);
                    cadastrouser.setVisible(true);
//                    cadastrouser.setMaximum(true);
                }
            jDesktopPane1.moveToFront(cadastrouser);
            }
            if (cadastrouser.isClosed()) {
                cadastrouser = new FrmInCadUser();
                jDesktopPane1.add(cadastrouser);
                cadastrouser.setVisible(true);
                jDesktopPane1.moveToFront(cadastrouser);
//                cadastrouser.setMaximum(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }  
    }//GEN-LAST:event_menuCadUserActionPerformed

    private void MenuConsPatrimonioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuConsPatrimonioActionPerformed
        try {
            if (evt.getSource() == MenuConsPatrimonio) {
                if (relatpatrim == null) {
                    relatpatrim = new FrmInConsPatrimonio();
                    jDesktopPane1.add(relatpatrim);
                    relatpatrim.setVisible(true);
//                    relatpatrim.setMaximum(true);
                }
            jDesktopPane1.moveToFront(relatpatrim);
            }
            if (relatpatrim.isClosed()) {
                relatpatrim = new FrmInConsPatrimonio();
                jDesktopPane1.add(relatpatrim);
                relatpatrim.setVisible(true);
                jDesktopPane1.moveToFront(relatpatrim);
//                relatpatrim.setMaximum(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }  
    }//GEN-LAST:event_MenuConsPatrimonioActionPerformed

    private void MenuCadPatrimonioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadPatrimonioActionPerformed
        try {
            if (evt.getSource() == MenuCadPatrimonio) {
                if (cadastropatrim == null) {
                    cadastropatrim = new FrmInCadPatrimonio();
                    jDesktopPane1.add(cadastropatrim);
                    cadastropatrim.setVisible(true);
//                    cadastropatrim.setMaximum(true);
                }
            jDesktopPane1.moveToFront(cadastropatrim);
            }
            if (cadastropatrim.isClosed()) {
                cadastropatrim = new FrmInCadPatrimonio();
                jDesktopPane1.add(cadastropatrim);
                cadastropatrim.setVisible(true);
                jDesktopPane1.moveToFront(cadastropatrim);
//                cadastropatrim.setMaximum(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }  
    }//GEN-LAST:event_MenuCadPatrimonioActionPerformed

    private void menuConsOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsOSActionPerformed
        try {
            if (evt.getSource() == menuConsOS) {
                if (relatos == null) {
                    relatos = new FrmInConsOS();
                    jDesktopPane1.add(relatos);
                    relatos.setVisible(true);
//                    relatos.setMaximum(true);
                }
            jDesktopPane1.moveToFront(relatos);
            }
            if (relatos.isClosed()) {
                relatos = new FrmInConsOS();
                jDesktopPane1.add(relatos);
                relatos.setVisible(true);
                jDesktopPane1.moveToFront(relatos);
//                relatos.setMaximum(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }  
    }//GEN-LAST:event_menuConsOSActionPerformed

    private void menuCadSoftwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadSoftwareActionPerformed
        try {
            if (evt.getSource() == menuCadSoftware) {
                if (cadastrosoftware == null) {
                    cadastrosoftware = new FrmInCadSoftware();
                    jDesktopPane1.add(cadastrosoftware);
                    cadastrosoftware.setVisible(true);
//                    relatos.setMaximum(true);
                }
            jDesktopPane1.moveToFront(cadastrosoftware);
            }
            if (cadastrosoftware.isClosed()) {
                cadastrosoftware = new FrmInCadSoftware();
                jDesktopPane1.add(cadastrosoftware);
                cadastrosoftware.setVisible(true);
                jDesktopPane1.moveToFront(cadastrosoftware);
//                relatos.setMaximum(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }//GEN-LAST:event_menuCadSoftwareActionPerformed

    private void menuCadLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadLocalActionPerformed
        try {
            if (evt.getSource() == menuCadLocal) {
                if (cadastrolocal == null) {
                    cadastrolocal = new FrmInCadLocal();
                    jDesktopPane1.add(cadastrolocal);
                    cadastrolocal.setVisible(true);
//                    relatos.setMaximum(true);
                }
            jDesktopPane1.moveToFront(cadastrolocal);
            }
            if (cadastrolocal.isClosed()) {
                cadastrolocal = new FrmInCadLocal();
                jDesktopPane1.add(cadastrolocal);
                cadastrolocal.setVisible(true);
                jDesktopPane1.moveToFront(cadastrolocal);
//                relatos.setMaximum(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }//GEN-LAST:event_menuCadLocalActionPerformed

    private void MenuConSoftwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuConSoftwareActionPerformed
        try {
            if (evt.getSource() == MenuConSoftware) {
                if (conssoftware == null) {
                    conssoftware = new FrmInConsSoftware();
                    jDesktopPane1.add(conssoftware);
                    conssoftware.setVisible(true);
//                    relatos.setMaximum(true);
                }
            jDesktopPane1.moveToFront(conssoftware);
            }
            if (conssoftware.isClosed()) {
                conssoftware = new FrmInConsSoftware();
                jDesktopPane1.add(conssoftware);
                conssoftware.setVisible(true);
                jDesktopPane1.moveToFront(conssoftware);
//                relatos.setMaximum(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }//GEN-LAST:event_MenuConSoftwareActionPerformed

    private void MenuCadHardwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadHardwareActionPerformed
        try {
            if (evt.getSource() == MenuCadHardware) {
                if (cadastrohardware == null) {
                    cadastrohardware = new FrmInCadGabinete();
                    jDesktopPane1.add(cadastrohardware);
                    cadastrohardware.setVisible(true);
//                    relatos.setMaximum(true);
                }
            jDesktopPane1.moveToFront(cadastrohardware);
            }
            if (cadastrohardware.isClosed()) {
                cadastrohardware = new FrmInCadGabinete();
                jDesktopPane1.add(cadastrohardware);
                cadastrohardware.setVisible(true);
                jDesktopPane1.moveToFront(cadastrohardware);
//                relatos.setMaximum(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }//GEN-LAST:event_MenuCadHardwareActionPerformed

    private void MenuConsHardwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuConsHardwareActionPerformed
        try {
            if (evt.getSource() == MenuConsHardware) {
                if (conshardware == null) {
                    conshardware = new FrmInConsHardware();
                    jDesktopPane1.add(conshardware);
                    conshardware.setVisible(true);
//                    relatos.setMaximum(true);
                }
            jDesktopPane1.moveToFront(conshardware);
            }
            if (conshardware.isClosed()) {
                conshardware = new FrmInConsHardware();
                jDesktopPane1.add(conshardware);
                conshardware.setVisible(true);
                jDesktopPane1.moveToFront(conshardware);
//                relatos.setMaximum(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }//GEN-LAST:event_MenuConsHardwareActionPerformed

    private void menuConsUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsUserActionPerformed
        try {
            if (evt.getSource() == menuConsUser) {
                if (consuser == null) {
                    consuser = new FrmInConsUser();
                    jDesktopPane1.add(consuser);
                    consuser.setVisible(true);
//                    relatos.setMaximum(true);
                }
            jDesktopPane1.moveToFront(consuser);
            }
            if (consuser.isClosed()) {
                consuser = new FrmInConsUser();
                jDesktopPane1.add(consuser);
                consuser.setVisible(true);
                jDesktopPane1.moveToFront(consuser);
//                relatos.setMaximum(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }//GEN-LAST:event_menuConsUserActionPerformed

    private void menuConsTipoUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsTipoUserActionPerformed
        try {
            if (evt.getSource() == menuConsTipoUser) {
                if (consgrupo == null) {
                    consgrupo = new FrmInConsTipoUser();
                    jDesktopPane1.add(consgrupo);
                    consgrupo.setVisible(true);
//                    relatos.setMaximum(true);
                }
            jDesktopPane1.moveToFront(consgrupo);
            }
            if (consgrupo.isClosed()) {
                consgrupo = new FrmInConsTipoUser();
                jDesktopPane1.add(consgrupo);
                consgrupo.setVisible(true);
                jDesktopPane1.moveToFront(consgrupo);
//                relatos.setMaximum(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }//GEN-LAST:event_menuConsTipoUserActionPerformed

    private void MenuConsLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuConsLocalActionPerformed
        try {
            if (evt.getSource() == MenuConsLocal) {
                if (conslocal == null) {
                    conslocal = new FrmInConsLocal();
                    jDesktopPane1.add(conslocal);
                    conslocal.setVisible(true);
//                    relatos.setMaximum(true);
                }
            jDesktopPane1.moveToFront(conslocal);
            }
            if (conslocal.isClosed()) {
                conslocal = new FrmInConsLocal();
                jDesktopPane1.add(conslocal);
                conslocal.setVisible(true);
                jDesktopPane1.moveToFront(conslocal);
//                relatos.setMaximum(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
    }//GEN-LAST:event_MenuConsLocalActionPerformed

    private void menuMinhasOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMinhasOSActionPerformed
        try {
            if (evt.getSource() == menuMinhasOS) {
                if (minhasos == null) {
                    minhasos = new FrmInMinhasOS();
                    jDesktopPane1.add(minhasos);
                    minhasos.setVisible(true);
                    //                    fechaos.setMaximum(true);
                }
                jDesktopPane1.moveToFront(minhasos);
            }
            if (minhasos.isClosed()) {
                minhasos = new FrmInMinhasOS();
                jDesktopPane1.add(minhasos);
                minhasos.setVisible(true);
                jDesktopPane1.moveToFront(minhasos);
                //                fechaos.setMaximum(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_menuMinhasOSActionPerformed

    private void menuAbrirOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbrirOSActionPerformed
        try {
            if (evt.getSource() == menuAbrirOS) {
                if (cadastroos == null) {
                    cadastroos = new FrmInAbreOS();
                    jDesktopPane1.add(cadastroos);
                    cadastroos.setVisible(true);
                    //                    cadastroos.setMaximum(true);
                }
                jDesktopPane1.moveToFront(cadastroos);
            }
            if (cadastroos.isClosed()) {
                cadastroos = new FrmInAbreOS();
                jDesktopPane1.add(cadastroos);
                cadastroos.setVisible(true);
                jDesktopPane1.moveToFront(cadastroos);
                //                cadastroos.setMaximum(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_menuAbrirOSActionPerformed

    private void menuConfigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuConfigMouseClicked
        try {
            if (evt.getSource() == menuConfig) {
                if (opcoes == null) {
                    opcoes = new FrmInOpcoes();
                    jDesktopPane1.add(opcoes);
                    opcoes.setVisible(true);
                    //                    cadastroos.setMaximum(true);
                }
                jDesktopPane1.moveToFront(opcoes);
            }
            if (opcoes.isClosed()) {
                opcoes = new FrmInOpcoes();
                jDesktopPane1.add(opcoes);
                opcoes.setVisible(true);
                jDesktopPane1.moveToFront(opcoes);
                //                cadastroos.setMaximum(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_menuConfigMouseClicked

    private void MenuOSnfechadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuOSnfechadasActionPerformed
        try {
            if (evt.getSource() == MenuOSnfechadas) {
                if (gerenciaos == null) {
                    gerenciaos = new FrmInGerenciaOS();
                    jDesktopPane1.add(gerenciaos);
                    gerenciaos.setVisible(true);
                    //                    cadastroos.setMaximum(true);
                }
                jDesktopPane1.moveToFront(gerenciaos);
            }
            if (gerenciaos.isClosed()) {
                gerenciaos = new FrmInGerenciaOS();
                jDesktopPane1.add(gerenciaos);
                gerenciaos.setVisible(true);
                jDesktopPane1.moveToFront(gerenciaos);
                //                cadastroos.setMaximum(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_MenuOSnfechadasActionPerformed

    private void MenuCadGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadGrupoActionPerformed
        try {
            if (evt.getSource() == MenuCadGrupo) {
                if (cadtipouser == null) {
                    cadtipouser = new FrmInCadTipoUser();
                    jDesktopPane1.add(cadtipouser);
                    cadtipouser.setVisible(true);
                    //                    cadastroos.setMaximum(true);
                }
                jDesktopPane1.moveToFront(cadtipouser);
            }
            if (cadtipouser.isClosed()) {
                cadtipouser = new FrmInCadTipoUser();
                jDesktopPane1.add(cadtipouser);
                cadtipouser.setVisible(true);
                jDesktopPane1.moveToFront(cadtipouser);
                //                cadastroos.setMaximum(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_MenuCadGrupoActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        nome_usuario_relat = JOptionPane.showInputDialog("Qual o nome do usuário?");
        if (nome_usuario_relat != null) {
            Ordem_de_ServicoDAO dao = new Ordem_de_ServicoDAO();
            try {
                dao.RelatorioDeOsUsuarios();
            } catch (JRException ex) {
                Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            dao.ChamaRelOsUsuarios();
        }
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        nome_os_status_relat = JOptionPane.showInputDialog("Qual o status?");
        if (nome_os_status_relat != null) {
            Ordem_de_ServicoDAO dao = new Ordem_de_ServicoDAO();
            try {
                dao.RelatorioDeOsStatus();
            } catch (JRException ex) {
                Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            dao.ChamaRelOsStatus();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        nome_os_tproblema_relat = JOptionPane.showInputDialog("Qual o tipo de serviço?");
        if (nome_os_tproblema_relat != null) {
            Ordem_de_ServicoDAO dao = new Ordem_de_ServicoDAO();
            try {
                dao.RelatorioDeOsTipoServico();
            } catch (JRException ex) {
                Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            dao.ChamaRelOsTipoServico();
        }
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        Ordem_de_ServicoDAO dao = new Ordem_de_ServicoDAO();
        try {
            dao.RelatorioDeOs();
        } catch (JRException ex) {
            Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.ChamaRelOs();
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        nome_grupo_usuario_relat = JOptionPane.showInputDialog("Qual o nome do grupo?");
        if (nome_grupo_usuario_relat != null) {
            UsuarioDAO dao = new UsuarioDAO();
            try {
                dao.RelatorioUsuariosGrupo();
            } catch (JRException ex) {
                Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            dao.ChamaRelUsuariosGrupo();
        }
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        UsuarioDAO dao = new UsuarioDAO();
        try {
            dao.RelatorioDeUsuarios();
        } catch (JRException ex) {
            Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.ChamaRel();
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Ordem_de_ServicoDAO dao = new Ordem_de_ServicoDAO();
        try {
            dao.RelatorioDeOsNaoFechadas();
        } catch (JRException ex) {
            Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.ChamaRelOsNaoFechadas();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuRelTipoUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelTipoUserActionPerformed
        TipousuarioDAO dao = new TipousuarioDAO();
        try {
            dao.RelatorioUsuariosGrupo();
        } catch (JRException ex) {
            Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.ChamaRelUsuariosGrupo();
    }//GEN-LAST:event_menuRelTipoUserActionPerformed

    private void menuRelLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelLocalActionPerformed
        Local_2DAO dao = new Local_2DAO();
        try {
            dao.RelatorioLocais();
        } catch (JRException ex) {
            Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        dao.ChamaRelLocais();
    }//GEN-LAST:event_menuRelLocalActionPerformed

    private void menuRelTipoUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelTipoUser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuRelTipoUser1ActionPerformed

    private void menuRelLocal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelLocal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuRelLocal1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try
        {
            java.awt.Desktop.getDesktop().open
              (new File("Relatorios/Excel/relOS.xlsm"));
        }
        catch(Exception e)
        {
            
        }  
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try
        {
            java.awt.Desktop.getDesktop().open
              (new File("Relatorios/Excel/relPatrimonio.xlsm"));
        }
        catch(Exception e)
        {
            
        }  
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        try
        {
            java.awt.Desktop.getDesktop().open
              (new File("Relatorios/Excel/relPCs.xlsm"));
        }
        catch(Exception e)
        {
            
        }  
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try
        {
            java.awt.Desktop.getDesktop().open
              (new File("Relatorios/Excel/relSoftwaresInstalados.xlsm"));
        }
        catch(Exception e)
        {
            
        }        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuCadGrupo;
    private javax.swing.JMenuItem MenuCadHardware;
    private javax.swing.JMenuItem MenuCadPatrimonio;
    private javax.swing.JMenu MenuCadastro;
    private javax.swing.JMenuItem MenuConSoftware;
    private javax.swing.JMenuItem MenuConsHardware;
    private javax.swing.JMenuItem MenuConsLocal;
    private javax.swing.JMenuItem MenuConsPatrimonio;
    private javax.swing.JMenu MenuConsulta;
    private javax.swing.JMenu MenuOS;
    private javax.swing.JMenuItem MenuOSnfechadas;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    public javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem menuAbrirOS;
    private javax.swing.JMenuItem menuCadLocal;
    private javax.swing.JMenuItem menuCadSoftware;
    private javax.swing.JMenuItem menuCadUser;
    private javax.swing.JMenu menuConfig;
    private javax.swing.JMenuItem menuConsOS;
    private javax.swing.JMenuItem menuConsTipoUser;
    private javax.swing.JMenuItem menuConsUser;
    private javax.swing.JMenuItem menuMinhasOS;
    private javax.swing.JMenu menuRelHardware;
    private javax.swing.JMenuItem menuRelLocal;
    private javax.swing.JMenuItem menuRelLocal1;
    private javax.swing.JMenu menuRelOS;
    private javax.swing.JMenu menuRelPatr;
    private javax.swing.JMenu menuRelSoftware;
    private javax.swing.JMenuItem menuRelTipoUser;
    private javax.swing.JMenuItem menuRelTipoUser1;
    private javax.swing.JMenu menuRelUser;
    private javax.swing.JMenu menuRelatorio;
    private javax.swing.JMenu menuSair;
    // End of variables declaration//GEN-END:variables
}
