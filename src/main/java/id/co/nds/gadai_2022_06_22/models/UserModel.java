package id.co.nds.gadai_2022_06_22.models;

import java.sql.Timestamp;

public class UserModel {
    private String userId;
    private String userName;
    private String userPhone;
    private String userNotes;
    private Double userMaxLimit;
    private String userRegisterDate;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private Timestamp deletedDate;
    private Integer createdBy;
    private Integer updatedBy;
    private Integer deletedBy;
    private String recStatus;
    
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public String getUserNotes() {
        return userNotes;
    }
    public void setUserNotes(String userNotes) {
        this.userNotes = userNotes;
    }
    public Double getUserMaxLimit() {
        return userMaxLimit;
    }
    public void setUserMaxLimit(Double userMaxLimit) {
        this.userMaxLimit = userMaxLimit;
    }
    public String getUserRegisterDate() {
        return userRegisterDate;
    }
    public void setUserRegisterDate(String userRegisterDate) {
        this.userRegisterDate = userRegisterDate;
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
    public String getRecStatus() {
        return recStatus;
    }
    public void setRecStatus(String recStatus) {
        this.recStatus = recStatus;
    }

}
