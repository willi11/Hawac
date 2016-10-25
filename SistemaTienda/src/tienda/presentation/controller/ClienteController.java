/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.controller;

import java.util.List;
import tienda.Application;
import tienda.entities.Cliente;
import tienda.logic.model.Model;
import tienda.presentation.model.TiendaModel;
import tienda.presentation.view.FormularioCliente;

/**
 *
 * @author Marco
 */
public class ClienteController {
    FormularioCliente view;
    TiendaModel model;
    Model logicModel=new Model();
    
    public ClienteController(FormularioCliente view, TiendaModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    public void guardar(){
        Cliente nueva = new Cliente();
        model.clearErrors();
        
        nueva.setId(view.idFld.getText());
        if (view.idFld.getText().length()==0){
            model.getErrores().put("id", "Id requerido");
        }
        else if (!isNumeric(view.idFld.getText())) {
            model.getErrores().put("id", "La identificación debe ser numeral");
        }else if(!logicModel.existeCliente(view.idFld.getText()).isEmpty()) {
            model.getErrores().put("id", "El cliente existe, digite una nueva identificación ");
        } else {
            int n = Integer.parseInt(view.idFld.getText());
            if (n < 0) {
                model.getErrores().put("id", "Id requerido");
            }
        }
        
        nueva.setNombre(view.nombreFld.getText());
        if (view.nombreFld.getText().length()==0){
            model.getErrores().put("nombre", "Nombre requerido");
        }
        nueva.setPrimerApellido(view.apellido1Fld.getText());
        if (view.apellido1Fld.getText().length()==0){
            model.getErrores().put("primer apellido", "Primer apellido requerido");
        }
        nueva.setSegundoApellido(view.apellido2Fld.getText());
        if (view.apellido2Fld.getText().length()==0){
            model.getErrores().put("segundo apellido", "Segundo apellido requerido");
        }
        nueva.setDireccion(view.direccionFld.getText());
        if (view.direccionFld.getText().length()==0){
            model.getErrores().put("direccion", "Dirección requerida");
        }
        nueva.setTelefono(view.telefonoFld.getText());
        if (view.telefonoFld.getText().length()==0){
            model.getErrores().put("telefono", "Teléfono requerido");
        }
        
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        logicModel.addCliente(nueva);
                        model.setMensaje("CLIENTE AGREGADO");
                        model.setClienteCurrent(new Cliente());
                        List<Cliente> rowsAgr = logicModel.searchClientes(model.getFiltro());
                        model.setClientes(rowsAgr);                        
                        break;
                    case Application.MODO_EDITAR:
                        logicModel.updateCliente(nueva);
                        model.setMensaje("CLIENTE MODIFICADO");
                       // model.setClienteCurrent(nueva);
                        model.setClienteCurrent(new Cliente());
                        model.setModo(Application.MODO_AGREGAR);
                        List<Cliente> rowsMod = logicModel.searchClientes(model.getFiltro());
                        model.setClientes(rowsMod);
                        view.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("id", "Cliente ya existe");
                model.setMensaje("CLIENTE YA EXISTE");
                model.setClienteCurrent(nueva);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setClienteCurrent(nueva);
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
