package id.co.nds.gadai_2022_06_22.models;

import java.sql.Timestamp;



public class CicilanModel extends CustomerModel{
    
    private String noTransaksi;
    private String produtId;
    private String productName;
    private Double totalNilaiTaksiran;
    private Double nilaiPencairanPelanggan;
    private Double diskonAdmBuka;
    private Integer actorId;
    private String statusTrans;
    private Timestamp trxDateBegin;
    private Timestamp trxDateEnd;


    public String getNoTransaksi() {
        return noTransaksi;
    }
    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }
    public String getProdutId() {
        return produtId;
    }
    public void setProdutId(String produtId) {
        this.produtId = produtId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Double getTotalNilaiTaksiran() {
        return totalNilaiTaksiran;
    }
    public void setTotalNilaiTaksiran(Double totalNilaiTaksiran) {
        this.totalNilaiTaksiran = totalNilaiTaksiran;
    }
    public Double getNilaiPencairanPelanggan() {
        return nilaiPencairanPelanggan;
    }
    public void setNilaiPencairanPelanggan(Double nilaiPencairanPelanggan) {
        this.nilaiPencairanPelanggan = nilaiPencairanPelanggan;
    }
    public Double getDiskonAdmBuka() {
        return diskonAdmBuka;
    }
    public void setDiskonAdmBuka(Double diskonAdmBuka) {
        this.diskonAdmBuka = diskonAdmBuka;
    }
    public Integer getActorId() {
        return actorId;
    }
    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }
    public String getStatusTrans() {
        return statusTrans;
    }
    public void setStatusTrans(String statusTrans) {
        this.statusTrans = statusTrans;
    }
    public Timestamp getTrxDateBegin() {
        return trxDateBegin;
    }
    public void setTrxDateBegin(Timestamp trxDateBegin) {
        this.trxDateBegin = trxDateBegin;
    }
    public Timestamp getTrxDateEnd() {
        return trxDateEnd;
    }
    public void setTrxDateEnd(Timestamp trxDateEnd) {
        this.trxDateEnd = trxDateEnd;
    }
    
}
