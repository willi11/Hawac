/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import tienda.entities.Producto;

/**
 *
 * @author Marco
 */
public class ProductoTableModel extends AbstractTableModel{
     List<Producto> rows;
    int[] cols;

    public  ProductoTableModel(int[] cols, List<Producto> rows){
        this.cols=cols;
        this.rows=rows;
        initColNames();
    }
    public String getColumnName(int col){
        return colNames[cols[col]];
    }
    
    public int getRowCount() {
        return rows.size();
    }

    public int getColumnCount() {
        return cols.length;
    }
    
    public Object getValueAt(int row, int col) {
        Producto producto = rows.get(row);
        switch (cols[col]){
            case DESCRIPCION: return producto.getDescripcion();
            case CODIGO: return producto.getId();
            case COLOR: return producto.getColor();
            case TALLA: return producto.getTalla();
            case GENERO: return producto.getGenero();
            case VALOR: return producto.getValor();
                
            default: return "";
        }
    }    
    
    public static final int DESCRIPCION=0;
    public static final int CODIGO=1;
    public static final int COLOR=2;
    public static final int TALLA=3;
    public static final int GENERO=4;
    public static final int VALOR=5;
    
    
    
    String[] colNames = new String[6];
    private void initColNames(){
        colNames[DESCRIPCION]= "DESCRIPCION";
        colNames[CODIGO]= "CODIGO";
        colNames[COLOR]= "COLOR";
        colNames[TALLA]= "TALLA";
        colNames[GENERO]= "GENERO";
        colNames[VALOR]= "VALOR";
    }
    
    public Producto getRowAt(int row) {
        return rows.get(row);
    }
       
}
