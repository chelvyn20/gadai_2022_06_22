package id.co.nds.gadai_2022_06_22.services;

import java.io.Serializable;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.nds.gadai_2022_06_22.entities.ProductEntity;
import id.co.nds.gadai_2022_06_22.exceptions.ClientException;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;
import id.co.nds.gadai_2022_06_22.models.ProductModel;
import id.co.nds.gadai_2022_06_22.repos.ProductRepo;
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
        productValidator.validateProductDesc(productModel.getProductDesc());

        productValidator.nullCheckJangkaWaktu(productModel.getProductJangkaWaktu());
        productValidator.validateJangkaWaktu(productModel.getProductJangkaWaktu(), productModel.getProductType());

        productValidator.nullCheckLtv(productModel.getProductLtv());
        productValidator.validateProductLtv(productModel.getProductLtv()/100);

        productValidator.nullCheckProductAdminOpeningFeeType(productModel.getProductAdminOpeningFeeType());
        productValidator.nullCheckProductAdminClosingFeeType(productModel.getProductAdminClosingFeeType());
        productValidator.nullCheckProductAdminOpeningFee(productModel.getProductAdminOpeningFee());
        productValidator.nullCheckProductAdminClosingFee(productModel.getProductAdminClosingFee());
        productValidator.validateProductAdminOpeningFeeType(productModel.getProductAdminOpeningFeeType());
        productValidator.validateProductAdminClosingFeeType(productModel.getProductAdminClosingFeeType());
        productValidator.validateProductAdminOpeningFee(productModel.getProductAdminOpeningFee());
        productValidator.validateProductAdminClosingFee(productModel.getProductAdminClosingFee());

        productValidator.nullCheckProductBiayaPenyimpanan(productModel.getProductBiayaJasaPeny());
        productValidator.validateProductBiayaPenyimpanan(productModel.getProductBiayaJasaPeny());
        productValidator.nullCheckProductBiayaPenyimpananPeriode(productModel.getProductBiayaJasaPenyPeriode());;
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

        product.setProductAdminOpeningFeeType(productModel.getProductAdminOpeningFeeType());
        product.setProductAdminClosingFeeType(productModel.getProductAdminClosingFeeType());
        product.setProductAdminOpeningFee(productModel.getProductAdminOpeningFee());
        product.setProductAdminClosingFee(productModel.getProductAdminClosingFee());

        product.setProductBiayaJasaPeny(productModel.getProductBiayaJasaPeny());
        product.setProductBiayaJasaPenyPeriode(productModel.getProductBiayaJasaPenyPeriode());

        product.setProductBiayaDenda(productModel.getProductBiayaDenda());
        product.setProductBiayaDendaPeriode(productModel.getProductBiayaDendaPeriode());

        // if(productModel.getProductAdminOpeningFeeType().equalsIgnoreCase("Persen")) {
        //     product.setProductAdminOpeningFee(productModel.getProductAdminOpeningFee() / 100);
        // }

        // if(productModel.getProductAdminClosingFeeType().equalsIgnoreCase("Persen")) {
        //     product.setProductAdminClosingFee(productModel.getProductAdminClosingFee() / 100);
        // }

        // if(productModel.getProductAdminOpeningFeeType().equalsIgnoreCase("Nominal")) {
        //     product.setProductAdminOpeningFee(productModel.getProductAdminOpeningFee());
        // }

        // if(productModel.getProductAdminClosingFeeType().equalsIgnoreCase("Nominal")) {
        //     product.setProductAdminClosingFee(productModel.getProductAdminClosingFee());
        // }

        product.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        product.setCreatedBy(productModel.getActorId() == null ? 0 : productModel.getActorId());
        product.setRecStatus(GlobalConstant.REC_STATUS_ACTIVE);

        return productRepo.save(product);
    }
}
