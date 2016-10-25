/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.controller;

import java.util.List;
import tienda.Application;
import tienda.entities.Producto;
import tienda.logic.model.Model;
import tienda.presentation.model.ProductoModel;
import tienda.presentation.model.TiendaModel;
import tienda.presentation.view.FormularioProducto;

/**
 *
 * @author Marco
 */
public class ProductoController {
    FormularioProducto view;
    ProductoModel model;
    Model logicModel=new Model();
    
    public ProductoController(FormularioProducto view, ProductoModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
   
    public void guardar(){
        Producto nueva = new Producto();
        model.clearErrors();
        nueva.setId(view.IdTex.getText());
        if(view.IdTex.getText().isEmpty()){
            model.getErrores().put("id", "Id requerido");
        }
        
        nueva.setColor(view.ColorTex.getText());
        if (view.ColorTex.getText().length()==0){
            model.getErrores().put("color", "Color requerido");
        }
        
        nueva.setTalla(view.TipoTex.getText());
        if (view.TipoTex.getText().length()==0){
            model.getErrores().put("talla", "Talla requerido");
        }
        if (view.ValorTex.getText().length()==0){
            model.getErrores().put("valor", "Valor requerido");
        }
        else {
            float m= Float.parseFloat(view.ValorTex.getText());
            nueva.setValor(m);
        }
        if (view.FRb.isSelected()==false && view.MRb.isSelected()==false){
            model.getErrores().put("genero", "Genero requerido");
        }
        else if(view.MRb.isSelected()){
            nueva.setGenero("M");
        }
        else {
            nueva.setGenero("F");
        }
        
        nueva.setDescripcion(view.descripcionTex.getText());
        if (view.descripcionTex.getText().length() == 0) {
            model.getErrores().put("desc", "descripcion requerida");
        }
        
        if (view.CantidadTex.getText().length()==0){
            model.getErrores().put("cantidad", "Cantidad requerido");
        }
        else
            nueva.setCantidad(Integer.parseInt(view.CantidadTex.getText()));
        
        if (model.getErrores().isEmpty()){    
            try{
 
                        logicModel.addProducto(nueva);
                        model.setMensaje("PRODUCTO  AGREGADO");
                        model.setProductoCurrent(new Producto());
                        view.setVisible(false);
                        Application.HOME.setVisible(true);
          
            }
            catch(Exception e){
                model.getErrores().put("id", "Apartado ya existe");
                model.setMensaje("APARTADO YA EXISTE");
                model.setProductoCurrent(nueva);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setProductoCurrent(nueva);
        }
    }   
}
