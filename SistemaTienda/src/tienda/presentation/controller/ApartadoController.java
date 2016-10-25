/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import tienda.Application;
import tienda.entities.Apartado;
import tienda.logic.model.Model;
import tienda.presentation.model.ApartadoModel;
import tienda.presentation.view.FormularioApartado;


/**
 *
 * @author Marco
 */
public class ApartadoController {
    FormularioApartado view;
    ApartadoModel model;
    Model logicModel=new Model();
    
    public ApartadoController(FormularioApartado view, ApartadoModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
   
    public void guardar(){
        Apartado nueva = new Apartado();
        model.clearErrors();
        
        nueva.setId_cliente(view.idCliente.getText());
        if (view.idCliente.getText().length() == 0) {
            model.getErrores().put("id", "Id requerido");
        } else if (!isNumeric(view.idCliente.getText())) {
            model.getErrores().put("id", "La identificación debe ser numeral");
        } else if(logicModel.existeCliente(view.idCliente.getText()).isEmpty()) {
            model.getErrores().put("id", "El cliente no existe, digite una identificación de cliente existente ");
        }else {
            int n = Integer.parseInt(view.idCliente.getText());
            if (n < 0) {
                model.getErrores().put("id", "Id requerido");
            }
        }
        
        
        nueva.setFechaMaximaRetiro(view.fechaMaximaFld.getText());
        if (view.fechaMaximaFld.getText().length()==0){
            model.getErrores().put("fechamaxima", "Fecha máxima de retiro requerida");
        }
        
        if (model.getErrores().isEmpty()){
            
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        nueva.setDescripcion(view.descripcionFld.getText());
                        nueva.setFechaRealizado(view.fechaRealizadoFld.getText());
                        nueva.setMonto(view.montoFld.getText());
                        int n=logicModel.addApartado(nueva);
                        model.setMensaje("APARTADO "+n+" AGREGADO");
                        model.setApartadoCurrent(new Apartado());
                        
            //            Application.APARTADO_VIEW.setVisible(false);
                       // List<Apartado> rowsAgr = logicModel.searchApartados(model.getFiltro());
                        //model.setApartados(rowsAgr);                        
                        break;
                    case Application.MODO_EDITAR:
                        logicModel.updateApartado(nueva);
                        model.setMensaje("APARTADO MODIFICADO");
                        //model.setApartadoCurrent(nueva);
                        model.setApartadoCurrent(new Apartado());
                        model.setModo(Application.MODO_AGREGAR);
                        List<Apartado> rowsMod = logicModel.searchApartados(model.getFiltro());
                        model.setApartados(rowsMod);
                        view.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("id", "Apartado ya existe");
                model.setMensaje("APARTADO YA EXISTE");
                model.setApartadoCurrent(nueva);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setApartadoCurrent(nueva);
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

