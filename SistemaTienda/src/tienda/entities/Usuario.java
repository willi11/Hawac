/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.entities;

/**
 *
 * @author William
 */
public class Usuario {
    private String nombre;
    private String contraseña;
    private String tipo;

    public Usuario(String nombre, String contraseña, String tipo) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }

    public Usuario() {
        this.nombre = "";
        this.contraseña = "";
        this.tipo = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", contrase\u00f1a=" + contraseña + ", tipo=" + tipo + '}';
    }
    
}
