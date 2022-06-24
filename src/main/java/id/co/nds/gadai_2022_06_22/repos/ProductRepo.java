package id.co.nds.gadai_2022_06_22.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai_2022_06_22.entities.ProductEntity;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity,String>, JpaSpecificationExecutor<ProductEntity>{
    
}
