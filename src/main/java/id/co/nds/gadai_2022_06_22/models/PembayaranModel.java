package id.co.nds.gadai_2022_06_22.models;

import java.sql.Timestamp;

public class PembayaranModel {
    private String noPembayaran;
    private String noTransaksi;
    private Double totalTagihanCicilan;
    private Double totalTagihanDenda;
    private Double biayaAdmTutup;
    private Double totalTagihan;
    private Double pembulatan;
    private Double jumlahPembayaran;
    private String metodeBayar;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private Timestamp deletedDate;
    private Integer createdBy;
    private Integer updatedBy;
    private Integer deletedBy;
    
    public String getNoPembayaran() {
        return noPembayaran;
    }
    public void setNoPembayaran(String noPembayaran) {
        this.noPembayaran = noPembayaran;
    }
    public String getNoTransaksi() {
        return noTransaksi;
    }
    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }
    public Double getTotalTagihanCicilan() {
        return totalTagihanCicilan;
    }
    public void setTotalTagihanCicilan(Double totalTagihanCicilan) {
        this.totalTagihanCicilan = totalTagihanCicilan;
    }
    public Double getTotalTagihanDenda() {
        return totalTagihanDenda;
    }
    public void setTotalTagihanDenda(Double totalTagihanDenda) {
        this.totalTagihanDenda = totalTagihanDenda;
    }
    public Double getBiayaAdmTutup() {
        return biayaAdmTutup;
    }
    public void setBiayaAdmTutup(Double biayaAdmTutup) {
        this.biayaAdmTutup = biayaAdmTutup;
    }
    public Double getTotalTagihan() {
        return totalTagihan;
    }
    public void setTotalTagihan(Double totalTagihan) {
        this.totalTagihan = totalTagihan;
    }
    public Double getPembulatan() {
        return pembulatan;
    }
    public void setPembulatan(Double pembulatan) {
        this.pembulatan = pembulatan;
    }
    public Double getJumlahPembayaran() {
        return jumlahPembayaran;
    }
    public void setJumlahPembayaran(Double jumlahPembayaran) {
        this.jumlahPembayaran = jumlahPembayaran;
    }
    public String getMetodeBayar() {
        return metodeBayar;
    }
    public void setMetodeBayar(String metodeBayar) {
        this.metodeBayar = metodeBayar;
    }
    public Timestamp getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
    public Timestamp getUpdatedDate() {
        return updatedDate;
    }
    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }
    public Timestamp getDeletedDate() {
        return deletedDate;
    }
    public void setDeletedDate(Timestamp deletedDate) {
        this.deletedDate = deletedDate;
    }
    public Integer getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }
    public Integer getUpdatedBy() {
        return updatedBy;
    }
    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }
    public Integer getDeletedBy() {
        return deletedBy;
    }
    public void setDeletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
    }
}
