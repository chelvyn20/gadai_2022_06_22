package id.co.nds.gadai_2022_06_22.models;

import java.util.Date;

public class PaymentModel extends CustomerModel{
    private String noTransaksi;
    private Integer selectedNoCic;
    private Integer actorId;
    private Date cicDateBegin;
    private Date cicDateEnd;
    
    public String getNoTransaksi() {
        return noTransaksi;
    }
    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }
    public Integer getSelectedNoCic() {
        return selectedNoCic;
    }
    public void setSelectedNoCic(Integer selectedNoCic) {
        this.selectedNoCic = selectedNoCic;
    }
    public Integer getActorId() {
        return actorId;
    }
    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }
    public Date getCicDateBegin() {
        return cicDateBegin;
    }
    public void setCicDateBegin(Date cicDateBegin) {
        this.cicDateBegin = cicDateBegin;
    }
    public Date getCicDateEnd() {
        return cicDateEnd;
    }
    public void setCicDateEnd(Date cicDateEnd) {
        this.cicDateEnd = cicDateEnd;
    }
    
}
