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
    @Id
    @GenericGenerator(name = "product_id_seq",
    strategy = "id.co.nds.gadai_2022_06_22.generators.ProductIdGenerator")
    @GeneratedValue(generator = "product_id_seq")
    @Column(name="product_id")
    private String productId;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_desc")
    private String productDesc;

    @Column(name = "product_ltv")
    private Double productLtv;

    @Column(name = "product_tenor")
    private Integer productJangkaWaktu;

    @Column(name = "biaya_adm_buka_type")
    private String productAdminOpeningFeeType;

    @Column(name = "biaya_adm_buka_val")
    private Double productAdminOpeningFee;

    @Column(name = "biaya_adm_tutup_type")
    private String productAdminClosingFeeType;

    @Column(name = "biaya_adm_tutup_val")
    private Double productAdminClosingFee;

    @Column(name = "biaya_js_peny_rate")
    private Double productBiayaJasaPeny;

    @Column(name = "biaya_js_peny_per")
    private Integer productBiayaJasaPenyPeriode;

    @Column(name = "biaya_denda_keterlambatan_rate")
    private Double productBiayaDenda;

    @Column(name = "biaya_denda_keterlambatan_per")
    private Integer productBiayaDendaPeriode;

    @Column(name = "rec_status")
    private String recStatus;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "updated_date")
    private Timestamp updatedDate;

    @Column(name = "deleted_date")
    private Timestamp deletedDate;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "deleted_by")
    private Integer deletedBy;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
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

    public String getProductAdminOpeningFeeType() {
        return productAdminOpeningFeeType;
    }

    public void setProductAdminOpeningFeeType(String productAdminOpeningFeeType) {
        this.productAdminOpeningFeeType = productAdminOpeningFeeType;
    }

    public String getProductAdminClosingFeeType() {
        return productAdminClosingFeeType;
    }

    public void setProductAdminClosingFeeType(String productAdminClosingFeeType) {
        this.productAdminClosingFeeType = productAdminClosingFeeType;
    }

    public Double getProductAdminOpeningFee() {
        return productAdminOpeningFee;
    }

    public void setProductAdminOpeningFee(Double productAdminOpeningFee) {
        this.productAdminOpeningFee = productAdminOpeningFee;
    }

    public Double getProductAdminClosingFee() {
        return productAdminClosingFee;
    }

    public void setProductAdminClosingFee(Double productAdminClosingFee) {
        this.productAdminClosingFee = productAdminClosingFee;
    }

    public Double getProductBiayaJasaPeny() {
        return productBiayaJasaPeny;
    }

    public void setProductBiayaJasaPeny(Double productBiayaJasaPeny) {
        this.productBiayaJasaPeny = productBiayaJasaPeny;
    }

    public Integer getProductBiayaJasaPenyPeriode() {
        return productBiayaJasaPenyPeriode;
    }

    public void setProductBiayaJasaPenyPeriode(Integer productBiayaJasaPenyPeriode) {
        this.productBiayaJasaPenyPeriode = productBiayaJasaPenyPeriode;
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

    public String getRecStatus() {
        return recStatus;
    }

    public void setRecStatus(String recStatus) {
        this.recStatus = recStatus;
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

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
    }
}
