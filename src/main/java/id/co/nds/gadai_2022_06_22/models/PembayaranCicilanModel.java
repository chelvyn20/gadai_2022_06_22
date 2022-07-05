package id.co.nds.gadai_2022_06_22.models;

import java.time.LocalDateTime;

public class PembayaranCicilanModel {
    private String noTransaksi;
    private LocalDateTime tanggalTransaksi;
    private String custId;
    private String custKtp;
    private String custName;
    private Integer cicilanKe;
    private Double totalTagihan;
    private String statusCicilan;
    private LocalDateTime tanggalAktifCicilan;
    private LocalDateTime tanggalJatuhTempoCicilan;

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
}
