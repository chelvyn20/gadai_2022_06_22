package id.co.nds.gadai_2022_06_22.models;

import java.time.LocalDateTime;

public class PembayaranCicilanModel {
    private String noTransaksi;
    private LocalDateTime tanggalTransaksi;
    private String custId;
    private String custKtp;
    private String custName;
    private String productId;
    private String productName;
    private String productDesc;
    private Integer cicilanKe;
    private Double totalTagihan;
    private String statusCicilan;
    private LocalDateTime tanggalAktifCicilan;
    private LocalDateTime tanggalJatuhTempoCicilan;
    private Double totalNilaiPinjaman;
    private Integer tenor;
    private Double totalKewajiban;
    private Double totalDenda;
    private Double totalPembayaran;
    private Double sisaKewajiban;

    public String getNoTransaksi() {
        return noTransaksi;
    }
    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }
    public LocalDateTime getTanggalTransaksi() {
        return tanggalTransaksi;
    }
    public void setTanggalTransaksi(LocalDateTime tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }
    public String getCustId() {
        return custId;
    }
    public void setCustId(String custId) {
        this.custId = custId;
    }
    public String getCustKtp() {
        return custKtp;
    }
    public void setCustKtp(String custKtp) {
        this.custKtp = custKtp;
    }
    public String getCustName() {
        return custName;
    }
    public void setCustName(String custName) {
        this.custName = custName;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Integer getCicilanKe() {
        return cicilanKe;
    }
    public void setCicilanKe(Integer cicilanKe) {
        this.cicilanKe = cicilanKe;
    }
    public Double getTotalTagihan() {
        return totalTagihan;
    }
    public void setTotalTagihan(Double totalTagihan) {
        this.totalTagihan = totalTagihan;
    }
    public String getStatusCicilan() {
        return statusCicilan;
    }
    public void setStatusCicilan(String statusCicilan) {
        this.statusCicilan = statusCicilan;
    }
    public LocalDateTime getTanggalAktifCicilan() {
        return tanggalAktifCicilan;
    }
    public void setTanggalAktifCicilan(LocalDateTime tanggalAktifCicilan) {
        this.tanggalAktifCicilan = tanggalAktifCicilan;
    }
    public LocalDateTime getTanggalJatuhTempoCicilan() {
        return tanggalJatuhTempoCicilan;
    }
    public void setTanggalJatuhTempoCicilan(LocalDateTime tanggalJatuhTempoCicilan) {
        this.tanggalJatuhTempoCicilan = tanggalJatuhTempoCicilan;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getProductDesc() {
        return productDesc;
    }
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
    public Double getTotalNilaiPinjaman() {
        return totalNilaiPinjaman;
    }
    public void setTotalNilaiPinjaman(Double totalNilaiPinjaman) {
        this.totalNilaiPinjaman = totalNilaiPinjaman;
    }
    public Integer getTenor() {
        return tenor;
    }
    public void setTenor(Integer tenor) {
        this.tenor = tenor;
    }
    public Double getTotalKewajiban() {
        return totalKewajiban;
    }
    public void setTotalKewajiban(Double totalKewajiban) {
        this.totalKewajiban = totalKewajiban;
    }
    public Double getTotalDenda() {
        return totalDenda;
    }
    public void setTotalDenda(Double totalDenda) {
        this.totalDenda = totalDenda;
    }
    public Double getTotalPembayaran() {
        return totalPembayaran;
    }
    public void setTotalPembayaran(Double totalPembayaran) {
        this.totalPembayaran = totalPembayaran;
    }
    public Double getSisaKewajiban() {
        return sisaKewajiban;
    }
    public void setSisaKewajiban(Double sisaKewajiban) {
        this.sisaKewajiban = sisaKewajiban;
    }
}
