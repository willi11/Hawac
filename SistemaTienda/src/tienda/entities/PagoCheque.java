package tienda.entities;

/**
 *
 * @author byron
 * @version %I%
 */
public class PagoCheque extends Abono{

    public PagoCheque(String boxNumber, String mount, String payDate, 
            String checkNumber, String bank) {
        super(boxNumber, mount, payDate);
        this.bank = bank;
        this.checkNumber = checkNumber;
    }
    public PagoCheque() {
        super();
        this.bank = "";
        this.checkNumber = "";
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
    
    @Override
    public String getTipo(){
        return "Cheque";
    }
    
    private String checkNumber;
    private String bank;
}
