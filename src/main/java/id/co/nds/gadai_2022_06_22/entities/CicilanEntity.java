package id.co.nds.gadai_2022_06_22.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import id.co.nds.gadai_2022_06_22.embedded.CicilanId;

@Entity
@Table(name = "TX_CICILAN")
@IdClass(CicilanId.class)
public class CicilanEntity implements Serializable{
    @Id
    @Column(name = "no_transaksi")
    private String noTransaksi;

    @Id
    @Column(name = "cicilan_ke")
    private Integer cicilanKe;

    @Column(name = "tx_pokok")
    private Double txPokok;

    @Column(name = "tx_bunga")
    private Double txBunga;

    @Column(name = "tx_status")
    private String txStatus;

    @Column(name = "tanggal_aktif")
    private LocalDateTime tanggalAktif;

    @Column(name = "tanggal_jatuh_tempo")
    private LocalDateTime tanggalJatuhTempo;

    @Column(name = "tanggal_bayar")
    private LocalDateTime tanggalBayar;

    @Column(name = "no_pembayaran")
    private String noPembayaran;

    @Column(name = "created_date")
    private Timestamp createdDate;

    public CicilanEntity() {
    }

    public CicilanEntity(String noTransaksi, Integer cicilanKe) {
        this.noTransaksi = noTransaksi;
        this.cicilanKe = cicilanKe;
    }

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

    public LocalDateTime getTanggalAktif() {
        return tanggalAktif;
    }

    public void setTanggalAktif(LocalDateTime tanggalAktif) {
        this.tanggalAktif = tanggalAktif;
    }

    public LocalDateTime getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public void setTanggalJatuhTempo(LocalDateTime tanggalJatuhTempo) {
        this.tanggalJatuhTempo = tanggalJatuhTempo;
    }

    public LocalDateTime getTanggalBayar() {
        return tanggalBayar;
    }

    public void setTanggalBayar(LocalDateTime tanggalBayar) {
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
