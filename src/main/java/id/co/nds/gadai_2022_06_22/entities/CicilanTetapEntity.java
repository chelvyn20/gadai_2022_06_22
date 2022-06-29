package id.co.nds.gadai_2022_06_22.entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tx_transaksi_cicilan_tetap")
public class CicilanTetapEntity {
    @Id
    @GenericGenerator(name = "no_transaksi_seq",
    strategy = "id.co.nds.gadai_2022_06_22.generators.CicilanIdGenerator")
    @GeneratedValue(generator = "no_transaksi_seq")

    @Column(name="no_transaksi")
    private String noTransaksi;

    @OneToMany(targetEntity = BarangEntity.class, mappedBy = "noTransaksi" )
    private List<BarangEntity>daftarBarang;

    @Column(name="total_nilai_taksiran")
    private Double totalNilaiTaksiran;

    @Column(name="nilai_pencairan_pelanggan")
    private Double nilaiPencairanPelanggan;

    @Column(name="diskon_adm_buka")
    private Double diskonAmdBuka;

    @Column(name="tx_ltv")
    private Double txLtv;

    @Column(name="max_nilai_pinjam")
    private Double maxNilaiPinjam;

    @Column(name="biaya_adm_buka")
    private Double biayaAdmBuka;

    @Column(name="biaya_adm_buka_akhir")
    private Double biayaAdmBukaAkhir;

    @Column(name="total_nilai_pinjaman")
    private Double totalNilaiPinjaman;

    @Column(name="tanggal_tx")
    private Date tanggalTx;

    @Column(name="tanggal_jatuh_tempo")
    private Date tglJatuhTempo;

    @Column(name="biaya_jasa_penyimpanan")
    private Double biayaJasaPenyimpanan;

    @Column(name="biaya_jasa_peny_periode")
    private Double biayaJasaPenyPeriode;

    @Column(name="total_biaya_jasa_peny")
    private Double totalBiayaJasaPeny;

    @Column(name="biaya_adm_tutup")
    private Double biayaAdmTutup;

    @Column(name="total_pengembalian")
    private Double totalPengembalian;

    @Column(name="product_id")
    private String productId;

    @Column(name="cust_id")
    private String custId;

    @Column(name="created_date")
    private Timestamp createdDate;

    @Column(name="actor_id")
    private Integer actorId;

    public String getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public Double getTotalNilaiTaksiran() {
        return totalNilaiTaksiran;
    }

    public void setTotalNilaiTaksiran(Double totalNilaiTaksiran) {
        this.totalNilaiTaksiran = totalNilaiTaksiran;
    }

    public Double getNilaiPencairanPelanggan() {
        return nilaiPencairanPelanggan;
    }

    public void setNilaiPencairanPelanggan(Double nilaiPencairanPelanggan) {
        this.nilaiPencairanPelanggan = nilaiPencairanPelanggan;
    }

    public Double getDiskonAmdBuka() {
        return diskonAmdBuka;
    }

    public void setDiskonAmdBuka(Double diskonAmdBuka) {
        this.diskonAmdBuka = diskonAmdBuka;
    }

    public Double getTxLtv() {
        return txLtv;
    }

    public void setTxLtv(Double txLtv) {
        this.txLtv = txLtv;
    }

    public Double getMaxNilaiPinjam() {
        return maxNilaiPinjam;
    }

    public void setMaxNilaiPinjam(Double maxNilaiPinjam) {
        this.maxNilaiPinjam = maxNilaiPinjam;
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

    public Double getTotalNilaiPinjaman() {
        return totalNilaiPinjaman;
    }

    public void setTotalNilaiPinjaman(Double totalNilaiPinjaman) {
        this.totalNilaiPinjaman = totalNilaiPinjaman;
    }

    public Date getTanggalTx() {
        return tanggalTx;
    }

    public void setTanggalTx(Date tanggalTx) {
        this.tanggalTx = tanggalTx;
    }

    public Date getTglJatuhTempo() {
        return tglJatuhTempo;
    }

    public void setTglJatuhTempo(Date tglJatuhTempo) {
        this.tglJatuhTempo = tglJatuhTempo;
    }

    public Double getBiayaJasaPenyimpanan() {
        return biayaJasaPenyimpanan;
    }

    public void setBiayaJasaPenyimpanan(Double biayaJasaPenyimpanan) {
        this.biayaJasaPenyimpanan = biayaJasaPenyimpanan;
    }

    public Double getBiayaJasaPenyPeriode() {
        return biayaJasaPenyPeriode;
    }

    public void setBiayaJasaPenyPeriode(Double biayaJasaPenyPeriode) {
        this.biayaJasaPenyPeriode = biayaJasaPenyPeriode;
    }

    public Double getTotalBiayaJasaPeny() {
        return totalBiayaJasaPeny;
    }

    public void setTotalBiayaJasaPeny(Double totalBiayaJasaPeny) {
        this.totalBiayaJasaPeny = totalBiayaJasaPeny;
    }

    public Double getBiayaAdmTutup() {
        return biayaAdmTutup;
    }

    public void setBiayaAdmTutup(Double biayaAdmTutup) {
        this.biayaAdmTutup = biayaAdmTutup;
    }

    public Double getTotalPengembalian() {
        return totalPengembalian;
    }

    public void setTotalPengembalian(Double totalPengembalian) {
        this.totalPengembalian = totalPengembalian;
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

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getActorId() {
        return actorId;
    }

    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }
}
