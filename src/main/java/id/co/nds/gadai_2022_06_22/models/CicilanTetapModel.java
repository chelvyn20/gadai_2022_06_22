package id.co.nds.gadai_2022_06_22.models;

import java.sql.Timestamp;
import java.util.List;

import id.co.nds.gadai_2022_06_22.entities.BarangEntity;

public class CicilanTetapModel extends BarangModel {
    private String noTransaksi;
    private List<BarangEntity> daftarBarangGadai;
    private Double totalNilaiTak;
    private Double nilaiPencairanPelanggan;
    private Double diskonAdmBuka;
    private Double txLtv;
    private Double maxNilaiPinj;
    private Double biayaAdmBuka;
    private Double biayaAdmBukaAkhir;
    private Double totalNilaiPinj;
    private Timestamp tanggalTx;
    private Timestamp tanggalJatuhTempo;
    private Double txBiayaJasaPeny;
    private Integer txBiayaJasaPenyPer;
    private Double totalBiayaJasaPeny;
    private Double txBiayaAdmTutup;
    private Double totalPengem;
    private String custId;
    private String productId;
    private Timestamp createdDate;
    
    public String getNoTransaksi() {
        return noTransaksi;
    }
    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }
    public List<BarangEntity> getDaftarBarangGadai() {
        return daftarBarangGadai;
    }
    public void setListBarangEntity(List<BarangEntity> daftarBarangGadai) {
        this.daftarBarangGadai = daftarBarangGadai;
    }
    public Double getTotalNilaiTak() {
        return totalNilaiTak;
    }
    public void setTotalNilaiTak(Double totalNilaiTak) {
        this.totalNilaiTak = totalNilaiTak;
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
    public Double getTxLtv() {
        return txLtv;
    }
    public void setTxLtv(Double txLtv) {
        this.txLtv = txLtv;
    }
    public Double getMaxNilaiPinj() {
        return maxNilaiPinj;
    }
    public void setMaxNilaiPinj(Double maxNilaiPinj) {
        this.maxNilaiPinj = maxNilaiPinj;
    }
    public Double getBiayaAdmBuka() {
        return biayaAdmBuka;
    }
    public void setBiayaAdmBuka(Double biayaAdmBuka) {
        this.biayaAdmBuka = biayaAdmBuka;
    }
    public Double getBiayaAdmBukaAkhir() {
        return biayaAdmBukaAkhir;
    }
    public void setBiayaAdmBukaAkhir(Double biayaAdmBukaAkhir) {
        this.biayaAdmBukaAkhir = biayaAdmBukaAkhir;
    }
    public Double getTotalNilaiPinj() {
        return totalNilaiPinj;
    }
    public void setTotalNilaiPinj(Double totalNilaiPinj) {
        this.totalNilaiPinj = totalNilaiPinj;
    }
    public Timestamp getTanggalTx() {
        return tanggalTx;
    }
    public void setTanggalTx(Timestamp tanggalTx) {
        this.tanggalTx = tanggalTx;
    }
    public Timestamp getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }
    public void setTanggalJatuhTempo(Timestamp tanggalJatuhTempo) {
        this.tanggalJatuhTempo = tanggalJatuhTempo;
    }
    public Double getTxBiayaJasaPeny() {
        return txBiayaJasaPeny;
    }
    public void setTxBiayaJasaPeny(Double txBiayaJasaPeny) {
        this.txBiayaJasaPeny = txBiayaJasaPeny;
    }
    public Integer getTxBiayaJasaPenyPer() {
        return txBiayaJasaPenyPer;
    }
    public void setTxBiayaJasaPenyPer(Integer txBiayaJasaPenyPer) {
        this.txBiayaJasaPenyPer = txBiayaJasaPenyPer;
    }
    public Double getTotalBiayaJasaPeny() {
        return totalBiayaJasaPeny;
    }
    public void setTotalBiayaJasaPeny(Double totalBiayaJasaPeny) {
        this.totalBiayaJasaPeny = totalBiayaJasaPeny;
    }
    public Double getTxBiayaAdmTutup() {
        return txBiayaAdmTutup;
    }
    public void setTxBiayaAdmTutup(Double txBiayaAdmTutup) {
        this.txBiayaAdmTutup = txBiayaAdmTutup;
    }
    public Double getTotalPengem() {
        return totalPengem;
    }
    public void setTotalPengem(Double totalPengem) {
        this.totalPengem = totalPengem;
    }
    public String getCustId() {
        return custId;
    }
    public void setCustId(String custId) {
        this.custId = custId;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public Timestamp getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

}
