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
import tienda.entities.Producto;
import tienda.entities.Usuario;
import tienda.logic.model.Model;
import tienda.presentation.model.ProductoModel;
import tienda.presentation.model.UserModel;
import tienda.presentation.view.ProductosView;
import tienda.presentation.view.UsuariosView;

/**
 *
 * @author William
 */
public class UsuariosController {
    UsuariosView view;
   UserModel model;
   Model logicModel=new Model();

    public UsuariosController(UsuariosView view, UserModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public Model getLogicModel() {
        return logicModel;
    }

    
    public void buscar(){
        model.getFiltro().setNombre(view.buscarTex.getText());
        List<Usuario> rows = logicModel.searchUsuarios(model.getFiltro());
        model.setUsuarios(rows);
    }
    public void borrar(int row){
        Usuario seleccionada = model.getUsuariosModel().getRowAt(row); 
        try {
            logicModel.deleteUsuario(seleccionada);
        } catch (Exception ex) {
            //todo
        }
        List<Usuario> rowsMod = logicModel.searchUsuarios(model.getFiltro());
        model.setUsuarios(rowsMod);
    }
    public void editar(int row){
       model.clearErrors();
        Usuario seleccionada = model.getUsuariosModel().getRowAt(row); 
        model.setModo(Application.MODO_EDITAR);
        model.setUsuarioCurrent(seleccionada);
        Application.PRODUCTO_VIEW.setVisible(true);
    }
     public String fechaActual() {

        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);

    }
}
