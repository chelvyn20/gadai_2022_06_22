package id.co.nds.gadai_2022_06_22.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tx_cicilan")
public class CicilanEntity {
    
    @Id
    @GenericGenerator(name = "no_transaksi_seq",
    strategy = "id.co.nds.gadai_2022_06_22.generators.CicilanIdGenerator")
    @GeneratedValue(generator = "no_transaksi_seq")

    @Column(name="no_transaksi")
    private String noTransaksi;

    @Column(name="cicilan_ke")
    private String cicilanKe;

    @Column(name="total_pinjaman")
    private Double totalPinjaman;

    @Column(name="tx_pokok")
    private Double txPokok;

    @Column(name="tx_bunga")
    private Double txBunga;

    @Column(name="trx_date")
    private Timestamp txrDate;

    @Column(name="actor_id")
    private Integer actorId;

    @Column(name="tanggal_aktif")
    private Date tglAktif;

    @Column(name="tanggal_jatuh_tempo")
    private Date tglJatuhTempo;

    @Column(name="tanggal_bayar")
    private Date tglBayar;

    @Column(name="status_trans")
    private String statusTrans;

    public String getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public String getCicilanKe() {
        return cicilanKe;
    }

    public void setCicilanKe(String cicilanKe) {
        this.cicilanKe = cicilanKe;
    }

    public Double getTotalPinjaman() {
        return totalPinjaman;
    }

    public void setTotalPinjaman(Double totalPinjaman) {
        this.totalPinjaman = totalPinjaman;
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

    public Timestamp getTxrDate() {
        return txrDate;
    }

    public void setTxrDate(Timestamp txrDate) {
        this.txrDate = txrDate;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }

    public Date getTglAktif() {
        return tglAktif;
    }

    public void setTglAktif(Date tglAktif) {
        this.tglAktif = tglAktif;
    }

    public Date getTglJatuhTempo() {
        return tglJatuhTempo;
    }

    public void setTglJatuhTempo(Date tglJatuhTempo) {
        this.tglJatuhTempo = tglJatuhTempo;
    }

    public Date getTglBayar() {
        return tglBayar;
    }

    public void setTglBayar(Date tglBayar) {
        this.tglBayar = tglBayar;
    }

    public String getStatusTrans() {
        return statusTrans;
    }

    public void setStatusTrans(String statusTrans) {
        this.statusTrans = statusTrans;
    }

   
   
}
