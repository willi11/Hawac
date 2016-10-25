/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.controller;

import java.util.List;
import tienda.Application;
import tienda.entities.Abono;
import tienda.entities.Apartado;
import tienda.entities.PagoCheque;
import tienda.entities.PagoEfectivo;
import tienda.entities.PagoTarjeta;
import tienda.logic.model.Model;
import tienda.presentation.model.AbonoModel;
import tienda.presentation.view.FormularioAbono;

/**
 *
 * @author Marco
 */
public class AbonoController {
    FormularioAbono view;
    AbonoModel model;
    Model logicModel = new Model();

    public AbonoController(FormularioAbono view, AbonoModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

   public void guardar(){
        Abono a = new PagoEfectivo();
        Abono nueva=(Abono)a;
        
        PagoEfectivo pagoE = new PagoEfectivo();
        PagoTarjeta pagoT = new PagoTarjeta();
        PagoCheque pagoC = new PagoCheque();
        model.clearErrors();
        
        nueva.setMount(view.montoFld.getText());
       if (view.montoFld.getText().length() == 0) {
           model.getErrores().put("monto", "Monto requerido");
       } else if (!isNumeric(view.montoFld.getText())) {
           model.getErrores().put("monto", "El monto debe ser un numero");
       } else {
           int n = Integer.parseInt(view.montoFld.getText());
           if (n < 0) {
               model.getErrores().put("monto", "Monto requerido");
           }
       }      
        if (view.TarjetaCB.isSelected()){ 
            pagoT.setBoxNumber(nueva.getBoxNumber());
            pagoT.setMount(nueva.getMount());
            pagoT.setPayDate(nueva.getPayDate());
            pagoT.setIdApartado(nueva.getIdApartado());
            
            pagoT.setCardNumber(view.tarjetaFld.getText());
            if (view.tarjetaFld.getText().isEmpty()) {
                model.getErrores().put("tarjeta", "Número de tarjeta requerida");
            } else if (!isNumeric(view.tarjetaFld.getText())) {
                model.getErrores().put("tarjeta", "El número de tarjeta debe ser numeral");
            } else {
                int n = Integer.parseInt(view.tarjetaFld.getText());
                if (n < 0) {
                   model.getErrores().put("tarjeta", "Número de tarjeta requerida");
                }
            }
            
           pagoT.setDeadLine(view.vencimientoFld.getText());
            if (view.vencimientoFld.getText().isEmpty())
                model.getErrores().put("vencimiento", "Fecha requerida");
            
            pagoT.setReferenceNumber(view.referenciaFld.getText());
            if (view.referenciaFld.getText().isEmpty()) {
                model.getErrores().put("referencia", "Referencia requerida");
            } else if (!isNumeric(view.referenciaFld.getText())) {
                model.getErrores().put("referencia", "El número de referencia debe ser numeral");
            } else {
                int n = Integer.parseInt(view.referenciaFld.getText());
                if (n < 0) {
                     model.getErrores().put("referencia", "Referencia requerida");
                }
            }
        }
        else if (view.EfectivoRB.isSelected()){
             pagoE.setBoxNumber(nueva.getBoxNumber());
            pagoE.setMount(nueva.getMount());
            pagoE.setPayDate(nueva.getPayDate());
            pagoE.setIdApartado(nueva.getIdApartado());
        }
        else if (view.chequeCB.isSelected()){
            pagoC.setBoxNumber(nueva.getBoxNumber());
            pagoC.setMount(nueva.getMount());
            pagoC.setPayDate(nueva.getPayDate());
            pagoC.setIdApartado(nueva.getIdApartado());
           
            pagoC.setBank(view.siglasFld.getText());
            if (view.siglasFld.getText().isEmpty())
                model.getErrores().put("siglas", "Siglas requeridas"); 
                
             pagoC.setCheckNumber(view.chequeFld.getText());
            if (view.chequeFld.getText().isEmpty())
                model.getErrores().put("cheque", "Numero de cheque requerido");
            else if (!isNumeric(view.chequeFld.getText())) {
                model.getErrores().put("cheque", "El número de cheque debe ser numeral");
            } else {
                int n = Integer.parseInt(view.chequeFld.getText());
                if (n < 0) {
                     model.getErrores().put("cheque", "Numero de cheque requerido");
                }
            }
            
        }
         if (!view.EfectivoRB.isSelected() && !view.TarjetaCB.isSelected()&& !view.chequeCB.isSelected()){
            model.getErrores().put("tipopago", "Tipo de pago requerido requerido");
        }
        if (model.getErrores().isEmpty()){
            try{
                int row = Application.APARTADOS_VIEW.apartadosFld.getSelectedRow();
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        if (view.TarjetaCB.isSelected()){
                            
                            //logicModel.getApartado(String.valueOf(row)).addAbono(pagoT);
                            pagoT.setIdApartado(view.getId_apartado());
                            pagoT.setPayDate(view.nombreFld.getText());
                            
                            int n=logicModel.addAbono(pagoT);
                            model.setMensaje("ABONO "+n+" AGREGADO");
                            Apartado ap=logicModel.getApartadosAbono(pagoT);
                            List<Abono> abonos=logicModel.abonos(ap);
                            ap.setLista_abonos(abonos);
                            if(Double.parseDouble(ap.saldoPendiente())<=0){
                            Apartado b=new Apartado();
                            b.setNumeroApartado(pagoT.getIdApartado());
                             logicModel.deleteAbono(b);
                            logicModel.deleteApartado(b);
                        }
                            model.setAbonoCurrent(nueva);
                        }
                        else if (view.EfectivoRB.isSelected()){
                            //logicModel.getApartado(String.valueOf(row+1)).addAbono(pagoE);
                            pagoE.setPayDate(view.nombreFld.getText());
                            pagoE.setIdApartado(view.getId_apartado());
                            int n=logicModel.addAbono(pagoE);
                            model.setMensaje("ABONO "+n+" AGREGADO");
                            Apartado ap=logicModel.getApartadosAbono(pagoE);
                            List<Abono> abonos=logicModel.abonos(ap);
                            ap.setLista_abonos(abonos);
                            if (Double.parseDouble(ap.saldoPendiente()) <= 0) {
                                Apartado b = new Apartado();
                                b.setNumeroApartado(pagoE.getIdApartado());
                                logicModel.deleteAbono(b);
                                logicModel.deleteApartado(b);
                                
                            }
                            model.setAbonoCurrent(nueva);
                        }
                        else if (view.chequeCB.isSelected()){
                            //logicModel.getApartado(String.valueOf(row)).addAbono(pagoC);
                            pagoC.setPayDate(view.nombreFld.getText());
                            pagoC.setIdApartado(view.getId_apartado());
                            int n=logicModel.addAbono(pagoC);
                            model.setMensaje("ABONO "+n+" AGREGADO");
                            Apartado ap=logicModel.getApartadosAbono(pagoC);
                            List<Abono> abonos=logicModel.abonos(ap);
                            ap.setLista_abonos(abonos);
                            if (Double.parseDouble(ap.saldoPendiente()) <= 0) {
                                Apartado b = new Apartado();
                                b.setNumeroApartado(pagoC.getIdApartado());
                                logicModel.deleteAbono(b);
                                logicModel.deleteApartado(b);
                                
                            }
                            model.setAbonoCurrent(new PagoEfectivo());
                        }
                        else{}
                        
                        break;
//                    case Application.MODO_EDITAR:
//                        Application.Model.updateAbono(nueva);
//                        model.setMensaje("ABONO MODIFICADADA");
//                        model.setAbonoCurrent(nueva);
//                        
//                        List<Abono> rowsMod = Application.Model.searchAbonos(model.getFiltro());
//                        model.setAbonos(rowsMod);
//                        //view.setVisible(false);
//                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("id", "Abono ya existe");
                model.setMensaje("ABONO YA EXISTE");
                model.setAbonoCurrent(nueva);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setAbonoCurrent(nueva);
        }
    }   
   public boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}