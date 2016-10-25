/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.model;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.swing.ComboBoxModel;
import tienda.entities.Apartado;
import tienda.entities.Producto;


/**
 *
 * @author Marco
 */
public class ApartadoModel  extends java.util.Observable{
    public ApartadoModel() {
      initApartado();
        initApartados();
    }

//======= PERSONA ============    
    Apartado apartadoCurrent;
    Hashtable<String,String> errores;
    String mensaje;
    int modo;
    

    private void initApartado(){
       /*// try {
        //setEstadosCiviles(new DefaultComboBoxModel(Application.Model.getEstadosCiviles().toArray(new EstadoCivil[0])));
        //AQUI FALTA ----------------
        //setAbonoCurrent(new Abono()); NO SE PUEDE INSTANCIAR ABONO
        clearErrors();
        }
        catch (Exception e){
            System.out.println(e);
        }*/
        setApartadoCurrent(new Apartado());
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
    public Apartado getApartadoCurrent() {
        return apartadoCurrent;
    }

    public void setApartadoCurrent(Apartado apartadoCurrent) {
        this.apartadoCurrent = apartadoCurrent;
        setChanged();
        notifyObservers(APARTADO_CURRENT);        
    }

//======== PERSONAS ===========
    Apartado filtro;
    ApartadoTableModel apartadoModel;//falta apartadotablemodel
    
    private void initApartados(){
        filtro = new Apartado();
        List<Apartado> rows = new ArrayList<Apartado>();
        setApartados(rows);
    }
    
    public void setApartados(List<Apartado> rows){
        int[] cols={
            ApartadoTableModel.ID,
            ApartadoTableModel.DESCRIPTION,
            ApartadoTableModel.MONTO,
            ApartadoTableModel.FECHA,
            ApartadoTableModel.CLIENTE};
        setApartadosModel(new ApartadoTableModel(cols,rows));        
    }
    
    public Apartado getFiltro() {
        return filtro;
    }
    
    public void setFiltro(Apartado filtro) {
        this.filtro = filtro;
    }
    
     public ApartadoTableModel getApartadoModel() {
        return apartadoModel;
    }

    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(APARTADO_CURRENT);
        setChanged();        
        notifyObservers(APARTADO_MODEL);
    }
    
    public void setApartadosModel(ApartadoTableModel personasModel) {
        this.apartadoModel = personasModel;
        setChanged();
        notifyObservers(APARTADO_MODEL);
    }
    public static Integer APARTADO_CURRENT=1;
    public static Integer APARTADO_MODEL=2;
}

