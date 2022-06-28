

package id.co.nds.gadai_2022_06_22.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "ms_product")
public class ProductEntity {
    @Column(name="product_tipe")
    private String productTipe;

    @Id
    @GenericGenerator(name = "product_id_seq",
    strategy = "id.co.nds.gadai_2022_06_22.generators.ProductIdGenerator")
    @GeneratedValue(generator = "product_id_seq")
         
    @Column(name="product_id")
    private String productId;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_desc")
    private String productDesc;

    @Column(name="product_jangka_waktu")
    private Integer productJangkaWaktu;

    @Column(name="product_ltv")
    private Double productLtv;

    @Column(name="product_biaya_admin_buka")
    private Double productBiayaAdminBuka;

    @Column(name="product_biaya_admin_buka_tipe")
    private String productBiayaAdminBukaTipe;

    @Column(name="product_biaya_admin_tutup")
    private Double productBiayaAdminTutup;

    @Column(name="product_biaya_admin_tutup_tipe")
    private String productBiayaAdminTutupTipe;

    @Column(name="product_biaya_peny")
    private Double productBiayaPeny;

    @Column(name="product_biaya_peny_periode")
    private Integer productBiayaPenyPeriode;

    @Column(name="product_biaya_denda")
    private Double productBiayaDenda;

    @Column(name="product_biaya_denda_periode")
    private Integer productBiayaDendaPeriode;

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

    @Column(name="product_status")
    private String productStatus;

    public String getProductTipe() {
        return productTipe;
    }

    public void setProductTipe(String productTipe) {
        this.productTipe = productTipe;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductJangkaWaktu() {
        return productJangkaWaktu;
    }

    public void setProductJangkaWaktu(Integer productJangkaWaktu) {
        this.productJangkaWaktu = productJangkaWaktu;
    }

    public Double getProductLtv() {
        return productLtv;
    }

    public void setProductLtv(Double productLtv) {
        this.productLtv = productLtv;
    }

    public Double getProductBiayaAdminBuka() {
        return productBiayaAdminBuka;
    }

    public void setProductBiayaAdminBuka(Double productBiayaAdminBuka) {
        this.productBiayaAdminBuka = productBiayaAdminBuka;
    }

    public String getProductBiayaAdminBukaTipe() {
        return productBiayaAdminBukaTipe;
    }

    public void setProductBiayaAdminBukaTipe(String productBiayaAdminBukaTipe) {
        this.productBiayaAdminBukaTipe = productBiayaAdminBukaTipe;
    }

    public Double getProductBiayaAdminTutup() {
        return productBiayaAdminTutup;
    }

    public void setProductBiayaAdminTutup(Double productBiayaAdminTutup) {
        this.productBiayaAdminTutup = productBiayaAdminTutup;
    }

    public String getProductBiayaAdminTutupTipe() {
        return productBiayaAdminTutupTipe;
    }

    public void setProductBiayaAdminTutupTipe(String productBiayaAdminTutupTipe) {
        this.productBiayaAdminTutupTipe = productBiayaAdminTutupTipe;
    }

    public Double getProductBiayaPeny() {
        return productBiayaPeny;
    }

    public void setProductBiayaPeny(Double productBiayaPeny) {
        this.productBiayaPeny = productBiayaPeny;
    }

    public Integer getProductBiayaPenyPeriode() {
        return productBiayaPenyPeriode;
    }

    public void setProductBiayaPenyPeriode(Integer productBiayaPenyPeriode) {
        this.productBiayaPenyPeriode = productBiayaPenyPeriode;
    }

    public Double getProductBiayaDenda() {
        return productBiayaDenda;
    }

    public void setProductBiayaDenda(Double productBiayaDenda) {
        this.productBiayaDenda = productBiayaDenda;
    }

    public Integer getProductBiayaDendaPeriode() {
        return productBiayaDendaPeriode;
    }

    public void setProductBiayaDendaPeriode(Integer productBiayaDendaPeriode) {
        this.productBiayaDendaPeriode = productBiayaDendaPeriode;
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

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    
}

