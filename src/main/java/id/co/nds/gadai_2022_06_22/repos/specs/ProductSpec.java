package id.co.nds.gadai_2022_06_22.repos.specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import id.co.nds.gadai_2022_06_22.entities.ProductEntity;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;
import id.co.nds.gadai_2022_06_22.models.ProductModel;

public class ProductSpec implements Specification<ProductEntity>{
    private ProductModel productModel;

    public ProductSpec(ProductModel productModel) {
        super();
        this.productModel = productModel;
    }

    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate p = criteriaBuilder.and();

        if(productModel.getProductId() != null && productModel.getProductId().length() > 0 ) {
            p.getExpressions().add(criteriaBuilder.equal(root.get("productId"), productModel.getProductId()));
        }

        if(productModel.getProductName() != null && productModel.getProductName().length() > 0) {
            p.getExpressions().add(criteriaBuilder.like(criteriaBuilder.lower(root.get("productName")), "%" 
            + productModel.getProductName().toLowerCase() + "%"));
        }

        if(productModel.getProductType() != null && productModel.getProductType().length() > 0) {
            p.getExpressions().add(criteriaBuilder.like(criteriaBuilder.lower(root.get("productType")), "%" 
            + productModel.getProductType().toLowerCase() + "%"));
        }

        if(productModel.getProductLtv() != null && productModel.getProductLtvBefore() > 0 && productModel.getProductLtvAfter() > 0) {
            p.getExpressions().add(criteriaBuilder.equal(root.get("productLtv"), productModel.getProductLtvBefore() 
            + productModel.getProductLtvAfter()));
        }

        if(productModel.getProductAdminClosingFee() != null && productModel.getProductBiayaJasaPenyBefore() > 0 && productModel.getProductBiayaJasaPenyAfter() > 0) {
            p.getExpressions().add(criteriaBuilder.equal(root.get("biayaJasaPenyRate"), productModel.getProductBiayaJasaPenyBefore()
            + productModel.getProductBiayaJasaPenyAfter()));
        }

        if(productModel.getRecStatus() != null && 
        (productModel.getRecStatus().trim().equalsIgnoreCase(GlobalConstant.REC_STATUS_ACTIVE) 
        || productModel.getRecStatus().trim().equalsIgnoreCase(GlobalConstant.REC_STATUS_NON_ACTIVE))) {
            p.getExpressions().add(criteriaBuilder.equal(criteriaBuilder.upper(root.get("recStatus")), 
            productModel.getRecStatus().toUpperCase()));
        }

        query.orderBy(criteriaBuilder.asc(root.get("productId")));

        return p;
    }
}
