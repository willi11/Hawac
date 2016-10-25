/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.view;

import java.awt.Toolkit;
import javax.swing.JOptionPane;
import tienda.Application;
import tienda.presentation.controller.ApartadosController;
import tienda.presentation.model.ApartadoModel;
import tienda.presentation.model.TiendaModel;

/**
 *
 * @author Marco
 */
public class ApartadosView extends javax.swing.JDialog implements java.util.Observer{
    ApartadosController controller;
    ApartadoModel model;

    public ApartadosController getController() {
        return controller;
    }
    public void setButto(boolean e){
        this.agregarBtn.setVisible(e);
    }

    public void setController(ApartadosController controller) {
        this.controller = controller;
    }

    public ApartadoModel getModel() {
        return model;
    }

    public void setModel(ApartadoModel model) {
        this.model = model;
         model.addObserver(this);
    }

   
    
    /**
     * Creates new form ApartadoView
     */
   public ApartadosView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
      this.setLocationRelativeTo(null);
    }
 public void update(java.util.Observable updatedModel,Object parametros){
       if (parametros != TiendaModel.CLIENTES_MODEL) return;
       nombreFld.setText(model.getFiltro().getNumeroApartado());
       apartadosFld.setModel(model.getApartadoModel());
       this.revalidate();
   }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buscarGroup = new javax.swing.ButtonGroup();
        buscarBtn = new javax.swing.JButton();
        nombreFld = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        apartadosFld = new javax.swing.JTable();
        agregarBtn = new javax.swing.JButton();
        abonosBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        idClienteRB = new javax.swing.JRadioButton();
        idApartado = new javax.swing.JRadioButton();

        setTitle("Apartados");

        buscarBtn.setText("Buscar");
        buscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBtnActionPerformed(evt);
            }
        });

        nombreFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreFldActionPerformed(evt);
            }
        });

        apartadosFld.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(apartadosFld);

        agregarBtn.setText("Nuevo Abono");
        agregarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBtnActionPerformed(evt);
            }
        });

        abonosBtn.setText("Ver Abonos");
        abonosBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abonosBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar por:");

        buscarGroup.add(idClienteRB);
        idClienteRB.setSelected(true);
        idClienteRB.setText("Id Cliente");

        buscarGroup.add(idApartado);
        idApartado.setText("Número de Apartado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(39, 39, 39)
                            .addComponent(idClienteRB)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idApartado))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(nombreFld, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(buscarBtn))))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(agregarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(abonosBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idClienteRB)
                    .addComponent(idApartado))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(agregarBtn)
                        .addGap(86, 86, 86)
                        .addComponent(abonosBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreFldActionPerformed

    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBtnActionPerformed
         controller.buscar();
    }//GEN-LAST:event_buscarBtnActionPerformed

    private void agregarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBtnActionPerformed
        int row = this.apartadosFld.getSelectedRow();
        if (this.apartadosFld.isRowSelected(row)) {
            int result = JOptionPane.showConfirmDialog(null, "Desea abonar en este apartado?", null, JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                controller.abonar(row);
                
            }
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "ERROR AL ABONAR, DEBE HABER SELECCIONADO UN APARTADO", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_agregarBtnActionPerformed

    private void abonosBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abonosBtnActionPerformed
        // TODO add your handling code here:
        int row = this.apartadosFld.getSelectedRow();
        if (this.apartadosFld.isRowSelected(row)){
            controller.buscarAbonos(row);
        } else {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Primero seleccione un apartado", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_abonosBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ClientesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientesView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abonosBtn;
    public javax.swing.JButton agregarBtn;
    public javax.swing.JTable apartadosFld;
    public javax.swing.JButton buscarBtn;
    public javax.swing.ButtonGroup buscarGroup;
    public javax.swing.JRadioButton idApartado;
    public javax.swing.JRadioButton idClienteRB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField nombreFld;
    // End of variables declaration//GEN-END:variables
}
