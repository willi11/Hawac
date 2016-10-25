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
public class Producto {
    private String id;
    private String talla;
    private String color;
    private String descripcion;
    private String genero;
    private float valor;
    private int cantidad;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    

    public Producto(String tipo, String color, String empresa, String genero, float valor, int cantidad) {
        this.talla = tipo;
        this.color = color;
        this.descripcion = empresa;
        this.genero = genero;
        this.valor = valor;
        this.cantidad=cantidad;
    }

    public Producto() {
        this.talla = "";
        this.color = "";
        this.descripcion = "";
        this.genero="";
        this.valor = 0;
        this.cantidad=0;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    
    public String getTalla() {
        return talla;
    }

    public void setTalla(String tipo) {
        this.talla = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String empresa) {
        this.descripcion = empresa;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
}
