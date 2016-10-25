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
public class Cliente implements Serializable{
    private String id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String direccion;
    private String telefono;
    List<Apartado> lista_apartados;
    
    public Cliente(){
        this.id="";
        this.nombre="";
        this.primerApellido="";
        this.segundoApellido="";
        this.direccion="";
        this.telefono="";
        this.lista_apartados = new ArrayList<Apartado>(); 
    }
    public Cliente(String id, String nombre, String primerApellido, String segundoApellido, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.lista_apartados = new ArrayList<Apartado>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Apartado> getLista_apartados() {
        return lista_apartados;
    }

    public void setLista_apartados(List<Apartado> lista_apartados) {
        this.lista_apartados = lista_apartados;
    }
    
}
