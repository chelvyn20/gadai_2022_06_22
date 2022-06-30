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
        productValidator.notNullCheckProductId(productModel.getProductId());

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
        product.setProductType(productModel.getProductType());
        product.setProductName(productModel.getProductName());
        product.setProductDesc(productModel.getProductDesc());

        product.setProductJangkaWaktu(productModel.getProductJangkaWaktu());
        product.setProductLtv(productModel.getProductLtv() / 100);
        product.setBiayaAdmBukaType(productModel.getProductAdminOpeningFeeType());
        product.setBiayaAdmTutupType(productModel.getProductAdminClosingFeeType());

        if(productModel.getProductAdminOpeningFeeType().equalsIgnoreCase("Persen")) {
            product.setBiayaAdmBukaVal(productModel.getProductAdminOpeningFee() / 100);
        }

        if(productModel.getProductAdminClosingFeeType().equalsIgnoreCase("Persen")) {
            product.setBiayaAdmTutupVal(productModel.getProductAdminClosingFee() / 100);
        }

        if(productModel.getProductAdminOpeningFeeType().equalsIgnoreCase("Nominal")) {
            product.setBiayaAdmBukaVal(productModel.getProductAdminOpeningFee());
        }

        if(productModel.getProductAdminClosingFeeType().equalsIgnoreCase("Nominal")) {
            product.setBiayaAdmTutupVal(productModel.getProductAdminClosingFee());
        }

        product.setBiayaJasaPenyRate(productModel.getProductBiayaJasaPeny());
        product.setBiayaJasaPenyPer(productModel.getProductBiayaJasaPenyPeriode());

        product.setBiayaDendaKeterlambatanRate(productModel.getProductBiayaDenda());
        product.setBiayaDendaKeterlambatanPer(productModel.getProductBiayaDendaPeriode());

        product.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        product.setCreatedBy(productModel.getActorId() == null ? 0 : productModel.getActorId());
        product.setRecStatus(GlobalConstant.REC_STATUS_ACTIVE);

        return productRepo.save(product);
    }

    public ProductEntity doUpdateProduk(ProductModel productModel) throws ClientException, Exception{
        productValidator.nullCheckProductId(productModel.getProductId());
        productValidator.validateProductId(productModel.getProductId());

        if(productRepo.getActiveProductByProductId(productModel.getProductId()) == null) {
            throw new NotFoundException("Tidak dapat menemukan produk dengan id: " + productModel.getProductId());
        }

        ProductEntity product = new ProductEntity();
        product = doGetDetailProduct(productModel.getProductId());

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
            product.setBiayaAdmBukaType(productModel.getProductAdminOpeningFeeType());
        }

        if(productModel.getProductAdminClosingFeeType() != null) {
            productValidator.validateProductAdminClosingFeeType(productModel.getProductAdminClosingFeeType());
            product.setBiayaAdmTutupType(productModel.getProductAdminClosingFeeType());
        }

        if(productModel.getProductAdminOpeningFee() != null) {
            productValidator.validateProductAdminOpeningFee(productModel.getProductAdminOpeningFee());

            String productAdminType = productModel.getProductAdminOpeningFeeType() == null ? product.getBiayaAdmBukaType() : productModel.getProductAdminOpeningFeeType();
            if(productAdminType.equalsIgnoreCase("Persen")) {
                product.setBiayaAdmBukaVal(productModel.getProductAdminOpeningFee() / 100);
            }

            if(productAdminType.equalsIgnoreCase("Nominal")) {
                product.setBiayaAdmBukaVal(productModel.getProductAdminOpeningFee());
            }
        }

        if(productModel.getProductAdminClosingFee() != null) {
            productValidator.validateProductAdminClosingFee(productModel.getProductAdminClosingFee());

            String productAdminType = productModel.getProductAdminClosingFee() == null ? product.getBiayaAdmTutupType() : productModel.getProductAdminClosingFeeType();
            if(productAdminType.equalsIgnoreCase("Persen")) {
                product.setBiayaAdmTutupVal(productModel.getProductAdminClosingFee() / 100);
            }

            if(productAdminType.equalsIgnoreCase("Nominal")) {
                product.setBiayaAdmTutupVal(productModel.getProductAdminClosingFee());
            }
        }

        if(productModel.getProductBiayaJasaPeny() != null) {
            productValidator.validateProductBiayaPenyimpanan(productModel.getProductBiayaJasaPeny());
            product.setBiayaJasaPenyRate(productModel.getProductBiayaJasaPeny());
        }

        if(productModel.getProductBiayaJasaPenyPeriode() != null) {
            Integer jangkaWaktu = productModel.getProductJangkaWaktu() == null ? product.getProductJangkaWaktu() :  productModel.getProductJangkaWaktu();
            productValidator.validateProductBiayaPenyimpananPeriode(productModel.getProductBiayaJasaPenyPeriode(), jangkaWaktu, product.getProductType());
            product.setBiayaJasaPenyPer(productModel.getProductBiayaJasaPenyPeriode());
        }

        if(productModel.getProductBiayaDenda() != null) {
            productValidator.validateProductBiayaDenda(productModel.getProductBiayaDenda());
            product.setBiayaDendaKeterlambatanRate(productModel.getProductBiayaDenda());
        }

        if(productModel.getProductBiayaDendaPeriode() != null) {
            productValidator.validateProductBiayaDendaPeriode(productModel.getProductBiayaDendaPeriode());
            product.setBiayaDendaKeterlambatanPer(productModel.getProductBiayaDendaPeriode());
        }

        product.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        product.setUpdatedBy(productModel.getActorId() == null ? 0 : productModel.getActorId());

        return productRepo.save(product);
    }

    public ProductEntity doDeleteProduct(ProductModel productModel) throws ClientException, Exception {
        productValidator.nullCheckProductId(productModel.getProductId());
        productValidator.validateProductId(productModel.getProductId());

        if(productRepo.getActiveProductByProductId(productModel.getProductId()) == null) {
            throw new NotFoundException("Cannot find product with id: " + productModel.getProductId());
        }

        ProductEntity product = new ProductEntity();
        product = doGetDetailProduct(productModel.getProductId());

        if(product.getRecStatus().equalsIgnoreCase(GlobalConstant.REC_STATUS_NON_ACTIVE)) {
            throw new ClientException("Product id (" + productModel.getProductId() + ") is already been deleted.");
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

    public ProductEntity doGetDetailProduct(String productId) throws ClientException, NotFoundException {
        productValidator.nullCheckProductId(productId);
        productValidator.validateProductId(productId);


        ProductEntity product = productRepo.getActiveProductByProductId(productId);
        productValidator.nullCheckObject(product);

        return product;
    }
}
