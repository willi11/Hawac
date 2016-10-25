package tienda.entities;

import java.io.Serializable;

/**
 *
 * @author byron
 * @version %I%
 */
public abstract class Abono implements Serializable{

    public Abono(String boxNumber, String mount, String payDate) {
        this.boxNumber = boxNumber;
        this.mount = mount;
        this.payDate = payDate;
        this.idApartado="";
    }

    public Abono() {
        boxNumber="";
        mount="";
        payDate="";
        this.idApartado="";
    }

    public String getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(String boxNUmber) {
        this.boxNumber = boxNUmber;
    }

    public String getMount() {
        return mount;
    }

    public void setMount(String mount) {
        this.mount = mount;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }
    
    public abstract String getTipo();
   
    protected String boxNumber;
    protected String mount;
    protected String payDate;
    protected String idApartado;

    public String getIdApartado() {
        return idApartado;
    }

    public void setIdApartado(String idApartado) {
        this.idApartado = idApartado;
    }
}
