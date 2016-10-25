/*
 * Byron Picado Obando
 * I Proyecto Programado Programación III
 * Universidad Nacional de Costa Rica
 * Escuela de Informática
 */
package tienda.presentation.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import tienda.entities.Abono;
import tienda.entities.Apartado;
import tienda.logic.model.Model;
import tienda.presentation.model.AbonoModel;
import tienda.presentation.model.ApartadoModel;
import tienda.presentation.view.AbonosView;
import tienda.presentation.view.ApartadosView;

/**
 *
 * @author Byron
 */
public class AbonosController {
     AbonosView view;
     AbonoModel model;
     Model logicModel=new Model();

    public AbonosController(AbonosView view, AbonoModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    
     public void buscar(){
         Apartado ap=view.getApartado();
        view.setIdApartado(ap.getNumeroApartado());
        String id = view.getIdApartado();
        List<Abono> rows = logicModel.searchAbonos(id);
        model.setAbonos(rows);
        ap.setLista_abonos(rows);
        view.setSaldoPendiente(ap.saldoPendiente());
        
    }
     
}
