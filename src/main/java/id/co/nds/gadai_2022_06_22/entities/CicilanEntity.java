package id.co.nds.gadai_2022_06_22.entities;


import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import id.co.nds.gadai_2022_06_22.entities.compositeId.CompositeCicilanId;

@Entity
@Table(name = "tx_cicilan")
@IdClass(CompositeCicilanId.class)
public class CicilanEntity {
    
    @Id
    @Column(name="no_transaksi")
    private String noTransaksi;

    @Id
    @Column(name="cicilan_ke")
    private Integer cicilanKe;

    @Column(name="tx_pokok")
    private Double txPokok;

    @Column(name="tx_bunga")
    private Double txBunga;

    @Column(name="tx_status")
    private String statusTrans;

    @Column(name="tanggal_aktif")
    private LocalDate tglAktif;

    @Column(name="tanggal_jatuh_tempo")
    private LocalDate tglJatuhTempo;

    @Column(name="tanggal_bayar")
    private LocalDate tglBayar;

    @Column(name="created_date")
    private Timestamp txrDate;

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

    public String getStatusTrans() {
        return statusTrans;
    }

    public void setStatusTrans(String statusTrans) {
        this.statusTrans = statusTrans;
    }

    public LocalDate getTglAktif() {
        return tglAktif;
    }

    public void setTglAktif(LocalDate tglAktif) {
        this.tglAktif = tglAktif;
    }

    public LocalDate getTglJatuhTempo() {
        return tglJatuhTempo;
    }

    public void setTglJatuhTempo(LocalDate tglJatuhTempo) {
        this.tglJatuhTempo = tglJatuhTempo;
    }

    public LocalDate getTglBayar() {
        return tglBayar;
    }

    public void setTglBayar(LocalDate tglBayar) {
        this.tglBayar = tglBayar;
    }

    public Timestamp getTxrDate() {
        return txrDate;
    }

    public void setTxrDate(Timestamp txrDate) {
        this.txrDate = txrDate;
    }

   
}
