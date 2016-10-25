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
import javax.swing.DefaultComboBoxModel;
import tienda.entities.Abono;
import tienda.entities.PagoEfectivo;

/**
 *
 * @author William
 */
public class AbonoModel extends java.util.Observable{
    public AbonoModel() {
        initAbono();
        initAbonos();
    }

//======= PERSONA ============    
    Abono abonoCurrent;
    ComboBoxModel<Abono> apartados;
    Hashtable<String,String> errores;
    String mensaje;
    int modo;
    

    private void initAbono(){
        try {
        setAbonoCurrent(new PagoEfectivo());
        clearErrors();
        }
        catch (Exception e){
            System.out.println(e);
        }
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
    public Abono getAbonoCurrent() {
        return abonoCurrent;
    }

    public void setAbonoCurrent(Abono abonoCurrent) {
        this.abonoCurrent = abonoCurrent;
        setChanged();
        notifyObservers(ABONO_CURRENT);        
    }

//======== PERSONAS ===========
    Abono filtro;
    AbonoTableModel personasModel;
    
    private void initAbonos(){
        //filtro = new Abono(); MAMANDO TUCAS
        List<Abono> rows = new ArrayList<Abono>();
        setAbonos(rows);
    }
    
    public void setAbonos(List<Abono> rows){
        int[] cols={AbonoTableModel.ID,AbonoTableModel.MONTO,AbonoTableModel.FECHA, AbonoTableModel.TIPO,
                    AbonoTableModel.BANCO, AbonoTableModel.REFERENCIA};
        setPersonasModel(new AbonoTableModel(cols,rows));        
    }
    
    public Abono getFiltro() {
        return filtro;
    }
    
    public void setFiltro(Abono filtro) {
        this.filtro = filtro;
    }
    
     public AbonoTableModel getPersonasModel() {
        return personasModel;
    }

    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(ABONO_MODEL);
        setChanged();  
        //notifyObservers(ABONO_CURRENT);      
    }
    
    public void setPersonasModel(AbonoTableModel personasModel) {
        this.personasModel = personasModel;
        setChanged();
        notifyObservers(ABONO_MODEL);
    }
    public static Integer ABONO_CURRENT=2;
    public static Integer ABONO_MODEL=1;
}
