package id.co.nds.gadai_2022_06_22.validators;

import id.co.nds.gadai_2022_06_22.exceptions.ClientException;

public class AuctionValidator {
    public void nullCheckId(Integer id) throws ClientException {
        if(id == null) {
            throw new ClientException("Id perlu diisi");
        }
    }

    public void notNullCheckId(Integer id) throws ClientException {
        if(id != null) {
            throw new ClientException("Id dibuat secara otomatis, jangan masukan id");
        }
    }

    public void nullCheckProductName(String productName) throws ClientException {
        if(productName == null) {
            throw new ClientException("Product Name perlu diisi");
        }
    }

    public void nullCheckProductCondition(String productCondition) throws ClientException {
        if(productCondition == null) {
            throw new ClientException("Product Condition perlu diisi");
        }
    }

    public void nullCheckProductDesc(String productDesc) throws ClientException {
        if(productDesc == null) {
            throw new ClientException("Product Desc perlu diisi");
        }
    }

    public void nullCheckProductQuantity(Integer productQuantity) throws ClientException {
        if(productQuantity == null) {
            throw new ClientException("Product Quantity perlu diisi");
        }
    }

    public void nullCheckProductPrice(Double productPrice) throws ClientException {
        if(productPrice == null) {
            throw new ClientException("Product Price perlu diisi");
        }
    }

    public void validateProductName(String productName) throws ClientException {
        if(productName.length() > 30) {
            throw new ClientException("Nama produk tidak boleh melebihi 30 huruf.");
        }
    }

    public void validateProductDesc(String productDesc) throws ClientException {
        if(productDesc.length() > 150) {
            throw new ClientException("Deskripsi produk tidak boleh melebihi 150 huruf.");
        }
    }

    public void validateProductQuantity(Integer productQuantity) throws ClientException {
        if(productQuantity < 1) {
            throw new ClientException("Quantity produk tidak valid");
        }
    }

    public void validateProductPrice(Double productPrice) throws ClientException {
        if(productPrice < 1) {
            throw new ClientException("Harga produk tidak valid");
        }
    }
}
