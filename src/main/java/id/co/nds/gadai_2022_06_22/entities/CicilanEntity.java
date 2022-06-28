package id.co.nds.gadai_2022_06_22.entities;

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
    @GenericGenerator(name = "cicilan_id_seq",
    strategy = "id.co.nds.gadai_2022_06_22.generators.CicilanIdGenerator")
    @GeneratedValue(generator = "cicilan_id_seq")

    @Column(name="no_transaksi")
    private String noTransaksi;

    @Column(name="product_id")
    private String productId;

    @Column(name="cust_id")
    private String custId;

    @Column(name="total_pinjaman")
    private Double totalPinjaman;

    @Column(name="pokok")
    private Double pokok;

    @Column(name="bunga")
    private Double bunga;

    @Column(name="no_barang")
    private Integer noBarang;

    @Column(name="trx_date")
    private Timestamp txrDate;

    @Column(name="tanggal_aktif")
    private Timestamp tglAktif;

    @Column(name="tanggal_jatuh_tempo")
    private Timestamp tglJatuhTempo;

    @Column(name="tanggal_bayar")
    private Timestamp tglBayar;

    @Column(name="actor_id")
    private Integer actorId;

    @Column(name="status_trans")
    private String statusTrans;

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

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public Double getTotalPinjaman() {
        return totalPinjaman;
    }

    public void setTotalPinjaman(Double totalPinjaman) {
        this.totalPinjaman = totalPinjaman;
    }

    public Double getPokok() {
        return pokok;
    }

    public void setPokok(Double pokok) {
        this.pokok = pokok;
    }

    public Double getBunga() {
        return bunga;
    }

    public void setBunga(Double bunga) {
        this.bunga = bunga;
    }

    public Integer getNoBarang() {
        return noBarang;
    }

    public void setNoBarang(Integer noBarang) {
        this.noBarang = noBarang;
    }

    public Timestamp getTxrDate() {
        return txrDate;
    }

    public void setTxrDate(Timestamp txrDate) {
        this.txrDate = txrDate;
    }

    public Timestamp getTglAktif() {
        return tglAktif;
    }

    public void setTglAktif(Timestamp tglAktif) {
        this.tglAktif = tglAktif;
    }

    public Timestamp getTglJatuhTempo() {
        return tglJatuhTempo;
    }

    public void setTglJatuhTempo(Timestamp tglJatuhTempo) {
        this.tglJatuhTempo = tglJatuhTempo;
    }

    public Timestamp getTglBayar() {
        return tglBayar;
    }

    public void setTglBayar(Timestamp tglBayar) {
        this.tglBayar = tglBayar;
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

   
}
