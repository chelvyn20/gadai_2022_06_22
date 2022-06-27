
package id.co.nds.gadai_2022_06_22.repos.specs;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import id.co.nds.gadai_2022_06_22.entities.ProductEntity;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;
import id.co.nds.gadai_2022_06_22.models.ProductModel;

public class ProductSpec implements Specification<ProductEntity>{
    private ProductModel productModel;

    public ProductSpec(ProductModel productModel){
        super();
        this.productModel=productModel;
    }
  
    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?>cq, CriteriaBuilder cb){
        Predicate p = cb.and();
        
        if(productModel.getProductId()!=null && productModel.getProductId().length() > 0){
            p.getExpressions().add(cb.equal(root.get("productId"), productModel.getProductId()));
        }

        if (productModel.getProductTipe()!=null && productModel.getProductTipe().length() > 0 ){
            p.getExpressions().add(cb.like(cb.lower(root.get("productTipe")),
            "%" +    productModel.getProductTipe().toLowerCase()+ "%"));
        }
        
        if (productModel.getProductName()!=null && productModel.getProductName().length() > 0 ){
            p.getExpressions().add(cb.like(cb.lower(root.get("productName")),
            "%" +    productModel.getProductName().toLowerCase()+ "%"));
        }

        if(productModel.getProductLtv() != null && productModel.getProductLtvBefore() > 0 && productModel.getProductLtvAfter() > 0) {
            p.getExpressions().add(cb.equal(root.get("productLtv"), productModel.getProductLtvBefore() 
            + productModel.getProductLtvAfter()));
        }

        if(productModel.getProductBiayaPeny() != null && productModel.getProductBiayaJasaPenyBefore() > 0 && productModel.getProductBiayaJasaPenyAfter() > 0) {
            p.getExpressions().add(cb.equal(root.get("productBiayaJasaPeny"), productModel.getProductBiayaJasaPenyBefore()
            + productModel.getProductBiayaJasaPenyAfter()));
        }

        if (productModel.getProductStatus() != null
        && (productModel.getProductStatus().trim().equalsIgnoreCase(GlobalConstant.REC_STATUS_ACTIVE)
                || productModel.getProductStatus().trim().equalsIgnoreCase(GlobalConstant.REC_STATUS_NONACTIVE))) {
        p.getExpressions()
            .add(cb.equal(cb.upper(root.get("productStatus")), productModel.getProductStatus().toUpperCase()));
        }
        
        cq.orderBy(cb.asc(root.get("productId")));
        return p;

    }
    
    
    
}
