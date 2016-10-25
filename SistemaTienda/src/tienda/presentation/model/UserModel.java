/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.model;

import java.util.Hashtable;
import tienda.entities.Usuario;

/**
 *
 * @author William
 */
public class UserModel extends java.util.Observable{
       public UserModel() {
        initUsuario();
       // initUsuarios();
        
    }

//======= PRODUCTO ============    
    Usuario usuarioCurrent;
    Hashtable<String,String> errores;
    String mensaje;
    int modo;
    

    private void initUsuario(){
       
        setProductoCurrent(new Usuario());
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
    public Usuario getProductoCurrent() {
        return usuarioCurrent;
    }

    public void setProductoCurrent(Usuario productoCurrent) {
        this.usuarioCurrent = productoCurrent;
        setChanged();
        notifyObservers(PRODUCTO_CURRENT);        
    }

   

//======== PRODUCTOS ===========
//    Usuario filtro;
//    UsuarioTableModel productosModel;
//    
//    private void initProductos(){
//        filtro = new Producto();
//        List<Producto> rows = new ArrayList<Producto>();
//        setProductos(rows);
//    }
//    
//    public void setProductos(List<Producto> rows){
//        int[] cols={ProductoTableModel.ID,ProductoTableModel.NOMBRE,
//            ProductoTableModel.PRECIO};
//        setProductosModel(new ProductoTableModel(cols,rows));        
//    }
//    
//    public Producto getFiltro() {
//        return filtro;
//    }
//    
//    public void setFiltro(Producto filtro) {
//        this.filtro = filtro;
//    }
//    
//     public ProductoTableModel getProductosModel() {
//        return productosModel;
//    }
//
//    public void addObserver(java.util.Observer o) {
//        super.addObserver(o);
//        setChanged();
//        notifyObservers(PRODUCTO_CURRENT);
//        setChanged();        
//        notifyObservers(PRODUCTOS_MODEL);
//    }
//    
//    public void setProductosModel(ProductoTableModel productosModel) {
//        this.productosModel = productosModel;
//        setChanged();
//        notifyObservers(PRODUCTOS_MODEL);
//    }
    
    public static Integer PRODUCTO_CURRENT=1;
    public static Integer PRODUCTOS_MODEL=2;
}

