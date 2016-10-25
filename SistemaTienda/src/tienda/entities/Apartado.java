/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marco
 */
public class Apartado implements Serializable{
    private String descripcion;
    private String monto;
    private String numeroApartado;
    private String fechaRealizado;
    private String fechaMaximaRetiro;
    private String id_cliente;
    List<Abono> lista_abonos;
    
    public Apartado(){
        this.descripcion="";
        this.monto="";
        this.numeroApartado="";
        this.fechaRealizado="";
        this.fechaMaximaRetiro="";
        this.id_cliente="";
        this.lista_abonos = new ArrayList<Abono>();
    }

    public Apartado(String descripcion, String monto, String numeroApartado, String fechaRealizado, 
            String fechaMaximaRetiro, String cliente) {
        this.descripcion = descripcion;
        this.monto = monto;
        this.numeroApartado = numeroApartado;
        this.fechaRealizado = fechaRealizado;
        this.fechaMaximaRetiro = fechaMaximaRetiro;
        this.id_cliente = cliente;
        this.lista_abonos = new ArrayList<Abono>();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getNumeroApartado() {
        return numeroApartado;
    }

    public void setNumeroApartado(String numeroApartado) {
        this.numeroApartado = numeroApartado;
    }

    public String getFechaRealizado() {
        return fechaRealizado;
    }

    public void setFechaRealizado(String fechaRealizado) {
        this.fechaRealizado = fechaRealizado;
    }

    public String getFechaMaximaRetiro() {
        return fechaMaximaRetiro;
    }

    public void setFechaMaximaRetiro(String fechaMaximaRetiro) {
        this.fechaMaximaRetiro = fechaMaximaRetiro;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

   

    public List<Abono> getLista_abonos() {
        return lista_abonos;
    }

    public void setLista_abonos(List<Abono> lista_abonos) {
        this.lista_abonos = lista_abonos;
    }
    
   public String saldoPendiente(){
       String some;
       double mo =0.0;
       double aux;
       for(Abono abono: this.lista_abonos){
           mo+= Double.parseDouble(abono.getMount());
       }
       aux = Double.parseDouble(this.getMonto()) - mo;
       some = String.valueOf(aux);
       return some;
    }
}
