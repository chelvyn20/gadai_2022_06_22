package id.co.nds.gadai_2022_06_22.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import id.co.nds.gadai_2022_06_22.entities.compositeId.CompositeBarangId;

@Entity
@Table(name = "tx_transaksi_barang")
@IdClass(CompositeBarangId.class)
public class BarangEntity implements Serializable {
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="no_urut")
    private Integer noUrut;
    
    @Id
    // @GenericGenerator(name = "no_transaksi_seq",
    // strategy = "id.co.nds.gadai_2022_06_22.generators.CicilanIdGenerator")
    // @GeneratedValue(generator = "no_transaksi_seq")
    @JoinColumn(name="no_transaksi", referencedColumnName =  "no_transaksi")
    @Column(name="no_transaksi")
    private String noTransaksi;

    @Column(name="nama_barang")
    private String namaBarang;

    @Column(name="kondisi")
    private String kondisiBarang;

    @Column(name="jumlah")
    private Integer jmlhBarang;

    @Column(name="harga_per_satuan")
    private Double hargaBarang;

    public Integer getNoUrut() {
        return noUrut;
    }

    public void setNoUrut(Integer noUrut) {
        this.noUrut = noUrut;
    }

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

    public String getKondisiBarang() {
        return kondisiBarang;
    }

    public void setKondisiBarang(String kondisiBarang) {
        this.kondisiBarang = kondisiBarang;
    }

    public Integer getJmlhBarang() {
        return jmlhBarang;
    }

    public void setJmlhBarang(Integer jmlhBarang) {
        this.jmlhBarang = jmlhBarang;
    }

    public Double getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(Double hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

  
   
    
   
}
