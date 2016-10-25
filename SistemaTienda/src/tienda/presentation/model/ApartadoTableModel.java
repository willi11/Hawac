/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import tienda.entities.Apartado;


/**
 *
 * @author Marco
 */
public class ApartadoTableModel  extends AbstractTableModel{
        List<Apartado> rows;
    int[] cols;

    public  ApartadoTableModel(int[] cols, List<Apartado> rows){
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
        Apartado apartado = rows.get(row);
        switch (cols[col]){
            case ID: return apartado.getNumeroApartado();
            case CLIENTE: return apartado.getId_cliente();
            case MONTO: return apartado.getMonto();
            case FECHA: return apartado.getFechaRealizado();
            case FECHA_LIMIT: return apartado.getFechaMaximaRetiro();
            case DESCRIPTION: return apartado.getDescripcion();
            default: return "";
        }
    }    
    
    public static final int ID=0;
    public static final int CLIENTE=1;
    public static final int MONTO=2;
    public static final int FECHA=3;
    public static final int FECHA_LIMIT=4;
    public static final int DESCRIPTION=5;
    
    
    String[] colNames = new String[6];
    private void initColNames(){
        colNames[ID]= "Id";
        colNames[CLIENTE]="Cliente";
        colNames[MONTO]= "Monto";
        colNames[FECHA]= "Fecha inicial";
        colNames[FECHA_LIMIT]= "Fecha limite";
        colNames[DESCRIPTION]= "Producto";
        
    }
    
    public Apartado getRowAt(int row) {
        return rows.get(row);
    }
}
