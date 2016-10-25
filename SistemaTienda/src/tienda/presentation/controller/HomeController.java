/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import tienda.Application;
import tienda.presentation.model.TiendaModel;
import tienda.presentation.view.Home;

/**
 *
 * @author Marco
 */
public class HomeController {
        Home view;
   TiendaModel model;

    public HomeController(Home view, TiendaModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    public void preAgregar(){
        //model.clearErrors();
        model.setModo(Application.MODO_EDITAR);
        Application.CLIENTES_VIEW.setVisible(true);
    }
    public String fechaActual() {

        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatoFecha.format(fecha);

    }

    public String horaActual() {
        Date time = new Date();

        SimpleDateFormat formatoFecha = new SimpleDateFormat("hh:mm:ss");

        return formatoFecha.format(time);
    }
}
