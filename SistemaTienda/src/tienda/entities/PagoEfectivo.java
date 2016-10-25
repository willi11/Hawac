package tienda.entities;

/**
 *
 * @author byron
 * @version %I%
 */
public class PagoEfectivo extends Abono{

    public PagoEfectivo(String boxNUmber, String mount, String payDate) {
        super(boxNUmber, mount, payDate);
    }
    
    public PagoEfectivo(){
        super();
    }
    
    @Override
    public String getTipo(){
        return "Efectivo";
    }
    
}
