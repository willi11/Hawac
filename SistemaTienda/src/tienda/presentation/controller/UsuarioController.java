/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.controller;

import java.util.List;
import tienda.Application;
import tienda.entities.Cliente;
import tienda.entities.Usuario;
import tienda.logic.model.Model;
import tienda.presentation.model.TiendaModel;
import tienda.presentation.model.UserModel;
import tienda.presentation.view.FormularioCliente;
import tienda.presentation.view.FormularioUsuario;

/**
 *
 * @author William
 */
public class UsuarioController {
    FormularioUsuario view;
    UserModel model;
    Model logicModel=new Model();
    
    public UsuarioController(FormularioUsuario view, UserModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    public void guardar(){
        Usuario nueva = new Usuario();
        model.clearErrors();
        
        nueva.setNombre(view.nombreTex.getText());
        if (view.nombreTex.getText().length()==0){
            model.getErrores().put("nombre", "Nombre requerido");
        }
               
        nueva.setContraseña(view.contaseTex.getText());
        if (view.contaseTex.getText().length()==0){
            model.getErrores().put("contraseña", "Contraseña requerido");
        }
        if(view.administradorRB.isSelected()){
            nueva.setTipo("super");
        }
        else{
            if(view.dependienteRB.isSelected()){
                nueva.setTipo("normal");
            }
        }
        if(!view.administradorRB.isSelected() && !view.dependienteRB.isSelected()){
            model.getErrores().put("tipo", "Tipo requerido");
        }
        
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        logicModel.addUsuario(nueva);
                        model.setMensaje("USUARIO AGREGADO");
                        model.setUsuarioCurrent(new Usuario());
                        List<Usuario> rowsAgr = logicModel.searchUsuarios(model.getFiltro());
                        model.setUsuarios(rowsAgr);                        
                        break;
                    case Application.MODO_EDITAR:
                        logicModel.updateUsuario(nueva);
                        model.setMensaje("USUARIO MODIFICADO");
                       // model.setClienteCurrent(nueva);
                        model.setUsuarioCurrent(new Usuario());
                        model.setModo(Application.MODO_AGREGAR);
                        List<Usuario> rowsMod = logicModel.searchUsuarios(model.getFiltro());
                        model.setUsuarios(rowsMod);
                        view.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("nombre", "USUARIO ya existe");
                model.setMensaje("USUARIO YA EXISTE");
                model.setUsuarioCurrent(nueva);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setUsuarioCurrent(nueva);
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
