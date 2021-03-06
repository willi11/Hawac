/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.view;

import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import tienda.Application;
import tienda.entities.Abono;
import tienda.entities.PagoCheque;
import tienda.entities.PagoEfectivo;
import tienda.entities.PagoTarjeta;
import tienda.presentation.controller.AbonoController;
import tienda.presentation.model.AbonoModel;


public class FormularioAbono extends javax.swing.JDialog implements java.util.Observer {

    /**
     * Creates new form 
     */
    public FormularioAbono(java.awt.Frame parent, boolean modal) {
        super(parent,modal);
        initComponents();
        this.vencimientoFld.setVisible(false);
    }
AbonoController controller;
    AbonoModel model;
    String id_apartado;
    
    public void setController(AbonoController controller){
        this.controller=controller;
    }
    public void setModel(AbonoModel model){
        this.model=model;
        this.model.addObserver(this);
    }

    public String getId_apartado() {
        return id_apartado;
    }

    public void setId_apartado(String id_apartado) {
        this.id_apartado = id_apartado;
    }
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pago = new javax.swing.ButtonGroup();
        montoLbl = new javax.swing.JLabel();
        fechaLbl = new javax.swing.JLabel();
        montoFld = new javax.swing.JTextField();
        nombreFld = new javax.swing.JTextField();
        formaPagoLbl = new javax.swing.JLabel();
        guardarBtn = new javax.swing.JButton();
        cancelarBtn = new javax.swing.JButton();
        EfectivoRB = new javax.swing.JRadioButton();
        chequeCB = new javax.swing.JRadioButton();
        TarjetaCB = new javax.swing.JRadioButton();
        siglasLbl = new javax.swing.JLabel();
        siglasFld = new javax.swing.JTextField();
        tarjetaLbl = new javax.swing.JLabel();
        tarjetaFld = new javax.swing.JTextField();
        chequeLbl = new javax.swing.JLabel();
        chequeFld = new javax.swing.JTextField();
        vencimientoLbl = new javax.swing.JLabel();
        vencimientoFld = new javax.swing.JTextField();
        referenciaLbl = new javax.swing.JLabel();
        referenciaFld = new javax.swing.JTextField();
        calendarFld = new com.toedter.calendar.JCalendar();

        setTitle("Abono");
        setAutoRequestFocus(false);
        setResizable(false);

        montoLbl.setText("Monto");

        fechaLbl.setText("Fecha");

        nombreFld.setEditable(false);

        formaPagoLbl.setText("Forma de pago");

        guardarBtn.setText("Guardar");
        guardarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBtnActionPerformed(evt);
            }
        });

        cancelarBtn.setText("Cancelar");
        cancelarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtnActionPerformed(evt);
            }
        });

        Pago.add(EfectivoRB);
        EfectivoRB.setText("Efectivo");
        EfectivoRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EfectivoRBActionPerformed(evt);
            }
        });

        Pago.add(chequeCB);
        chequeCB.setText("Cheque");
        chequeCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chequeCBActionPerformed(evt);
            }
        });

        Pago.add(TarjetaCB);
        TarjetaCB.setText("Tarjeta");
        TarjetaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TarjetaCBActionPerformed(evt);
            }
        });

        siglasLbl.setText("Siglas del Banco");

        tarjetaLbl.setText("Número de Tarjeta");

        chequeLbl.setText("Número de Cheque");

        vencimientoLbl.setText("Fecha de Vencimiento");

        vencimientoFld.setEditable(false);
        vencimientoFld.setDragEnabled(true);
        vencimientoFld.setEnabled(false);

        referenciaLbl.setText("Número de Referencia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(guardarBtn)
                        .addGap(56, 56, 56)
                        .addComponent(cancelarBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(referenciaLbl)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fechaLbl)
                                .addComponent(montoLbl)
                                .addComponent(formaPagoLbl)
                                .addComponent(siglasLbl)
                                .addComponent(tarjetaLbl)
                                .addComponent(vencimientoLbl)
                                .addComponent(chequeLbl)
                                .addComponent(vencimientoFld, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tarjetaFld, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(EfectivoRB)
                                .addGap(36, 36, 36)
                                .addComponent(chequeCB)
                                .addGap(30, 30, 30)
                                .addComponent(TarjetaCB))
                            .addComponent(chequeFld, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(siglasFld, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreFld, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(montoFld, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(referenciaFld, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calendarFld, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(montoLbl))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(montoFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaLbl)
                    .addComponent(nombreFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formaPagoLbl)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EfectivoRB)
                        .addComponent(chequeCB)
                        .addComponent(TarjetaCB)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(siglasLbl)
                    .addComponent(siglasFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chequeFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chequeLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tarjetaLbl)
                    .addComponent(tarjetaFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(vencimientoFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(vencimientoLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(calendarFld, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(referenciaLbl)
                    .addComponent(referenciaFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarBtn)
                    .addComponent(cancelarBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TarjetaCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TarjetaCBActionPerformed
        // TODO add your handling code here:
        this.siglasFld.setVisible(false);
        this.siglasLbl.setVisible(false);
        this.chequeFld.setVisible(false);
        this.chequeLbl.setVisible(false);
        this.vencimientoFld.setVisible(false);
        this.vencimientoLbl.setVisible(true);
        this.calendarFld.setVisible(true);
        this.referenciaFld.setVisible(true);
        this.referenciaLbl.setVisible(true);
        this.tarjetaFld.setVisible(true);
        this.tarjetaLbl.setVisible(true);
    }//GEN-LAST:event_TarjetaCBActionPerformed

    private void EfectivoRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EfectivoRBActionPerformed
        // TODO add your handling code here:
        this.siglasFld.setVisible(false);
        this.siglasLbl.setVisible(false);
        this.tarjetaFld.setVisible(false);
        this.tarjetaLbl.setVisible(false);
        this.chequeFld.setVisible(false);
        this.chequeLbl.setVisible(false);
        this.vencimientoFld.setVisible(false);
        this.calendarFld.setVisible(false);
        this.vencimientoLbl.setVisible(false);
        this.referenciaFld.setVisible(false);
        this.referenciaLbl.setVisible(false);
    }//GEN-LAST:event_EfectivoRBActionPerformed

    private void chequeCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chequeCBActionPerformed
        // TODO add your handling code here:
        this.siglasFld.setVisible(true);
        this.siglasLbl.setVisible(true);
        this.chequeFld.setVisible(true);
        this.chequeLbl.setVisible(true);
        this.vencimientoFld.setVisible(false);
        this.calendarFld.setVisible(false);
        this.vencimientoLbl.setVisible(false);
        this.referenciaFld.setVisible(false);
        this.referenciaLbl.setVisible(false);
        this.tarjetaFld.setVisible(false);
        this.tarjetaLbl.setVisible(false);
    }//GEN-LAST:event_chequeCBActionPerformed

    private void guardarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBtnActionPerformed
        // TODO add your handling code here:
        
            
             SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        String fecha= formatoFecha.format(this.calendarFld.getDate());
        vencimientoFld.setText(fecha);
            controller.guardar();
             
    }//GEN-LAST:event_guardarBtnActionPerformed

    private void cancelarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtnActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelarBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioAbono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioAbono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioAbono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioAbono.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JRadioButton EfectivoRB;
    private javax.swing.ButtonGroup Pago;
    public javax.swing.JRadioButton TarjetaCB;
    private com.toedter.calendar.JCalendar calendarFld;
    public javax.swing.JButton cancelarBtn;
    public javax.swing.JRadioButton chequeCB;
    public javax.swing.JTextField chequeFld;
    public javax.swing.JLabel chequeLbl;
    public javax.swing.JLabel fechaLbl;
    public javax.swing.JLabel formaPagoLbl;
    public javax.swing.JButton guardarBtn;
    public javax.swing.JTextField montoFld;
    public javax.swing.JLabel montoLbl;
    public javax.swing.JTextField nombreFld;
    public javax.swing.JTextField referenciaFld;
    public javax.swing.JLabel referenciaLbl;
    public javax.swing.JTextField siglasFld;
    public javax.swing.JLabel siglasLbl;
    public javax.swing.JTextField tarjetaFld;
    public javax.swing.JLabel tarjetaLbl;
    public javax.swing.JTextField vencimientoFld;
    public javax.swing.JLabel vencimientoLbl;
    // End of variables declaration//GEN-END:variables
    
    
   public void update(java.util.Observable updatedModel,Object parametros){
      if (parametros != AbonoModel.ABONO_CURRENT) return;
       
       Abono abonoCurrent = model.getAbonoCurrent();
       
       PagoEfectivo pagoE = new PagoEfectivo();
        PagoTarjeta pagoT = new PagoTarjeta();
        PagoCheque pagoC = new PagoCheque();
        
       this.montoFld.setEnabled(model.getModo()==Application.MODO_AGREGAR);
       //if (this.TarjetaCB.isSelected())
        // this.siglasFld.setEnabled(false);
       
       montoFld.setText(abonoCurrent.getMount());
        if (model.getErrores().get("monto")!=null){
            montoLbl.setBorder(Application.BORDER_ERROR);
            montoLbl.setToolTipText(model.getErrores().get("monto"));
        }
        else{
            montoLbl.setBorder(null);
            montoLbl.setToolTipText("");
        }
        //this.Pago.clearSelection();
         
        if (this.chequeCB.isSelected()) {
            pagoC.setBoxNumber(abonoCurrent.getBoxNumber());
            pagoC.setMount(abonoCurrent.getMount());
            pagoC.setPayDate(abonoCurrent.getPayDate());
            pagoC.setIdApartado(abonoCurrent.getIdApartado());
                   
           this.chequeCB.setSelected(true);
           this.siglasFld.setEditable(true);
           this.tarjetaFld.setEditable(false);
           this.chequeFld.setEditable(true);
           this.vencimientoFld.setEditable(false);
           this.calendarFld.setVisible(false);
           this.referenciaFld.setEditable(false);
           siglasFld.setText(pagoC.getBank());
            if (model.getErrores().get("siglas") != null) {
                siglasLbl.setBorder(Application.BORDER_ERROR);
                siglasLbl.setToolTipText(model.getErrores().get("siglas"));
            } else {
                siglasLbl.setBorder(null);
                siglasLbl.setToolTipText("");
            }
            chequeFld.setText(pagoC.getCheckNumber());
            if (model.getErrores().get("cheque") != null) {
                chequeLbl.setBorder(Application.BORDER_ERROR);
                chequeLbl.setToolTipText(model.getErrores().get("cheque"));
            } else {
                chequeLbl.setBorder(null);
                chequeLbl.setToolTipText("");
            }
        }
        else if(this.EfectivoRB.isSelected()){
             pagoE.setBoxNumber(abonoCurrent.getBoxNumber());
            pagoE.setMount(abonoCurrent.getMount());
            pagoE.setPayDate(abonoCurrent.getPayDate());
            pagoE.setIdApartado(abonoCurrent.getIdApartado());
            this.EfectivoRB.setSelected(true); 
            this.siglasFld.setEditable(false);
            this.tarjetaFld.setEditable(false);
            this.chequeFld.setEditable(false);
            this.vencimientoFld.setEditable(false);
            this.calendarFld.setVisible(false);
            this.referenciaFld.setEditable(false);
        }
        else if(this.TarjetaCB.isSelected()){
            pagoT.setBoxNumber(abonoCurrent.getBoxNumber());
            pagoT.setMount(abonoCurrent.getMount());
            pagoT.setPayDate(abonoCurrent.getPayDate());
            pagoT.setIdApartado(abonoCurrent.getIdApartado());
            this.TarjetaCB.setSelected(true); 
            this.siglasFld.setEditable(false);
            this.tarjetaFld.setEditable(true);
            this.chequeFld.setEditable(false);
            this.vencimientoFld.setEditable(true);
            this.calendarFld.setVisible(true);
            this.referenciaFld.setEditable(true);
            
            tarjetaFld.setText(pagoT.getCardNumber());
            if (model.getErrores().get("tarjeta") != null) {
                tarjetaLbl.setBorder(Application.BORDER_ERROR);
                tarjetaLbl.setToolTipText(model.getErrores().get("tarjeta"));
            } else {
                tarjetaLbl.setBorder(null);
                tarjetaLbl.setToolTipText("");
            }
            vencimientoFld.setText(pagoT.getDeadLine());
            if (model.getErrores().get("vencimiento") != null) {
                vencimientoLbl.setBorder(Application.BORDER_ERROR);
                vencimientoLbl.setToolTipText(model.getErrores().get("vencimiento"));
            } else {
               vencimientoLbl.setBorder(null);
                vencimientoLbl.setToolTipText("");
            }
            referenciaFld.setText(pagoT.getReferenceNumber());
            if (model.getErrores().get("referencia") != null) {
                referenciaLbl.setBorder(Application.BORDER_ERROR);
                referenciaLbl.setToolTipText(model.getErrores().get("referencia"));
            } else {
               referenciaLbl.setBorder(null);
               referenciaLbl.setToolTipText("");
            }
        }
       
        if (model.getErrores().get("tipoPago")!=null){
            formaPagoLbl.setBorder(Application.BORDER_ERROR);
            formaPagoLbl.setToolTipText(model.getErrores().get("tipoPago"));
        }
        else{
           
           formaPagoLbl.setBorder(null);
           formaPagoLbl.setToolTipText("");
         }
        
        this.validate();
        if (!model.getMensaje().equals("")){
            JOptionPane.showMessageDialog(this, model.getMensaje(), "",JOptionPane.INFORMATION_MESSAGE);
        }
    } 
}
