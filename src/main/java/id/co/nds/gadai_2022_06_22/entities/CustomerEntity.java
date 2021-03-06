package id.co.nds.gadai_2022_06_22.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ms_customer")
public class CustomerEntity {
    @Id

    @GenericGenerator(name = "customer_id_seq",
    strategy = "id.co.nds.gadai_2022_06_22.generators.CustomerIdGenerator")
    
    @GeneratedValue(generator = "customer_id_seq")
    
    @Column(name="cust_id")
    private String custId;

    @Column(name="cust_name")
    private String custName;

    @Column(name="cust_ktp")
    private String custKtp;

    @Column(name="cust_hp")
    private String custHp;

    @Column(name="cust_jk")
    private String custJk;

    @Column(name="cust_jenis_usaha_id")
    private String custJenisUsahaId;

    @Column(name="cust_limit_txn")
    private Double custLimitTxn;

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

    @Column(name="cust_status")
    private String custStatus;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustKtp() {
        return custKtp;
    }

    public void setCustKtp(String custKtp) {
        this.custKtp = custKtp;
    }

    public String getCustHp() {
        return custHp;
    }

    public void setCustHp(String custHp) {
        this.custHp = custHp;
    }

    public String getCustJk() {
        return custJk;
    }

    public void setCustJk(String custJk) {
        this.custJk = custJk;
    }

    public String getCustJenisUsahaId() {
        return custJenisUsahaId;
    }

    public void setCustJenisUsahaId(String custJenisUsahaId) {
        this.custJenisUsahaId = custJenisUsahaId;
    }

    public Double getCustLimitTxn() {
        return custLimitTxn;
    }

    public void setCustLimitTxn(Double custLimitTxn) {
        this.custLimitTxn = custLimitTxn;
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

    public String getCustStatus() {
        return custStatus;
    }

    public void setCustStatus(String custStatus) {
        this.custStatus = custStatus;
    }
    

}
