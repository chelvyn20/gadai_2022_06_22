package id.co.nds.gadai_2022_06_22.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tx_transaksi_barang;")
public class BarangEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="no_barang")
    private Integer noBarang;

    @Column(name="nama_barang")
    private String namaBarang;

    @Column(name="desc_barang")
    private String kondisiBarang;

    @Column(name="jmlh_barang")
    private Integer jmlhBarang;

    @Column(name="harga_barang")
    private Double hargaBarang;

    @Column(name="total_harga_barang")
    private Double totalHargaBarang;

    @Column(name="created_date")
    private Timestamp createdDate;
    
    @Column(name="updated_date")
    private Timestamp updatedDate;

    @Column(name="deleted_date")
    private Timestamp deletedDate;

    @Column(name="creator_id")
    private Integer creatorId;

    @Column(name="updater_id")
    private Integer updaterId;

    @Column(name="deleter_id")
    private Integer deleterId;

    @Column(name="status_barang")
    private String statusBarang;

    public Integer getNoBarang() {
        return noBarang;
    }

    public void setNoBarang(Integer noBarang) {
        this.noBarang = noBarang;
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

    public Double getTotalHargaBarang() {
        return totalHargaBarang;
    }

    public void setTotalHargaBarang(Double totalHargaBarang) {
        this.totalHargaBarang = totalHargaBarang;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Timestamp getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Timestamp deletedDate) {
        this.deletedDate = deletedDate;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Integer updaterId) {
        this.updaterId = updaterId;
    }

    public Integer getDeleterId() {
        return deleterId;
    }

    public void setDeleterId(Integer deleterId) {
        this.deleterId = deleterId;
    }

    public String getStatusBarang() {
        return statusBarang;
    }

    public void setStatusBarang(String statusBarang) {
        this.statusBarang = statusBarang;
    }
 
}
