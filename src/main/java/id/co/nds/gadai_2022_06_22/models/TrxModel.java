package id.co.nds.gadai_2022_06_22.models;

import java.sql.Date;

import java.util.List;



public class TrxModel extends CustomerModel{
    
    private String noTransaksi;
    private String productId;
    private String productName;
    private Double totalNilaiTaksiran;
    private Double nilaiPencairanPelanggan;
    private Double diskonAdmBuka;
    private Integer actorId;
    private String statusTrans;
    private Date trxDateBegin;
    private Date trxDateEnd;
    private List<daftarBarangGadai> daftarBarangGadai;
    
    public String getNoTransaksi() {
        return noTransaksi;
    }
    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
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
    public Date getTrxDateBegin() {
        return trxDateBegin;
    }
    public void setTrxDateBegin(Date trxDateBegin) {
        this.trxDateBegin = trxDateBegin;
    }
    public Date getTrxDateEnd() {
        return trxDateEnd;
    }
    public void setTrxDateEnd(Date trxDateEnd) {
        this.trxDateEnd = trxDateEnd;
    }
    public List<daftarBarangGadai> getDaftarBarangGadai() {
        return daftarBarangGadai;
    }
    public void setDaftarBarangGadai(List<daftarBarangGadai> barang) {
        this.daftarBarangGadai = barang;
    }
    
   
    
}
