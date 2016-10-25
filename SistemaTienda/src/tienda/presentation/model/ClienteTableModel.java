/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import tienda.entities.Cliente;

/**
 *
 * @author Marco
 */
public class ClienteTableModel extends AbstractTableModel{
     List<Cliente> rows;
    int[] cols;

    public  ClienteTableModel(int[] cols, List<Cliente> rows){
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
        Cliente cliente = rows.get(row);
        switch (cols[col]){
            case ID: return cliente.getId();
            case NOMBRE: return cliente.getNombre();
            case PRIMERAPELLIDO: return cliente.getPrimerApellido();
            case SEGUNDOAPELLIDO: return cliente.getSegundoApellido();
            case DIRECCION: return cliente.getDireccion();
            case TELEFONO: return cliente.getTelefono();
            default: return "";
        }
    }    
    
    public static final int ID=0;
    public static final int NOMBRE=1;
    public static final int PRIMERAPELLIDO=2;
    public static final int SEGUNDOAPELLIDO=3;
    public static final int DIRECCION=4;
    public static final int TELEFONO=5;
    
    
    String[] colNames = new String[6];
    private void initColNames(){
        colNames[ID]= "Id";
        colNames[NOMBRE]= "Nombre";
        colNames[PRIMERAPELLIDO]= "PrimerApellido";
        colNames[SEGUNDOAPELLIDO]= "SegundoApellido";
        colNames[DIRECCION]= "Direccion";
        colNames[TELEFONO]= "Telefono";
    }
    
    public Cliente getRowAt(int row) {
        return rows.get(row);
    }
       
}
