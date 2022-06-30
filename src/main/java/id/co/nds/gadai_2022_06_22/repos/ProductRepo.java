package id.co.nds.gadai_2022_06_22.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai_2022_06_22.entities.ProductEntity;
import id.co.nds.gadai_2022_06_22.globals.GlobalConstant;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity,String>, JpaSpecificationExecutor<ProductEntity>{
    @Query(value = "SELECT COUNT (*) FROM ms_product WHERE product_status = '"  + GlobalConstant.REC_STATUS_ACTIVE
    + "' AND product_id = :product_id",nativeQuery = true)
    long countById(@Param("product_id")String id);

    @Query(value = "SELECT * FROM ms_product AS p WHERE product_status = '"  + GlobalConstant.REC_STATUS_ACTIVE
    + "' AND LOWER(product_tipe) = 'konsinyasi cicilan tetap'",nativeQuery = true)
    List<ProductEntity> findAllProductCiTetap();

    @Query(value = "SELECT COUNT (*) FROM ms_product AS p WHERE product_status = '"  + GlobalConstant.REC_STATUS_ACTIVE
    + "' AND LOWER(product_tipe) = 'konsinyasi cicilan tetap' AND (product_id) = (:product_id)",nativeQuery = true)
    long countProductIdCiTetap(@Param("product_id")String id);

   
}
