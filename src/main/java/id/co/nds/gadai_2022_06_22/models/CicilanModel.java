package id.co.nds.gadai_2022_06_22.models;

import java.sql.Timestamp;

public class CicilanModel {
    private String noTransaksi;
    private Integer cicilanKe;
    private Double txPokok;
    private Double txBunga;
    private String txStatus;
    private Timestamp tanggalAktif;
    private Timestamp tanggalJatuhTempo;
    private Timestamp tanggalBayar;
    private String noPembayaran;
    private Timestamp createdDate;
    
    public String getNoTransaksi() {
        return noTransaksi;
    }
    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }
    public Integer getCicilanKe() {
        return cicilanKe;
    }
    public void setCicilanKe(Integer cicilanKe) {
        this.cicilanKe = cicilanKe;
    }
    public Double getTxPokok() {
        return txPokok;
    }
    public void setTxPokok(Double txPokok) {
        this.txPokok = txPokok;
    }
    public Double getTxBunga() {
        return txBunga;
    }
    public void setTxBunga(Double txBunga) {
        this.txBunga = txBunga;
    }
    public String getTxStatus() {
        return txStatus;
    }
    public void setTxStatus(String txStatus) {
        this.txStatus = txStatus;
    }
    public Timestamp getTanggalAktif() {
        return tanggalAktif;
    }
    public void setTanggalAktif(Timestamp tanggalAktif) {
        this.tanggalAktif = tanggalAktif;
    }
    public Timestamp getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }
    public void setTanggalJatuhTempo(Timestamp tanggalJatuhTempo) {
        this.tanggalJatuhTempo = tanggalJatuhTempo;
    }
    public Timestamp getTanggalBayar() {
        return tanggalBayar;
    }
    public void setTanggalBayar(Timestamp tanggalBayar) {
        this.tanggalBayar = tanggalBayar;
    }
    public String getNoPembayaran() {
        return noPembayaran;
    }
    public void setNoPembayaran(String noPembayaran) {
        this.noPembayaran = noPembayaran;
    }
    public Timestamp getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}
