/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import tienda.entities.Producto;

/**
 *
 * @author Marco
 */
public class ProductoModel extends java.util.Observable{
 

    public ProductoModel() {
        initProducto();
        initProductos();
    }

//======= PRODUCTO ============    
    Producto productoCurrent;
    Hashtable<String,String> errores;
    String mensaje;
    int modo;
    

    private void initProducto(){
       
        setProductoCurrent(new Producto());
        clearErrors();
    }

    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Hashtable<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Hashtable<String, String> errores) {
        this.errores = errores;
    }
    
    public void clearErrors(){
        setErrores(new Hashtable<String,String>());
        setMensaje("");
        
    }
    public Producto getProductoCurrent() {
        return productoCurrent;
    }

    public void setProductoCurrent(Producto productoCurrent) {
        this.productoCurrent = productoCurrent;
        setChanged();
        notifyObservers(PRODUCTO_CURRENT);        
    }

   

//======== PRODUCTOS ===========
    Producto filtro;
    ProductoTableModel productosModel;
    
    private void initProductos(){
        filtro = new Producto();
        List<Producto> rows = new ArrayList<Producto>();
        setProductos(rows);
    }
    
    public void setProductos(List<Producto> rows){
        int[] cols={ProductoTableModel.DESCRIPCION,ProductoTableModel.COLOR,
            ProductoTableModel.GENERO,ProductoTableModel.TALLA,ProductoTableModel.VALOR};
        setProductosModel(new ProductoTableModel(cols,rows));        
    }
    
    public Producto getFiltro() {
        return filtro;
    }
    
    public void setFiltro(Producto filtro) {
        this.filtro = filtro;
    }
    
     public ProductoTableModel getProductosModel() {
        return productosModel;
    }

    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(PRODUCTO_CURRENT);
        setChanged();        
        notifyObservers(PRODUCTOS_MODEL);
    }
    
    public void setProductosModel(ProductoTableModel productosModel) {
        this.productosModel = productosModel;
        setChanged();
        notifyObservers(PRODUCTOS_MODEL);
    }
    
    public static Integer PRODUCTO_CURRENT=1;
    public static Integer PRODUCTOS_MODEL=2;
}


