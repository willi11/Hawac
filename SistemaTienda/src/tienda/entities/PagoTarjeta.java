package tienda.entities;

/**
 *
 * @author byron
 * @version %I%
 */
public class PagoTarjeta extends Abono{
    
    public PagoTarjeta(String boxNumber, String mount, 
            String payDate, String cardNumber, String deadLine, String referenceNumber) {
        super(boxNumber, mount, payDate);
        this.cardNumber = cardNumber;
        this.deadLine = deadLine;
        this.referenceNumber = referenceNumber;
    }
    public PagoTarjeta(){
        super();
        this.cardNumber = "";
        this.deadLine = "";
        this.referenceNumber = "";
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
    
    @Override
    public String getTipo(){
        return "Tarjeta";
    }

    private String cardNumber;
    private String deadLine;
    private String referenceNumber;
}
