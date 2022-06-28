package id.co.nds.gadai_2022_06_22.models;

public class AuctionModel {
    private Integer id;
    private String productName;
    private String productDesc;
    private String productCondition;
    private Integer productQuantity;
    private Double productPrice;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
    public String getProductCondition() {
        return productCondition;
    }
    public void setProductCondition(String productCondition) {
        this.productCondition = productCondition;
    }
    public Integer getProductQuantity() {
        return productQuantity;
    }
    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
    public Double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}
