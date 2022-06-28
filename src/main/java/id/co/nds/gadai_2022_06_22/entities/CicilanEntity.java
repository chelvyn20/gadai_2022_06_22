package id.co.nds.gadai_2022_06_22.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TX_CICILAN")
public class CicilanEntity {
    @Id
    @GenericGenerator(name = "transaksi_no_seq", strategy = "id.co.nds.gadai_2022_06_22.generators.TransactionNoGenerator")
    @GeneratedValue(generator = "transaksi_no_seq")
    @Column(name = "no_transaksi")
    private String noTransaksi;

    @Column(name = "cicilan_ke")
    private Integer cicilanKe;

    @Column(name = "tx_pokok")
    private Double txPokok;

    @Column(name = "tx_bunga")
    private Double txBunga;

    @Column(name = "tx_status")
    private String txStatus;

    @Column(name = "tanggal_aktif")
    private Timestamp tanggalAktif;

    @Column(name = "tanggal_jatuh_tempo")
    private Timestamp tanggalJatuhTempo;

    @Column(name = "tanggal_bayar")
    private Timestamp tanggalBayar;

    @Column(name = "created_date")
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

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}
