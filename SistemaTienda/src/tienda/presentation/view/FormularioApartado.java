/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.view;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import tienda.Application;
import tienda.entities.Apartado;
import tienda.presentation.controller.ApartadoController;
import tienda.presentation.model.ApartadoModel;

/**
 *
 * @author Marco
 */
public class FormularioApartado extends java.awt.Dialog implements java.util.Observer{

    /**
     * Creates new form FormularioApartado
     */
    ApartadoController controller;
    ApartadoModel model;

    public ApartadoController getController() {
        return controller;
    }

    public void setController(ApartadoController controller) {
        this.controller = controller;
    }

    public ApartadoModel getModel() {
        return model;
    }

    public void setModel(ApartadoModel model) {
        this.model = model;
        this.model.addObserver(this);
        this.fechaMaximaFld.setVisible(false);
    }
    
    public FormularioApartado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public void update(java.util.Observable updatedModel,Object parametros){
       if (parametros != ApartadoModel.APARTADO_CURRENT) return;
       
       Apartado personaCurrent = model.getApartadoCurrent();
        
       this.idCliente.setEnabled(model.getModo()==Application.MODO_AGREGAR);
       
       idCliente.setText(personaCurrent.getId_cliente());
       if (model.getErrores().get("id")!=null){
            idClienteLbl.setBorder(Application.BORDER_ERROR);
            idClienteLbl.setToolTipText(model.getErrores().get("id"));
        }
        else{
            idClienteLbl.setBorder(null);
            idClienteLbl.setToolTipText("");
        }

        fechaMaximaFld.setText(personaCurrent.getFechaMaximaRetiro());
        if (model.getErrores().get("fechamaxima")!=null){
            fechaMaximaLbl.setBorder(Application.BORDER_ERROR);
            fechaMaximaLbl.setToolTipText(model.getErrores().get("fechamaxima"));
        }
        else{
          fechaMaximaLbl.setBorder(null);
           fechaMaximaLbl.setToolTipText("");
        }

        
        this.validate();
        if (!model.getMensaje().equals("")){
            JOptionPane.showMessageDialog(this, model.getMensaje(), "",JOptionPane.INFORMATION_MESSAGE);
        }
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        descripcionLbl = new javax.swing.JLabel();
        montoLbl = new javax.swing.JLabel();
        fechaRealizadoLbl = new javax.swing.JLabel();
        fechaMaximaLbl = new javax.swing.JLabel();
        idClienteLbl = new javax.swing.JLabel();
        idCliente = new javax.swing.JTextField();
        descripcionFld = new javax.swing.JTextField();
        montoFld = new javax.swing.JTextField();
        fechaRealizadoFld = new javax.swing.JTextField();
        fechaMaximaFld = new javax.swing.JTextField();
        aceptarBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();
        calendar = new com.toedter.calendar.JCalendar();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        descripcionLbl.setText("Descripcion");
        descripcionLbl.setToolTipText("");

        montoLbl.setText("Monto");

        fechaRealizadoLbl.setText("Fecha Realizado");

        fechaMaximaLbl.setText("Fecha Maxima");

        idClienteLbl.setText("Identificación cliente");

        descripcionFld.setEnabled(false);

        montoFld.setEnabled(false);
        montoFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                montoFldActionPerformed(evt);
            }
        });

        fechaRealizadoFld.setEnabled(false);

        fechaMaximaFld.setEditable(false);

        aceptarBtn.setText("Aceptar");
        aceptarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarBtnActionPerformed(evt);
            }
        });

        cancelarBtn.setText("Cancelar");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idClienteLbl)
                            .addComponent(descripcionLbl)
                            .addComponent(fechaRealizadoLbl)
                            .addComponent(montoLbl)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(fechaMaximaLbl)
                                .addComponent(fechaMaximaFld, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(descripcionFld, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(idCliente, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(montoFld, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaRealizadoFld, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(calendar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(aceptarBtn)
                        .addGap(57, 57, 57)
                        .addComponent(cancelarBtn)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idClienteLbl)
                            .addComponent(idCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(descripcionFld, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(descripcionLbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(montoLbl)
                    .addComponent(montoFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaRealizadoLbl)
                    .addComponent(fechaRealizadoFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(fechaMaximaLbl)
                        .addGap(27, 27, 27)
                        .addComponent(fechaMaximaFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelarBtn)
                            .addComponent(aceptarBtn))
                        .addGap(19, 19, 19))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void montoFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_montoFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_montoFldActionPerformed

    private void aceptarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarBtnActionPerformed
         SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        String fecha= formatoFecha.format(this.calendar.getDate());
        fechaMaximaFld.setText(fecha); 
        controller.guardar();  
        
    }//GEN-LAST:event_aceptarBtnActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
         this.setVisible(false); // TODO add your handling code here:
    }//GEN-LAST:event_cancelarBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormularioApartado dialog = new FormularioApartado(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton aceptarBtn;
    private com.toedter.calendar.JCalendar calendar;
    public javax.swing.JButton cancelarBtn;
    public javax.swing.JTextField descripcionFld;
    public javax.swing.JLabel descripcionLbl;
    public javax.swing.JTextField fechaMaximaFld;
    public javax.swing.JLabel fechaMaximaLbl;
    public javax.swing.JTextField fechaRealizadoFld;
    public javax.swing.JLabel fechaRealizadoLbl;
    public javax.swing.JTextField idCliente;
    public javax.swing.JLabel idClienteLbl;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField montoFld;
    public javax.swing.JLabel montoLbl;
    // End of variables declaration//GEN-END:variables
}