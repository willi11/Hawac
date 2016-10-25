/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import tienda.entities.Abono;
import tienda.entities.PagoCheque;
import tienda.entities.PagoTarjeta;

/**
 *
 * @author William
 */
public class AbonoTableModel  extends AbstractTableModel{
        List<Abono> rows;
    int[] cols;

    public  AbonoTableModel(int[] cols, List<Abono> rows){
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
        Abono abono = rows.get(row);
        PagoCheque pC = new PagoCheque();
        PagoTarjeta pT = new PagoTarjeta();
        if (abono instanceof PagoCheque){
            pC = (PagoCheque)abono;
        }
        if (abono instanceof PagoTarjeta){
            pT = (PagoTarjeta)abono;
        }
            switch (cols[col]) {
                case ID:
                    return abono.getBoxNumber();
                case MONTO:
                    return abono.getMount();
                case FECHA:
                    return abono.getPayDate();
                case TIPO:
                    return abono.getTipo();
                case BANCO: 
                    return pC.getBank();
                case REFERENCIA:
                    return pT.getReferenceNumber();
                default:
                    return "";
            }
    }    
    
    public static final int ID=0;
    public static final int MONTO=1;
    public static final int FECHA=2;
    public static final int TIPO=3;
    public static final int BANCO=4;
    public static final int REFERENCIA=5;
    
    
    String[] colNames = new String[6];
    private void initColNames(){
        colNames[ID]= "Id";
        colNames[MONTO]= "Monto";
        colNames[FECHA]= "Fecha";
        colNames[TIPO]= "Tipo";
        colNames[BANCO]= "Banco";
        colNames[REFERENCIA]= "Numero de referencia";
    }
    
    public Abono getRowAt(int row) {
        return rows.get(row);
    }
}