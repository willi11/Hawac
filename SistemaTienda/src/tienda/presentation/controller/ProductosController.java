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
import tienda.entities.Producto;
import tienda.logic.model.Model;
import tienda.presentation.model.ProductoModel;
import tienda.presentation.view.ProductosView;

/**
 *
 * @author Marco
 */
public class ProductosController {
   ProductosView view;
   ProductoModel model;
   Model logicModel=new Model();

    public ProductosController(ProductosView view, ProductoModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public Model getLogicModel() {
        return logicModel;
    }
   
    
    public void buscar(){
        model.getFiltro().setDescripcion(view.nombreFld.getText());
        List<Producto> rows = logicModel.searchProductos(model.getFiltro());
        model.setProductos(rows);
    }
    public void borrar(int row){
        Producto seleccionada = model.getProductosModel().getRowAt(row); 
        try {
            logicModel.deleteProducto(seleccionada);
        } catch (Exception ex) {
            //todo
        }
        List<Producto> rowsMod = logicModel.searchProductos(model.getFiltro());
        model.setProductos(rowsMod);
    }
    public void apartar(int row){
        Producto seleccionado = model.getProductosModel().getRowAt(row);
        Application.APARTADO_VIEW.descripcionFld.setText(seleccionado.getId());
         Application.APARTADO_VIEW.montoFld.setText(Float.toString(seleccionado.getValor()));
         Application.APARTADO_VIEW.fechaRealizadoFld.setText(fechaActual());
          model.setModo(Application.MODO_EDITAR);
        Application.APARTADO_VIEW.setVisible(true);
        
    }
    public void editar(int row){
       model.clearErrors();
        Producto seleccionada = model.getProductosModel().getRowAt(row); 
        model.setModo(Application.MODO_EDITAR);
        model.setProductoCurrent(seleccionada);
        Application.PRODUCTO_VIEW.setVisible(true);
    }
     public String fechaActual() {

        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);

    }
}
