package id.co.nds.gadai_2022_06_22.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TX_TRANSAKSI_BARANG")
public class BarangEntity {
    @Id
    @GenericGenerator(name = "transaksi_no_seq", strategy = "id.co.nds.gadai_2022_06_22.generators.TransactionNoGenerator")
    @GeneratedValue(generator = "transaksi_no_seq")
    @Column(name = "no_transaksi")
    private String noTransaksi;

    @Column(name = "nama_barang")
    private String namaBarang;

    @Column(name = "kondisi")
    private String kondisi;

    @Column(name = "jumlah")
    private Integer jumlah;

    @Column(name = "harga_per_satuan")
    private Double hargaPerSatuan;

    public String getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Double getHargaPerSatuan() {
        return hargaPerSatuan;
    }

    public void setHargaPerSatuan(Double hargaPerSatuan) {
        this.hargaPerSatuan = hargaPerSatuan;
    }

}
