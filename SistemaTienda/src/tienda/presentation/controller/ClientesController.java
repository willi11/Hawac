/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import tienda.Application;
import tienda.entities.Apartado;
import tienda.entities.Cliente;
import tienda.logic.model.Model;
import tienda.presentation.model.TiendaModel;
import tienda.presentation.view.ClientesView;

/**
 *
 * @author Marco
 */
public class ClientesController {
      ClientesView view;
   TiendaModel model;
   Model logicModel=new Model();

    public ClientesController(ClientesView view, TiendaModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
   
    
    public void buscar(){
         List<Cliente> rows=new ArrayList<Cliente>();
        if(view.cedulaRB.isSelected()){
             model.getFiltro().setId(view.nombreFld.getText());
            rows = logicModel.searchClientesId(model.getFiltro());
        }
        else{
           model.getFiltro().setNombre(view.nombreFld.getText());
           rows = logicModel.searchClientes(model.getFiltro());
        }
        model.setClientes(rows);
    }
    public void listarApartados(int row){
         Cliente seleccionada = model.getClientesModel().getRowAt(row); 
         List<Apartado> apartados=logicModel.apartados(seleccionada);
         seleccionada.setLista_apartados(apartados);
         Application.APARTADOS_VIEW.getModel().setApartados(apartados);
         Application.APARTADOS_VIEW.setVisible(true);
         
    }
     public void borrar(int row){
        Cliente seleccionada = model.getClientesModel().getRowAt(row); 
        try {
            if(logicModel.getApartadoCliente(seleccionada)==null)
                logicModel.deleteCliente(seleccionada);
            else
                JOptionPane.showMessageDialog(view, "El cliente Tiene un apartado.", "No se puede Eliminar", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            //todo
        }
        List<Cliente> rowsMod = logicModel.searchClientes(model.getFiltro());
        model.setClientes(rowsMod);
    }
    public void editar(int row){
        model.clearErrors();
        Cliente seleccionada = model.getClientesModel().getRowAt(row); 
        model.setModo(Application.MODO_EDITAR);
        model.setClienteCurrent(seleccionada);
        Application.CLIENTE_VIEW.setVisible(true);
    }
}
