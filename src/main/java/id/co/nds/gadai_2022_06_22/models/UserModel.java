package id.co.nds.gadai_2022_06_22.models;

public class UserModel {
    private Integer id;
    private String userId;
    private String userName;
    private String userNoHp;
    private String userDesc;
    private Double userTxnLimit;
    private String entryDate;
    private Integer actorId;
    private String recStatus;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
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
    public String getUserNoHp() {
        return userNoHp;
    }
    public void setUserNoHp(String userNoHp) {
        this.userNoHp = userNoHp;
    }
    public String getUserDesc() {
        return userDesc;
    }
    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }
    public Double getUserTxnLimit() {
        return userTxnLimit;
    }
    public void setUserTxnLimit(Double userTxnLimit) {
        this.userTxnLimit = userTxnLimit;
    }
    public String getEntryDate() {
        return entryDate;
    }
    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }
    public Integer getActorId() {
        return actorId;
    }
    public void setActorId(Integer actorId) {
        this.actorId = actorId;
    }
    public String getRecStatus() {
        return recStatus;
    }
    public void setRecStatus(String recStatus) {
        this.recStatus = recStatus;
    }

}
