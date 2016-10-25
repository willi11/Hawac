/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tienda.Application;
import tienda.entities.Apartado;
import tienda.entities.Cliente;
import tienda.logic.model.Model;
import tienda.presentation.model.ApartadoModel;
import tienda.presentation.view.ApartadosView;

/**
 *
 * @author Marco
 */
public class ApartadosController {
     ApartadosView view;
     ApartadoModel model;
     Model logicModel=new Model();

    public ApartadosController(ApartadosView view, ApartadoModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
    public void buscar(){
         List<Apartado> rows=new ArrayList<Apartado>();
        if(view.idClienteRB.isSelected()){
             model.getFiltro().setId_cliente(view.nombreFld.getText());
            rows = logicModel.searchApartados(model.getFiltro());
        }
        else{
           model.getFiltro().setNumeroApartado(view.nombreFld.getText());
           rows = logicModel.searchApartadosId(model.getFiltro());
        }
        model.setApartados(rows);
        
    }
    public void borrar(int row){
        Apartado seleccionada = model.getApartadoModel().getRowAt(row); 
        try {
            logicModel.deleteApartado(seleccionada);
        } catch (Exception ex) {
            //todo
        }
        List<Apartado> rowsMod = logicModel.searchApartados(model.getFiltro());
        model.setApartados(rowsMod);
    }
    public void editar(int row){
        model.clearErrors();
        Apartado seleccionada = model.getApartadoModel().getRowAt(row); 
        model.setModo(Application.MODO_EDITAR);
        model.setApartadoCurrent(seleccionada);
        Application.CLIENTE_VIEW.setVisible(true);
    }
    public void abonar(int row){
        Apartado seleccionado = model.getApartadoModel().getRowAt(row);
        Application.FORMULARIO_ABONO.setId_apartado(seleccionado.getNumeroApartado()); 
        Application.FORMULARIO_ABONO.nombreFld.setText(fechaActual());
        model.setModo(Application.MODO_AGREGAR);
        Application.FORMULARIO_ABONO.setVisible(true);
        
    }
    public String fechaActual() {

        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);

    }
    
    public void buscarAbonos(int row){
        Apartado seleccionado = model.getApartadoModel().getRowAt(row);
        Application.ABONOS_VIEW.setApartado(seleccionado);
        Application.ABONOS_VIEW.buscar();
        Application.ABONOS_VIEW.setVisible(true);
    }
}
