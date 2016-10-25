/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import tienda.entities.Cliente;

/**
 * @author Marco
 */
public class TiendaModel extends java.util.Observable{
    public TiendaModel() {
        initCliente();
        initClientes();
    }

//======= CLIENTE ============    
    Cliente clienteCurrent;
    
    Hashtable<String,String> errores;
    String mensaje;
    int modo;
    

    private void initCliente(){
       
        setClienteCurrent(new Cliente());
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
    public Cliente getClienteCurrent() {
        return clienteCurrent;
    }

    public void setClienteCurrent(Cliente clienteCurrent) {
        this.clienteCurrent = clienteCurrent;
        setChanged();
        notifyObservers(CLIENTE_CURRENT);        
    }

   

//======== CLIENTES ===========
    Cliente filtro;
    ClienteTableModel clientesModel;
    
    private void initClientes(){
        filtro = new Cliente();
        List<Cliente> rows = new ArrayList<Cliente>();
        setClientes(rows);
    }
    
    public void setClientes(List<Cliente> rows){
        int[] cols={ClienteTableModel.ID,ClienteTableModel.NOMBRE,
            ClienteTableModel.PRIMERAPELLIDO,
            ClienteTableModel.DIRECCION};
        setClientesModel(new ClienteTableModel(cols,rows));        
    }
    
    public Cliente getFiltro() {
        return filtro;
    }
    
    public void setFiltro(Cliente filtro) {
        this.filtro = filtro;
    }
    
     public ClienteTableModel getClientesModel() {
        return clientesModel;
    }

    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(CLIENTE_CURRENT);
        setChanged();        
        notifyObservers(CLIENTES_MODEL);
    }
    
    public void setClientesModel(ClienteTableModel clientesModel) {
        this.clientesModel = clientesModel;
        setChanged();
        notifyObservers(CLIENTES_MODEL);
    }
    
    public static Integer CLIENTE_CURRENT=1;
    public static Integer CLIENTES_MODEL=2;
}
