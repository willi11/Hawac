/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import tienda.entities.Cliente;
import tienda.entities.Usuario;

/**
 *
 * @author William
 */
public class UsuarioTableModel extends AbstractTableModel{
    List<Usuario> rows;
    int[] cols;

    public  UsuarioTableModel(int[] cols, List<Usuario> rows){
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
        Usuario cliente = rows.get(row);
        switch (cols[col]){
            case NOMBRE: return cliente.getNombre();
            case CONTRASEÑA: return cliente.getContraseña();
            case TIPO: return cliente.getTipo();
            default: return "";
        }
    }    
    
    public static final int NOMBRE=0;
    public static final int CONTRASEÑA=1;
    public static final int TIPO=2;
    
    
    
    String[] colNames = new String[3];
    private void initColNames(){
        colNames[NOMBRE]= "Nombre";
        colNames[CONTRASEÑA]= "Contraseña";
        colNames[TIPO]= "Tipo";
        
    }
    
    public Usuario getRowAt(int row) {
        return rows.get(row);
    }
       
}
