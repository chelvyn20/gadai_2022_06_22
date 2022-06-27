package id.co.nds.gadai_2022_06_22.services;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.nds.gadai_2022_06_22.entities.ProductEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.exceptions.NotFoundException;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;
import id.co.nds.gadai_2022_06_22.models.ProductModel;
import id.co.nds.gadai_2022_06_22.repos.ProductRepo;
import id.co.nds.gadai_2022_06_22.repos.specs.ProductSpec;
import id.co.nds.gadai_2022_06_22.validators.ProductValidator;

@Service
public class ProductService implements Serializable{
    @Autowired
    private ProductRepo productRepo;

    ProductValidator productValidator = new ProductValidator();

    public ProductEntity doInsertProduk(ProductModel productModel) throws ClientException, Exception{
        productValidator.notNullCheckId(productModel.getId());
        productValidator.nullCheckProductId(productModel.getProductId());
        productValidator.validateProductId(productModel.getProductId());

        Long countProductId = productRepo.countByProductId(productModel.getProductId());

        if(countProductId > 0) {
            throw new ClientException("Produk id telah terdaftar");
        }

        productValidator.nullCheckProductType(productModel.getProductType());
        productValidator.validateProductType(productModel.getProductType());
        productValidator.nullCheckProductName(productModel.getProductName());
        productValidator.validateProductName(productModel.getProductName());
        productValidator.validateProductDesc(productModel.getProductDesc() == null ? "" : productModel.getProductDesc());

        productValidator.nullCheckJangkaWaktu(productModel.getProductJangkaWaktu());
        productValidator.validateJangkaWaktu(productModel.getProductJangkaWaktu(), productModel.getProductType());

        productValidator.nullCheckLtv(productModel.getProductLtv());
        productValidator.validateProductLtv(productModel.getProductLtv()/100);

        productValidator.nullCheckProductAdminOpeningFeeType(productModel.getProductAdminOpeningFeeType());
        productValidator.validateProductAdminOpeningFeeType(productModel.getProductAdminOpeningFeeType());

        productValidator.nullCheckProductAdminClosingFeeType(productModel.getProductAdminClosingFeeType());
        productValidator.validateProductAdminClosingFeeType(productModel.getProductAdminClosingFeeType());

        productValidator.nullCheckProductAdminOpeningFee(productModel.getProductAdminOpeningFee());
        productValidator.validateProductAdminOpeningFee(productModel.getProductAdminOpeningFee());

        productValidator.nullCheckProductAdminClosingFee(productModel.getProductAdminClosingFee());
        productValidator.validateProductAdminClosingFee(productModel.getProductAdminClosingFee());

        productValidator.nullCheckProductBiayaPenyimpanan(productModel.getProductBiayaJasaPeny());
        productValidator.validateProductBiayaPenyimpanan(productModel.getProductBiayaJasaPeny());
        productValidator.nullCheckProductBiayaPenyimpananPeriode(productModel.getProductBiayaJasaPenyPeriode());
        productValidator.validateProductBiayaPenyimpananPeriode(productModel.getProductBiayaJasaPenyPeriode(), productModel.getProductJangkaWaktu(), productModel.getProductType());

        productValidator.nullCheckProductBiayaDenda(productModel.getProductBiayaDenda());
        productValidator.validateProductBiayaDenda(productModel.getProductBiayaDenda());
        productValidator.nullCheckProductBiayaDendaPeriode(productModel.getProductBiayaDendaPeriode());
        productValidator.validateProductBiayaDendaPeriode(productModel.getProductBiayaDendaPeriode());

        ProductEntity product = new ProductEntity();
        product.setProductId(productModel.getProductId());
        product.setProductType(productModel.getProductType());
        product.setProductName(productModel.getProductName());
        product.setProductDesc(productModel.getProductDesc());

        product.setProductJangkaWaktu(productModel.getProductJangkaWaktu());
        product.setProductLtv(productModel.getProductLtv() / 100);
        product.setProductAdminOpeningFeeType(productModel.getProductAdminOpeningFeeType());
        product.setProductAdminClosingFeeType(productModel.getProductAdminClosingFeeType());

        if(productModel.getProductAdminOpeningFeeType().equalsIgnoreCase("Persen")) {
            product.setProductAdminOpeningFee(productModel.getProductAdminOpeningFee() / 100);
        }

        if(productModel.getProductAdminClosingFeeType().equalsIgnoreCase("Persen")) {
            product.setProductAdminClosingFee(productModel.getProductAdminClosingFee() / 100);
        }

        if(productModel.getProductAdminOpeningFeeType().equalsIgnoreCase("Nominal")) {
            product.setProductAdminOpeningFee(productModel.getProductAdminOpeningFee());
        }

        if(productModel.getProductAdminClosingFeeType().equalsIgnoreCase("Nominal")) {
            product.setProductAdminClosingFee(productModel.getProductAdminClosingFee());
        }

        product.setProductBiayaJasaPeny(productModel.getProductBiayaJasaPeny());
        product.setProductBiayaJasaPenyPeriode(productModel.getProductBiayaJasaPenyPeriode());

        product.setProductBiayaDenda(productModel.getProductBiayaDenda());
        product.setProductBiayaDendaPeriode(productModel.getProductBiayaDendaPeriode());

        product.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        product.setCreatedBy(productModel.getActorId() == null ? 0 : productModel.getActorId());
        product.setRecStatus(GlobalConstant.REC_STATUS_ACTIVE);

        return productRepo.save(product);
    }

    public ProductEntity doUpdateProduk(ProductModel productModel) throws ClientException, Exception{
        productValidator.nullCheckId(productModel.getId());
        productValidator.validateId(productModel.getId());

        if(!productRepo.existsById(productModel.getId())) {
            throw new NotFoundException("Tidak dapat menemukan produk dengan id: " + productModel.getId());
        }

        ProductEntity product = new ProductEntity();
        product = doGetDetailProduct(productModel.getId());

        if(productModel.getProductName() != null) {
            productValidator.validateProductName(productModel.getProductName());
            product.setProductName(productModel.getProductName());
        }
        
        if(productModel.getProductDesc() != null) {
            productValidator.validateProductDesc(productModel.getProductDesc());
            product.setProductDesc(productModel.getProductDesc());
        }

        if(productModel.getProductLtv() != null) {
            productValidator.validateProductLtv(productModel.getProductLtv()/100);
            product.setProductLtv(productModel.getProductLtv() / 100);
        }

        if(productModel.getProductJangkaWaktu() != null) {
            productValidator.validateJangkaWaktu(productModel.getProductJangkaWaktu(), product.getProductType());
            product.setProductJangkaWaktu(productModel.getProductJangkaWaktu());
        }

        if(productModel.getProductAdminOpeningFeeType() != null) {
            productValidator.validateProductAdminOpeningFeeType(productModel.getProductAdminOpeningFeeType());
            product.setProductAdminOpeningFeeType(productModel.getProductAdminOpeningFeeType());
        }

        if(productModel.getProductAdminClosingFeeType() != null) {
            productValidator.validateProductAdminClosingFeeType(productModel.getProductAdminClosingFeeType());
            product.setProductAdminClosingFeeType(productModel.getProductAdminClosingFeeType());
        }

        if(productModel.getProductAdminOpeningFee() != null) {
            productValidator.validateProductAdminOpeningFee(productModel.getProductAdminOpeningFee());

            String productAdminType = productModel.getProductAdminOpeningFeeType() == null ? product.getProductAdminOpeningFeeType() : productModel.getProductAdminOpeningFeeType();
            if(productAdminType.equalsIgnoreCase("Persen")) {
                product.setProductAdminOpeningFee(productModel.getProductAdminOpeningFee() / 100);
            }

            if(productAdminType.equalsIgnoreCase("Nominal")) {
                product.setProductAdminOpeningFee(productModel.getProductAdminOpeningFee());
            }
        }

        if(productModel.getProductAdminClosingFee() != null) {
            productValidator.validateProductAdminClosingFee(productModel.getProductAdminClosingFee());

            String productAdminType = productModel.getProductAdminClosingFee() == null ? product.getProductAdminClosingFeeType() : productModel.getProductAdminClosingFeeType();
            if(productAdminType.equalsIgnoreCase("Persen")) {
                product.setProductAdminClosingFee(productModel.getProductAdminClosingFee() / 100);
            }

            if(productAdminType.equalsIgnoreCase("Nominal")) {
                product.setProductAdminClosingFee(productModel.getProductAdminClosingFee());
            }
        }

        if(productModel.getProductBiayaJasaPeny() != null) {
            productValidator.validateProductBiayaPenyimpanan(productModel.getProductBiayaJasaPeny());
            product.setProductBiayaJasaPeny(productModel.getProductBiayaJasaPeny());
        }

        if(productModel.getProductBiayaJasaPenyPeriode() != null) {
            Integer jangkaWaktu = productModel.getProductJangkaWaktu() == null ? product.getProductJangkaWaktu() :  productModel.getProductJangkaWaktu();
            productValidator.validateProductBiayaPenyimpananPeriode(productModel.getProductBiayaJasaPenyPeriode(), jangkaWaktu, product.getProductType());
            product.setProductBiayaJasaPenyPeriode(productModel.getProductBiayaJasaPenyPeriode());
        }

        if(productModel.getProductBiayaDenda() != null) {
            productValidator.validateProductBiayaDenda(productModel.getProductBiayaDenda());
            product.setProductBiayaDenda(productModel.getProductBiayaDenda());
        }

        if(productModel.getProductBiayaDendaPeriode() != null) {
            productValidator.validateProductBiayaDendaPeriode(productModel.getProductBiayaDendaPeriode());
            product.setProductBiayaDendaPeriode(productModel.getProductBiayaDendaPeriode());
        }

        product.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        product.setUpdatedBy(productModel.getActorId() == null ? 0 : productModel.getActorId());

        return productRepo.save(product);
    }

    public ProductEntity doDeleteProduct(ProductModel productModel) throws ClientException, Exception {
        productValidator.nullCheckId(productModel.getId());
        productValidator.validateId(productModel.getId());

        if(!productRepo.existsById(productModel.getId())) {
            throw new NotFoundException("Cannot find product with id: " + productModel.getId());
        }

        ProductEntity product = new ProductEntity();
        product = doGetDetailProduct(productModel.getId());

        if(product.getRecStatus().equalsIgnoreCase(GlobalConstant.REC_STATUS_NON_ACTIVE)) {
            throw new ClientException("Product id (" + productModel.getId() + ") is already been deleted.");
        }

        product.setRecStatus(GlobalConstant.REC_STATUS_NON_ACTIVE);
        product.setDeletedDate(new Timestamp(System.currentTimeMillis()));
        product.setDeletedBy(productModel.getActorId() == null ? 0 : productModel.getActorId());

        return productRepo.save(product);
    }

    public List<ProductEntity> doSearchProduct(ProductModel productModel) {
        List<ProductEntity> products = new ArrayList<>();
        ProductSpec specs = new ProductSpec(productModel);
        productRepo.findAll(specs).forEach(products::add);

        return products;
    }

    public ProductEntity doGetDetailProduct(Integer id) throws ClientException, NotFoundException {
        productValidator.nullCheckId(id);
        productValidator.validateId(id);


        ProductEntity product = productRepo.findById(id).orElse(null);
        productValidator.nullCheckObject(product);

        return product;
    }
}
