/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.view;

import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.System.exit;
import java.util.Observable;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import tienda.presentation.controller.UserController;
import tienda.presentation.model.UserModel;

/**
 *
 * @author William
 */
public class UsuarioView extends javax.swing.JFrame implements java.util.Observer{

    /**
     * Creates new form UsuarioView
     */
    UserModel model;
    UserController controller;
KeyEvent ke;
    public JPasswordField getCampoContraseña() {
        return Contraseña;
    }

    public JTextField getUsuarioTex() {
        return UsuarioTex;
    }

    public void setUsuarioTex(JTextField UsuarioTex) {
        this.UsuarioTex = UsuarioTex;
    }

    public void setContraseña(JPasswordField Contraseña) {
        this.Contraseña = Contraseña;
    }

    public UserController getController() {
        return controller;
    }

    public void setController(UserController controller) {
        this.controller = controller;
    }

    public UserModel getModel() {
        return model;
    }

    public void setModel(UserModel model) {
        this.model = model;
        this.model.addObserver(this);
        // this.fechaMaximaFld.setVisible(false);
    }

    public UsuarioView(java.awt.Frame parent, boolean modal) {
        //super(parent, modal);
        initComponents();
    }

    public UsuarioView() {
        initComponents();
        
        this.addWindowListener(new WindowAdapter() {
                public void windowOpened( WindowEvent e ){
       UsuarioTex.requestFocus();
    }
        });

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

        Usuariolbl = new javax.swing.JLabel();
        EntrarBt = new javax.swing.JButton();
        UsuarioTex = new javax.swing.JTextField();
        SalirBt = new javax.swing.JButton();
        Contrasenalbl = new javax.swing.JLabel();
        Contraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Usuariolbl.setText("Usuario");

        EntrarBt.setText("Entrar");
        EntrarBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntrarBtActionPerformed(evt);
            }
        });

        SalirBt.setText("Salir");
        SalirBt.setBorderPainted(false);
        SalirBt.setDefaultCapable(false);
        SalirBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirBtActionPerformed(evt);
            }
        });

        Contrasenalbl.setText("Contraseña");

        Contraseña.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(89, 89, 89)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(EntrarBt)
                            .addGap(50, 50, 50)
                            .addComponent(SalirBt))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Contrasenalbl)
                                .addComponent(Usuariolbl))
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(UsuarioTex)
                                .addComponent(Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(89, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(58, 58, 58)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Usuariolbl)
                        .addComponent(UsuarioTex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(37, 37, 37)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Contrasenalbl)
                        .addComponent(Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EntrarBt)
                        .addComponent(SalirBt))
                    .addGap(59, 59, 59)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EntrarBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntrarBtActionPerformed
        //        try {
            //                 if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                //              EntrarBtActionPerformed(null);
                //          }
            controller.buscar();
            //        } catch (Exception ex) {
            //            System.out.println("error no encontre");
            //            Logger.getLogger(UsuarioView.class.getName()).log(Level.SEVERE, null, ex);
            //        }

        // TODO add your handling code here:
    }//GEN-LAST:event_EntrarBtActionPerformed

    private void SalirBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirBtActionPerformed
        exit(0);
    }//GEN-LAST:event_SalirBtActionPerformed

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
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Contrasenalbl;
    public javax.swing.JPasswordField Contraseña;
    public javax.swing.JButton EntrarBt;
    public javax.swing.JButton SalirBt;
    public javax.swing.JTextField UsuarioTex;
    public javax.swing.JLabel Usuariolbl;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
